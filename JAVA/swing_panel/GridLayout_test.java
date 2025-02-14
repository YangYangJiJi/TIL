package swingtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GridLayout_test extends JFrame {
	public GridLayout_test() {
		// �� ��ġ�� �ش��ϴ� JButton ����
		JButton btnNorth = new JButton("North");
		JButton btnCenter = new JButton("Center");
		JButton btnSouth = new JButton("South");

		// South�� JButton�� ���� Panel�� ����
		// South ��ġ �ȿ� �� BorderLayout ������ ���� + �߰��� new BorderLayout
		JPanel pnlEast = new JPanel(new BorderLayout());
		JLabel tfNorthEast = new JLabel("NorthEast");
		tfNorthEast.setPreferredSize(new Dimension(300, 30)); //�ٽ� ����Ʈ
		LineBorder bb = new LineBorder(Color.black, 1, true);
		tfNorthEast.setBorder(bb);
		JTextField tfSouthEast = new JTextField("SouthEast");
		tfSouthEast.setPreferredSize(new Dimension(300, 200)); //�ٽ� ����Ʈ

		pnlEast.add(tfNorthEast, BorderLayout.NORTH);
		pnlEast.add(tfSouthEast, BorderLayout.SOUTH);

		// �� ������ ��ư�� BorderLayout�� ���ؼ� �� ��ġ�� ��ġ
		add(pnlEast, BorderLayout.EAST);
		add(btnNorth, BorderLayout.NORTH);
		add(btnCenter, BorderLayout.CENTER);
		add(btnSouth, BorderLayout.SOUTH);

		setTitle("BorderLayoutEx");
		setSize(500, 500); // â�� ����� ����
		setLocation(680, 300); // ����ÿ� â�� ó�� ��ġ�� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �����ư �����ÿ� �ٷ� ����
		setVisible(true); // ���ü� �ο� (���� ���̰� �ϱ�)
		setResizable(false); // â�� ����� ����
	}

	public static void main(String[] args) {
		new GridLayout_test();

	}

}
