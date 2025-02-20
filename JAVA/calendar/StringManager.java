package calendar;

public class StringManager {

	// 숫자를 2자리 문자열로 변환하는 유틸리티 클래스
	//넘겨받은 인수가 1자리 수 인 경우 앞에 '0' 문자를 붙이고
	//2자리 수면 그냥 쓴다.
	public static String getZeroString(int n) {
		return (n < 10)? "0"+n : Integer.toString(n);
	}
}
