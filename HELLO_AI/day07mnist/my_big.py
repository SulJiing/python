import numpy as np

arr = [0,5,0,0,1, 2,0,0,3,0]

arr_n = np.array(arr)

mymax = -1
for i in arr_n:
    if i > mymax:
        mymax=i
    
print(mymax)    

for idx,i in enumerate(arr_n):
    if mymax == i:
        print(idx)

# arr_b = max(arr_n)
#
# arr_num = np.where( arr_n == arr_b)
#
# print(arr_b)
#
# print(arr_num)