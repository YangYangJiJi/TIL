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
	JButton btn = new JButton("�˻�");

	SearchSchedule() {
		super("SearchSchedule"); // Ÿ��Ʋ
		Container pane = getContentPane();
		setSize(420, 250);
		add(panelCenter);
		// panelTop.add(btn, BorderLayout.SOUTH);
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // ȭ�� �߾ӿ� ����
		btn.doClick();
		setVisible(true);
	}
}