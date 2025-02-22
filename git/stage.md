# 스테이징과 관련된 내용
- `git add` 하면 해당 파일 및 폴더가 스테이지로 올라가고, 그것을 스테이징이라고 한다.

### 스테이징된 여부 확인
- `git status`를 입력하면 스테이징된 파일과 스테이징되지 않은 파일을 구분하여 표시된다.
- 예를 들어 
```
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)
        modified:   Text_Analysis/some_file.txt

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   Text_Analysis/another_file.txt
```
- 여기에서
- Changes to be committed: 여기에 나열된 파일들은 스테이징된 파일로, 다음 커밋에 포함될 파일들임.
- Changes not staged for commit: 여기에 나열된 파일들은 스테이징되지 않은 파일로, 아직 git add를 하지 않아서 커밋에 포함되지 않은 파일들임.


### 스테이징 취소
- 스테이징 취소 (파일 하나만): git reset <파일명>
- 모든 스테이징 취소: git reset
- 파일 변경 내용까지 되돌리기: git checkout -- <파일명>
