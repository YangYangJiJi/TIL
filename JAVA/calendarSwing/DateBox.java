package calendarSwing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class DateBox extends JPanel {
	int year, month;
	String day;
	Color color;
	int width;
	int height;
	String schedule = "";
	String key;

	public DateBox() {
	};

	public DateBox(int year, int month, String day, Color color, int width, int height, String schedule) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.color = color;
		this.width = width;
		this.height = height;
		this.schedule = schedule;
		setPreferredSize(new Dimension(width, height));
	}

	// paint�� �������ϸ� ������Ʈ�� ���� ���ϴ� ���� �׸� �� �ִ�.
	// �̸� �̿��ؼ� ������ �۾��� �ֱ�
	public void paint(Graphics g) {
		g.setColor(color);
		// ���� ���ڸ� �ִ� ���ε� ������ ������ ������ ������ ĥ�ϴ� ��
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		// �۾��� �׸��� ���ε� ù�� ° �Ű������� �۾��� ����
		// 2��°�� x�� 3��°�� y��
		g.drawString(day, 10, 20);
		g.drawString(schedule, 20, 40);
	}

}