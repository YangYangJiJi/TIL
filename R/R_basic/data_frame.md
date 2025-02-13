# R에서 데이터 프레임
## 1️⃣ 데이터 생성 및 데이터 프레임, 행렬 만들기
```
x <- 1:3		# 정수형(integer)
y <- c("하나", "둘", "셋")	# 문자형(character)
z <- c(T, F, T)		# 논리형(logical)

mt <- cbind(x, y, z)  # 행렬(matrix) 생성
df <- data.frame(x, y, z)  # 데이터 프레임 생성
```
**✅ 설명 :**
- cbind()를 사용하면 행렬(matrix)이 생성됨.
- data.frame()을 사용하면 데이터 프레임(data frame)이 생성됨.
- 행렬(matrix)은 모든 요소가 동일한 자료형이어야 하므로, 문자형(character)로 통일됨.
- 데이터 프레임(data frame)은 각 열의 자료형을 유지함.
<br>
## 2️⃣ merge() 함수로 데이터 프레임 병합
```
df1 <- data.frame(id = 1:3, name = c("A", "B", "C"))
df2 <- data.frame(id = 2:4, score = c(90, 88, 92))

result <- merge(df1, df2, by = "id")
```
결과 (result 데이터 프레임):
```
  id name score
1  2    B    90
2  3    C    88
```
**✅ 설명:**
- merge(df1, df2, by = "id")는 id 열을 기준으로 두 데이터 프레임을 병합함.
- id = 2, 3이 두 데이터 프레임 모두에 존재하므로, 공통된 행만 남음.
- id = 1과 id = 4는 포함되지 않음.
**📌 배울 점:**
- merge()는 SQL의 INNER JOIN과 동일한 동작을 함.
- by = "id"를 지정하면 공통된 열을 기준으로 병합함.
- 만약 모든 데이터(LEFT JOIN)를 유지하려면 all.x = TRUE를 사용해야 함.
`merge(df1, df2, by = "id", all.x = TRUE)  # 왼쪽 데이터(df1) 기준으로 병합`
<br>
## 3️⃣ 행렬(matrix)과 데이터 프레임(data.frame)의 차이점
```
class(mt[,1])	# character
class(mt[,2]) 	# character
class(mt[,3]) 	# character
```
결과:
```
[1] "character"
[1] "character"
[1] "character"
```
**✅ 설명:**
- 행렬(matrix)은 한 가지 자료형만 허용함.
- y 열(character) 때문에, 모든 열이 강제로 문자형(character)으로 변환됨.
```
class(df[,1])	# integer
class(df[,2]) 	# character
class(df[,3]) 	# logical
```
결과:
```
[1] "integer"
[1] "character"
[1] "logical"
```
**✅ 설명:**
- 데이터 프레임(data.frame)은 각 열이 서로 다른 자료형을 유지할 수 있음.
- x는 정수형(integer), y는 문자형(character), z는 논리형(logical)을 그대로 유지함.
<br>
## 📌 최종 정리
✅ 1. cbind()로 만든 행렬(matrix)은 모든 요소가 같은 자료형이 되어야 함.
✅ 2. data.frame()을 사용하면 각 열이 원래 자료형을 유지할 수 있음.
✅ 3. merge() 함수는 INNER JOIN처럼 공통된 열을 기준으로 데이터 프레임을 병합함.
✅ 4. 행렬에서는 character가 포함되면 모든 값이 문자형으로 변환됨.
✅ 5. 데이터 프레임은 integer, character, logical을 유지할 수 있음.
