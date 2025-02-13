# R의 기본 중 기본

## 변수 할당
```
x <- 10
y = 20
```

## Vector 객체
### 문자형 벡터
`char_vec <- c("A", "B", "C")`

### 숫자형 벡터
`num_vec <- c(1, 2, 3, 4, 5)`

### 논리형 벡터
`log_vec <- c(TRUE, FALSE, TRUE)`

### 팩터형 벡터
`factor_vec <- factor(c("Low", "Medium", "High"))`
`detach("package:dplyr", unload = TRUE)`

## 논리 연산자
```
TRUE | FALSE   # OR: TRUE
!TRUE          # NOT: FALSE
TRUE & TRUE    # AND: TRUE
FALSE & TRUE   # AND: FALSE
```
```
c(TRUE, FALSE, TRUE) & c(TRUE, TRUE, FALSE)  # AND 연산
c(TRUE, FALSE, TRUE) | c(FALSE, TRUE, FALSE) # OR 연산
!c(TRUE, FALSE, TRUE)     
```
```
data <- c(10, 20, 30, 40, 50)
data[data > 25 & data < 45]  # AND 조건
data[data < 15 | data > 45]
```
***

## Matrix / Array 객체
- 다차원 데이터 구조: vector 객체를 기반으로 생성
- 2차원은 matrix, 3차원 이상은 array라고 함.
- Matrix 생성 : `mat <- matrix(1:6, nrow = 2, ncol = 3)`
- Array 생성 : `arr <- array(1:12, dim = c(2, 3, 2))`

## Data frame 객체
- 서로 다른 타입의 벡터를 결합하여 테이블 형식으로 표현한 구조
- 여러개의 vector object를 이용해 표 형태로 표현한 데이터
- data frame 안에는 문자, 숫자 다 들어갈 수 있음. 
- data frame은 행과 열에 이름 지정 가능.
```
df <- data.frame(
  Name = c("Alice", "Bob", "Charlie"),
  Age = c(25, 30, 35),
  Score = c(85, 90, 88)
)
rownames(df) =c('a','b','c')
```

### List 객체
- 다양한 타입의 객체를 하나로 묶을 수 있는 구조
```
my_list <- list(
  vec = c(1, 2, 3),
  mat = matrix(1:4, nrow = 2),
  df = data.frame(A = c(1, 2), B = c("X", "Y"))
)
```
