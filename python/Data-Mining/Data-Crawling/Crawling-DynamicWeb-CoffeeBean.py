from bs4 import BeautifulSoup
import urllib.request
import pandas as pd
import datetime
from selenium import webdriver
import time
import csv

#[CODE 1]
def CoffeeBean_store(result):
    CoffeeBean_URL = "https://www.coffeebeankorea.com/store/store.asp"
    wd = webdriver.Chrome() #크롬 webdriver 객체생성

    for i in range(1, 389): #마지막 매장번호(최근 신규 매장번호) 까지 반복
        wd.get(CoffeeBean_URL)
        time.sleep(1) #웹페이지 연결할 동안 1초 대기
        try:
            wd.execute_script("storePop2(%d)" %i)
            time.sleep(1) #웹페이지 연결할 동안 1초 대기
            html = wd.page_source #js함수가 수행된 페이지의 소스코드를 html에 저장
            
            #저장한 html소스를 parsing하기 위해 beautifulSoup 객체생성
            soupCB = BeautifulSoup(html, 'html.parser')
            store_name_h2 = soupCB.select("div.store_txt > h2")
            store_name = store_name_h2[0].string
            print(store_name) #매장 이름 출력하기
            store_info = soupCB.select("div.store_txt > table.store_table > tbody > tr > td")
            store_address_list = list(store_info[2])
            store_address = store_address_list[0]
            store_phone = store_info[3].string
            result.append([store_name]+[store_address]+[store_phone])
        except:
            continue
        return

#[CODE 0]
def main():
    result = []
    print('CoffeeBean store crawling >>>>>>>>>>>>>>>>>>>>>>>>')
    CoffeeBean_store(result) #[CODE 1]

#    CB_tbl = pd.DataFrame(result, columns = ('store', 'address','phone'))
#    CB_tbl.to_csv('./CoffeeBean.csv', encoding = 'cp949', mode = 'w', index = True)
    with open("CoffeeBean.csv", "w") as file:
        writer = csv.writer(file)
        writer.writerows(result)

if __name__ == '__main__':
    main()
