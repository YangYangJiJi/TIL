package page_turn;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FirstPage extends JFrame {
	public FirstPage() {

		super("â1"); // â ���� ����
		JPanel jPanel = new JPanel(); //�г� ����
		JButton btn1 = new JButton("â 2"); //��ư ����
		setSize(300, 200); // â ũ�� ����
		jPanel.add(btn1); //��ư�� �гο� �߰�
		add(jPanel);// �г��� �����ӿ� �߰�

		// â�� ȭ�� ���߾ӿ� ��ġ
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // ȭ�� �߾ӿ� ����
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true); //â ���̰� ����

		// ��ư Ŭ�� �� ���ο� â�� ���� ���� â�� ����
		//�� �κ��� â ��ȯ�� �ٽ��̴�.
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SecondPage(); // �ι�° â ����
				setVisible(false); // ���� â �Ⱥ��̰� �ϱ�
				
			}
		});
	}

	public static void main(String[] args) {
		new FirstPage(); //���α׷� ���� �� ù��° â ����
	}
}
