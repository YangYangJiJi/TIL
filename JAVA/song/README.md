# song : 노래 데이터와 사용자 데이터를 관리하고 검색하는 프로그램

## 주요 클래스
### Main.java
- 프로그램의 메인 클래스 (파일 읽기, 정렬, 검색, 사용자 입력 처리)
- `songs.txt`, `users.txt` 읽기
- 노래 정렬 및 출력
- 가수 등장 횟수 계산
- 사용자 입력을 받아 노래 검색
### Song.java
- 노래 정보를 저장하는 클래스
- 노래 정보 (ID, 가수명, 제목, 발매 연도)
- `matches()` 메서드로 검색 기능 지원
### User.java
- 사용자 정보를 저장하는 클래스 (즐겨듣는 노래 목록 포함)
- 사용자 정보 (ID, 이름, 나이, 성별)
- 즐겨 듣는 노래 목록 포함
- `matches()` 메서드로 검색 기능 지원

## [1] Main.java 클래스 설명
### 주요기능
- songs.txt, users.txt 파일을 읽어서 노래 목록과 사용자 목록을 저장함.
- 노래 제목 기준 정렬 & 상위 20개 출력
- 3회 이상 등장한 가수 출력
- 사용자 입력을 받아 특정 키워드로 노래 검색 (제목, 가수명, 발매 연도 등)
- 파일 열기 및 예외 처리
### 핵심 코드 설명
- `readSongs("songs.txt")` 
    - songs.txt 파일을 읽어서 songs 리스트에 저장
- `readUsers("users.txt")`
    - users.txt 파일을 읽어서 users 리스트에 저장
- `Collections.sort(songs, (x, y) -> x.songTitle.compareTo(y.songTitle));`
    - 노래 제목 기준 정렬
- `singerCnt = songs.stream().collect(Collectors.groupingBy(o -> o.name, Collectors.counting()));` 
    - 가수별 등장 횟수 계산
- `result2 = findAll(kwd);`
    - 사용자가 입력한 키워드로 노래 검색
- `openFile(filename)`
    - 파일을 안전하게 열고 예외 처리

## [2] Song.java 클래스 설명
### 주요기능
- 노래의 ID, 가수 이름, 제목, 발매 연도를 저장
- read(Scanner scan) : 파일에서 한 줄씩 읽어서 Song 객체 생성
- print() : 노래 정보를 출력
- matches(String n) : 키워드가 제목, 연도, 가수명과 일치하는지 확인하여 검색 기능 지원
### 핵심 코드 설명
- `Song(String x)` 
    - 문자열을 받아서 id, name, songTitle, year 추출
- `void read(Scanner scan)` 
    - 파일에서 한 줄씩 읽고 Song 객체 생성
- `boolean matches(String n)`
    - `songTitle.contains(n)`, `name.equals(n)`, `year.equals(n)` 중 하나라도 맞으면 true 반환

## [3] User.java 클래스 설명
### 주요기능
- 사용자 ID, 이름, 나이, 성별, 즐겨듣는 노래 목록을 저장
- read(Scanner scan, Main main) : 파일에서 사용자 정보와 즐겨 듣는 노래 목록을 읽어옴
- print() : 사용자 정보를 출력 (즐겨듣는 노래 포함)
- matches(String kwd) : 키워드가 사용자 ID, 이름, 성별, 연령대와 일치하는지 확인하여 검색 기능 지원

### 핵심 코드 설명
- `read(Scanner scan, Main main)`
    - users.txt에서 데이터를 읽고, 사용자가 좋아하는 Song을 channel 리스트에 추가
- `matches(String kwd)`
    - 검색 키워드(kwd)가 사용자 ID, 이름, 성별과 일치하는지 확인
    - 키워드가 숫자(예: "20")일 경우, 해당 연령대의 사용자만 검색 가능

## 프로그램 실행 흐름
1. 파일 읽기
    - songs.txt → songs 리스트 생성
    - users.txt → users 리스트 생성
2. 노래 정렬 및 출력
    - 노래 제목 기준 정렬
    - 상위 20개 노래 출력
3. 가수 등장 횟수 계산
    - 3번 이상 등장한 가수 출력
4. 사용자 입력 루프
    - 특정 키워드를 입력하면 해당하는 노래를 출력

```
제목 순으로 정렬 (20개만):
1월부터6월까지
And..그리고
Awoo
BAEBAE
BeautifulDay
CALLMEBABY
CUPID
Coffee&Tea
Dream
GOODBOY
Get
HelloBubble
I'mNotTheOnlyOne
INEEDU
IReallyLikeYou
IceCreamCake
KissMyLips
LOSER
LostStars
LoveSick


3회 이상 등장한 가수:
아이유, 빅뱅, 프라이머리, 어반자카파

=> 아이유 #입력
금요일에만나요
너의의미
마음

=> 빅뱅
BAEBAE
LOSER
WELIKE2PARTY
뱅뱅뱅

=> l
BeautifulDay
HelloBubble
I'mNotTheOnlyOne
IReallyLikeYou

=> 2013
금요일에만나요
```
