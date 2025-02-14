package swingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTest extends JFrame {

	public PanelTest() {
		setTitle("Panel Visibility Example"); //창 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 버튼 클릭 시 프로그램 종료

		//메인 패널 생성 (BorderLayout 사용)
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		// 빨간색 패널 생성 (초기엔 안보임)
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		panel1.setPreferredSize(new Dimension(200, 200));
		panel1.setVisible(false); //처음에는 안 보이도록 설정

		// 파란색 패널 생성 (초기엔 안보임)
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLUE);
		panel2.setPreferredSize(new Dimension(200, 200));
		panel2.setVisible(false); //처음에는 안 보이도록 설정

		// 'Show panel'버튼 생성 (클릭 시 패널 보이도록 설정)
		JButton showPanelsButton = new JButton("Show Panels");
		showPanelsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true); //빨간색 패널 보이게
				panel2.setVisible(true); //파란색 패널 보이게
			}
		});

		//메인 패널에 버튼과 패널 추가
		mainPanel.add(showPanelsButton, BorderLayout.NORTH); //버튼을 상단에 배치
		mainPanel.add(panel1, BorderLayout.CENTER); //빨간색 패널을 중앙에 배치
		mainPanel.add(panel2, BorderLayout.SOUTH); //파란색 패널을 아래쪽에 배치

		// 메인 패널을 JFrame에 추가
		add(mainPanel);

		//창 크기 설정 및 화면 중앙 정렬
		setSize(300, 300);
		setLocationRelativeTo(null); //화면 중앙에 위치
		setVisible(true); //창 보이게 설정
	}

	public static void main(String[] args) {
		//GUI 프로그램을 실행할 때 SwingUtilities.invokeLater()을 사용하여 실행
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanelTest(); //PanelTest창 실행
			}
		});
	}
}