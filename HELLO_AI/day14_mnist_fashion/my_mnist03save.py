import tensorflow as tf
from tensorflow import keras
import cv2

(x_train, y_train), (x_test, y_test) = tf.keras.datasets.fashion_mnist.load_data()

print(x_train.shape)
print(y_train.shape)
print(x_test.shape)
print(y_test.shape)

for i in range(60000):
    cv2.imwrite('img/{}/{}.png'.format(y_train[i],i),x_train[i])