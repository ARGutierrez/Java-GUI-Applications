/*
 * Simple Savings Calculator
 * contains class that extends ActionListener
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SavingsFrame extends JFrame {

	JLabel balanceLbl, rateLbl, yearLbl;
	JPanel savingsPanel, resultPanel, bPanel, rPanel, yPanel;
	JTextField balanceFld, rateFld, yearFld;
	JButton calculate;
	JTextArea results;
	JScrollPane resultScroll;

	public SavingsFrame() {
		savingsPanel = new JPanel(new BorderLayout());
		bPanel = new JPanel();
		rPanel = new JPanel();
		yPanel = new JPanel();
		resultPanel = new JPanel();
		calculate = new JButton("Calculate");
		calculate.addActionListener(new savingsListener());
		balanceLbl = new JLabel("Initial Balance");
		rateLbl = new JLabel("Annual Rate");
		yearLbl = new JLabel("Number of Years");
		balanceFld = new JTextField(10);
		rateFld = new JTextField(10);
		yearFld = new JTextField(10);
		results = new JTextArea(20, 1);
		results.setEditable(false);
		// results.setPreferredSize(new Dimension(100, 100));
		results.setLineWrap(true);
		resultScroll = new JScrollPane(results,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		resultScroll.setPreferredSize(new Dimension(140, 140));
		resultScroll.setWheelScrollingEnabled(true);
		setTitle("Savings Calculator");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(400, 500));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(savingsPanel, BorderLayout.NORTH);
		bPanel.add(balanceLbl);
		bPanel.add(balanceFld);
		rPanel.add(rateLbl);
		rPanel.add(rateFld);
		yPanel.add(yearLbl);
		yPanel.add(yearFld);
		resultPanel.add(calculate);
		resultPanel.add(resultScroll);
		savingsPanel.add(bPanel, BorderLayout.NORTH);
		savingsPanel.add(rPanel, BorderLayout.CENTER);
		savingsPanel.add(yPanel, BorderLayout.SOUTH);
		add(resultPanel, BorderLayout.CENTER);
	}

	public class savingsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DecimalFormat d = new DecimalFormat("#.00");

			double yearAmt = Double.parseDouble(yearFld.getText());
			double initial = Double.parseDouble(balanceFld.getText());
			double rate = Double.parseDouble(rateFld.getText());
			String s = "";
			double result = 0;
			for (int i = 0; i < yearAmt; i++) {
				result = (initial * rate) + initial;
				s += ("$" + d.format(result) + "\n");
				initial = result;
			}
			results.setText(s);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new SavingsFrame();
	}
}
