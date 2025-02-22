# 기존 파일을 폴더로 옮기기(로컬) → 깃허브에 반영
목차
> 기존 파일을 폴더로 옮기기(로컬) → 깃허브에 반영
> 파일 및 폴더 이름 변경

## 기존 파일을 폴더로 옮기기(로컬) → 깃허브에 반영
1. **새 폴더 생성**
파일탐색기에서 새 폴더 생성

2. **기존 파일을 새 폴더로 이동**
- 예를 들어, file1.txt, file2.txt를 new_folder로 이동하려면:
```
mkdir file1.txt file2.txt new_folder/
```
- 혹은 폴더 안에 여러 파일을 한번에 이동하려면, 해당 폴더 내 모든 파일을 이동시킬 수 있다.
```
mv * new_folder/
```
3. **폴더구조 확인**
이동 후, 파일이 올바르게 new_folder 안에 있는지 확인
```
ls new_folder/
```
4. **add, commit, push**
- git status로 잘 옮겨졌는지 확인한다.
- Git은 파일이 이동된 것을 deleted (삭제된 파일)와 new file (새로 추가된 파일)로 표시할 것이다.
- 이후 add, commit, push로 업로드 한다.


## 파일 및 폴더 이름 변경
1. **파일 이름 변경**
```
git mv old_file.txt new_file.txt
```
이 명령어는 old_file.txt를 new_file.txt로 변경한다.  
git mv는 변경된 파일을 Git에 자동으로 반영하므로, 따로 git add를 사용할 필요는 없다.  

2. **폴더 이름 변경**
```
git mv old_folder new_folder
```
이 명령어는 old_folder라는 폴더를 new_folder로 이름을 변경하고,   
해당 폴더 안에 있는 모든 파일도 새 폴더로 이동한다.
이후 변경사항을 commit 후 push 한다.  