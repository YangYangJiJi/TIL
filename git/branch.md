# Github/Git에서 branch
## branch 개념

### git branch란?
- 기존 코드(main 브랜치)를 유지하면서, 새로운 기능을 개발하거나 기존 코드를 수정하는 독립적인 공간
- Git에서는 기본적으로 main 브랜치가 존재하는데, 새로운 브랜치를 만들어서 실험하거나, 기능을 추가한 후 main 브랜치에 병합(merge)할 수 있음
- 즉, 브랜치를 활용하면 기존 코드에 영향을 주지 않고 새로운 코드를 개발할 수 있음

### branch 활용의 장점
✅ 기존 코드를 유지하면서 새로운 기능 개발 가능. 
✅ 기능별로 독립적인 작업 가능 (버그 수정, 성능 개선 등). 
✅ 변경 사항을 main에 적용하기 전에 검토 가능. 
✅ 여러 사람이 동시에 협업하기 편리. 

### 브랜치 활용 전략 예시
대규모 프로젝트에서는 다음과 같은 브랜치 전략을 사용할 수 있다.  
- main: 안정적인 버전 유지
- develop: 새로운 기능 개발을 위한 브랜치
- feature/*: 기능 추가를 위한 브랜치 (예: feature-authentication)
- bugfix/*: 버그 수정용 브랜치
- hotfix/*: 긴급 패치 브랜치
  

## Github에서 branch를 만들어 코드를 수정하는 방법
GitHub에서 직접 수정해도 기존 코드가 사라지지 않고, 브랜치로 분리하여 관리 가능. 
### 1. Github에서 새로운 브랜치 만들기
1. GitHub에서 Repository로 이동
2. 파일을 열고 `Edit` 버튼(연필 아이콘) 클릭
3. 수정 후, 아래에서 `Commit changes` 옵션에서 새로운 브랜치 생성 (`Create a new branch`) 선택
4. 브랜치 이름 입력 (`upgrade-version` 같은 의미 있는 이름)
5. `Propose changes` 클릭
➡ 기존 코드(main 브랜치)는 그대로 유지되고, 새로운 브랜치에서 수정된 코드가 따로 보관됨.

### 2. Pull Request(PR) 생성하기
브랜치를 만든 후, GitHub에서  
1. `Compare & pull request` 버튼 클릭
2. 변경 사항을 확인하고 `Create pull request` 클릭
3. 필요하면 코드 리뷰를 받고, 문제가 없으면 `Merge pull request` 클릭하여 `main` 브랜치로 병합

### 3. 브랜치 병합 후 기존 브랜치 삭제 가능
PR이 승인되면 브랜치를 삭제할 수도 있고, 유지할 수도 있음  
- GitHub에서 `Delete branch` 버튼을 눌러 브랜치를 삭제하거나
- CLI에서 `git push origin --delete upgrade-version` 명령어로 삭제 가능
➡ 이 과정에서도 기존 코드(`main`)는 변경 전 상태를 유지하며, 변경 후 코드는 PR을 통해 병합해야 반영됨.

### 4. 기존 main 브랜치의 코드 확인하는 방법
**방법1. Github에서 Commit history 확인**
1. GitHub 저장소(Repository)로 이동
2. <> Code 탭에서 현재 브랜치를 main으로 선택
3. 상단 메뉴에서 "History" (또는 "Commits") 클릭
4. 이전 커밋들을 클릭하면, 기존 코드 상태를 그대로 확인 가능
➡ 기존 코드가 어떤 상태였는지 커밋별로 확인하고, 필요하면 복구도 가능!

**방법 2: GitHub에서 특정 커밋으로 이동하기**
1. GitHub에서 "History" 페이지에서 원하는 커밋을 클릭
2. 해당 커밋의 내용을 확인하고, 필요하면 다운로드 가능
3. 특정 커밋을 main 브랜치로 되돌리고 싶다면:
```
git reset --hard <커밋해시>
git push --force
```
*주의: reset --hard는 현재 변경사항을 덮어씌우므로 조심해서 사용해야 함


## Git CLI에서 branch를 활용하는 방법
1. 현재 브랜치 확인
`git branch`
현재 있는 브랜치 목록이 표시되고, *가 붙은 브랜치가 현재 작업 중인 브랜치

2. 새로운 브랜치 만들기 
`git branch upgrade-version`  
upgrade-version이라는 새 브랜치를 생성하지만, 아직 해당 브랜치로 이동한 건 아님.

3. 새로운 브랜치로 이동 (체크아웃)
`git checkout upgrade-version` 또는  
`git switch upgrade-version`  
이제부터 새로운 upgrade-version 브랜치에서 작업할 수 있음

4. 코드 수정 후 변경 사항 저장
파일을 수정한 후 변경 사항을 git에 저장하려면
```
git add .
git commit -m "업그레이드된 코드 추가"
```
새로운 브랜치에 변경 사항을 커밋함

5. Github에 새로운 브랜치 올리기
`git push origin upgrade-version`  
새로운 브랜치를 GitHub에 업로드하면, main 브랜치는 기존 코드 그대로 유지되고, 새로운 코드가 있는 브랜치가 추가됨

6. Pull Request (PR) 생성하기
- GitHub에서 새로운 브랜치를 push하면, GitHub에서 Compare & pull request 버튼이 보임
  - 버튼을 눌러서 변경 사항을 검토하고
  - 설명을 추가한 뒤
  - Create pull request 버튼 클릭
이제 팀원들과 코드 리뷰를 하거나, 스스로 변경 사항을 비교할 수 있음

7. 브랜치를 main에 merge(병합) 하기
PR이 승인되면 Merge pull request 버튼을 눌러 main 브랜치에 변경 사항을 합칠 수 있음
병합이 끝나면 브랜치 정리를 위해 삭제할 수도 있다
```
git branch -d upgrade-version  # 로컬 브랜치 삭제
git push origin --delete upgrade-version  # GitHub에서 브랜치 삭제
```



