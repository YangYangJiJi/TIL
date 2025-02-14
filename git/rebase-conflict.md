# git pull --rebase 중 Conflict해결

## 문제상황
- 현재 git pull origin main --rebase를 실행했는데, 충돌 발생
- 즉, 원격 저장소와 로컬 저장소 간의 변경 사항이 충돌하여 수동으로 해결해야 하는 상황!

## 해결방법
1. 충돌 상태 확인
- 먼저 git status를 실행해서 충돌이 난 파일을 확인
- 충돌된 파일들이 나열될 거임

2. 충돌 해결 (수동 수정)
(1) 충돌된 파일을 직접 수정 (예: ML/README.md) <br>
- ML/README.md를 열어보면 충돌된 부분이 
- <<<<<< HEAD, =======, >>>>>>> 로 표시됨.
- 충돌 내용을 보고 원하는 내용으로 수정 후 저장.
<br>
(2) 삭제되지 않은 디렉토리 강제 삭제 <br>
- 만약 AI,ML,DL/CNN/img-classification 폴더 삭제가 실패했다면, 수동으로 삭제:
```
Remove-Item -Recurse -Force "AI,ML,DL/CNN/img-classification"
```

3. 충돌 해결된 파일을 git에 추가
- 충돌 해결 후 git에 추가
```
git add ML/README.md  # 수정한 파일 추가
git add -u  # 삭제된 파일 반영
```

4. rebase 중단하고 원래 상태로 되돌리기 (선택)
- 만약 해결이 어렵다면, Rebase를 취소하고 원래 상태로 되돌릴 수도 있음.
```
git rebase --abort
```
- 이렇게 하면 원래 git pull 하기 전 상태로 돌아감.


## 충돌난 README.md 파일 수정 : CLI에서 README.md 파일 여는 방법
### 1. nano (간단한 텍스트 편집기, 추천)
- ```nano README.md```
- 화살표 키로 이동 후, 충돌 부분 수정
- 수정이 끝나면 Ctrl + X → Y → Enter (저장 후 종료)
### 2. vim (더 강력한 편집기)
- `vim README.md`
- i 키를 눌러 INSERT 모드로 진입 (편집 가능)
- 충돌 내용 수정
- Esc 키를 눌러 편집 모드 종료
- :wq 입력 후 Enter (저장 후 종료)
### 3. VS Code에서 열기 (GUI 편집기)
- 만약 VS Code가 설치되어 있다면, CLI에서 직접 열 수도 있어:
- `code README.md`
- VS Code에서 수정 후 저장(ctrl + S)하면 터미널에서 자동 반영됨.

