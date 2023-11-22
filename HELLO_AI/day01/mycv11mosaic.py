import cv2
print(cv2.__version__)

face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

img = cv2.imread('son.jpg')

# 얼굴 인식을 위해 얼굴 검출기를 로드합니다.
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_alt.xml')

# 이미지에서 얼굴을 검출합니다.
faces = face_cascade.detectMultiScale(img, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))

v=20
# 검출된 얼굴 주위에 사각형을 그립니다.
for (x, y, w, h) in faces:
    # cv2.rectangle(img, (x, y), (x+w, y+h), (0, 255, 0), 2)
    roi_color = img[y : y + h, x : x + w]

    roi = cv2.resize(roi_color, (w // v, h // v))
    roi = cv2.resize(roi, (w, h), interpolation=cv2.INTER_AREA)
    img[y:y+h, x:x+w] = roi

# 결과 이미지를 화면에 출력합니다.
cv2.imshow('Face Detection', img)

cv2.waitKey() # 창 띄어두기
