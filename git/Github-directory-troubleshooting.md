# Github 디렉토리에 화살표 표시 = 폴더 접근 불가능

## 문제 발생 상황 
- 원래 내 로컬 구조
C:/myGithub/Biopython/ROSALIND_BI_Stronghold/001_DNA 등등
- 파일탐색기에서 이름수정, 구조변경을 했다.
C:/myGithub/Rosalind/Stronghold/001_DNA 등
C:/myGithub/Rosalind/Armory/001_INI 등
- 이렇게 git이 아니라 파일탐색기로 바꾸다보니, 뭐가 꼬였나보다. push하는 과정까지도 힘들었고, 기껏 push하고 github로 들어가보니 Stronghold폴더에 화살표 표시가 생겼더라... Stronghold 폴더 클릭이 안되고 접근이 아예 불가능했다. 내가 지금까지 9문제 정도를 풀었는데, 너무 아쉬웠다. 

## 문제 원인
- 어떤 티스토리에서 이 문제는 해당 폴더에 .git 폴더가 생겨서 발생하는 문제라고 했다.
- .git은 원래 최상위폴더에만 있어야 한다. 
- 원래 ROSALIND_BI_Stronghold (구 최상위폴더)에 .git이 있었고 > 이 상태에서 폴더명을 그냥 Stronghold로 바꾸었다. > 따라서 Stronghold에 .git이 아직 있는 상태로 > Rosalind (신 최상위폴더)에 또 .git을 부여해버렸기에 > 이 난리가 난것이다. 

## 해결
** .git이 있는지 확인 -> .git 파일 제거 -> 스테이지 파일 제거 -> add, commit, push 진행 **

### 1. .git이 있는지 확인
- 문제가 있는 디렉토리에 가서 .git 파일이 있는지 확인
``` 
cd C:/myGithub/Rosalind/Stronghold
ls -al  
```
- .git 파일을 찾으면 이 방법 통함.

### 2. .git 파일 제거
- 먼저 위 문제가 발생하는 디렉토리에서 .git 파일을 제거한다. 
``` 
rm -rf .git 
```

### 3. 스테이지 파일 제거
- 해당 스테이지의 파일을 제거
```
git rm --cached . -rf
```

### 4. add - commit - push 진행
- 위 과정을 끝낸 후 push를 진행
```
git add .
git commit -m "remove .git files"
git push origin main
```

### 5. 깃허브가서 확인
- 디렉토리에 화살표모양이 사라지고, 접근 가능!!

reference : 어느 천사의 티스토리 참고
https://zzang9ha.tistory.com/346
