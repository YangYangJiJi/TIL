# JAVA enum을 활용한 요일관리 코드

## 핵심
- enum을 사용하여 요일을 관리하고, 각 요일에 대해 숫자 및 한글 요일명을 저장함.
- 사용자로부터 요일 입력을 받아 enum 값으로 변환하여 배열에 저장 후 출력함.
- 특정 로직 (num())을 이용해 마스크 구매 요일을 계산하는 기능이 있음.
- toString()을 오버라이딩하여 enum 값을 출력할 때 보기 좋게 변환함.

## WorkDay라는 enum
- enum WorkDay는 요일을 나타내는 열거형이며, 각 요일에 대해 숫자(number)와 한글 요일명(yoil)을 저장함.
- private WorkDay(int n, String harg) : 생성자로 숫자와 요일명을 저장함.
- toString() : name()을 활용해 첫 글자는 대문자, 나머지는 소문자로 변환하여 출력.
- 예: THURSDAY → "Thursday"
- num() : 요일에 해당하는 숫자 반환 (MONDAY = 1, FRIDAY = 0 등).
- yoil() : 한글 요일명 반환 (MONDAY는 "월", TUESDAY는 "화" 등).

## MainEnum 클래스 run 흐름
1. 사용자 입력을 받아서 WorkDay 배열을 5개 채움.
    - valueOf(scan.next())를 사용하여 문자열 입력을 enum 값으로 변환함.
    - 예: 입력 "MONDAY" → WorkDay.MONDAY
2. 입력받은 요일들을 출력하며 name(), num() 및 toString()을 활용하여 각 요일의 정보 출력.
3. num()을 활용해 2000년대생 및 2005년대생이 마스크를 구입할 수 있는 요일을 출력.

## example input, output
input
```
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
```
output
```
MONDAY (1) Monday
2001, 2006년도 생은 마스크를 구입할 수 있습니다.
TUESDAY (2) Tuesday
2002, 2007년도 생은 마스크를 구입할 수 있습니다.
WEDNESDAY (3) Wednesday
2003, 2008년도 생은 마스크를 구입할 수 있습니다.
THURSDAY (4) Thursday
2004, 2009년도 생은 마스크를 구입할 수 있습니다.
FRIDAY (0) Friday
2000, 2005년도 생은 마스크를 구입할 수 있습니다.
```

## 주석처리 된 run 메서드
- 이 부분은 특정 요일을 직접 할당하여 마스크 구입이 가능한지 판별하는 코드임.
- day1 = WorkDay.THURSDAY, day2 = WorkDay.MONDAY를 설정.
- day1.name(), day1.num(), day1.toString()을 출력.
- 2002년도생이 day2 (월요일) 에 해당하는지 판단.
- 2002 % 5 == day2.num()이면 "가능", 아니면 "불가".
```
THURSDAY (4) Thursday
2002년도생: 월요일 마스크 구입 가능
```