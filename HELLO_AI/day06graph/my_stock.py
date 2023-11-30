import time
import requests
from bs4 import BeautifulSoup as bs
import datetime
from day06graph import daostock

res = requests.get("https://stock.mk.co.kr/domestic/all_stocks?type=kospi&status=industry")
soup = bs(res.text, "html.parser")

trs = soup.select(".row_sty")
ds = daostock()

s_name = ""
price = 0
s_code = ""
y_md = ""

for tr in trs:
    tds1 = tr.select(".st_name")
    tds2 = tr.select(".st_price")
    att = tr.select('a')[0]['href']
    attr = att.split('/')[3]
    # print(tds1[0].text, tds2[0].text,attr,time.strftime('%Y%m%d_%H%M'))
    s_name = tds1[0].text.strip()
    price = tds2[0].text.strip()
    s_code = attr.strip()
    y_md = time.strftime('%Y%m%d_%H%M').strip()
    ds.insert(s_name, price, s_code, y_md)
    
# now = datetime.datetime.now()
# ymd = now.strftime('%Y%m%d_%H%M')
#
# names = soup.select(".st_name")
# for idx,n in enumerate(names):
#     s_name = n.text.strip()
#     s_code = n.select("a")[0]['href'].split("/")[3]
#     price = n.parent.select(".price")[0].text.replace(",","")
#     print(idx,s_name,s_code,price,ymd)