package calendarSwing;
//캘린더 패널의 버튼들만 모아놓은 클래스
//캘린더 패널의 버튼 : 이전달, 현재달, 다음달, 일정추가, 일정검색

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
	JPanel panelNorth = new JPanel(); // 버튼, 년 - 월 들어갈 곳
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	CalendarMain calMain;
	
	public CalendarButton(CalendarMain calMain) {
		this.calMain = calMain;
		yearMonthTitle = new JLabel();
		panelNorth = new JPanel(); // 버튼, 년 - 월 들어갈 곳
		panelCenter = new JPanel();
		panelSouth = new JPanel();
	}

	void addComponentsToPane() {
		CalendarMain calMain = new CalendarMain();
		setTitle("Calendar");
		JButton previousButton = new JButton("◀");
		JButton nextButton = new JButton("▶");
		JButton addScheduleButton = new JButton("일정추가");
		JButton searchScheduleButton = new JButton("일정검색");
		yearMonthTitle = new JLabel("년 - 월", SwingConstants.CENTER);
		
		panelNorth.add(previousButton);
		panelNorth.add(yearMonthTitle);
		panelNorth.add(nextButton);
		panelSouth.add(addScheduleButton);
		panelSouth.add(searchScheduleButton);
		panelCenter.add(calMain.panelCenter); //새로 추가
		yearMonthTitle.setFont(new Font("Arial-Black", Font.CENTER_BASELINE, 25));
		yearMonthTitle.setPreferredSize(new Dimension(300, 30));
		
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("◀")) {
					calMain.updateMonth(-1);
					setDateTitle(calMain);
				}
			}
		});
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("▶")) {
					calMain.updateMonth(1);
					setDateTitle(calMain);
				}
			}
		});
		addScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("일정추가")) {
					calMain.addSchedule();
				}
			}
		});
		searchScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("일정검색")) {
					calMain.searchSchedule();
				}
			}
		});	
		
		calMain.getCurrentDate(); //현재 날짜 객체 생성
		calMain.getDateInfo(); // 날짜 객체로부터 정보들 구하기
		setDateTitle(calMain); // 타이틀 라벨에 날짜 표시하기
		calMain.createDay(); // 요일 박스 생성
		calMain.createDate(); // 날짜 박스 생성
		calMain.printDate(); // 상자에 날짜 그리기
	}

	public void setDateTitle(CalendarMain cm) {
		yearMonthTitle.setText(cm.year + "-" + (cm.month + 1));
		yearMonthTitle.updateUI();
	}

}
