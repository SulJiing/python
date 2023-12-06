import sys

from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from keras.models import load_model
import numpy as np


form_class = uic.loadUiType("holl_ai_qt.ui")[0]

class MainClass(QMainWindow, form_class):
    
    def __init__(self) :
        self.model = load_model('holl.h5')
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.show()
        self.pb.clicked.connect(self.pbFunction)

    def pbFunction(self):
        
        mine = self.le_mine.text()
        if mine=="홀":
            mines=1,0
        else:
            mines=0,1 
            
        pred_rf = self.model.predict(np.array([[mines]])) 
        pred_rfs = np.argmax(pred_rf)
        
        if pred_rfs==1:
            pred_rfs = "짝"
        else:
            pred_rfs = "홀"
            
        self.le_com.setText(pred_rfs)
            
        if pred_rfs == mine:
            result = "축하합니다! 컴퓨터를 상대로 승리하셨습니다!!!"
        else:
            result = "패~~~~~~~배!"
        self.le_result.setText(result)
        
if __name__ == "__main__" :
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec_()