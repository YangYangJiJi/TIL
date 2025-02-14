package calendarSwing;
//Ķ���� �г��� ��ư�鸸 ��Ƴ��� Ŭ����
//Ķ���� �г��� ��ư : ������, �����, ������, �����߰�, �����˻�

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalendarButton extends JFrame {
	JLabel yearMonthTitle;
	JPanel panelNorth = new JPanel(); // ��ư, �� - �� �� ��
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	CalendarMain calMain;
	
	public CalendarButton(CalendarMain calMain) {
		this.calMain = calMain;
		yearMonthTitle = new JLabel();
		panelNorth = new JPanel(); // ��ư, �� - �� �� ��
		panelCenter = new JPanel();
		panelSouth = new JPanel();
	}

	void addComponentsToPane() {
		CalendarMain calMain = new CalendarMain();
		setTitle("Calendar");
		JButton previousButton = new JButton("��");
		JButton nextButton = new JButton("��");
		JButton addScheduleButton = new JButton("�����߰�");
		JButton searchScheduleButton = new JButton("�����˻�");
		yearMonthTitle = new JLabel("�� - ��", SwingConstants.CENTER);
		
		panelNorth.add(previousButton);
		panelNorth.add(yearMonthTitle);
		panelNorth.add(nextButton);
		panelSouth.add(addScheduleButton);
		panelSouth.add(searchScheduleButton);
		panelCenter.add(calMain.panelCenter); //���� �߰�
		yearMonthTitle.setFont(new Font("Arial-Black", Font.CENTER_BASELINE, 25));
		yearMonthTitle.setPreferredSize(new Dimension(300, 30));
		
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("��")) {
					calMain.updateMonth(-1);
					setDateTitle(calMain);
				}
			}
		});
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("��")) {
					calMain.updateMonth(1);
					setDateTitle(calMain);
				}
			}
		});
		addScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�����߰�")) {
					calMain.addSchedule();
				}
			}
		});
		searchScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�����˻�")) {
					calMain.searchSchedule();
				}
			}
		});	
		
		calMain.getCurrentDate(); //���� ��¥ ��ü ����
		calMain.getDateInfo(); // ��¥ ��ü�κ��� ������ ���ϱ�
		setDateTitle(calMain); // Ÿ��Ʋ �󺧿� ��¥ ǥ���ϱ�
		calMain.createDay(); // ���� �ڽ� ����
		calMain.createDate(); // ��¥ �ڽ� ����
		calMain.printDate(); // ���ڿ� ��¥ �׸���
	}

	public void setDateTitle(CalendarMain cm) {
		yearMonthTitle.setText(cm.year + "-" + (cm.month + 1));
		yearMonthTitle.updateUI();
	}

}
