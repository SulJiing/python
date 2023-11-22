import cv2
cam = cv2.VideoCapture(0)

cnt = 0
while True:
    check,frame = cam.read()
    
    cv2.imshow("video", frame)
    
    myKey = cv2.waitKey(1)
    print(myKey)
    
    if myKey == 97:
        cv2.imwrite('{}.png'.format(cnt), frame)
        cnt += 1
    if myKey == 113 :
        break

cam.release()
cv2.destroyAllWindows()