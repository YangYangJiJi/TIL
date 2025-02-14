# Word_Freq로 문자열 빈도 분석

## 핵심기능
- 문자열 등장 횟수를 계산하는 빈도 분석 기능
- `LinkedHashMap`을 사용한 단어 빈도 분석
- 입력된 단어 개수와 등장 횟수 출력

### 주요기능
- 문자열 배열을 받아 등장 횟수를 계산
- LinkedHashMap을 사용하여 삽입 순서 유지
- 단어별 빈도 출력

### 코드 분석
**입력된 단어의 등장 횟수를 계산**
- m.get(a)를 사용해 단어가 이미 존재하면 기존 값에 +1
- 없으면 1을 추가
```
Map<String, Integer> m = new LinkedHashMap<>();
for (String a : args) {
    Integer freq = m.get(a);
    m.put(a, (freq == null) ? 1 : freq + 1);
}
```
**결과 출력**
- 단어 종류 개수 (m.size())
- 단어와 빈도수 (m)
```
System.out.println(m.size() + " distinct words:");
System.out.println(m);

```

### 터미널에서 실행 결과
```
java word_freq.Word_Freq apple banana apple orange apple banana


//출력결과
3 distinct words:
{apple=3, banana=2, orange=1}
```
