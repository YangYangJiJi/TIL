# working directory setting 하는 방법
```
# get working directory 현재 워킹 디렉토리 확인
getwd()

# set working directory 워킹 디렉토리 다시 설정
setwd("/Users/hyojungson/ISG/2025/Internship/RNAseq")
```
항상 R을 시작하기 전 꼭 해줘야 하는 작업이다.


### 더 간편하게 setting 하는 방법
- 현재 실행 중인 R 스크립트의 폴더 경로를 가져와서 작업 디렉토리를 해당 폴더로 변경하는 코드
- 파일 입출력(read.csv, write.csv)을 할 때 유용
```
install.packages('rstudioapi')
library(rstudioapi)
mainDir = dirname(rstudioapi::getSourceEditorContext()$path)
setwd(mainDir)
``` 
✅ rstudioapi 패키지는 RStudio의 다양한 기능을 프로그래밍적으로 제어할 수 있도록 해줌. <br>
✅ `install.packages('rstudioapi')`는 패키지를 설치하는 명령어이며, 한 번만 실행하면 됨. <br>
✅ `library(rstudioapi)`는 패키지를 로드하는 명령어. <br>
<br>
<br>
`mainDir = dirname(rstudioapi::getSourceEditorContext()$path)` <br>
✅ 현재 RStudio에서 열려 있는 스크립트 파일의 전체 경로를 가져옴. <br>
✅ 예를 들어, C:/Users/Username/Documents/R/my_script.R처럼 파일의 절대 경로가 반환됨. <br>
✅ 그 파일이 위치한 폴더 경로를 dirname()에 저장 <br>
<br>
<br>
✅ `setwd(mainDir)` <br>
✅ 현재 작업 디렉토리를 해당 스크립트가 위치한 폴더로 변경하는 명령어. <br>
✅ 이후 read.csv(), write.csv() 등의 함수에서 상대 경로를 사용할 때 현재 스크립트가 있는 폴더를 기준으로 경로가 설정됨. <br>
