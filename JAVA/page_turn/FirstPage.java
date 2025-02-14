package page_turn;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FirstPage extends JFrame {
	public FirstPage() {

		super("창1"); // 창 제목 설정
		JPanel jPanel = new JPanel(); //패널 생성
		JButton btn1 = new JButton("창 2"); //버튼 생성
		setSize(300, 200); // 창 크기 설정
		jPanel.add(btn1); //버튼을 패널에 추가
		add(jPanel);// 패널을 프레임에 추가

		// 창을 화면 정중앙에 배치
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true); //창 보이게 설정

		// 버튼 클릭 시 새로운 창을 열고 현재 창을 숨김
		//이 부분이 창 변환의 핵심이다.
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SecondPage(); // 두번째 창 열기
				setVisible(false); // 현재 창 안보이게 하기
				
			}
		});
	}

	public static void main(String[] args) {
		new FirstPage(); //프로그램 실행 시 첫번째 창 열기
	}
}
