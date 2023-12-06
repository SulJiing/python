import tensorflow as tf
import numpy as np

x_train = np.array([
    [1,0],
    [0,1]
])

y_train = np.array([
    0,1
])

# 3. 모델 구성
model = tf.keras.models.Sequential([
    tf.keras.layers.Flatten(input_shape=(2,)),
    tf.keras.layers.Dense(512, activation=tf.nn.relu), #퍼셉트론1개
    tf.keras.layers.Dense(512, activation=tf.nn.relu), #딥러닝
    tf.keras.layers.Dense(2, activation=tf.nn.softmax)
])

# 4. 모델 컴파일
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 5. 모델 훈련
model.fit(x_train, y_train, epochs=20)

# 저장
model.save('holl.h5')

pred = model.predict(x_train)

print(pred)
# 연습
for p in pred:
    myidx = np.argmax(p)
    print("myidx",myidx,p)
 
# 실전
x_rf = np.array([
    [1,0] #  사용자가 낸 홀
])   
pred_rf = model.predict(x_rf) # 학습한 데이터로 홀의 반대를 내는 인공지능

print(np.argmax(pred_rf))
    