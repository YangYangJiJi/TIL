import numpy as np

a_list = list(range(5))
a_array = np.arange(5)
print(a_list, a_array)
#리스트는 컴마로 구분, 넘파이는 컴마없음

### 결과 : [0, 1, 2, 3, 4] [0 1 2 3 4]

#브로드캐스팅 : 차원이 맞지 않아도 계산됨. -> 배열 연산을 리스트 보다 더 편하게 할 수 있음. 이게 리스트보다 넘파이의 장점이다.
a_array + 1 #배열 전체에 자유자재로 1씩 더할 수 있음

### 결과 : array([1, 2, 3, 4, 5])

np.random.seed(234234) #시드는 아무거나 줘도 됨
b1=np.random.randint(1,10,size=18).reshape(2,9)
print(b1,'\n')

### 결과
"""
[[1 5 2 9 2 9 2 2 6]
 [8 5 9 1 8 2 1 7 1]] 
"""

