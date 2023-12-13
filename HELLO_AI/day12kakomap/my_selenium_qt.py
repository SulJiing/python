import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.common.by import By

form_class = uic.loadUiType("my_selenium_qt.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self) :
        QMainWindow.__init__(self)
        self.driver = webdriver.Firefox()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        self.driver.get("https://map.kakao.com/")
        
    def myclick(self) :
        strongs = self.driver.find_elements(By.CSS_SELECTOR,"strong[class='busstop']")
        for idx,s in enumerate(strongs):
            
            # 부모 element를 찾기위한 코드
            obj_sele_s = s.find_element(By.XPATH, '..')
            
            obj_busstop = obj_sele_s.find_elements(By.CSS_SELECTOR,"p[class='busid']")
            
            sta_name = s.text
            sta_id = obj_busstop[0].text
            
            print(idx,sta_name,sta_id)

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    window = MainClass() 
    app.exec_()