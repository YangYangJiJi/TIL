# CRLF 에러 메시지 해결
## 에러 메시지
### 설명
- warning: in the working copy of 'Stronghold/012_GRPH/012_GRPH.py', CRLF will be replaced by LF the next time Git touches it
- 이 경고 메시지는 Windows에서 생성된 파일의 줄바꿈(CRLF, \r\n)이 Git에서 Unix 스타일의 줄바꿈(LF, \n)으로 변경될 예정이라는 의미예요.

### 왜 발생할까?
- Windows에서는 기본적으로 **줄바꿈을 CRLF (\r\n)**로 저장하지만, Git은 기본적으로 LF (\n) 형식을 선호합니다.
- Git이 자동으로 변환하려고 하면서 이 경고가 발생하는 거예요.

## 해결 방법
### 1. (추천) Git 설정을 변경해서 CRLF → LF 자동 변환 방지
```
git config --global core.autocrlf false
```
- 이렇게 설정하면 Git이 줄바꿈 변환을 하지 않고 원래 파일 그대로 유지합니다.
- 단, 이미 CRLF로 저장된 파일은 직접 수정해야 해요!

### 2. 이미 CRLF가 적용된 파일을 LF로 변경
- Git이 자동 변환을 하지 않게 설정했더라도, 이미 CRLF로 저장된 파일이 있다면 이를 직접 변경해야 합니다.
**방법 1: VS Code에서 LF로 변환**
- VS Code에서 문제의 파일을 엽니다.
- 우측 하단에 CRLF라고 표시된 부분을 클릭합니다.
- LF를 선택하면 줄바꿈이 LF로 변환됩니다.
- 변경된 파일을 다시 커밋하면 해결됩니다.
**방법 2: dos2unix 명령어 사용 (Linux/macOS, WSL)**
```
dos2unix Stronghold/012_GRPH/012_GRPH.py
dos2unix Stronghold/012_GRPH/README.md
dos2unix Stronghold/Read_FASTA.py
dos2unix Stronghold/data/rosalind_grph.txt
dos2unix Stronghold/output/012_GRPH.txt
```
이 명령어를 실행하면 CRLF가 LF로 변환됩니다.

### 3. 변경된 파일을 다시 Git에 반영
변경 후 Git에 다시 커밋하세요.
```
git add --all
git commit -m "Fix line endings from CRLF to LF"
git push
```
이제 더 이상 경고 메시지가 나오지 않을 거예요! 🚀
