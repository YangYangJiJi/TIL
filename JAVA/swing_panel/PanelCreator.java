package swingtest;

import javax.swing.*;

public class PanelCreator extends JFrame {
	private JPanel emptyPanel;

	public PanelCreator() {
		setTitle("Panel Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		emptyPanel = new JPanel();
		add(emptyPanel);

		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JPanel getEmptyPanel() {
		return emptyPanel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new PanelCreator();
		});
	}
}