package page_turn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SecondPage extends JFrame{
    SecondPage(){
        super("창2"); //창 제목 설정
        JPanel jPanel = new JPanel(); //패널 생성

        jPanel.setBackground(Color.BLUE); //배경색을 파란색으로 설정

        setSize(300, 200); //창 크기 설정

        add(jPanel); //패널을 프레임에 추가

        //창을 화면 정중앙에 배치
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); //창 보이게 설정
    }
}
