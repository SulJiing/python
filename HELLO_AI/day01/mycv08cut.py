import cv2
print(cv2.__version__)

img = cv2.imread('bp.jpg')
x= 100
y = 100
w = 100
h = 100
img_cropped = img[y:y+h,x:x+w]

cv2.imshow('k',img)
cv2.imshow('k_c',img_cropped)

cv2.waitKey() # 창 띄어두기

print(img)