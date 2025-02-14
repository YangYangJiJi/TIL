package swingtest;

import java.awt.*; // Needed for BorderLayout class
import javax.swing.*; // Needed for Swing classes

/**
 * This class demonstrates how JPanels can be nested inside each region of a
 * content pane governed by a BorderLayout manager.
 */

public class BorderPanelWindow extends JFrame {
	/**
	 * Constructor
	 */

	public BorderPanelWindow() {
		// Set the title bar text.
		setTitle("Border Layout");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // better

		// Add a BorderLayout manager to the content pane.
		setLayout(new BorderLayout());

		// Create five panels.
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 3));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 2));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		JPanel panel4 = new JPanel();
		// we need as many rows as needed (0) in 2 columns (2)
		panel4.setLayout(new GridLayout(0, 2));

		// Create five buttons.
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		JButton button4 = new JButton("Button 4");
		JButton button5 = new JButton("Button 5");
		JButton button6 = new JButton("Button 6");
		JButton button7 = new JButton("Button 7");
		JButton button8 = new JButton("Button 8");
		JButton button9 = new JButton("Button 9");
		JButton button10 = new JButton("Button 10");
		JButton button11 = new JButton("Button 11");
		JButton button12 = new JButton("Button 12");
		JButton button13 = new JButton("Button 13");
		JButton button14 = new JButton("Button 14");
		JButton button15 = new JButton("Button 15");
		JButton button16 = new JButton("Button 16");
		JButton button17 = new JButton("Button 17");
		JButton button18 = new JButton("Button 18");

		// Add buttons to panel1
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
		panel1.add(button6);

		// Add buttons to panel2

		// Add the buttons to panel3
		panel3.add(button7, BorderLayout.PAGE_START);
		panel3.add(button8, BorderLayout.PAGE_END);
		panel3.add(button9, BorderLayout.LINE_END);
		panel3.add(button10, BorderLayout.LINE_START);

		// Add the buttons to panel4
		panel4.add(button11);
		panel4.add(button12);
		panel4.add(button13);
		panel4.add(button14);
		panel4.add(button15);
		panel4.add(button16);
		panel4.add(button17);
		panel4.add(button18);

		// Add panel4 to the CENTER of panel3
		panel3.add(panel4, BorderLayout.CENTER);

		// Add the five panels to the content pane.
		add(panel1, BorderLayout.LINE_START);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.LINE_END);
		// add(panel4, BorderLayout.CENTER); // AND DON'T ADD IT HERE!

		// Pack and display the window.
		pack();
		setVisible(true);
	}

	/**
	 * The main method creates an instance of the BorderPanelWindow class, causing
	 * it to display its window.
	 */

	public static void main(String[] args) {
		new BorderPanelWindow();
	}
}