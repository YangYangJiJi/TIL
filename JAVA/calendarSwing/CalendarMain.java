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
	Calendar calendar; //날짜 객체
	JPanel panelCenter = new JPanel();
	int year, month;
	int monthStartDay; // 월의 시작 요일
	int monthEndDay; // 월의 마지막 날짜
	HashMap<String, String> scheduleMap = new HashMap<>();
	String key;

	public CalendarMain() {
	}
	
	// 캘린더 객체에 들어있는 날짜를 기준으로 월 정보를 바꿔준다.
	public void updateMonth(int data) {
		CalendarButton cb = new CalendarButton(this);
		calendar.set(Calendar.MONTH, month + data);
		getDateInfo();
		cb.setDateTitle(this);
		printDate();
		searchDateBoxSchedule(); // 스케쥴이 있는 dateBox 찾고 출력
	}
	
	// 달력 패널에서 일정추가 버튼을 눌렀을 때 실행되는 메서드
	public void addSchedule() {
		JPanel northContainer = new JPanel(); // 상단 컨테이너
		JPanel centerContainer = new JPanel(); // 중앙 컨테이너
		JPanel southContainer = new JPanel(); // 하단 컨테이너
		JPanel mainContainer = new JPanel(new BorderLayout());
		ScheduleArea scheduleField = new ScheduleArea();
		JLabel tl = new JLabel("어떤 날짜에 일정을 추가하시겠습니까? " + year + "-" + (month + 1) + "-");
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

	// 달력 패널에서 일정검색 버튼을 눌렀을 때 실행되는 메서드
	public void searchSchedule() {
		SearchSchedule scheduleField = new SearchSchedule();
		JLabel tl = new JLabel("검색 키워드: ");
		JTextField tf = new JTextField(10);
		JPanel northContainer = new JPanel(); // 상단 컨테이너
		JPanel centerContainer = new JPanel(); // 중앙 컨테이너
		JPanel southContainer = new JPanel(); // 하단 컨테이너
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
							&& inputDate.matches(dateBoxArray[i].schedule)) {// matches 메서드																							
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
				// 현재 월의 시작일부터 끝일까지만 처리
				int dayNumber = i - monthStartDay + 1;
				dateBoxArray[i].day = Integer.toString(dayNumber);
				dateBoxArray[i].repaint();

				// 해당 날짜에 대한 key 설정
				key = Integer.toString(year) + Integer.toString(month) + dateBoxArray[i].day;

				// scheduleMap에서 해당 날짜의 일정이 있을 경우에만 설정
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

	// 날짜 박스
	public void createDate() {
		for (int i = 0; i < dayArray.length * 6; i++) {
			DateBox dateBox = new DateBox(year, month, "", Color.white, 100, 100, "");
			panelCenter.add(dateBox);
			panelCenter.setLayout(new GridLayout(7, 7));
			dateBoxArray[i] = dateBox;
		}
	}
	
	public void printDate() {
		System.out.println("시작 요일" + monthStartDay);
		System.out.println("마지막 일" + monthEndDay);

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

	// 요일 박스
	public void createDay() {
		for (int i = 0; i < 7; i++) {
			DayBox dayBox = new DayBox(dayArray[i], Color.white, 100, 70);
			panelCenter.add(dayBox);
		}
	}
	
	// 현재날짜 객체 만들기
	public void getCurrentDate() {
		calendar = Calendar.getInstance();
	}

	// year, month, 월의 시작 요일, 월의 마지막 날짜 등 구하기
	public void getDateInfo() {
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		monthStartDay = getFirstDayOfMonth(year, month);
		monthEndDay = getEndDayOfMonth(year, month);
	}

	public int getFirstDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance(); // 현재시간
		calendar.set(year, month, 1);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	public int getEndDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance(); // 현재시간
		calendar.set(year, month + 1, 0);// 마지막 날
		return calendar.get(Calendar.DATE);
	}

	
	public static void main(String[] args) {
		GUIMain.startGUI();
	}

}
