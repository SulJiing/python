import numpy as np

# range는 함수형 배열이라 range(0, 6)로 나옴
# arr = range(6)

arr = list(range(9))
arr_n = np.array(arr)
arr_n2 = np.reshape(arr_n,(3,3))

arr_n3 = np.float16(arr_n2)

print(arr_n)
print(arr_n2)
# print(arr_n3)
# print(arr_n.shape)
# print(arr_n2.shape)