package calendarSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleArea extends JFrame {
	JTextArea scheduleArea = new JTextArea(10, 30);
	JPanel panel = new JPanel();
	JButton btn = new JButton("�Է�");

	ScheduleArea() {
		super("AddSchedule"); // Ÿ��Ʋ
		setSize(420, 250);
		add(panel);
		panel.add(scheduleArea, BorderLayout.EAST);
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // ȭ�� �߾ӿ� ����
		btn.doClick();
		setVisible(true);
	}

}