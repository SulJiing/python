import tensorflow as tf
from tensorflow import keras

# MNIST 데이터셋 로드
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

# 입력 데이터 전처리
x_train = x_train.reshape((60000, 28, 28, 1)) / 255.0
x_test = x_test.reshape((10000, 28, 28, 1)) / 255.0

# 모델 구성 = 뇌
model = tf.keras.models.Sequential([
    tf.keras.layers.Flatten(input_shape=((28*28),)),
    tf.keras.layers.Dense(512, activation=tf.nn.tanh), #퍼셉트론1개
    tf.keras.layers.Dense(512, activation=tf.nn.relu), #딥러닝
    tf.keras.layers.Dense(10, activation=tf.nn.softmax)
])

# 모델 컴파일
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 모델 학습 (값,값,돌릴횟수,램사용?클수록 실행하면 분모가 줄어듬,옵션) - 뒤에 3개는 없어도 기본값으로 들어감 - accuracy:정확도
model.fit(x_train, y_train, epochs=1, batch_size=128, validation_split=0.2)

# 모델 평가
test_loss, test_acc = model.evaluate(x_test, y_test)
print('Test accuracy:', test_acc)