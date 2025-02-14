package calendarSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DayBox extends DateBox {
	public DayBox(String day, Color color, int width, int height) {
		this.day = day;
		this.color = color;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.red);
		g.drawString(day, 10, 20);
	}
}