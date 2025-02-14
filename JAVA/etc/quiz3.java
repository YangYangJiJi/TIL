package gagche;

public class Test1 {
	int scores[]= {1,2,3,4,5,6,7,8};
	int sum;
	void mymain()
	{
		for (int i=0; i<scores.length; i++) {
			sum+=scores[i];
	}
	System.out.println("sum=" + sum);
	for (int n: scores)
		//System.out.printf("%d", scores[i]);  //여기서 i는 1,2,3,4,5,6,7,8을 가짐 그래서 scores[i]가 아니라 n으로 써야 가독성이 좋음
		sum += n; //System.out.printf("%d", n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test1 my = new Test1();
		my.mymain();
	}
}


// 실행결과
// sum=36
