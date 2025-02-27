# 레포지토리 속 파일 위치에서 add/commit/push해도 괜찮나??
GPT왈, 아니라고 한다.

### TIL이 Git 루트 저장소이고, python은 서브디렉터리인 경우
- 즉, c/myGithub/TIL이 Git 저장소이고, 
- c/myGithub/TIL/python은 그냥 일반 폴더일 때:
- ✅ TIL에서 add, commit, push를 해야 함. <br>

- TIL/python의 파일을 관리하려면 TIL에서 Git 명령어를 실행해야 함.
- TIL/python에서 `git add .`, `git commit -m "message"`, `git push origin main`을 실행하면 에러가 나거나, 아무 변화도 감지되지 않을 수 있음.
- 즉, 최상위 디렉터리(TIL)에서만 Git을 사용해야 함.