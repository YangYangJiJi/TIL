# 기본 git 개념과 용어
## 개요
- git bash에 다음과 같은 코드를 작성하면 로컬과 원격(깃허브)이 연결된다.
- 내 컴퓨터의 파일을 깃허브에 올리려면,
1.  깃허브에 '원격 저장소'를 만들고,
2. 내 컴퓨터(=올리려는 파일이 있는 폴더)에 '로컬 저장소'를 만든 뒤
3. 둘을 연결해서 로컬 저장소의 파일을 원격 저장소로 보내라고 명령하면 된다.

## 요약
```
//저장소 생성 및 연결 → 한번만 하면 됨
$ git init
$ git remote add origin [원격저장소 주소]
$ git branch -m master main

//파일 업로드
$ git pull origin main
$ git add .
$ git commit -m "commit message"
$ git push origin main

//추가적인 명령어
$ git remote -v
$ git remote rm origin
$ git branch
$ git config --global init.defaultBranch [브랜치 이름]
$ git status
$ git rm --cached -r .
$ git push -u origin main
```

## 1. 저장소 생성 및 연결
### 파일로 이동
- 내 컴퓨터의 폴더 중, 깃허브에 올리려고 하는 폴더에 마우스 우클릭 후 'Git bash here'를 누른다.
- 또는 cd C:/myGithub/Rosalind 와 같이 작성해서 이동해도 된다.

### git init
- git init은 현재 폴더를 Git 저장소(Repository)로 초기화하는 명령어
- 폴더 안에 .git 라는 폴더가 생성되는데, '.'으로 시작하는 폴더는 숨김처리되니 보이지는 않는다. Git이 변경 사항을 추적할 수 있음.
- 이후 git add, git commit, git push 등을 사용하여 버전 관리 가능.
- GitHub에 올리려면 먼저 git init을 해야 로컬 저장소가 만들어짐.
- 이미 Git이 초기화된 폴더라면 다시 git init 할 필요 없음!

### 원격 저장소 주소 등록
- https://github.com/아이디/저장소이름.git 이런게 원격 저장소 주소이다.
- github에서 레포지토리 생성하면 나온다.
- 예시 : `git remote add origin https://github.com/myid/my-cool-website.git`
- 로컬 저장소에 원격 저장소가 잘 연결됐는지 (혹은 이미 연결되어 있는 다른 저장소가 있는지) 확인하고 싶다면 `git remote -v` 명령어를 입력해서 연결된 저장소를 확인할 수 있다.
- 원격 저장소를 잘못 연결했거나, 기존에 연결했던 것을 삭제하고 싶다면 `git remote rm origin` 명령어를 통해 원격 저장소와의 연결을 끊을 수 있다.

### branch 이름 변경
- branch 이름이 master로 되어있으면 main으로 바꿔야 한다. ` git branch -m master main`
- 저장소를 만들때마다 브랜치 이름을 변경하기 귀찮으니, 항상 main으로 이름 짓도록 설정할 수 있다.
- `git config --global init.defaultBranch [브랜치 이름]` 명령어에서 브랜치 이름을 main으로 써서 입력하면, 앞으로 모든 로컬 저장소의 브랜치 이름은 main이 된다.
- 예시: git config --global init.defaultBranch main

## 2. 파일 업로드!! (가장 중요)
### 간단 설명

```
git pull → 원격 저장소의 변경사항이 로컬 저장소에 반영됨 
git add → 파일이 스테이징(Stage) 상태로 이동
git commit → 스테이징된 파일이 로컬 저장소(Repository)로 기록
git push → 로컬 저장소에 있는 커밋을 원격 저장소(GitHub)로 업로드
```

### 나의 이해
- 파일 올리기 포인트는 add > commit > push!!
- 약간 소속사 지하에서 연습하던 아이돌을 무대에 올리고, 그 영상을 유튜브에 올리는 느낌?
- 어떤 블로그에서는 add는 장바구니에 재료담기, commit은 계산대에 올려 계산하기, push는 구매한 물건 들고 원격저장소로 가기라고 비유를 맛깔나게 했다.
1. 내 .py 파일을 로컬 저장소에 저장함
2. 그 파일을 git add 해서 변경사항을 stage에 추가함. 
3. git commit을 하면 stage에 올라간 파일이 push될 준비가 됨. 이때 커밋메시지를 작성할 수 있음 
4. git push를 하면 로컬의 커밋을 원격인 Github로 업로드함. 
5. 반대로 git pull을 하면 Github 내 변경사항이 내 로컬에 반영됨.

### git pull을 가장 먼저 하기
- `git pull origin main`
- 로컬 저장소가 최신 상태를 유지할 수 있도록, 파일을 깃허브에 올리기 전에 항상 pull을 먼저 해준다.
- 변경 사항이 없는데 pull을 하면 그냥 변경사항 없다는 메시지 뜸

### git add .로 모든 변경사항 장바구니에 담기
- 그럼 변경했거나 추가 혹은 삭제한 파일들의 목록이 빨간 글씨로 뜬다.
- 빨간색으로 뜨는 것은 untracked files, 즉 추적되지 않은 파일이라는 것으로
- 쉽게 말해 장바구니에 아직 안 담았단 얘기다.
- add를 해준 뒤에 다시 status를 확인해보면 추적되었다는 뜻으로 초록색으로 바뀐다.
- (참고로 add 했던 파일을 또 변경하면 다시 빨간색으로 바뀐다)
- 만약 add를 했는데 이를 취소,즉 장바구니(staging area)에서 빼내려면?
```
//add한 파일 모두 취소
$ git rm --cached -r .

//특정 파일만 add 취소
$ git rm --cached [파일]
```

### git commit으로 계산 저질러버리기
- 원격 저장소에 올릴 파일을 다 추가했다면 이제 commit을 할 차례이다. 앞서 add 한 파일들을 확정하는 것이다.
- 물건을 담는 단계에서는 물건이 맘에 안 들면 다시 진열대에 내려 놓으면 되니 비교적 자유로웠다.
- 하지만 한번 계산대에서 계산을 한 뒤에는, 마음이 바뀌면 번거롭게 결제 취소를 해야 하니 복잡하다.
- 그러니 commit은 조금 신중할 필요가 있다. (참고로 commit은 '저지르다, 약속하다' 라는 뜻이다)
- `git commit -m "commit message"`
- 커밋 메시지는 이 커밋이 어떤 변경사항을 담고 있는지 알려주기 위한 글로, 잘 작성해주면 나중에 알아보기 좋다.

### git push로 원격에 올리기
- main 브랜치에 올릴 것이니 `git push origin main`
- 푸시할 때 항상 main 브랜치에 푸시하도록 설정할 수 있다. 푸시를 할 때 `git push -u origin main` 이렇게 명령해보자. (-u는 원격의 main브랜치를 'upstream' 브랜치로 설정하는 옵션이다)
- 그럼 그 다음부터 푸시할 때는 아래처럼 브랜치 이름을 생략할 수 있다.
```
//푸시할 때
$ git push

//풀할 때
$ git pull
```

reference
https://shortcuts.tistory.com/8
