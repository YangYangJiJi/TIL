package calendarSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalendarMain extends JFrame {
	String[] dayArray = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	DateBox[] dateBoxArray = new DateBox[dayArray.length * 6];
	Calendar calendar; //��¥ ��ü
	JPanel panelCenter = new JPanel();
	int year, month;
	int monthStartDay; // ���� ���� ����
	int monthEndDay; // ���� ������ ��¥
	HashMap<String, String> scheduleMap = new HashMap<>();
	String key;

	public CalendarMain() {
	}
	
	// Ķ���� ��ü�� ����ִ� ��¥�� �������� �� ������ �ٲ��ش�.
	public void updateMonth(int data) {
		CalendarButton cb = new CalendarButton(this);
		calendar.set(Calendar.MONTH, month + data);
		getDateInfo();
		cb.setDateTitle(this);
		printDate();
		searchDateBoxSchedule(); // �������� �ִ� dateBox ã�� ���
	}
	
	// �޷� �гο��� �����߰� ��ư�� ������ �� ����Ǵ� �޼���
	public void addSchedule() {
		JPanel northContainer = new JPanel(); // ��� �����̳�
		JPanel centerContainer = new JPanel(); // �߾� �����̳�
		JPanel southContainer = new JPanel(); // �ϴ� �����̳�
		JPanel mainContainer = new JPanel(new BorderLayout());
		ScheduleArea scheduleField = new ScheduleArea();
		JLabel tl = new JLabel("� ��¥�� ������ �߰��Ͻðڽ��ϱ�? " + year + "-" + (month + 1) + "-");
		JTextField tf = new JTextField(3);
		northContainer.add(tl);
		northContainer.add(tf);
		centerContainer.add(scheduleField.scheduleArea);
		southContainer.add(scheduleField.btn);
		mainContainer.add(northContainer, BorderLayout.NORTH);
		mainContainer.add(centerContainer, BorderLayout.CENTER);
		mainContainer.add(southContainer, BorderLayout.SOUTH);
		scheduleField.panel.add(mainContainer, BorderLayout.CENTER);
		scheduleField.btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputDate = tf.getText();
				String scheduleText = scheduleField.scheduleArea.getText();
				for (int i = 0; i < dateBoxArray.length; i++) {
					if (dateBoxArray[i].year == year && dateBoxArray[i].month == month
							&& dateBoxArray[i].day.equals(inputDate)) {
						key = Integer.toString(year) + Integer.toString(month) + dateBoxArray[i].day;
						scheduleMap.put(key, scheduleText);
						dateBoxArray[i].schedule = scheduleMap.get(key);
						dateBoxArray[i].repaint();
					} else {
						dateBoxArray[i].day = "";
					}
				}
				scheduleField.dispose();
			}
		});
	}

	// �޷� �гο��� �����˻� ��ư�� ������ �� ����Ǵ� �޼���
	public void searchSchedule() {
		SearchSchedule scheduleField = new SearchSchedule();
		JLabel tl = new JLabel("�˻� Ű����: ");
		JTextField tf = new JTextField(10);
		JPanel northContainer = new JPanel(); // ��� �����̳�
		JPanel centerContainer = new JPanel(); // �߾� �����̳�
		JPanel southContainer = new JPanel(); // �ϴ� �����̳�
		JPanel mainContainer = new JPanel(new BorderLayout());
		northContainer.add(tl);
		northContainer.add(tf);
		southContainer.add(scheduleField.btn);
		scheduleField.btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputDate = tf.getText();
				for (int i = 0; i < dateBoxArray.length; i++) {
					if (dateBoxArray[i].year == year && dateBoxArray[i].month == month
							&& dateBoxArray[i].day.equals(inputDate) 
							&& inputDate.matches(dateBoxArray[i].schedule)) {// matches �޼���																							
						DateBox dateBox = new DateBox(year, month, dateBoxArray[i].schedule, Color.white, 100, 100, "");
						centerContainer.add(dateBox);
						dateBoxArray[i] = dateBox;
					} else {
						dateBoxArray[i].day = "";
					}
				}

			}
		});
		
		mainContainer.add(northContainer, BorderLayout.NORTH);
		mainContainer.add(centerContainer, BorderLayout.CENTER);
		mainContainer.add(southContainer, BorderLayout.SOUTH);
		scheduleField.panelCenter.add(mainContainer, BorderLayout.CENTER);
	}
	
	public void searchDateBoxSchedule() {
		for (int i = 0; i < dateBoxArray.length; i++) {
			if (i >= monthStartDay && i - monthStartDay + 1 <= monthEndDay) {
				// ���� ���� �����Ϻ��� ���ϱ����� ó��
				int dayNumber = i - monthStartDay + 1;
				dateBoxArray[i].day = Integer.toString(dayNumber);
				dateBoxArray[i].repaint();

				// �ش� ��¥�� ���� key ����
				key = Integer.toString(year) + Integer.toString(month) + dateBoxArray[i].day;

				// scheduleMap���� �ش� ��¥�� ������ ���� ��쿡�� ����
				if (scheduleMap.containsKey(key)) {
					dateBoxArray[i].schedule = scheduleMap.get(key);
				} else {
					dateBoxArray[i].schedule = "";
				}
			} else {
				dateBoxArray[i].day = "";
				dateBoxArray[i].repaint();
				dateBoxArray[i].schedule = "";
			}
		}
	}

	// ��¥ �ڽ�
	public void createDate() {
		for (int i = 0; i < dayArray.length * 6; i++) {
			DateBox dateBox = new DateBox(year, month, "", Color.white, 100, 100, "");
			panelCenter.add(dateBox);
			panelCenter.setLayout(new GridLayout(7, 7));
			dateBoxArray[i] = dateBox;
		}
	}
	
	public void printDate() {
		System.out.println("���� ����" + monthStartDay);
		System.out.println("������ ��" + monthEndDay);

		int n = 1;
		for (int i = 0; i < dateBoxArray.length; i++) {
			if (i >= monthStartDay && n <= monthEndDay) {
				dateBoxArray[i].day = Integer.toString(n);
				dateBoxArray[i].repaint();
				n++;
			} else {
				dateBoxArray[i].day = "";
				dateBoxArray[i].repaint();
			}
		}

	}

	// ���� �ڽ�
	public void createDay() {
		for (int i = 0; i < 7; i++) {
			DayBox dayBox = new DayBox(dayArray[i], Color.white, 100, 70);
			panelCenter.add(dayBox);
		}
	}
	
	// ���糯¥ ��ü �����
	public void getCurrentDate() {
		calendar = Calendar.getInstance();
	}

	// year, month, ���� ���� ����, ���� ������ ��¥ �� ���ϱ�
	public void getDateInfo() {
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		monthStartDay = getFirstDayOfMonth(year, month);
		monthEndDay = getEndDayOfMonth(year, month);
	}

	public int getFirstDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance(); // ����ð�
		calendar.set(year, month, 1);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	public int getEndDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance(); // ����ð�
		calendar.set(year, month + 1, 0);// ������ ��
		return calendar.get(Calendar.DATE);
	}

	
	public static void main(String[] args) {
		GUIMain.startGUI();
	}

}
