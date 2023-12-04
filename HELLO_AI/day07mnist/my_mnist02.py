import tensorflow as tf
from tensorflow import keras
import cv2

# MNIST 데이터셋 로드
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

for idx,t in enumerate(x_train):
    cv2.imwrite('img/{}/{}.png'.format(y_train[idx],idx),t)