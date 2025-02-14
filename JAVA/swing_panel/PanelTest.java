package swingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTest extends JFrame {

	public PanelTest() {
		setTitle("Panel Visibility Example"); //â ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â �ݱ� ��ư Ŭ�� �� ���α׷� ����

		//���� �г� ���� (BorderLayout ���)
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		// ������ �г� ���� (�ʱ⿣ �Ⱥ���)
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		panel1.setPreferredSize(new Dimension(200, 200));
		panel1.setVisible(false); //ó������ �� ���̵��� ����

		// �Ķ��� �г� ���� (�ʱ⿣ �Ⱥ���)
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLUE);
		panel2.setPreferredSize(new Dimension(200, 200));
		panel2.setVisible(false); //ó������ �� ���̵��� ����

		// 'Show panel'��ư ���� (Ŭ�� �� �г� ���̵��� ����)
		JButton showPanelsButton = new JButton("Show Panels");
		showPanelsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true); //������ �г� ���̰�
				panel2.setVisible(true); //�Ķ��� �г� ���̰�
			}
		});

		//���� �гο� ��ư�� �г� �߰�
		mainPanel.add(showPanelsButton, BorderLayout.NORTH); //��ư�� ��ܿ� ��ġ
		mainPanel.add(panel1, BorderLayout.CENTER); //������ �г��� �߾ӿ� ��ġ
		mainPanel.add(panel2, BorderLayout.SOUTH); //�Ķ��� �г��� �Ʒ��ʿ� ��ġ

		// ���� �г��� JFrame�� �߰�
		add(mainPanel);

		//â ũ�� ���� �� ȭ�� �߾� ����
		setSize(300, 300);
		setLocationRelativeTo(null); //ȭ�� �߾ӿ� ��ġ
		setVisible(true); //â ���̰� ����
	}

	public static void main(String[] args) {
		//GUI ���α׷��� ������ �� SwingUtilities.invokeLater()�� ����Ͽ� ����
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanelTest(); //PanelTestâ ����
			}
		});
	}
}