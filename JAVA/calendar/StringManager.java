package calendar;

public class StringManager {

	// ���ڸ� 2�ڸ� ���ڿ��� ��ȯ�ϴ� ��ƿ��Ƽ Ŭ����
	//�Ѱܹ��� �μ��� 1�ڸ� �� �� ��� �տ� '0' ���ڸ� ���̰�
	//2�ڸ� ���� �׳� ����.
	public static String getZeroString(int n) {
		return (n < 10)? "0"+n : Integer.toString(n);
	}
}
