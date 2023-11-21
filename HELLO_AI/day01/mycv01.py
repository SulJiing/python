import cv2
print(cv2.__version__)

img1 = cv2.imread('son.jpg')
img2 = cv2.imread('son.jpg',0)
img3 = cv2.imread('son.jpg',-1)

cv2.imshow('image1', img1) # 창이름 지정
cv2.imshow('image2', img2) # 창이름 지정
cv2.imshow('image3', img3) # 창이름 지정

cv2.waitKey(5000) # 창 띄어두기

print(img1)