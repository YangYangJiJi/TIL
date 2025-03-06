# linux 파일 입출력 명령어 

## redirection

```
 $ [command] < [filename]
 $ [command] > [filename]
 $ [command] >> [filename]
```
- 리눅스에서 파일 입출력 다루기

```
# 표준 입력
$ ls < filelist.txt
 # 표준 출력
$ ls –al > filelist.txt
 # 표준 출력 (이어쓰기)
 $ cat text1.txt > all.txt
 $ cat text2.txt >> all.txt
 $ cat all.txt
```

## grep
### `$ grep [옵션] [패턴or키워드] [파일명]`
- 파일내에 특정 패턴이나 키워드를 찾는 명령어
```
 # myFile.txt 내에 test 란 문구가 들어간 라인을 출력
$ grep ＂test" myFile.txt
 # 프로세스 목록 중에 python 이 들어간 라인만 출력
$ ps–aux | grep python
 # 현재 폴더(.) 내에 test가 들어간 파일 및 라인 출력
$ grep "test" . –rn
```

## find
### `$ find [옵션] [경로] [패턴]`
- 파일을 검색할 때 사용하는 명령어
```
# test.txt 란 이름의 파일 찾기
$ find . –name "test.txt"
 # test 로 시작하는 모든 파일 찾기
$ find . –name "test*" 
```

## sed
### `$ sed 's/찾을텍스트/바꿀텍스트/' 파일명`
- 필터링과 텍스트를 변환하는 스트림 편집기. 원본 변화없이, 출력 결과를 변화
```
# <파일>에서 3~7라인만 출력 
$ sed-n '3,7p' <파일>
 # 1을 2로 바꿔서 출력 
$ sed 's/1/2/g' <파일>
 # services를 갖는 줄에서 start를 stop으로 global하게 변환
$ sed '/services/ s/start/stop/g' <파일>
 # "#"로 시작하거나 or 빈 줄인 라인 제거
$ sed '/^#\|^$\| *#/d' <파일>
```

## awk
### ` $ awk-F delim '{ print $x }'`
### `$ awk '{print $1}' file`
```
# 파일 목록에서 파일 이름만 빼서 보기
$ ls -al | awk '{ print $9}'

# 현재 저장된 history(명령어 기록)에서 가장 많이 내린 명령어 찾아서 출력
$ history | awk '{ print $2 }' \ | sort | uniq-c | sort -nr | head -3
```

## cut