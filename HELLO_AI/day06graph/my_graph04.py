import matplotlib.pyplot as plt
from day06graph.daostock02 import daostock02
import numpy as np

ds = daostock02()

prices = []
prices.append(ds.selectArr("삼성전자"))
prices.append(ds.selectArr("lg"))
prices.append(ds.selectArr("마니커"))
prices.append(ds.selectArr("서울식품"))

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1, projection='3d')

xs = np.ones((4),dtype=np.int8)
print(xs)

ax.plot(xs*0, [0, 1, 2, 3], prices[0], 'r')
ax.plot(xs*1, [0, 1, 2, 3], prices[1], 'g')
ax.plot(xs*2, [0, 1, 2, 3], prices[2], 'b')
ax.plot(xs*3, [0, 1, 2, 3], prices[3], 'yellow')
#ax.plot([x1, x2, x3], [y1, y2, y3], [z1, z2, z3], '')

plt.show()