package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
//import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//달력 전체를 관리하는 GUI 프로그램 (이전/다음 달 이동 가능)
public class Diary extends JFrame {

	String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" }; //요일 배열
	DateBox[] dateBoxAr = new DateBox[dayAr.length * 6]; //날짜 박스 배열 (최대 6주)
	JPanel p_north;  //상단 패널
	JButton bt_prev; //이전 버튼
	JLabel lb_title; //달력 제목
	JButton bt_next; //다음 버튼 
	JPanel p_center; // 날짜 박스 배치할 중앙 영역
	Calendar cal; // 날짜 객체

	int yy; // 기준점이 되는 년도
	int mm; // 기준점이 되는 월
	int startDay; // 월의 시작 요일
	int lastDate; // 월의 마지막 날

	// 생성자 : UI 구성 및 이벤트 리스너 설정
	public Diary() {
		// 디자인
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		lb_title = new JLabel("년도 올 예정", SwingConstants.CENTER);
		bt_next = new JButton("다음");
		p_center = new JPanel();

		// 라벨에 폰트 설정
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25));
		lb_title.setPreferredSize(new Dimension(300, 30));

		//상단 패널에 버튼과 제목 추가
		p_north.add(bt_prev);
		p_north.add(lb_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center); //날짜 패널 추가

		// 이전 버튼을 눌렀을 때 전 월로 이동해야함
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(-1);
			}
		});

		// 다음 버튼을 눌렀을 때 다음 달로 이동해야함
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(1);
			}
		});

		getCurrentDate(); // 현재 날짜 객체 생성
		getDateInfo(); // 날짜 객체로부터 정보들 구하기
		setDateTitle(); // 타이틀 라벨에 날짜 표시하기
		createDay(); // 요일 박스 생성
		createDate(); // 날짜 박스 생성
		printDate(); // 상자에 날짜 그리기

		setVisible(true);
		setBounds(100, 100, 780, 780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 현재날짜 객체 만들기
	public void getCurrentDate() {
		cal = Calendar.getInstance();
	}

	// 시작 요일, 끝 날 등 구하기
	public void getDateInfo() {
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		startDay = getFirstDayOfMonth(yy, mm);
		lastDate = getLastDate(yy, mm);
	}

	// 요일 박스 생성
	public void createDay() {
		for (int i = 0; i < 7; i++) {
			DateBox dayBox = new DateBox(dayAr[i], Color.gray, 100, 70);
			p_center.add(dayBox);
		}
	}

	// 날짜 생성
	public void createDate() {
		for (int i = 0; i < dayAr.length * 6; i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY, 100, 100);
			p_center.add(dateBox);
			dateBoxAr[i] = dateBox;
		}
	}

	// 해당 월의 시작 요일 구하기
	// 개발 원리 : 날짜 객체를 해당 월의 1일로 조작한 후, 요일 구하기
	// 사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal = Calendar.getInstance(); // 날짜 객체 생성
		cal.set(yy, mm, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;// 요일은 1부터 시작으로 배열과 쌍을 맞추기 위해 -1
	}

	// 사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getLastDate(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm + 1, 0);
		// 마지막 날을 의미한다.
		return cal.get(Calendar.DATE);
	}

	// 날짜 박스에 날짜 출력하기 (날짜 입력 & UI 업데이트)
	public void printDate() {
		System.out.println("시작 요일" + startDay);
		System.out.println("마지막 일" + lastDate);

		int n = 1;
		for (int i = 0; i < dateBoxAr.length; i++) {
			if (i >= startDay && n <= lastDate) {
				dateBoxAr[i].day = Integer.toString(n);
				dateBoxAr[i].repaint(); // UI 업데이트
				n++;
			} else {
				dateBoxAr[i].day = "";
				dateBoxAr[i].repaint();
			}
		}
	}

	//월을 변경하고 UI 업데이트
	// 달력을 넘기거나 전으로 이동할 때 날짜 객체에 대한 정보도 변경
	public void updateMonth(int data) {
		// 캘린더 객체에 들어있는 날짜를 기준으로 월 정보를 바꿔준다.
		cal.set(Calendar.MONTH, mm + data);
		getDateInfo();
		printDate();
		setDateTitle();
	}

	//타이틀 업데이트 (YYYY-MM 형식)
	// 몇년도 몇월인지를 보여주는 타이틀 라벨의 값을 변경
	public void setDateTitle() {
		lb_title.setText(yy + "-" + StringManager.getZeroString(mm + 1));
		lb_title.updateUI();
	}

	public static void main(String[] args) {
		new Diary();
	}
}