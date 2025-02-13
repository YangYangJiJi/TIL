# R 함수
- 함수 정의 방법 : Python에서는 def를 사용, R에서는 function() 사용
- 함수 잘만들면 스크립트 핸들링할 때 가독성 있게 구현 가능.
```
fun <- function(x) {
  x^2
}
q = fun(3)

add <- function(a, b) {
  return(a + b)
}
add(10, 20) 
```
중괄호 사용해서 제곱을 해주는 함수 만들기.
