nrow(iris)
ncol(iris)
class(iris)

###예제1. test1 데이터 중 1열의 class를 출력하세요.
class(iris[[1]])

###예제2. test1 데이터의 5열의 성분을 character로 바꿔보세요.
iris[[5]] = as.character(iris[[5]])

###예제3. test1 데이터의 5열 중 서로 다른 데이터 값을 출력하세요(중복제거).
unique(iris[[5]])

###예제4. test1 데이터 1-4열 중 가장 값이 큰 수를 출력하세요.
max(iris[1:4])

###예제5. test1 데이터 중 petal length가 1.5 이상인 행의 수를 구하세요.
nrow(iris[iris$Petal.Length >= 1.5,])

###예제6. test1 데이터를 Sepal length가 큰 순서대로 재정렬하세요.
iris = iris[order(iris$Sepal.Length, decreasing = T),]

###예제7. test2 데이터에서 자동차 이름을 추출하여출력하세요.
BiocManager::install("dplyr")
library("dplyr")
rownames(mtcars)

###예제8. test2 데이터 중 mpq값의 평균값과 표준편차값을 구하여 출력하세요.
mean(mtcars, mpg)
sd(mtcars$mpg)
#또는
summarise(mtcars, mean(mpg),sd(mpg))

# 예제 9. disp 값의 로그값을 구하고 그 총합을 출력
log10(mtcars$disp)
sum(log10(mtcars$disp))

# 예제 10. am값이 1이고 carb값이 4인 행의 수를 구함
nrow(mtcars[mtcars$am == 1 & mtcars$carb == 4, ]) 

# 예제 11. am값이 0이거나 carb값이 2인 행의 수를 구함
nrow(mtcars[mtcars$am == 0 | mtcars$carb == 2, ]) 

# 예제 12. cyl값을 기준으로 6, 4, 8 순서가 되도록 재정렬
mtcars$cyl <- factor(mtcars$cyl, levels=c('6','4','8'))
mtcars = mtcars[order(mtcars$cyl), ]
mtcars

# 예제 13. 각 carb값의 출현 빈도를 구하여 출력
table(mtcars$carb)

# 예제 14. qsec값을 반올림, 올림, 버림하여 출력
round(mtcars$qsec)
ceiling(mtcars$qsec)
floor(mtcars$qsec)

