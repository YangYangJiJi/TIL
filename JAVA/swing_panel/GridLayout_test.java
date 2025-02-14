package swingtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GridLayout_test extends JFrame {
	public GridLayout_test() {
		// 각 위치에 해당하는 JButton 생성
		JButton btnNorth = new JButton("North");
		JButton btnCenter = new JButton("Center");
		JButton btnSouth = new JButton("South");

		// South에 JButton을 담을 Panel을 생성
		// South 위치 안에 또 BorderLayout 생성을 위해 + 추가로 new BorderLayout
		JPanel pnlEast = new JPanel(new BorderLayout());
		JLabel tfNorthEast = new JLabel("NorthEast");
		tfNorthEast.setPreferredSize(new Dimension(300, 30)); //핵심 포인트
		LineBorder bb = new LineBorder(Color.black, 1, true);
		tfNorthEast.setBorder(bb);
		JTextField tfSouthEast = new JTextField("SouthEast");
		tfSouthEast.setPreferredSize(new Dimension(300, 200)); //핵심 포인트

		pnlEast.add(tfNorthEast, BorderLayout.NORTH);
		pnlEast.add(tfSouthEast, BorderLayout.SOUTH);

		// 각 생성한 버튼을 BorderLayout을 통해서 각 위치에 배치
		add(pnlEast, BorderLayout.EAST);
		add(btnNorth, BorderLayout.NORTH);
		add(btnCenter, BorderLayout.CENTER);
		add(btnSouth, BorderLayout.SOUTH);

		setTitle("BorderLayoutEx");
		setSize(500, 500); // 창의 사이즈를 설정
		setLocation(680, 300); // 실행시에 창의 처음 위치를 지정
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료버튼 누를시에 바로 종료
		setVisible(true); // 가시성 부여 (눈에 보이게 하기)
		setResizable(false); // 창의 사이즈를 고정
	}

	public static void main(String[] args) {
		new GridLayout_test();

	}

}
