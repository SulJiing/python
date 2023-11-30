import os
import sys
import urllib.request
from bs4 import BeautifulSoup as bs
import json

client_id = "cIbd4UZ6FDF1wkGVGhi1"
client_secret = "46gl7SxovB"
encText = urllib.parse.quote("장원영")
url = "https://openapi.naver.com/v1/search/blog?query=" + encText # JSON 결과
# url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText # XML 결과
request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()

response_body = response.read()
txt = response_body.decode('utf-8')

json_ob = json.loads(txt)
list = json_ob["items"]
print(json_ob)
print(json_ob["items"][0]["title"])
print(json_ob["items"][0]["link"])

for b in list:
    print(b["title"])
    print(b["link"])
