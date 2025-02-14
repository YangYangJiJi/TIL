package page_turn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SecondPage extends JFrame{
    SecondPage(){
        super("â2"); //â ���� ����
        JPanel jPanel = new JPanel(); //�г� ����

        jPanel.setBackground(Color.BLUE); //������ �Ķ������� ����

        setSize(300, 200); //â ũ�� ����

        add(jPanel); //�г��� �����ӿ� �߰�

        //â�� ȭ�� ���߾ӿ� ��ġ
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //ȭ�� �߾ӿ� ����
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); //â ���̰� ����
    }
}
