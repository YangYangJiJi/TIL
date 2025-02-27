# git push error #1

## error 상황
```
$ git push origin main
fatal: 'origin' does not appear to be a git repository
fatal: Could not read from remote repository.

Please make sure you have the correct access rights
and the repository exists.
```

## 해결방법

### 1. 원격 저장소 확인하기
- `git remote -v`
- 원격 저장소(origin)이 설정되어 있는지 확인


### 2. 원격 저장소 추가하기
- 'git remote add origin https://github.com/사용자이름/저장소이름.git`
- 이때 꼭 원격(깃허브)와 연결된 폴더 위치에서 해야함

### 3. 원격 저장소가 올바르게 설정되었는지 확인
- `git remote -v`
- 이후 다시 push 하면 됨



## 2번에서 원격(깃허브)와 연결된 폴더 위치가 아니라, 그 안에 있는 폴더에서 한 경우.

### 상황설명
```
근데 내가 원래 c/myGithub/TIL에다가 git remote add origin https:// 를 했었어.
근데 이번에는 c/myGithub/TIL/python에다가 git remote add origin https:// 를 해버렸어. 이거 괜찮아? 아니면 다시 TIL에 다가 git remote add origin https:// 를 하면 돼?
```
- 즉, c/myGithub/TIL에서 원격 저장소를 추가했었음.
c/myGithub/TIL/python에서도 git remote add origin https://...을 실행했음.
- 이 경우, TIL/python 디렉터리가 독립적인 Git 저장소로 설정되었을 가능성이 있음. 즉, TIL과 TIL/python 각각 다른 Git 저장소로 관리될 수 있음.

### 해결방법
1. **TIL/python이 독립적인 저장소인지 확인**
- `git rev-parse --is-inside-work-tree`
- 만약 true가 출력되면, TIL/python은 독립적인 Git 저장소로 설정된 상태임.
- 또는 원격 저장소를 확인하는 방법:
- `git remote -v`
- 만약 origin이 등록되어 있다면, TIL/python은 TIL과 별개의 Git 저장소가 됨.

2. ** TIL/python의 원격 저장소를 삭제하고 TIL에서 다시 설정**
- 만약 TIL/python이 잘못된 Git 저장소라면, 해당 디렉터리에서 Git 설정을 제거하고 TIL에서 다시 원격 저장소를 추가하면 됨.
- TIL/python의 Git 저장소 초기화 해제 방법 :
- `git remote remove origin`
- 또는 `rm -rf .git`

3. **이후 다시 TIL에서 원격 저장소 설정**
```
cd c/myGithub/TIL
git remote remove origin  # 기존 원격 저장소 삭제 (필요한 경우)
git remote add origin https://github.com/사용자이름/저장소이름.git
git remote -v  # 정상적으로 등록되었는지 확인
```
- 이후 push하기.

