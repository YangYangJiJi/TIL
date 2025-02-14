package calendarSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleArea extends JFrame {
	JTextArea scheduleArea = new JTextArea(10, 30);
	JPanel panel = new JPanel();
	JButton btn = new JButton("입력");

	ScheduleArea() {
		super("AddSchedule"); // 타이틀
		setSize(420, 250);
		add(panel);
		panel.add(scheduleArea, BorderLayout.EAST);
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		btn.doClick();
		setVisible(true);
	}

}