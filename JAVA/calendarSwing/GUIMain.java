package calendarSwing;
// GUI-store�� GUIMain�κ��� ���� ������ 

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//import table_demo.GUIMain;

public class GUIMain extends JFrame{
	// �̱��� ���� ���� �κ�
	private static GUIMain main = null;

	private GUIMain() {
	}

	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}

	// ������ �ν��Ͻ��� ���� ���� ������ �����Ѵ�
	public static void startGUI() {
		// �̺�Ʈ ó�� �����带 ����� �ű⼭ GUI�� �����ϰ� �����ش�.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIMain.getInstance().createAndShowGUI();
			}
		});
	}

	/**
	 * GUI�� �����Ͽ� �����ش�. ������ ������ ���Ͽ� �� �޼ҵ�� �̺�Ʈ ó�� �����忡�� �ҷ����� �Ѵ�.
	 */
	static JFrame mainFrame = new JFrame("Calendar & D-Day");

	public void createAndShowGUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane jtab = new JTabbedPane(); // ���� �����ϰ� �ΰ� �г��� �߰��Ѵ�.

		setupCalendarPane();
		setupDdayPane();

		// Ķ���� �ǰ� ���� �� �� ���� �г��� ������ �� �г�
		jtab.add("Calendar", calendarPane);
		jtab.add("D-Day", ddayPane);
		
		mainFrame.getContentPane().add(jtab);
		mainFrame.setBounds(100, 100, 780, 780);
		mainFrame.setVisible(true);
	}
	
	private JPanel calendarPane; // �޷��� �����ִ� �г� �κ�
	CalendarMain calMain = new CalendarMain();
	CalendarButton calButton = new CalendarButton(calMain);
	
	public void setupCalendarPane() {
		calendarPane = new JPanel(new BorderLayout());
		calMain.setTitle("Calendar");
		calButton.addComponentsToPane(); //���� �̱��� ����
		calendarPane.add(calButton.panelNorth, BorderLayout.NORTH);
		calendarPane.add(calButton.panelCenter, BorderLayout.CENTER);
		calendarPane.add(calButton.panelSouth, BorderLayout.SOUTH);
	}
	
	
	private JPanel ddayPane; // ���� �����ִ� �г� �κ�
	
	private void setupDdayPane() {
		// ���� �߰�
	}
}
