import requests
from bs4 import BeautifulSoup as bs

res = requests.get("http://localhost:8888/MVVM_EMP/emp.html")
res.encoding = "UTF-8"
print(res.text)
soup = bs(res.text, "html.parser") # String을 html태그로 바꿔줌
print(soup)

trs = soup.select("tr > td")

trss = soup.select("tr")
for idx,tr in enumerate(trss):
    if idx == 0:
        continue
    tds = tr.select("td")
    # print(tds[1].text,tds[3].text)