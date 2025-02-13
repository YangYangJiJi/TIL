package homework;

import java.util.Scanner;

//A+B - 5번 문제
//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//0 0 입력시 프로그램 종료

public class HW1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int A = 0;
			int B = 0;
			A = scan.nextInt();
			B = scan.nextInt();
			if (A == 0 && B ==0)
				break;
			System.out.println();
			System.out.println(A + B);
		}
	}
}
