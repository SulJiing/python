import cv2
import numpy as np

video = "sarang.mp4" # 동영상 파일 경로

img = cv2.imread('mask/118.png', cv2.IMREAD_UNCHANGED)
cv2.imshow('aaa',img)
mask = img[:,:,3]
cv2.waitKey(0)

cap = cv2.VideoCapture(video) # 동영상 캡쳐 객체 생성 

face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_alt.xml')

if cap.isOpened():
    while True:
        ret, frame = cap.read()     
        if ret:
        
            gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
            face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_alt.xml')
            faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))
            for (x, y, w, h) in faces:
                roi_color = frame[y : y + h, x : x + w]
                v=30
                roi = img
                roi = cv2.resize(roi, (w, h), interpolation=cv2.INTER_AREA)
                frame[y:y+h, x:x+w] = roi
                cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
            cv2.imshow('frame', frame)
        
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break                


cap.release() 
cv2.destroyAllWindows()