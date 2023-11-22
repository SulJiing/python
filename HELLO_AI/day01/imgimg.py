import cv2
import numpy as np


img1 = cv2.imread('118.png')
img2 = cv2.imread('117.png', cv2.IMREAD_UNCHANGED )


h, w, c = img2.shape


roi_img1 = img1[100:100+h, 100:100+w]
h, w, c = img1.shape

if c == 3:
    roi_img1 = cv2.cvtColor(roi_img1, cv2.COLOR_BGR2BGRA)



desired_alpha = 90
alpha = desired_alpha / 255.0


result = cv2.addWeighted(roi_img1, 1, img2, alpha, 0)

source = cv2.hconcat([roi_img1, img2])

cv2.imshow('Source', source)
cv2.imshow('Result', result)

cv2.waitKey(0)

cv2.destroyAllWindows()
