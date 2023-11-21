import cv2
print(cv2.__version__)

img = cv2.imread('cat1.jpg')

(h,w) = img.shape[:2]
(cx,cy) = (w // 2,h // 2)

# 이미지의 중심을 중심으로 이미지를 45도 회전
M = cv2.getRotationMatrix2D((cx,cy),45,1.0)
rotate_45 = cv2.warpAffine(img,M,(w,h))


cv2.imshow('image1', img) # 창이름 지정
cv2.imshow('image2', rotate_45) # 창이름 지정

cv2.waitKey() # 창 띄어두기

print(img)