# github repository 이름 변경 방법
- 이미 로컬 폴더와 연결된 상태에서 github repository의 이름을 변경하는 방법
- 참고로 로컬 폴더 이름 변경은 그냥 파일 탐색기에서 하면 됨

<br>

## ✅ 1. GitHub에서 레포지토리 이름 변경
1. GitHub에 로그인 후, 해당 레포지토리로 이동
2. 우측 상단의 ⚙️ Settings(설정) 클릭
3. Repository name(레포지토리 이름 변경) 섹션에서 새로운 이름 입력
4. Rename(이름 변경) 버튼 클릭
이제 GitHub에서 레포지토리 이름이 변경되었습니다.

## 2. 로컬과 변경된 GitHub 레포지토리 연결 유지
로컬에서는 기존의 remote origin URL이 변경된 레포지토리 이름을 가리키도록 업데이트해야 합니다.

1. 현재 연결된 원격 저장소 확인

```
git remove -v

결과
origin  https://github.com/old-repo-name.git (fetch)
origin  https://github.com/old-repo-name.git (push)
```

2. 새로운 레포지토리 이름으로 원격 URL 변경

```
git remote set-url origin https://github.com/username/EGR_Tcell_RNAseq.git

```

3. 변경된 원격 저장소 URL 확인

```
git remove -v

결과
origin  https://github.com/NEW-REPO-NAME.git (fetch)
origin  https://github.com/NEW-REPO-NAME.git (push)

```