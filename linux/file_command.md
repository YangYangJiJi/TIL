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
- 패턴 탐색과 처리를 위한 명령어

```
# 파일 목록에서 파일 이름만 빼서 보기
$ ls -al | awk '{ print $9}'

# 현재 저장된 history(명령어 기록)에서 가장 많이 내린 명령어 찾아서 출력
$ history | awk '{ print $2 }' \ | sort | uniq-c | sort -nr | head -3
```

## cut
### `$ cut [옵션] [파일]`
- 파일 내용을 각 필드로 구분하고 필드 별로 내용을 추출하며 각 필드들을 구분 자로 구분할 수 있는 명령어
- -b : 바이트 단위 선택
- -c : 문자 단위 선택
- -d : 필드 구분 값 지정 (기본 : tab)
- -f : 지정한 필드만 출력
- -s : 필드 구분자 미포함 라인 미출력

```
 # 파일의 각 라인의 1~3번째 까지의 문자만 출력
$ cut -c 1-3 cut_test.txt
 # 파일의 각 라인의 3번째 필드 출력(탭 구분 기준)
 $ cut -f 3 cut_test.txt
 # 파일의 각 라인의 3번째 필드 출력(',' 구분 기준)
 $ cut -d , -f 3 cut_test.txt
```

## tar
### `$ tar cvf [filename] [path]`
### `$ tar xvf [tar filename] [path]`
- 디렉토리나 여러 개의 파일을 하나의 파일로 묶는 명령어
- -c : tar파일 생성할 때 사용 (풀때는 –x옵션)
- -t : tar파일의 내용을 확인할 때 사용
- -f : tar파일을 사용할 때 사용 (기본사용)
- -p : tar파일을 생성/풀때 원본 파일속성 (permission) 유지
- -v : 묶거나 풀 때 과정보기

```
# tar를 이용하여 /home/test라는 폴더 test.tar로 압축하기
$ tar -cvf test.tar /home/test 
# tar를 이용하여 test.tar 압축파일을 /home/test에 풀기
$ tar -xvf test.tar /home/test
```

## gzip
### `$ gzip [filename]`
### `$ gzip-d [compressed filename]`
- 디렉토리나 여러 개의 파일을 하나의 파일로 묶는 명령어, tar와 함께 사용하기도 함
- -c : 표준 출력 이용 (파이프와 사용)
- -d : 압축 풀기
- -f : 강제로 쓰기
- -q : 경고 메시지 출력 없이 하기

```
# gzip를 이용하여 test.tar 파일을 압축하기
$ gzip test.tar
$ ls
test.tar.gz

$ gzip-d test.tar.gz
$ ls
test.tar

# tar를 명령에 ‘z’ 옵션주기
$ tar –czvf test.tar.gz /home/test
```

## ftp, sftp, wget, curl
### ftp
- FTP 사이트로부터 파일을 업로드하거나 다운로드 할 때 사용하는 명령어

### sftp
- ssh 통신을 통해 FTP 처럼 이용하는 명령어
```
$ ftp [URL]
$ ftp [ip]
$ ftp [user id]@[URL]
```

### wget 
- URL을 이용하여 인터넷에서 받을 수 있는 파일을 내려받을 때 사용하는 명령어
- `$ wget [URL]`

### curl 
- 다양한 프로토콜로 데이터를 전송해볼 수 있는 명령어, 웹 페이지 확인 가능
- `$ curl [URL]`