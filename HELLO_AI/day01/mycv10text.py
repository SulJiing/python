import cv2
import numpy as np
from PIL import ImageFont, ImageDraw, Image

img = cv2.imread('ma.jpg')

img = Image.fromarray(img) #img배열을 PIL이 처리가능하게 변환

draw = ImageDraw.Draw(img)

font=ImageFont.truetype("fonts/gulim.ttc",40)

draw.text((310,125),"마동석",font=font,fill=(0,255,0)) #text를 출력
img = np.array(img) #다시 OpenCV가 처리가능하게 np 배열로 변환

cv2.imshow("A",img)
cv2.waitKey()
cv2.destroyAllWindows()