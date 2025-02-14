package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

//�޷¿��� ��¥�� ǥ���ϴ� ���� �ڽ� (�� ��¥ ĭ�� ��ü�� ǥ��)
public class DateBox extends JPanel{
	String day;  //��¥�� ǥ���� ���ڿ�
	Color color; //�ڽ��� ����
	int width;	 //�ڽ��� ����ũ��
	int height;	 //�ڽ��� ����ũ��
	
	// ������ : ��¥ ���ڿ�, ����, ũ�⸦ �����ϰ� �г� ũ�⸦ ����
	public DateBox(String day, Color color, int width, int height) {
		this.day = day;
		this.color = color;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));		
	}
	
	//paint�� �������ϸ� ������Ʈ�� ���� ���ϴ� ���� �׸� �� �ִ�.
	//�̸� �̿��ؼ� ������ �۾��� �ֱ�
	//JPanel�� paint �ż��� �������̵�
	public void paint(Graphics g) {
		g.setColor(color);
		//���� ���ڸ� �ִ� ���ε� ������ ������ ������ ������ ĥ�ϴ� ��
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.black);
		//�۾��� �׸��� ���ε� ù�� ° �Ű������� �۾��� ����
		//2��°�� x��  3��°�� y��
		g.drawString(day, 10, 20); //��¥ �ؽ�Ʈ�� �׸� (��ǥ : 10,20)
	}
}