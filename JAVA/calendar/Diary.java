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

//�޷� ��ü�� �����ϴ� GUI ���α׷� (����/���� �� �̵� ����)
public class Diary extends JFrame {

	String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" }; //���� �迭
	DateBox[] dateBoxAr = new DateBox[dayAr.length * 6]; //��¥ �ڽ� �迭 (�ִ� 6��)
	JPanel p_north;  //��� �г�
	JButton bt_prev; //���� ��ư
	JLabel lb_title; //�޷� ����
	JButton bt_next; //���� ��ư 
	JPanel p_center; // ��¥ �ڽ� ��ġ�� �߾� ����
	Calendar cal; // ��¥ ��ü

	int yy; // �������� �Ǵ� �⵵
	int mm; // �������� �Ǵ� ��
	int startDay; // ���� ���� ����
	int lastDate; // ���� ������ ��

	// ������ : UI ���� �� �̺�Ʈ ������ ����
	public Diary() {
		// ������
		p_north = new JPanel();
		bt_prev = new JButton("����");
		lb_title = new JLabel("�⵵ �� ����", SwingConstants.CENTER);
		bt_next = new JButton("����");
		p_center = new JPanel();

		// �󺧿� ��Ʈ ����
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25));
		lb_title.setPreferredSize(new Dimension(300, 30));

		//��� �гο� ��ư�� ���� �߰�
		p_north.add(bt_prev);
		p_north.add(lb_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center); //��¥ �г� �߰�

		// ���� ��ư�� ������ �� �� ���� �̵��ؾ���
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(-1);
			}
		});

		// ���� ��ư�� ������ �� ���� �޷� �̵��ؾ���
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(1);
			}
		});

		getCurrentDate(); // ���� ��¥ ��ü ����
		getDateInfo(); // ��¥ ��ü�κ��� ������ ���ϱ�
		setDateTitle(); // Ÿ��Ʋ �󺧿� ��¥ ǥ���ϱ�
		createDay(); // ���� �ڽ� ����
		createDate(); // ��¥ �ڽ� ����
		printDate(); // ���ڿ� ��¥ �׸���

		setVisible(true);
		setBounds(100, 100, 780, 780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ���糯¥ ��ü �����
	public void getCurrentDate() {
		cal = Calendar.getInstance();
	}

	// ���� ����, �� �� �� ���ϱ�
	public void getDateInfo() {
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		startDay = getFirstDayOfMonth(yy, mm);
		lastDate = getLastDate(yy, mm);
	}

	// ���� �ڽ� ����
	public void createDay() {
		for (int i = 0; i < 7; i++) {
			DateBox dayBox = new DateBox(dayAr[i], Color.gray, 100, 70);
			p_center.add(dayBox);
		}
	}

	// ��¥ ����
	public void createDate() {
		for (int i = 0; i < dayAr.length * 6; i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY, 100, 100);
			p_center.add(dateBox);
			dateBoxAr[i] = dateBox;
		}
	}

	// �ش� ���� ���� ���� ���ϱ�
	// ���� ���� : ��¥ ��ü�� �ش� ���� 1�Ϸ� ������ ��, ���� ���ϱ�
	// ��� ��� : 2021�� 2���� ���ҽ� 2021, 1�� ������ ��
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal = Calendar.getInstance(); // ��¥ ��ü ����
		cal.set(yy, mm, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;// ������ 1���� �������� �迭�� ���� ���߱� ���� -1
	}

	// ��� ��� : 2021�� 2���� ���ҽ� 2021, 1�� ������ ��
	public int getLastDate(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm + 1, 0);
		// ������ ���� �ǹ��Ѵ�.
		return cal.get(Calendar.DATE);
	}

	// ��¥ �ڽ��� ��¥ ����ϱ� (��¥ �Է� & UI ������Ʈ)
	public void printDate() {
		System.out.println("���� ����" + startDay);
		System.out.println("������ ��" + lastDate);

		int n = 1;
		for (int i = 0; i < dateBoxAr.length; i++) {
			if (i >= startDay && n <= lastDate) {
				dateBoxAr[i].day = Integer.toString(n);
				dateBoxAr[i].repaint(); // UI ������Ʈ
				n++;
			} else {
				dateBoxAr[i].day = "";
				dateBoxAr[i].repaint();
			}
		}
	}

	//���� �����ϰ� UI ������Ʈ
	// �޷��� �ѱ�ų� ������ �̵��� �� ��¥ ��ü�� ���� ������ ����
	public void updateMonth(int data) {
		// Ķ���� ��ü�� ����ִ� ��¥�� �������� �� ������ �ٲ��ش�.
		cal.set(Calendar.MONTH, mm + data);
		getDateInfo();
		printDate();
		setDateTitle();
	}

	//Ÿ��Ʋ ������Ʈ (YYYY-MM ����)
	// ��⵵ ��������� �����ִ� Ÿ��Ʋ ���� ���� ����
	public void setDateTitle() {
		lb_title.setText(yy + "-" + StringManager.getZeroString(mm + 1));
		lb_title.updateUI();
	}

	public static void main(String[] args) {
		new Diary();
	}
}