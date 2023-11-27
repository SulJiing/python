import sys

from PyQt5 import uic, QtGui
from PyQt5.QtWidgets import QApplication, QMainWindow

# UI파일 연결
form_class = uic.loadUiType("myomok01.ui")[0]

# 프로그램 메인을 담당하는 Class 선언
class MainClass(QMainWindow, form_class):
    def __init__(self) :
        QMainWindow.__init__(self)
        # 연결한 Ui를 준비한다.
        self.setupUi(self)
        self.pb.clicked.connect(self.pbFunction)
        self.lbl.mousePressEvent = self.mylblclick
        # 화면을 보여준다.
        self.show()
        
    def mylblclick(self, event):
        self.lbl.setPixmap(QtGui.QPixmap("1.png"))

    def pbFunction(self):
        self.pb.setIcon(QtGui.QIcon("1.png"))

if __name__ == "__main__" :
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec_()