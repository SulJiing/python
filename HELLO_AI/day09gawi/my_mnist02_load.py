import tensorflow as tf
import numpy as np
from keras.models import load_model

x_train = np.array([
    [1,0,0],
    [0,1,0],
    [0,0,1]
])

y_train = np.array([
    2,0,1 # 라벨이 들어감
])

model = load_model('gawi.h5')

pred = model.predict(x_train)

print(pred)
# 연습
for p in pred:
    myidx = np.argmax(p)
    print("myidx",myidx,p)
 
# # 실전
# x_rf = np.array([
#     [1,0] #  사용자가 낸 홀
# ])   
# pred_rf = model.predict(x_rf) # 학습한 데이터로 홀의 반대를 내는 인공지능
#
# print(np.argmax(pred_rf))