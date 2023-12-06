from random import random
from keras.models import load_model
import numpy as np

x_train = np.array([
    [1,0,0],
    [0,1,0],
    [0,0,1]
])

y_train = np.array([
    2,0,1 # 라벨이 들어감
])

mine = input("가위/바위/보을 선택하시오")
model = load_model('gawi.h5')

mines = ""
com = ""
result = ""

if mine=="가위":
    pred = model.predict(np.array([[1,0,0]]))
elif mine=="바위":
    pred = model.predict(np.array([[0,1,0]]))
else:
    pred = model.predict(np.array([[0,0,1]]))

preds = np.argmax(pred)
print(preds)

if preds == 2 :
    com = "보"
elif preds == 0 :
    com = "가위"
else :
    com = "바위"  
    
if com == "가위" and mine == "가위"  :  result = "비김"
if com == "가위" and mine == "바위"  :  result = "이김"
if com == "가위" and mine == "보"  :  result = "짐"

if com == "바위" and mine == "가위"  :  result = "짐"
if com == "바위" and mine == "바위"  :  result = "비김"
if com == "바위" and mine == "보"  :  result = "이김"

if com == "보" and mine == "가위"  :  result = "이김"
if com == "보" and mine == "바위"  :  result = "짐"
if com == "보" and mine == "보"  :  result = "비김"

print("나:",mine)
print("컴:",com)
print("결과:",result)

