# selenium의 webdriver를 사용하기 위한 import
from selenium import webdriver

# selenium으로 키를 조작하기 위한 import
from selenium.webdriver.common.keys import Keys

# 페이지 로딩을 기다리는데에 사용할 time 모듈 import
import time
from bs4 import BeautifulSoup
from selenium.webdriver.common.by import By

# 크롬드라이버 실행
driver = webdriver.Chrome() 

#크롬 드라이버에 url 주소 넣고 실행
driver.get('http://localhost:8888/MVVM_EMP/emp.html')

print(driver.page_source)

# 페이지가 완전히 로딩되도록 3초동안 기다림
time.sleep(1)

#Tag명으로 요소 추출
tables = driver.find_elements(By.CSS_SELECTOR,'table')

# print(tables[0].text)

trs = tables[0].find_elements(By.CSS_SELECTOR,'tr')

for idx,tr in enumerate(trs):
    if idx==0:
        continue
    tds = tr.find_elements(By.CSS_SELECTOR,'td')
    print(tds[1].text,tds[3].text)
    print()
