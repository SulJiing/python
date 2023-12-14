import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from selenium import webdriver
from selenium.webdriver.common.by import By
from flask import json
import flask
from flask.globals import request
from day11crawl2.dao_bus_path import DaoBusPath
import time

form_class = uic.loadUiType("my_daejeon_all_qt.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self) :
        QMainWindow.__init__(self)
        self.dbp = DaoBusPath()
        self.driver = webdriver.Firefox()
        self.setupUi(self)
        self.bp_names = []
        self.cnt = 0
        self.pb.clicked.connect(self.myclick)
        self.pb_all.clicked.connect(self.my_busall)
        self.pb_macro.clicked.connect(self.my_macro)
        self.show()
        self.driver.get("http://traffic.daejeon.go.kr/bus/busInfo")
        self.my_busall()
        
    def my_macro(self):
        
        for idx,bp_name in enumerate(self.bp_names):
            ul = self.driver.find_element(By.CSS_SELECTOR,"ul[class='route']")
            lis = ul.find_elements(By.CSS_SELECTOR, "li")
            lis[self.cnt].click()
            time.sleep(2)
            self.myclick()
            time.sleep(2)
        
    def my_busall(self):
        ul = self.driver.find_element(By.CSS_SELECTOR,"ul[class='route']")
        marks = ul.find_elements(By.CSS_SELECTOR, "mark")
        strongs = ul.find_elements(By.CSS_SELECTOR, "strong")
        
        # 2번 눌러도 중복 안되게끔 삭제 시킴
        self.bp_names.clear()
        
        for idx,mark in enumerate(marks):
            bp_name = f"{mark.text}{strongs[idx].text}"
            self.bp_names.append(bp_name)
            print(idx,bp_name)
        print("self.bp_names",self.bp_names,len(self.bp_names))
               
    def myclick(self) :
        spans = self.driver.find_elements(By.CSS_SELECTOR,"span[class='st_name']")
        
        for idx,s in enumerate(spans):
            
            # 부모 element를 찾기위한 코드
            myparent = s.find_element(By.XPATH, '..')
            
            sp2 = myparent.find_elements(By.CSS_SELECTOR,"span[class='st_id']")
            
            # input 요소 찾기
            ip = myparent.find_elements(By.CSS_SELECTOR, "input")[0]
    
            # Hidden input 요소의 값을 가져오기
            txt = ip.get_attribute("value")
            
            # JSON 형식의 문자열을 파이썬 객체로 변환
            myjson = json.loads(txt)
            
            lat = myjson['gpsLati']
            lng = myjson['gpsLong']
            bus_name = s.text
            bus_id = sp2[0].text
            
            cnt = self.dbp.insert(self.bp_names[self.cnt], idx, bus_id, bus_name, lat, lng)
            
            print(f"버스번호 : {self.bp_names[self.cnt]}, 정류장ID : {bus_id}, 정류장명 : {bus_name}, 위도 : {lat}, 경도 : {lng}")
            print()
        self.cnt += 1
        # 다시 처음화면으로 진행
        self.driver.get("http://traffic.daejeon.go.kr/bus/busInfo")
            
if __name__ == "__main__" :
    app = QApplication(sys.argv)
    window = MainClass() 
    app.exec_()