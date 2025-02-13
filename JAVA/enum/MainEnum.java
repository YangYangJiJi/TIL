package enum1;

import java.util.Scanner;

public class MainEnum {
	
	
	void run() {
		Scanner scan = new Scanner(System.in);
		WorkDay[] days = new WorkDay[5];
		for (int i = 0; i<5; i++) {
			days[i] = WorkDay.valueOf(scan.next());
		}
		for (int i =0; i<5; i++) {
			System.out.printf("%s (%d) %s\n", days[i].name(), days[i].num(), days[i]);
			System.out.printf("%d, %d년도 생은 마스크를 구입할 수 있습니다.\n", days[i].num()+2000, days[i].num()+2005);
		}
	}
		
	public static void main(String[] args) {
		MainEnum me = new MainEnum();
		me.run();
	}
	
//	void run() {
//		WorkDay day1 = WorkDay.THURSDAY;
//		WorkDay day2 = WorkDay.MONDAY;
//		System.out.printf("%s (%d) %s\n", day1.name(), day1.num(), day1);
//		int n = 2002;
//		System.out.printf("%d년도생: %s요일 마스크 구입 ", n, day2.yoil());
//		if (n % 5 == day2.num())
//			System.out.println("가능");
//		else
//			System.out.println("불가");
//	}
//	
//	public static void main(String[] args) {
//		MainEnum me = new MainEnum();
//		me.run();
//	}
}
