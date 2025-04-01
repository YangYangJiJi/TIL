# tee 명령어
### 터미널 화면에 출력값이 그대로 나타나면서 같은 결과를 파일에 저장할 때
`echo "hello" | tee output.txt`

### 예를 들어, ls 명령어를 실행하면서 로그를 남기려면:
`ls -l | tee -a /path/to/logfile.txt`   
이렇게 하면 ls 명령어의 출력이 화면에 표시되는 동시에 로그 파일에 추가된다. 
