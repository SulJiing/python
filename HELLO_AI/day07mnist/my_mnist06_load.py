from tensorflow import keras
from keras.models import load_model
from tensorboard.compat import tf

(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

x_train = x_train.reshape((60000, 28, 28, 1)) / 255.0
x_test = x_test.reshape((10000, 28, 28, 1)) / 255.0

model = tf.keras.models.load_model('first.h5')

model.summary()

pred = model.predict(x_test)

print(pred.shape)