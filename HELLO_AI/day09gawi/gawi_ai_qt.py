import sys

from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from random import random
from keras.models import load_model
import numpy as np

form_class = uic.loadUiType("gawi_ai_qt.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self) :
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.show()
        self.pb.clicked.connect(self.pbFunction)

    def pbFunction(self):
        
        mine = self.le_mine.text()
        model = load_model('gawi.h5')
        
        if mine=="가위":
            pred = model.predict(np.array([[1,0,0]]))
        elif mine=="바위":
            pred = model.predict(np.array([[0,1,0]]))
        else:
            pred = model.predict(np.array([[0,0,1]]))
               
        preds = np.argmax(pred)
        
        if preds == 2 :
            com = "보"
        elif preds == 0 :
            com = "가위"
        else :
            com = "바위" 
        
        self.le_com.setText(com)
        
        if com == "가위" and mine == "가위"  :  result = "비김"
        if com == "가위" and mine == "바위"  :  result = "이김"
        if com == "가위" and mine == "보"  :  result = "짐"
        
        if com == "바위" and mine == "가위"  :  result = "짐"
        if com == "바위" and mine == "바위"  :  result = "비김"
        if com == "바위" and mine == "보"  :  result = "이김"
        
        if com == "보" and mine == "가위"  :  result = "이김"
        if com == "보" and mine == "바위"  :  result = "짐"
        if com == "보" and mine == "보"  :  result = "비김"
        self.le_result.setText(result)
        
if __name__ == "__main__" :
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec_()