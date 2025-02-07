# 기본 git 개념과 용어

## 코드
- 다음과 같은 코드는 bit bash에 치면 된다.

```
git add → 파일이 스테이징(Stage) 상태로 이동
git commit → 스테이징된 파일이 로컬 저장소(Repository)로 기록
git push → 로컬 저장소에 있는 커밋을 원격 저장소(GitHub)로 업로드
git pull → 원격 저장소의 변경사항이 로컬 저장소에 반영됨 
```

## 나의 이해
- 약간 소속사 지하에서 연습하던 아이돌을 무대에 올리고, 그 영상을 유튜브에 올리는 느낌?
1. 내 .py 파일을 로컬 저장소에 저장함
2. 그 파일을 git add 해서 변경사항을 stage에 추가함. 
3. git commit을 하면 stage에 올라간 파일이 push될 준비가 됨. 이때 커밋메시지를 작성할 수 있음 
4. git push를 하면 로컬의 커밋을 원격인 Github로 업로드함. 
5. 반대로 git pull을 하면 Github 내 변경사항이 내 로컬에 반영됨. 
