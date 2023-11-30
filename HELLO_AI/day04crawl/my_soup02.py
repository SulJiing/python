import requests
from bs4 import BeautifulSoup as bs

res = requests.get("http://localhost:8888/HELLO_WEB_EMP/emp_list")
# print(res.text)
soup = bs(res.text, "html.parser") # String을 html태그로 바꿔줌
# print(soup.find_all("td")[0]) # td태그들을 쉼표 단위로 끊어서 배열로 보여줌

trs = soup.select("tr > td")

# print(trs[5].text,trs[7].text,trs[9].text,trs[11].text)

trss = soup.select("tr")
for idx,tr in enumerate(trss):
    if idx == 0:
        continue
    tds = tr.select("td")
    print(tds[1].text,tds[3].text)
