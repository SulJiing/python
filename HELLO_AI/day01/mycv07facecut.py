import cv2
print(cv2.__version__)

img = cv2.imread('bp.jpg')

# def cutting_face(img,name):
# 얼굴 인식을 위해 얼굴 검출기를 로드
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# 이미지에서 얼굴검출
i=0
faces = face_cascade.detectMultiScale(img, 1.3, 5)
for (x, y, w, h) in faces:
    ++i
    cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
    cropped = img[y: y+h, x: x+w]
    resize = cv2.resize(cropped,(180,180))
    cv2.imshow("crop&resize",resize)
    cv2.waitKey()
    cv2.imwrite(str(i)+".jpg", cropped)
    i += 1