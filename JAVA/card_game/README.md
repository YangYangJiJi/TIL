# card game 패키지 설명
이 패키지는 컬렉션 프레임워크를 활용한 다양한 데이터 처리를 다루고 있음.

## 핵심 클래스
### 1️⃣ Card.java
- 카드 덱을 만들고 섞어서, 플레이어에게 나누어 주는 기능
- 52장의 카드 생성 및 섞기 (`Collections.shuffle()`)
- 사용자 입력을 받아 카드 배분 (`dealHand()` 활용)

### 2️⃣ Collection_ex1.java
- 난수를 활용한 집합(Set)과 리스트(List)의 연산
- `Set`을 이용한 중복 제거
- `removeAll()`을 이용한 집합 연산
- `Set`을 `List`로 변환

## [1] Card 클래스
### 주요 기능
- 카드 덱을 생성 (♤, ♡, ◇, ♧ 4가지 문양 × A~K)
- 카드를 섞음 (Collections.shuffle(deck))
- 사용자 입력을 받아 플레이어에게 카드 배분 (dealHand() 활용)
- 카드가 부족할 경우 예외 처리
### 핵심 코드 설명
**카드 덱 생성**  
suit와 rank 배열을 조합하여 총 52장의 카드를 생성함.
```
String[] suit = { "♤", "♡", "◇", "♧" };
String[] rank = { "A", "2", "3", ..., "K" };
List<String> deck = new ArrayList<>();
for (String s : suit)
    for (String r : rank)
        deck.add(s + r);
```
**셔플 (카드 섞기)**  
Collections.shuffle()을 이용해 카드를 무작위로 섞음.
```
Collections.shuffle(deck);
```
**카드 배분 (dealHand)**  
subList()를 이용하여 덱에서 N장의 카드를 떼어 내고, 리스트에서 제거하는 방식.
```
public static <E> List<E> dealHand(List<E> deck, int n) {
    int deckSize = deck.size();
    List<E> handView = deck.subList(deckSize - n, deckSize);
    List<E> hand = new ArrayList<>(handView);
    handView.clear(); // 사용된 카드는 제거
    return hand;
}
```
### 실행 예시
```
// 2명의 플레이어에게 각각 5장씩 카드 배분
java Card 2 5

//실행 결과
[♧8, ♡K, ♡5, ♧10, ♡7]
[♤Q, ♧J, ♤6, ♡J, ♤2]
```

## [2] Collection 클래스
### 주요기능
- Set과 List를 활용하여 난수 생성
- 중복 제거된 Set과 원본 List 비교
- removeAll()을 사용한 집합 연산
- Set을 List로 변환하여 순서 확인
### 코드 분석
**난수 생성 (rand.nextInt(30))**  
- HashSet<Integer>에 저장하여 중복 제거
- ArrayList<Integer>에는 순차적으로 0~29 저장 (중복 가능)
```
Set<Integer> randSet = new HashSet<>();
Collection<Integer> col = new ArrayList<>();
for (int i = 0; i < 30; i++) {
    n = rand.nextInt(30);
    randSet.add(n);
    col.add(i);
}
```
**집합 연산 수행**
- removeAll(randSet)을 이용해 col에서 randSet에 있는 숫자들을 제거 → 집합 연산 수행
```
System.out.println("난수집합: " + randSet);
col.removeAll(randSet);
System.out.println("제외집합: " + col);
```
**Set을 List로**
- Set을 List로 변환하여 출력 (원래 Set은 순서가 없지만, toString()을 이용하면 정렬된 것처럼 보임)
```
ArrayList<Integer> setList = new ArrayList<>(randSet);
System.out.println("리스트변환:" + setList);
```

<br>
<br>

## 프로그램 실행 흐름
- Card.java → 카드 덱을 만들고 셔플 후 플레이어에게 배분
- Collection_ex1.java → Set과 List를 활용하여 중복 제거 및 집합 연산 수행

## cmd에 입력해서 Card.java 실행하는 방법

1. `cd C:\Java-Study\src\week10_collection`
Card.java 파일이 C:\Java-Study\src\week10_collection 폴더에 있다고 하면:


2. `javac Card.java`
- Java 파일 컴파일 (.class 파일 생성)
- 컴파일을 해야 .java 파일이 실행 가능한 .class 파일로 변환됨
- 오류가 생기면, 코드 속 한글 다 지우기 (나는 한글주석은 다 지우고, 스페이드, 다이아 이런 기호 다 영어로 바꿈)
- 완료되면 \week10_collection 이 폴더에 무슨 파일이 생김

3. `javac -d . Card.java`, `java week10_collection.Card 2 5`
- week10_collection 이라는 패키지가 있는 경우기에, 이 안에 있는 클래스를 실행할 경우 패키지 이름을 포함해야 함.
- -d . 옵션은 현재 디렉토리에 패키지 구조를 유지한 채 .class 파일을 생성함.
- 실행할 때는 패키지 이름을 포함해야 함.

4. 실행결과
```
java week10_collection.Card 2 5 
// args[0] =2 플레이어는 2명
// args[1] =5 각 플레이어에게 5장씩 배분

// 실행결과
[spad6, spad10, clova3, clovaA, diaQ]
[clova6, spad2, heart9, dia4, clova4]
```

