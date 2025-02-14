package calendarSwing;

import javax.swing.*;

public class ScheduleField extends JFrame {
	JTextField scheduleField = new JTextField("0", 20);
	JPanel panel = new JPanel();

	ScheduleField() {
		super("Schedule"); // ≈∏¿Ã∆≤
		setSize(300, 200);
		add(panel);
		panel.add(scheduleField);
	}
}
