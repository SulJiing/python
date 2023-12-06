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
        # li.BusNumberLineItemView의 자식 div 중 첫 번째 자식
        divs = self.driver.find_elements(By.CSS_SELECTOR,'li.BusNumberLineItemView > div:nth-child(1)')

        # 각 div 요소에 대해 반복하면서 strong 태그의 title 속성 값 출력
        for idx,div in enumerate(divs):
            # div 안에서 'strong' 첫 번째 strong 태그를 찾음
            strong = div.find_element(By.CSS_SELECTOR, 'strong')
            title = strong.get_attribute("title")
            print(title)
            print()
        
if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    window = MainClass() 
    app.exec_()