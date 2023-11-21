import cv2

img = cv2.imread('cat1.jpg')

cv2.imwrite('cat1.png',img)

cv2.waitKey()

print(img)