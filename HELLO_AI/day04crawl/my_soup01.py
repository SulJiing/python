import requests
from bs4 import BeautifulSoup as bs

res = requests.get("http://localhost:8888/HELLO_WEB_EMP/emp_list")
# print(res.text)
soup = bs(res.text, "html.parser") # String을 html태그로 바꿔줌
# print(soup.find_all("td")[0]) # td태그들을 쉼표 단위로 끊어서 배열로 보여줌

trs = soup.find_all("tr")

for idx,t in enumerate(trs):
    if idx == 0:
        continue
    tds = t.find_all("td")
    print(tds[1].text,tds[3].text)

# soup1 = soup.find_all("tr")[1]
# soup2 = soup.find_all("tr")[2]
#
# soo1 = soup1.find_all("td")[1].text
# soo2 = soup1.find_all("td")[3].text
# print(soo1,soo2)
#
# soo3 = soup2.find_all("td")[1].text
# soo4 = soup2.find_all("td")[3].text
# print(soo3,soo4)
