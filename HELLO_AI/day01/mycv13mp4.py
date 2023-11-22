import cv2

video = "sarang.mp4" # 동영상 파일 경로

cap = cv2.VideoCapture(video) # 동영상 캡쳐 객체 생성 

if cap.isOpened():                  # 캡쳐 객체 초기화 확인
    while True:
        ret, img = cap.read()       # 다음 프레임 읽기 
# 비디오 캡처 객체로부터 한 프레임을 읽어와서 ret 변수에 성공 여부를, img 변수에 읽어온 이미지를 저장하는 것을 의미 
# 이후에는 ret가 True이면 img에는 읽어온 이미지가 저장되고, False이면 더 이상 읽을 프레임이 없는 것을 나타넴

        if ret:                     # 프레임 읽기 정상
            cv2.imshow(video, img)  # 화면에 표시  --- ③
            cv2.waitKey(30)         # 25ms 지연(40fps로 가정)
        else:                       # 다음 프레임 읽을 수 없음,
            break                   # 재생 완료
else:
    print("can't open video.")      # 캡쳐 객체 초기화 실패
    
cap.release()                       # 캡쳐 자원 반납
cv2.destroyAllWindows()