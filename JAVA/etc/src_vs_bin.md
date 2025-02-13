# java에서 src/와 bin/의 차이
Java 프로젝트에서 src/(소스 폴더)와 bin/(바이너리 폴더)는 역할이 다름.

## 1️⃣ src/ (Source 폴더) - 소스 코드 저장
- src/ 폴더는 Java 소스 코드(.java 파일)가 저장되는 곳임.
- 프로그래머가 직접 작성하는 클래스, 메서드, 패키지가 포함됨.
- 예제 (src 폴더 구조):

```
MyJavaProject/
├── src/            # 소스 코드 폴더
│   ├── Main.java   # Java 소스 파일
│   ├── Utils.java
│   ├── models/
│   │   ├── User.java
│   │   ├── Product.java
```
여기서 Main.java 같은 파일을 직접 열어서 수정할 수 있음.

## 2️⃣ bin/ (Binary 폴더) - 컴파일된 파일 저장
- bin/ 폴더는 컴파일된 Java 바이트코드(.class 파일)가 저장되는 곳임.
- javac(Java Compiler)가 .java 파일을 .class 파일로 변환하면 생성됨.
- 이진 파일(.class)이므로 사람이 직접 수정할 필요 없음.
- 예제 (bin 폴더 구조)
```
MyJavaProject/
├── bin/            # 컴파일된 바이트코드 폴더
│   ├── Main.class  # 컴파일된 Java 파일
│   ├── Utils.class
│   ├── models/
│   │   ├── User.class
│   │   ├── Product.class
```
.class 파일은 Java 가상 머신(JVM)이 실행하는 파일이며, 사람이 직접 수정하지 않음.

## 결론 : 실행할 때는 bin/, 코드를 수정할 때는 src/
- 파일을 열어서 코드를 수정할 때 : src/ 폴더에서 .java 파일을 열어야 함.
- 프로그램을 실행할 때 : Java는 bin/ 폴더에 있는 .class 파일을 실행함.

