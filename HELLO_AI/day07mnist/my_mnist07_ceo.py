from tensorflow import keras
from keras.models import load_model
from tensorboard.compat import tf
import cv2
import numpy as np

(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

x_train = x_train.reshape((60000, 28, 28, 1)) / 255.0
x_test = x_test.reshape((10000, 28, 28, 1)) / 255.0

model = tf.keras.models.load_model('first.h5')

# model.summary()

pred = model.predict(x_test)

print(pred.shape)

count = 0
for idx,i in enumerate(y_test):
    myidx = np.argmax(pred[idx])
    goog = y_test[idx]
    if myidx != goog:
        cv2.imwrite('x/{}_{}_{}.png'.format(idx,myidx,y_test[idx]),x_test[idx])
        count += 1
        
print(count)