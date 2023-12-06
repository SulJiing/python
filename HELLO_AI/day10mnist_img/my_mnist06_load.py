from tensorflow import keras
from keras.models import load_model
import cv2
import numpy as np

model = load_model('first.h5')

model.summary()

# 이미지 로드 및 그레이로 벼환
img = cv2.imread('9_2.png')
img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
# 크기 조절
size = (28,28)
img_resize = cv2.resize(img_gray,(28,28))
# 이미지 출력해봄
cv2.imshow('image', img_resize)
cv2.waitKey(1000)

# 이미지 shape
img_resize2 = img_resize.reshape((1, 28, 28, 1)) / 255.0

# 색반전
img_resize2 = 1 - img_resize2
print(img_resize2)

# 예측
pred = model.predict(img_resize2)

print(pred)
print(np.argmax(pred))