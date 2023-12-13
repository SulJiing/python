import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from selenium import webdriver
from selenium.webdriver.common.by import By
from flask import json
import flask
from flask.globals import request
from day11crawl2.dao_bus_path import DaoBusPath

form_class = uic.loadUiType("my_daejeon_qt.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self) :
        QMainWindow.__init__(self)
        self.dbp = DaoBusPath()
        self.driver = webdriver.Firefox()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        self.driver.get("http://traffic.daejeon.go.kr/bus/busInfo")
        
    def myclick(self) :
        #root > div.mapWrap > aside > div > article > div > ul > li:nth-child(1) > span.st_name
        spans = self.driver.find_elements(By.CSS_SELECTOR,"span[class='st_name']")
        
        for idx,s in enumerate(spans):
            
            bus_type = self.driver.find_elements(By.CSS_SELECTOR,"mark[class*='bus_type']")
            bus_no = self.driver.find_elements(By.CSS_SELECTOR,"strong[class='bus_no']")
            
            bun_info = bus_type[0].text+bus_no[0].text
            
            # 부모 element를 찾기위한 코드
            myparent = s.find_element(By.XPATH, '..')            
            
            sp2 = myparent.find_elements(By.CSS_SELECTOR,"span[class='st_id']")
            
            # input 요소 찾기
            ip = myparent.find_elements(By.CSS_SELECTOR, "input")[0]
    
            # Hidden input 요소의 값을 가져오기
            txt = ip.get_attribute("value")
            
            # print(value)
            
            # JSON 형식의 문자열을 파이썬 객체로 변환
            myjson = json.loads(txt)
            
            lat = myjson['gpsLati']
            lng = myjson['gpsLong']
            bus_name = s.text
            bus_id = sp2[0].text
            
            cnt = self.dbp.insert(bun_info, idx, bus_id, bus_name, lat, lng)
            
            print(f"버스번호 : {bun_info}, 정류장ID : {bus_id}, 정류장명 : {bus_name}, 위도 : {lat}, 경도 : {lng}")
            print()
            
if __name__ == "__main__" :
    app = QApplication(sys.argv)
    window = MainClass() 
    app.exec_()