import tensorflow as tf
from tensorflow import keras
import numpy as np

# MNIST 데이터셋 로드
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

# 입력 데이터 전처리
x_train = x_train.reshape((60000, 28, 28, 1)) / 255.0
x_test = x_test.reshape((10000, 28, 28, 1)) / 255.0

# 모델 구성 = 뇌
model = keras.Sequential([
    keras.layers.Conv2D(32, (3,3), activation='relu', input_shape=(28,28,1)),
    keras.layers.MaxPooling2D((2,2)),
    # 다차원의 입력을 1차원으로 평탄화합니다.
    keras.layers.Flatten(),
    keras.layers.Dense(10, activation='softmax')
])

# 모델 컴파일
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 모델 학습 (값,값,돌릴횟수,램사용?클수록 실행하면 분모가 줄어듬,옵션) - 뒤에 3개는 없어도 기본값으로 들어감 - accuracy:정확도
model.fit(x_train, y_train, epochs=1, batch_size=128, validation_split=0.2)

# 예측
pred = model.predict(x_test)

print(pred.shape)

count = 0
for idx,i in enumerate(y_test):
    myidx = np.argmax(pred[idx])
    goog = y_test[idx]
    if myidx == goog:
        count += 1
        
avg = (float)(count/100)

print(avg,'%')

# print("myidx",myidx,"google",goog)