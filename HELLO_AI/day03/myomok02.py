import sys
from PyQt5 import uic, QtGui, QtCore
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton

# UI파일 연결
form_class = uic.loadUiType("myomok02.ui")[0]

# 프로그램 메인을 담당하는 Class 선언
class MainClass(QMainWindow, form_class):
    
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        
        self.flag_b = False
        self.arr2D = [
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        ]
        self.lbl2D = []  # 버튼들을 저장할 리스트
        self.init_buttons()
        self.show()

    def init_buttons(self):
        for i in range(10):
            row = []
            for j in range(10):
                btn = QPushButton("", self)
                btn.setIcon(QtGui.QIcon('0.png'))
                btn.setIconSize(QtCore.QSize(40, 40))
                btn.setGeometry(QtCore.QRect(j * 40, i * 40, 40, 40))
                btn.clicked.connect(self.my_click)
                row.append(btn)
            self.lbl2D.append(row)

    def my_click(self):
        sender = self.sender()
        i, j = self.btnidx(sender)
        
        if self.arr2D[i][j] == 0:
            if self.flag_b:
                sender.setIcon(QtGui.QIcon("2.png"))
                self.arr2D[i][j] = 1
            else:
                sender.setIcon(QtGui.QIcon("1.png"))
                self.arr2D[i][j] = 2

            self.flag_b = not self.flag_b

    def btnidx(self, button):
        for i in range(10):
            for j in range(10):
                if self.lbl2D[i][j] == button:
                    return i, j
                
    def resetBoard(self):
        for i in range(10):
            for j in range(10):
                self.arr2D[i][j] = 0
                self.lbl2D[i][j].setIcon(QtGui.QIcon('0.png'))
                self.flag_b = False
                
if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec_()
