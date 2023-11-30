# 삼성전자 LG SK 한화 포스코
from day06graph.daostock import daostock
import matplotlib.pyplot as plt
# import numpy as np
# x = np.ones(10)
# y = np.arange(1,11)

fig = plt.figure()

ax = fig.add_subplot(1,1,1, projection='3d') 

sd = daostock()

samsung = sd.select("삼성전자")
lg = sd.select("LG")
sk = sd.select("sk")
hanhwa = sd.select("한화")
posco = sd.select("포스코인터내셔널")
# 가격을 담을 리스트 생성
samsungP = []
skP = []
lgP = []
hanhwaP = []
poscoP = []
# 각 좌표를 담을 리스트 생성
x1 = []
x2 = []
x3 = []
x4 = []
x5 = []
y1 = []
y2 = []
y3 = []
y4 = []
y5 = []

for idx, i in enumerate(samsung):
    # 그래프를 %로 나타내기 위해 비교할 첫 가격
    firstPrice = samsung[0].get('price')
    # samsung에 {'price':10000}의 형태로 저장된 dict타입 데이터에서 금액만 꺼내오기
    price = i.get('price')
    # 첫 금액과 꺼내온 금액과의 차액을 구함
    gap = price - firstPrice
    # 그 차이를 %로 나타냄
    percent = gap/firstPrice*100
    # 퍼센티지를 리스트에 추가하기 (z축을 구성)
    samsungP.append(percent)
    # x좌표를 전부 0으로 하기 위해 데이터 갯수만큼 x1리스트에 0을 추가
    x1.append(0)
    # y좌표를 데이터 하나당 1칸 씩 이동시키기 위해 idx값을 y1에 추가
    y1.append(idx)
        
for idx, i in enumerate(sk):
    firstPrice = sk[0].get('price')
    price = i.get('price')
    gap = price - firstPrice
    percent = gap/firstPrice*100
    skP.append(percent)
    x2.append(1)
    y2.append(idx)
    
for idx, i in enumerate(lg):
    firstPrice = lg[0].get('price')
    price = i.get('price')
    gap = price - firstPrice
    percent = gap/firstPrice*100
    lgP.append(percent)
    x3.append(2)
    y3.append(idx)
    
for idx, i in enumerate(hanhwa):
    firstPrice = hanhwa[0].get('price')
    price = i.get('price')
    gap = price - firstPrice
    percent = gap/firstPrice*100
    hanhwaP.append(percent)
    x4.append(3)
    y4.append(idx)
    
for idx, i in enumerate(posco):
    firstPrice = posco[0].get('price')
    price = i.get('price')
    gap = price - firstPrice
    percent = gap/firstPrice*100
    poscoP.append(percent)
    x5.append(4)
    y5.append(idx)
    
    
fig=plt.figure()

ax = fig.add_subplot(1,1,1, projection='3d')  
ax.plot(x1, y1, samsungP, 'r')
ax.plot(x2, y2, skP, 'g')
ax.plot(x3, y3, lgP, 'b')
ax.plot(x4, y4, hanhwaP, '')
ax.plot(x5, y5, poscoP, '')
    
plt.show()
        