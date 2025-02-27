R.version
version

# 현재 작업 디렉토리 확인
getwd()
setwd("/R_2025/Inco")


install.packages('rstudioapi')
library(rstudioapi)
rstudioapi::getSourceEditorContext()$path 
mainDir = dirname(rstudioapi::getSourceEditorContext()$path)
setwd(mainDir)

list.files()

####### 변수 할당 ####### 
x <- 10
y = 20  

####### Vector 객체 ####### 
# 문자형 벡터
char_vec <- c("A", "B", "C")

# 숫자형 벡터
num_vec <- c(1, 2, 3, 4, 5)

# 논리형 벡터
log_vec <- c(TRUE, FALSE, TRUE)

# 팩터형 벡터
factor_vec <- factor(c("Low", "Medium", "High"))


####### Matrix / Array 객체 ####### 
# 다차원 데이터 구조: vector 객체를 기반으로 생성 (2차원 = Matrix, 3차원 이상 = Array)
# Matrix
mat <- matrix(1:6, nrow = 2, ncol = 3)

# Array 생성
arr <- array(1:12, dim = c(2, 3, 2))

####### Data frame 객체 ####### 
# 서로 다른 타입의 벡터를 결합하여 테이블 형식으로 표현한 구조
df <- data.frame(
  Name = c("Alice", "Bob", "Charlie"),
  Age = c(25, 30, 35),
  Score = c(85, 90, 88)
)
rownames(df) =c('a','b','c')

####### List 객체 ####### 
# 다양한 타입의 객체를 하나로 묶을 수 있는 구조
my_list <- list(
  vec = c(1, 2, 3),
  mat = matrix(1:4, nrow = 2),
  df = data.frame(A = c(1, 2), B = c("X", "Y"))
)

####### 함수 ####### 
# 함수 정의 방법
# Python에서는 def를 사용, R에서는 function() 사용
fun <- function(x) {
  x^2
}
q = fun(3)

add <- function(a, b) {
  return(a + b)
}
add(10, 20) 

####### 패키지 / 라이브러리 ####### 
# CRAN에서 설치
install.packages("ggplot2") # 패키지 설치
library(ggplot2)            # 라이브러리 로드

# Bioconductor에서 설치
if (!requireNamespace("BiocManager", quietly = TRUE))
  install.packages("BiocManager")

install.packages("BiocManager") 
BiocManager::install("TCC")
library(TCC)

BiocManager::install("dplyr")
library("dplyr")

# dplyr 패키지의 filter 함수 사용
dplyr::filter(mtcars, mpg > 20)

# stats 패키지의 filter 함수 사용
stats::filter(c(1, 2, 3), rep(1, 3))

detach("package:dplyr", unload = TRUE)

####### 논리 연산자 ####### 
TRUE | FALSE   # OR: TRUE
!TRUE          # NOT: FALSE
TRUE & TRUE    # AND: TRUE
FALSE & TRUE   # AND: FALSE

c(TRUE, FALSE, TRUE) & c(TRUE, TRUE, FALSE)  # AND 연산
c(TRUE, FALSE, TRUE) | c(FALSE, TRUE, FALSE) # OR 연산
!c(TRUE, FALSE, TRUE)     

data <- c(10, 20, 30, 40, 50)
data[data > 25 & data < 45]  # AND 조건
data[data < 15 | data > 45]

-
# Basic operations
#-----------------

3 + 5   # 8
8 - 3   # 5
7 * 5   # 35
1/2     # 0.5
4 ^ 4   # 256
4 ** 4  # 256
5 %/% 3 # 1
5 %% 3  # 2

#---------
# Vectors
#---------
# import numpy as np

x <- c(1, 7, 3)
y <- c(9, 4, 5)

x + y   # 10 11  8
x - y   # -8  3 -2
x * y   #  9 28 15
x / 2   #  0.5 3.5 1.5

# Each element of the first vector elevated
# to the corresponding element of the second
x ** y  # 1 2401  243 
x ^ y   # 1 2401  243

x %% y  # 1 3 3
x %/% y # 0 1 0

data <- c(1,2,3,4,5,6)
data <- 1:6
data[5] # 1-based indexing
## python indexing # (0-based indexing)

numbers <- 1:10
squares =c()
for (i in numbers) {
  squares[i] <- numbers[i]^2
}
squares

numbers <- 1:10
squares <- numbers^2
print(squares)

#---------
# matrix
#---------
# By columns
matrix(data, ncol = 2)
matrix(data, ncol = 2, byrow = TRUE) # byrow = FALSE by default
matrix(data, ncol = 2, nrow = 3) 
matrix(data, nrow = 3) 

# By rows
matrix(data, ncol = 2, byrow = TRUE)


# By columns               # By rows
# [, 1] [, 2]                 [, 1] [, 2]
# [1, ]   1    4             [1, ]    1    2
# [2, ]   2    5             [2, ]    3    4
# [3, ]   3    6             [3, ]    5    6

x <- c(2, 7, 3, 6, 1)
y <- c(3, 7, 3, 5, 9)
x=seq(1,6)
x=1:6

# By columns
cbind(x, y)

# By rows
rbind(x, y)

# By columns                # By rows
# x   y                    [, 1] [, 2] [, 3] [, 4] [, 5]
# [1, ] 2   3                 x    2     7     3     6     1   
# [2, ] 7   7                 y    3     7     3     5     9
# [3, ] 3   3
# [4, ] 6   5
# [5, ] 1   9


my_matrix <- matrix(c(1, 5, 8, 1, 3, 2), ncol = 3)
my_matrix

my_matrix[1]    # # First element of the first column
my_matrix[[1]]  
my_matrix[1, 1]


# Second row, third column
my_matrix[2, 3] # 2

# First row
my_matrix[1, ] # 1 8 3

# Second column
my_matrix[ ,2] # 8 1


# First and second column, first row
my_matrix[1, 1:2] # 1 8

# First and third column, second row
my_matrix[2, c(1, 3)] # 5 2
my_matrix[2, c(TRUE, FALSE, TRUE)] # Equivalent


# All columns except the second
my_matrix[, -2]

#---------
# Data frame object
#---------
# python import pandaandas의 data frame 객체와 유사하게 R에서는 데이터를 표 형태로 저장하고 처리할 수 있다.

x <- 1:3		# 1 2 3		/ integer
y <- c("하나", "둘", "셋")	# "하나" "둘" "셋"	/ character
z <- c(T, F, T)		# TRUE FALSE TRUE	/ logical

mt <- cbind(x, y, z)  # 행 기준으로 데이터 결합
df <- data.frame(x, y, z)  # 데이터 프레임 생성

df1 <- data.frame(id = 1:3, name = c("A", "B", "C"))
df2 <- data.frame(id = 2:4, score = c(90, 88, 92))

# 공통 열(id)을 기준으로 데이터 병합
result <- merge(df1, df2, by = "id")

# 행렬로 작업
class(mt[,1])	# character
class(mt[,2]) 	# character
class(mt[,3]) 	# character

# 데이터 프레임으로 작업
class(df[,1])	# integer
class(df[,2]) 	# character
class(df[,3]) 	# logical


#---------
# statistics
#---------
# mean 함수
# 주어진 데이터의 평균을 계산하는 기본 함수
# mean( )을 사용하여 계산할 수 있다.

x <- c(2, 4, 3, 6, 3, 7, 5, 8)

mean(x) # 4.75

# 아래와 동일:
sum(x)/length(x) # 4.75

# NA 값이 포함된 벡터
x <- c(2, 4, 3, 6, 3, 7, 5, 8, NA)

# NA 값이 포함된 경우 결과는 NA
mean(x) # NA

# NA 값을 제외하고 계산
mean(x, na.rm = TRUE) # 4.75

# var 함수
# 분산(데이터가 퍼져 있는 정도)을 계산하는 기본 함수
# var( )을 사용하여 계산할 수 있다.

x <- c(10, 25, 12, 18, 5, 16, 14, 20)

# 표준 편차
sd(x) # 6.21059

# 아래와 동일:
sqrt(var(x)) # 6.21059

# sd 함수
# 표준 편차(데이터의 평균으로부터의 산포)를 계산하는 기본 함수
# sd( )을 사용하여 계산할 수 있다.

x <- c(10, 25, 12, 18, 5, 16, 14, 20)

# 분산 계산
sd(x) ^ 2 # 38.57143


#---------
# plot
#---------
# 입력 데이터를 시각적으로 표현하며, 선 그래프, 산점도, 상자 그림 등 다양한 그래프 형식으로 표현할 수 있다.
# class 또는 입력 데이터에 따라 적절한 시각화를 선택한다.

set.seed(123)

n=10
rnorm(n, mean = 0, sd = 1)  # 평균 0, 표준편차 1의 정규분포 생성
x <- rnorm(500)
y <- x + rnorm(500)

par(mfrow = c(2, 3))  # 여러 그래프를 한 화면에 배치

# 시계열 데이터 생성
my_ts <- ts(matrix(rnorm(500), nrow = 500, ncol = 1),
            start = c(1950, 1), frequency = 12)

my_dates <- seq(as.Date("2005/1/1"), by = "month", length = 50)

# mtcars 데이터의 cyl 변수 순서 정렬 및 변환
mtcars$cyl <- factor(mtcars$cyl, levels = c('6', '4', '8'))
mtcars = mtcars[order(mtcars$cyl), ]

# 데이터 시각화
par(mfrow = c(2, 2))
plot(x, y, main = "Scatterplot")  # 산점도
plot(my_factor, main = "Barplot")  # 막대그래프
plot(my_factor, rnorm(32), main = "Boxplot")  # 상자 그림
plot(my_ts, main = "Time series")  # 시계열 그래프
plot(my_dates, rnorm(50), main = "Time based plot")  # 시간 기반 그래프
plot(fun, 0, 10, main = "Plot a function")  # 함수 그래프

#---------
# save
#---------
# PNG 형식으로 저장
png("plot_example.png", width = 800, height = 600)

#mainDirectory에 저장.
mainDir='/R_2025/Inco'
png(paste(mainDir, "/plot_example.png", sep='/'), width = 800, height = 600)
plot(1:10, 1:10, main = "Example Plot", xlab = "X-axis", ylab = "Y-axis")
dev.off()  # 파일 저장 완료

# PDF 형식으로 저장
pdf("plot_example.pdf", width = 7, height = 5)
plot(1:10, 1:10, main = "Example Plot", xlab = "X-axis", ylab = "Y-axis")
dev.off()  # 파일 저장 완료

# 데이터 저장 
a <- c(1, 2, 3)
b <- c("A", "B", "C")
df <- data.frame(id = 1:3, value = c(10, 20, 30))


# 아래처럼 변수를 저장해야 나중에 Rstudio를 다시 켰을 때 변수 다시 설정 안할 수 있음.
# 1. 변수 저장
save(a, file = "a.RData")

# 2. 여러 변수 저장
save(a, b, df, file = "variables.RData")

# 3. 작업 환경 저장
#환경 전체. 이 변수며 뭐며 전체.
save.image(file = "full_workspace.RData")
load("full_workspace.RData") #위에서 저장한 이미지(=환경전체) 불러오기.
#나중에 실습할 때 금요일에 save.image해두고
#월요일에 load해서 실습환경 다시 불러오면 됨.

# 4. CSV 파일 저장
write.csv(df, file = "data.csv", row.names = FALSE)

# 5. 텍스트 파일 저장
write.table(df, file = "data.txt", sep = "\t", row.names = FALSE)