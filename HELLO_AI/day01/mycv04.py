import cv2
print(cv2.__version__)

img = cv2.imread('cat1.jpg')

# cv2.imshow('image1', img) # 창이름 지정

cv2.rectangle(img, (600,400), (100,50), (0,255,255), 10) # 우하 좌상 좌표로 그림 // (크기), (x,y좌표), (색), 굵기

cv2.imshow('rectangle', img)

cv2.waitKey() # 창 띄어두기

print(img)