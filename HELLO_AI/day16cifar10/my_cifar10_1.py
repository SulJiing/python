# airplane : 0
# automobile : 1
# bird : 2
# cat : 3
# deer : 4
# dog : 5
# frog : 6
# horse : 7
# ship : 8
# truck : 9
import numpy as np
from keras.utils import np_utils
from keras.datasets import cifar10
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.layers import Conv2D, MaxPooling2D, Flatten
import matplotlib.pyplot as plt
import time
import cv2

(x_train, y_train), (x_test, y_test) = cifar10.load_data()

for i in range(1000):
    cv2.imwrite('img/{}/{}.png'.format(y_train[i][0],i),x_train[i])
