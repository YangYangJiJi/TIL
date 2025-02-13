package homework;

import java.util.Scanner;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.

//EOF : End Of File. 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타냄.
//scanner의 EOF는 hasNext() : 입력된 토큰 있으면 true, 없으면 false 반환

//수정사항 : 맨 마지막인 5 + 2가 출력되지 않는다. 

public class HW2 {
	static Scanner scan = new Scanner(System.in);
	//main 메소드 밖에 scanner 쓰면 오류가 났는데, 
	//static 쓰니까 오류 사라짐.

	public static void main(String[] args) {
		while(scan.hasNext()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a + b);

		}
		scan.close(); //스캐너 사용이 끝난 후에는 꼭 닫아줘야 한다.

	}

}

