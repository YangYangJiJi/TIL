package calendarSwing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchSchedule extends JFrame {
	JPanel panelTop = new JPanel();
	JPanel panelCenter = new JPanel();
	JButton btn = new JButton("검색");

	SearchSchedule() {
		super("SearchSchedule"); // 타이틀
		Container pane = getContentPane();
		setSize(420, 250);
		add(panelCenter);
		// panelTop.add(btn, BorderLayout.SOUTH);
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		btn.doClick();
		setVisible(true);
	}
}