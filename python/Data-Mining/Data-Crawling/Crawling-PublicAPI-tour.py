import os
import sys
import urllib.request
import datetime
import time
import json
import pandas as pd

ServiceKey="(serviceKey)"

#[CODE 1]
def getRequestUrl(url):    
    #매개변수로 받은 url에 대한 요청을 보낼 객체를 생성
    req = urllib.request.Request(url)    
    try: 
        #요청 객체를 보내서 받은 응답 데이터를 response 객체에 저장
        response = urllib.request.urlopen(req)

        #response 객체에 저장된 코드를 확인. 코드가 200이면 요청을 정상 처리한 것이므로 성공 
        #메시지와 현재 시간을 파이썬 셸 창에 출력하고 응답을 utf-8형식으로 디코딩하여 반환
        if response.getcode() == 200:
            print ("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode('utf-8')
    
    #요청이 처리되지 않은 예외 사항이 발생하면 에러 메시지를 파이썬 셸 창에 출력
    except Exception as e:
        print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None


#[CODE 2]
#출입국관광통계서비스의 오픈 API 상세정보 페이지에서 찾은 
#서비스 URL, 요청매개변수 정보, 발급받은 인증키
def getTourismStatsItem(yyyymm, national_code, ed_cd):    
    service_url = "http://openapi.tour.go.kr/openapi/service/EdrcntTourismStatsService/getEdrcntTourismStatsList"
    parameters = "?_type=json&serviceKey=" + ServiceKey   #인증키
    parameters += "&YM=" + yyyymm
    parameters += "&NAT_CD=" + national_code
    parameters += "&ED_CD=" + ed_cd
    url = service_url + parameters #요청 url을 구성
    
    #구성한 url로 getRequestUrl() 함수를 호출해서 받은 응답을 responseDecode에 저장
    retData = getRequestUrl(url)
    
    if (retData == None):
        return None
    #서버에서 받은 JSON 형태의 응답 객체를 파이썬 객체로 로드하여 반환
    else:
         return json.loads(retData)

#[CODE 3]
def getTourismStatsService(nat_cd, ed_cd, nStartYear, nEndYear):
    jsonResult = []
    result = []
    natName=''
    dataEND = "{0}{1:0>2}".format(str(nEndYear), str(12)) #데이터 끝 초기화
    isDataEnd = 0 #데이터 끝 확인용 flag 초기화    
    
    for year in range(nStartYear, nEndYear+1):        
        for month in range(1, 13):
            if(isDataEnd == 1): break #데이터 끝 flag 설정되어있으면 작업 중지.
            yyyymm = "{0}{1:0>2}".format(str(year), str(month))  
            #getTourismStatsItem()을 호출해 받은 월 데이터를 jsonData에 저장          
            jsonData = getTourismStatsItem(yyyymm, nat_cd, ed_cd)
            
            #응답 데이터가 정상인지 확인
            #['items'] 항목에 값이 없으면 출입국관광통계 데이터가 아직 들어가지 않은 
            #마지막 월이므로 날짜를 dataEND에 저장하고 데이터 수집 작업을 중단
            if (jsonData['response']['header']['resultMsg'] == 'OK'):               
                # 입력된 범위까지 수집하지 않았지만, 더이상 제공되는 데이터가 없는 마지막 항목인 경우 -------------------
                if jsonData['response']['body']['items'] == '': 
                    isDataEnd = 1 #데이터 끝 flag 설정
                    dataEND = "{0}{1:0>2}".format(str(year), str(month-1))
                    print("데이터 없음.... \n 제공되는 통계 데이터는 %s년 %s월까지입니다."                          
                          %(str(year), str(month-1)))                    
                    break                
                #jsonData를 출력하여 확인......................................................
                print (json.dumps(jsonData, indent=4, 
                         sort_keys=True, ensure_ascii=False))          
                natName = jsonData['response']['body']['items']['item']['natKorNm']
                natName = natName.replace(' ', '') #띄어쓰기 제거

                #수집한 국가 이름(natName), 국가 코드(nat_cd), 날짜(yyyymm), 데이터 수(num)를 
                # 딕셔너리 자료형으로 구성하여 jsonResult 리스트에 원소로 추가
                num = jsonData['response']['body']['items']['item']['num']
                ed = jsonData['response']['body']['items']['item']['ed']
                print('[ %s_%s : %s ]' %(natName, yyyymm, num))
                print('----------------------------------------------------------------------')                
                jsonResult.append({'nat_name': natName, 'nat_cd': nat_cd,
                                 'yyyymm': yyyymm, 'visit_cnt': num})
                result.append([natName, nat_cd, yyyymm, num])
                
    return (jsonResult, result, natName, ed, dataEND)

#[CODE 0]
def main():
    jsonResult = []
    result = []
    natName=''
    print("<< 국내 입국한 외국인의 통계 데이터를 수집합니다. >>")
    
    # 데이터 수집할 국가코드 입력 
    nat_cd = input('국가 코드를 입력하세요(중국: 112 / 일본: 130 / 미국: 275) : ')
    # 데이터 수집할 시작연도 입력     
    nStartYear =int(input('데이터를 몇 년부터 수집할까요? : '))
    # 데이터 수집할 마지막 연도 입력     
    nEndYear = int(input('데이터를 몇 년까지 수집할까요? : '))
    ed_cd = "E"     #E : 방한외래관광객, D : 해외 출국
    
    #getTourismStatsService()함수를 호출하여 반환받은 수집 데이터를 jsonResult,result, natName, dataEND에 저장
    jsonResult, result, natName, ed, dataEND =getTourismStatsService(nat_cd,
                                            ed_cd, nStartYear, nEndYear) #[CODE 3]

    if (natName=='') : #URL 요청은 성공하였지만, 데이터 제공이 안된 경우
        print('데이터가 전달되지 않았습니다. 공공데이터포털의 서비스 상태를 확인하기 바랍니다.')
    else:
        #파일저장 1 : json 파일
        #수집 데이터를 딕셔너리의 리스트로 저장한 jsonResult를 
        #json.dumps()를 통해json 객체로 변환한 후 JSON 파일에 저장       
        with open('./%s_%s_%d_%s.json' % (natName, ed, nStartYear, dataEND), 'w', 
                    encoding='utf8') as outfile:
            jsonFile  = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
            outfile.write(jsonFile)
        #파일저장 2 : csv 파일   
        columns = ["입국자국가", "국가코드", "입국연월", "입국자 수"]
        #수집 데이터를 리스트로 저장한 result를 데이터프레임으로 변환
        result_df = pd.DataFrame(result, columns = columns)
        #데이터프레임 객체인 result_df를 CSV 파일로 저장
        result_df.to_csv('./%s_%s_%d_%s.csv' % (natName, ed, nStartYear, dataEND),
                    index=False, encoding='cp949')
    
if __name__ == '__main__':
    main()
