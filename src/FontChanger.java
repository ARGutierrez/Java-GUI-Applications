/*
 * Font Editor
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FontChanger extends JFrame {
	private static final long serialVersionUID = 1L;
	static JPanel panel;

	FontChanger() {
		setTitle("Font Changer");
		setSize(600, 400);
		setResizable(true);
		panel = new FontPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		this.add(panel);
		this.setVisible(true);
	}

	public class FontPanel extends JPanel {
		private JLabel text;
		private JCheckBox italic;
		private JCheckBox bold;
		private JCheckBox center;
		private JComboBox fonts;
		private JComboBox size;
		private JRadioButton red;
		private JRadioButton blue;
		private JRadioButton yellow;
		private JRadioButton black;

		FontPanel() {
			ChoiceListener listener = new ChoiceListener();
			text = new JLabel("Change Me!", JLabel.LEFT);
			JPanel colorPanel = new JPanel();
			red = new JRadioButton("Red");
			red.addActionListener(listener);
			blue = new JRadioButton("Blue");
			blue.addActionListener(listener);
			yellow = new JRadioButton("Yellow");
			yellow.addActionListener(listener);
			black = new JRadioButton("Black");
			black.addActionListener(listener);
			black.setSelected(true);
			colorPanel.add(red);
			colorPanel.add(blue);
			colorPanel.add(yellow);
			colorPanel.add(black);
			colorPanel
					.setBorder(new TitledBorder(new EtchedBorder(), "Colors"));
			colorPanel.setVisible(true);
			ButtonGroup group = new ButtonGroup();
			group.add(red);
			group.add(blue);
			group.add(yellow);
			group.add(black);

			JPanel style = new JPanel();
			italic = new JCheckBox("Italic");
			italic.addActionListener(listener);
			bold = new JCheckBox("Bold");
			bold.addActionListener(listener);
			center = new JCheckBox("Centered");
			center.addActionListener(listener);
			style.add(italic);
			style.add(bold);
			style.add(center);
			style.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
			style.setVisible(true);

			JPanel fontPanel = new JPanel();
			GraphicsEnvironment e = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			String f[] = e.getAvailableFontFamilyNames();
			fonts = new JComboBox(f);
			fonts.addActionListener(listener);
			fontPanel.add(fonts);
			size = new JComboBox();
			size.addItem("12");
			size.addItem("24");
			size.addItem("36");
			size.addItem("42");
			size.addItem("48");
			size.addActionListener(listener);
			fontPanel.add(size);
			fontPanel.setVisible(true);
			setSampleFont();
			setLayout(new BorderLayout());
			add(text, BorderLayout.CENTER);
			add(fontPanel, BorderLayout.SOUTH);
			add(style, BorderLayout.NORTH);
			add(colorPanel, BorderLayout.EAST);
			setVisible(true);
			setPreferredSize(getMinimumSize());
			setVisible(true);

		}

		public void setSampleFont() {
			String n = (String) fonts.getSelectedItem();
			int s = Integer.parseInt((String) size.getSelectedItem());
			int style = 0;
			if (italic.isSelected()) {
				style = style + Font.ITALIC;
			}
			if (bold.isSelected()) {
				style = style + Font.BOLD;
			}
			if (center.isSelected()) {
				text.setHorizontalAlignment(SwingConstants.CENTER);
			} else {
				text.setHorizontalAlignment(SwingConstants.LEFT);
			}
			if (red.isSelected()) {
				text.setForeground(Color.RED);
			}
			if (blue.isSelected()) {
				text.setForeground(Color.BLUE);
			}
			if (yellow.isSelected()) {
				text.setForeground(Color.YELLOW);
			}
			if (black.isSelected()) {
				text.setForeground(Color.BLACK);
			}
			text.setFont(new Font(n, style, s));
			text.repaint();

		}
	}

	public class ChoiceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			((FontPanel) panel).setSampleFont();
		}

	}

	public static void main(String[] args) {
		JFrame frame = new FontChanger();
	}

}
