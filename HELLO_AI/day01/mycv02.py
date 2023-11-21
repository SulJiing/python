import cv2
print(cv2.__version__)

img1 = cv2.imread('r.jpg')
cv2.imshow('r', img1) # 창이름 지정
print(img1)
img2 = cv2.imread('g.jpg')
cv2.imshow('g', img2) # 창이름 지정
print(img2)
img3 = cv2.imread('b.jpg')
cv2.imshow('b', img3) # 창이름 지정
print(img3)
img4 = cv2.imread('spon.png',-1)
cv2.imshow('spongibab', img4) # 창이름 지정
print(img4)

cv2.waitKey(1000) # 창 띄어두기
