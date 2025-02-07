# .csv 등의 파일에서 줄바꿈 변환 방식을 CRLF에서 LF로 변경해야합니다!

## 꼭 해야하나요? 귀찮은데..
- 개인용으로만 사용한다면 꼭 LF로 변환할 필요는 없어요.
- 다만, Windows ↔ Linux/macOS에서 작업할 가능성이 있다면 LF 유지가 좋음.
- 줄바꿈 문제로 인한 diff 오류가 신경 쓰이지 않는다면 그냥 둬도 무방해요! 

## CRLF → LF 변환이 안된 채로 GitHub에 올라가면 어떤 일이 생길까?
줄바꿈 문제는 운영체제에 따라 다르게 동작하는데, 만약 CRLF(Line Ending) 변환이 제대로 안 된 상태로 GitHub에 올라가면 다음과 같은 문제들이 발생할 수 있어.

### 1. 협업 시 충돌(Conflict) 발생 가능
- 다른 팀원이 Linux/macOS 환경에서 LF로 작업하고, 내가 Windows에서 CRLF 상태로 커밋하면 줄바꿈 차이로 인해 불필요한 diff가 발생할 수 있어.
- Git이 파일이 변경되었다고 인식하여 실제 코드 변경이 없는데도 커밋이 필요해짐.
- 결국 같은 파일을 수정할 때 줄바꿈 차이 때문에 merge conflict가 발생할 수도 있음.
- 해결방법 : .gitattributes 파일을 추가하여 Git이 자동으로 LF를 유지하도록 설정
```
*.csv text eol=lf
*.ipynb text eol=lf
*.md text eol=lf
*.py text eol=lf
git add --renormalize . 명령어로 한 번 정리해 주기
```

### 2. 파일 비교(diff)가 깨질 수 있음
- Git은 기본적으로 텍스트 파일을 줄 단위로 비교(diff)하는데, CRLF와 LF 차이 때문에 실제 변경되지 않은 줄도 변경된 것으로 표시될 수 있음.
- 예를 들어, git diff를 실행했을 때, 코드 자체는 변경되지 않았지만 줄바꿈 방식이 달라서 모든 줄이 변경된 것으로 표시되는 문제가 발생할 수 있음.
- 해결 방법: Git 설정을 수정해서 LF로 강제 변환 `git config --global core.autocrlf input`

### 3. 일부 프로그래밍 언어에서 실행 오류 발생 가능
- 일부 언어 또는 특정 툴(특히 스크립트 기반 언어)에서는 CRLF가 포함된 파일을 정상적으로 처리하지 못하는 경우가 있어.
- 예시 1: Python 스크립트 실행 문제
```
with open('file.txt', 'r') as f:
    for line in f:
        print(line, end="")  # CRLF가 있으면 이상한 줄바꿈 발생 가능
```
- 해결방법 : Python, Shell Script 등의 파일은 LF로 강제 변환 `git config --global core.autocrlf input`

### 4. GitHub에서 Raw 파일 보기 시 줄바꿈 문제
- GitHub에서 .csv, .md, .ipynb 같은 파일을 Raw 파일 보기 모드로 열었을 때, CRLF가 남아 있으면 줄바꿈이 깨질 수 있음.
- 특히 Markdown 파일(.md)의 경우, 리스트나 코드 블록에서 의도치 않은 줄바꿈이 생길 수도 있음.

***

## 해결 방법 (기존 CRLF 파일을 LF로 변환)
### 1. Git의 줄바꿈 설정을 LF로 고정 (autocrlf input 적용)
- 이 설정은 줄바꿈(LF ↔ CRLF) 변환 방식을 설정하는 것이기 때문에, 파일을 add하기 전에 설정하는 것이 가장 좋아!
- 즉, 커밋 전에 실행해야 제대로 적용됨.
```
git config --global core.autocrlf input
```

### 2. .gitattributes 파일을 최상위 폴더에 만들고 아래 내용 추가
- .gitattributes 파일이 있는 저장소에서는 Git이 파일을 체크아웃할 때 LF를 유지하도록 강제함.
- 새로운 파일을 추가해도 LF 형식이 자동 적용됨.
- 나의 경우 최상위 폴더는 TIL이기에 여기에 만듦.
- 한 번 .gitattributes 파일을 만들고 커밋하면, 이후에는 반복할 필요 없음!
- 새로운 저장소를 만들 때는 다시 설정해야 함.
- 이미 CRLF로 저장된 파일이 있다면 git add --renormalize .로 한 번 정리하면 됨.
```
echo "*.csv text eol=lf" >> .gitattributes
echo "*.ipynb text eol=lf" >> .gitattributes
```

### 3. 변경 사항을 Git에 적용 (add & commit & push)
```
git add .gitattributes
git commit -m "Add .gitattributes to enforce LF line endings"
git push origin main
```

### 4. 기존 파일들도 LF로 변환 (줄바꿈 정리)
- 이미 커밋된 파일들이 CRLF로 저장되어 있다면 아래 명령어 실행:
```
git add --renormalize .
git commit -m "Normalize line endings to LF"
git push origin main
```
