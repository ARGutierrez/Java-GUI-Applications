/*
 * Simple Clock
 * Time changes when number changes
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ClockGUI {
	public static void main(String[] args) {
		ClockDrawingFrame frame = new ClockDrawingFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
}

class ClockDrawingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField hourField;
	private JTextField minuteField;
	private ClockPanel clock;

	public ClockDrawingFrame() {
		setTitle("Clock GUI");
		DocumentListener listener = new ClockFieldListener();

		JPanel panel = new JPanel();

		panel.add(new JLabel("Hours:"));
		hourField = new JTextField("12", 3);
		panel.add(hourField);
		hourField.getDocument().addDocumentListener(listener);

		panel.add(new JLabel("Minutes:"));
		minuteField = new JTextField("00", 3);
		panel.add(minuteField);
		minuteField.getDocument().addDocumentListener(listener);

		add(panel, BorderLayout.NORTH);

		clock = new ClockPanel();
		add(clock, BorderLayout.CENTER);
		pack();
	}

	public void setClock() {
		try {
			int hours = Integer.parseInt(hourField.getText().trim());
			int minutes = Integer.parseInt(minuteField.getText().trim());
			clock.setTime(hours, minutes);
		} catch (NumberFormatException e) {
		}
	}

	private class ClockFieldListener implements DocumentListener {
		public void insertUpdate(DocumentEvent event) {
			setClock();
		}

		public void removeUpdate(DocumentEvent event) {
			setClock();
		}

		public void changedUpdate(DocumentEvent event) {
		}
	}
}

/**
 * A panel that draws a clock.
 */
class ClockPanel extends JPanel {
	private double minutes = 0;
	private int RADIUS = 100;
	private double MINUTE_HAND_LENGTH = 0.8 * RADIUS;
	private double HOUR_HAND_LENGTH = 0.6 * RADIUS;

	public ClockPanel() {
		setPreferredSize(new Dimension(2 * RADIUS + 1, 2 * RADIUS + 1));
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawOval(0, 0, 2 * RADIUS, 2 * RADIUS);
		double hourAngle = Math.toRadians(90 - 360 * minutes / (12 * 60));
		drawHand(g, hourAngle, HOUR_HAND_LENGTH);
		double minuteAngle = Math.toRadians(90 - 360 * minutes / 60);
		drawHand(g, minuteAngle, MINUTE_HAND_LENGTH);
	}

	public void drawHand(Graphics g, double angle, double handLength) {
		Point end = new Point((int) (RADIUS + handLength * Math.cos(angle)),
				(int) (RADIUS - handLength * Math.sin(angle)));
		Point center = new Point(RADIUS, RADIUS);
		g.drawLine(center.x, center.y, end.x, end.y);
	}

	public void setTime(int h, int m) {
		minutes = h * 60 + m;
		repaint();
	}

}