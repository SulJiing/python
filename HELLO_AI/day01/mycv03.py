import cv2
print(cv2.__version__)

img = cv2.imread('son.jpg')
imgray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

cv2.imshow('image2', imgray) # 창이름 지정

cv2.waitKey(5000) # 창 띄어두기

print(img)