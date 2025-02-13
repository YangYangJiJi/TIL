# R plot 그리기
- 입력 데이터를 시각적으로 표현하며, 선 그래프, 산점도, 상자 그림 등 다양한 그래프 형식으로 표현할 수 있다.
- class 또는 입력 데이터에 따라 적절한 시각화를 선택한다.

```
set.seed(123)
# 난수 seed 값을 정해줘야 나중에 다시 분석해도 같은 결과가 나옴. 지정된 난수

n=10
rnorm(n, mean = 0, sd = 1)  # 평균 0, 표준편차 1의 정규분포 생성
x <- rnorm(500)
y <- x + rnorm(500) #x에 동일하게 난수 더해서 또 다른 난수 만듦.

par(mfrow = c(2, 3))  # 여러 그래프를 한 화면에 배치
```

### 시계열 데이터 생성
```
my_ts <- ts(matrix(rnorm(500), nrow = 500, ncol = 1),
            start = c(1950, 1), frequency = 12) #ts는 시계열 오브젝트 만들어주는 함수

my_dates <- seq(as.Date("2005/1/1"), by = "month", length = 50)
```

### mtcars 데이터의 cyl 변수 순서 정렬 및 변환
- 우리가 지정한 레벨대로 sorting 됨
- 예를들어 암 3기가 제일 심한것. 2기, 1기. 이중에서 3기, 1기만 뽑고싶다? 할때 뽑을 수 있음.
```
mtcars$cyl <- factor(mtcars$cyl, levels = c('6', '4', '8'))
mtcars = mtcars[order(mtcars$cyl), ]
```

### 데이터 시각화
```
par(mfrow = c(2, 2))
plot(x, y, main = "Scatterplot")  # 산점도
plot(my_factor, main = "Barplot")  # 막대그래프
plot(my_factor, rnorm(32), main = "Boxplot")  # 상자 그림
plot(my_ts, main = "Time series")  # 시계열 그래프
plot(my_dates, rnorm(50), main = "Time based plot")  # 시간 기반 그래프
plot(fun, 0, 10, main = "Plot a function")  # 함수 그래프
```
