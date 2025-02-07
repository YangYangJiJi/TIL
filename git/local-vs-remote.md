# 로컬저장소와 원격저장소 차이 모음
- 정리 계기 : git으로 이어진 로컬과 원격의 연결이 이해가 안가서 정리를 하게 되었다.

## 목차
> Q1. 로컬저장소와 원격저장소. 어디에 저장?
> Q2. 원격 저장소 확인하는 방법
> Q3. 폴더마다 원격 저장소 다르게 설정 가능? Yes

***

## Q1. 로컬저장소와 원격저장소. 어디에 저장?
- "오늘은 원격, 내일은 로컬, 모레는 원격 ... " 이런식으로 저장을 해도 되나요? Yes!!
- 올바른 방법으로 동기화하면 문제가 안생긴다.
- 바로 항상 작업하기전 pull을 먼저하고, push를 해주는 습관!!!
```
cd C:\myGithub\TIL\git  # 로컬 작업 폴더 이동
git pull origin main  # 원격 변경 사항을 먼저 가져오기
# 이후 편집 및 추가 작업
git add .
git commit -m "Update after pulling latest changes"
git push origin main  # 최신 변경사항 반영
```

## Q2. 원격 저장소 확인하는 방법
- 각 폴더에서 현재 어떤 원격 저장소가 연결되어 있는지 확인
- `git remote -v`
- 예를 들어, C:\myGithub\TIL\git 폴더에서 `git remote -v`을 실행하면 다음과 같은 결과가 나와야 한다.
```
origin  https://github.com/사용자명/TIL.git (fetch)
origin  https://github.com/사용자명/TIL.git (push)
```

## Q3. 폴더마다 원격 저장소 다르게 설정 가능? Yes
- 각 폴더에서 설정된 원격 저장소가 다르기 때문에, 다른 폴더에서 git push를 해도 영향을 주지 않는다.
- 즉, TIL 폴더에서 git push를 하면 TIL 레포지토리에만 반영되고,
- Rosalind 폴더에서 git push를 하면 Rosalind 레포지토리에만 반영된다.

