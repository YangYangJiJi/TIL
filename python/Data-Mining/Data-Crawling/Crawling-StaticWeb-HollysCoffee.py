from bs4 import BeautifulSoup
import urllib.request
import pandas as pd
import datetime

#[CODE 1]
#BeautifulSoup 객체를 생성하여 파싱
def hollys_store(result):
    for page in range(1,51): #1-51페이지까지 반복해서 url 생성
        Hollys_url = 'https://www.hollys.co.kr/store/korea/korStore.do?pageNo=%d&sido=&gugun=&store=' %page
        print(Hollys_url)
        #url 요청하여 응답받은 웹페이지 저장
        html = urllib.request.urlopen(Hollys_url)
        soupHollys = BeautifulSoup(html, 'html.parser') #BeautifulSoup 객체생성
        tag_tbody = soupHollys.find('tbody')
        for store in tag_tbody.find_all('tr'):
            if len(store) <= 3:
                break
            store_td = store.find_all('td')
            store_name = store_td[1].string
            store_sido = store_td[0].string
            store_address = store_td[3].string
            store_phone = store_td[5].string
            
            #tr태그 하위의 td태그 중에서 필요한 항목만 추출하여 result리스트에 추가 저장
            result.append([store_name]+[store_sido]+[store_address]+[store_phone])
    return

#[CODE 0]
def main():
    result = []
    print('Hollys store crawling >>>>>>>>>>>>>>>>>>>>>>>>>>')
    hollys_store(result)   #[CODE 1] 호출 

    #pandas를 이용해서 크롤링한 데이터를 테이블 형태의 dataframe형태로 저장
    hollys_tbl = pd.DataFrame(result, columns=('store', 'sido-gu', 'address','phone'))
    #csv로 dataframe 저장
    hollys_tbl.to_csv('hollys.csv', encoding='cp949', mode='w', index=True)
    del result[:]
       
if __name__ == '__main__':
     main()
