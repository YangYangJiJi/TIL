package calendarSwing;
// GUI-store의 GUIMain부분을 많이 참고함 

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//import table_demo.GUIMain;

public class GUIMain extends JFrame{
	// 싱글톤 패턴 적용 부분
	private static GUIMain main = null;

	private GUIMain() {
	}

	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}

	// 엔진의 인스턴스를 편리를 위해 변수에 저장한다
	public static void startGUI() {
		// 이벤트 처리 스레드를 만들고 거기서 GUI를 생성하고 보여준다.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIMain.getInstance().createAndShowGUI();
			}
		});
	}

	/**
	 * GUI를 생성하여 보여준다. 스레드 안전을 위하여 이 메소드는 이벤트 처리 스레드에서 불려져야 한다.
	 */
	static JFrame mainFrame = new JFrame("Calendar & D-Day");

	public void createAndShowGUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane jtab = new JTabbedPane(); // 탭을 생성하고 두개 패널을 추가한다.

		setupCalendarPane();
		setupDdayPane();

		// 캘린더 탭과 디데이 탭 두 개의 패널을 가지는 탭 패널
		jtab.add("Calendar", calendarPane);
		jtab.add("D-Day", ddayPane);
		
		mainFrame.getContentPane().add(jtab);
		mainFrame.setBounds(100, 100, 780, 780);
		mainFrame.setVisible(true);
	}
	
	private JPanel calendarPane; // 달력을 보여주는 패널 부분
	CalendarMain calMain = new CalendarMain();
	CalendarButton calButton = new CalendarButton(calMain);
	
	public void setupCalendarPane() {
		calendarPane = new JPanel(new BorderLayout());
		calMain.setTitle("Calendar");
		calButton.addComponentsToPane(); //추후 싱글톤 적용
		calendarPane.add(calButton.panelNorth, BorderLayout.NORTH);
		calendarPane.add(calButton.panelCenter, BorderLayout.CENTER);
		calendarPane.add(calButton.panelSouth, BorderLayout.SOUTH);
	}
	
	
	private JPanel ddayPane; // 디데이 보여주는 패널 부분
	
	private void setupDdayPane() {
		// 추후 추가
	}
}
