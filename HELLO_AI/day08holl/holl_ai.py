import tensorflow as tf
import numpy as np
from keras.models import load_model

x_train = np.array([
    [1,0],
    [0,1]
])

y_train = np.array([
    1,0
])

model = load_model('holl.h5')

mine = input("홀/짝을 선택하시오")
if mine=="홀":
    mines=1,0
else:
    mines=0,1

# 실전
# 학습한 데이터로 홀의 반대를 내는 인공지능
pred_rf = model.predict(np.array([[mines]])) 

print(pred_rf)

pred_rfs = np.argmax(pred_rf)

if pred_rfs==1:
    pred_rfs = "짝"
else:
    pred_rfs = "홀"
    
if pred_rfs == mine:
    result = "축하합니다! 컴퓨터를 상대로 승리하셨습니다!!!"
else:
    result = "패~~~~~~~배!"

print(f"사용자가 입력한 값 {mine} 컴퓨터는 {pred_rfs} 결과는 {result}")