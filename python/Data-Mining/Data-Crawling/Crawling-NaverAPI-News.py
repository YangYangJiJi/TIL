import os
import sys
import urllib.request
import datetime
import time
import json

client_id = '(client ID)'
client_secret = '(client secret)'


#[CODE 1]
def getRequestUrl(url):    
    #매개변수로 받은 url에 대한 요청을 보낼 객체를 생성
    req = urllib.request.Request(url)
    #API를 사용하기 위한 Client ID와 Client Secret 코드를 요청 객체 헤드에 추가
    req.add_header("X-Naver-Client-Id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    
    try: 
        #요청 객체를 보내고 그에 대한 응답을 받아 response 객체에 저장
        response = urllib.request.urlopen(req)

        #getcode()로 response 객체에 저장된 코드를 확인
        if response.getcode() == 200: #200이면 요청이 정상처리된 것이므로
            print ("[%s] Url Request Success" % datetime.datetime.now()) #성공 메시지를 파이썬 셸 창에 출력하고
            return response.read().decode('utf-8') #응답을 utf-8 형식으로 디코딩하여 반환
    
    #요청이 처리되지 않은 예외 사항exception이 발생하면
    #에러 메시지를 파이썬 셸 창에 출력
    except Exception as e: 
        print(e) 
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None

#[CODE 2]
#네이버 검색 API 정보에 따라 요청 URL을 구성
def getNaverSearch(node, srcText, start, display):    
    base = "https://openapi.naver.com/v1/search"
    node = "/%s.json" % node
    parameters = "?query=%s&start=%s&display=%s" % (urllib.parse.quote(srcText), start, display)
    
    url = base + node + parameters #url 구성하기
    
    #완성한 url을 이용하여 getRequestUrl() 함수를 호출하여 받은 utf-8 디코드 응답을responseDecode에 저장    
    responseDecode = getRequestUrl(url)   #[CODE 1]
    
    if (responseDecode == None):
        return None
    #요청 결과를 응답 JSON으로 받기
    #서버에서 받은 JSON 형태의 응답 객체를 파이썬 객체로 로드하여 반환
    else:
        return json.loads(responseDecode) 

#[CODE 3]
#응답 데이터를 정리하여 리스트에 저장하기
#검색 결과가 들어 있는 post 객체에서 필요한 데이터 항목을 추출하여 변수에 저장
def getPostData(post, jsonResult, cnt):    
    title = post['title']
    description = post['description']
    org_link = post['originallink']
    link = post['link']
    
    #네이버에서 제공하는 시간인 pubDate는 문자열 형태이므로 날짜 객체로 변환
    #pubDate는 그리니치 평균시사용. 한국 표준시보다 9시간 느리므로 +0900 을 사용해 한국 표준시로 맞춤
    pDate = datetime.datetime.strptime(post['pubDate'],  '%a, %d %b %Y %H:%M:%S +0900')
    pDate = pDate.strftime('%Y-%m-%d %H:%M:%S') #'연-월-일 시:분:초' 형식
    
    #저장한 데이터를 딕셔너리 형태인 {‘키’:값}으로 구성하여 
    #리스트 객체인 jsonResult에 추가
    jsonResult.append({'cnt':cnt, 'title':title, 'description': description, 
'org_link':org_link,   'link': org_link,   'pDate':pDate})
    return    

#[CODE 0]
#네이버 뉴스 검색을 위해 검색 API 대상을 news로 설정
def main():
    node = 'news'   # 크롤링 할 대상
    srcText = input('검색어를 입력하세요: ') #사용자로부터 입력받음
    cnt = 0
    jsonResult = []

    #getNaverSearch() : 1부터 100개의 검색 결과를 처리함
    jsonResponse = getNaverSearch(node, srcText, 1, 100)  #[CODE 2]
    total = jsonResponse['total']
    while ((jsonResponse != None) and (jsonResponse['display'] != 0)):   
        for post in jsonResponse['items']:
            cnt += 1
            #getPostData() : 검색결과 한 개를 처리함.
            getPostData(post, jsonResult, cnt)  #[CODE 3]       
        
        start = jsonResponse['start'] + jsonResponse['display']
        jsonResponse = getNaverSearch(node, srcText, start, 100)  #[CODE 2]
       
    print('전체 검색 : %d 건' %total)
    
    with open('%s_naver_%s.json' % (srcText, node), 'w', encoding='utf8') as outfile:
        #리스트를 JSON파일로 저장하기
        jsonFile = json.dumps(jsonResult,  indent=4, sort_keys=True,  ensure_ascii=False)
                        
        outfile.write(jsonFile)
        
    print("가져온 데이터 : %d 건" %(cnt))
    print ('%s_naver_%s.json SAVED' % (srcText, node))
    
if __name__ == '__main__':
    main()
