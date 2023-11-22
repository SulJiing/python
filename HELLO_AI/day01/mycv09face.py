import cv2

# 이미지 파일을 로드합니다.
image = cv2.imread('dons.jpg')

# 이미지를 회색으로 변환합니다. (얼굴 인식은 흑백 이미지에서 수행되므로)
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY) # 2 = to

# 얼굴 인식을 위해 얼굴 검출기를 로드합니다.
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_alt.xml')

# 이미지에서 얼굴을 검출합니다.
faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))

# 검출된 얼굴 주위에 사각형을 그립니다.
for (x, y, w, h) in faces:
    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)

# 결과 이미지를 화면에 출력합니다.
cv2.imshow('Face Detection', image)
cv2.waitKey(0)
cv2.destroyAllWindows()