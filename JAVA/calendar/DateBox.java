package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

//달력에서 날짜를 표시하는 개별 박스 (각 날짜 칸을 객체로 표현)
public class DateBox extends JPanel{
	String day;  //날짜를 표시할 문자열
	Color color; //박스의 배경색
	int width;	 //박스의 가로크기
	int height;	 //박스의 세로크기
	
	// 생성자 : 날짜 문자열, 배경색, 크기를 설정하고 패널 크기를 지정
	public DateBox(String day, Color color, int width, int height) {
		this.day = day;
		this.color = color;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));		
	}
	
	//paint를 재정의하면 컴포넌트에 내가 원하는 것을 그릴 수 있다.
	//이를 이용해서 배경색과 글씨를 넣기
	//JPanel의 paint 매서드 오버라이딩
	public void paint(Graphics g) {
		g.setColor(color);
		//꽉찬 상자를 넣는 것인데 위에서 설정한 색으로 배경색을 칠하는 것
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.black);
		//글씨를 그리는 것인데 첫번 째 매개변수는 글씨의 내용
		//2번째는 x축  3번째는 y축
		g.drawString(day, 10, 20); //날짜 텍스트를 그림 (좌표 : 10,20)
	}
}