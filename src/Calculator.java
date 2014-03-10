/*
 * Simple Calculator
 */

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Calculator extends JFrame {
	private static final long serialVersionUID = 1L;

	Calculator() {
		setTitle("Calculator");
		setSize(400, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		JPanel panel = new CalcPanel();
		add(panel);
		setVisible(true);
	}

	public class CalcPanel extends JPanel {

		Dimension buttonSize = new Dimension(60, 60);
		Boolean add = false, sub = false, divide = false, multiply = false;

		private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn,
				svnBtn, eightBtn, nineBtn, tenBtn, eqlBtn, addBtn, subBtn,
				multBtn, divBtn, solvBtn, decBtn;

		private double temp, tempCalc;
		private JTextField result;
		String display = "";

		public CalcPanel() {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(4, 3));

			panel.add(svnBtn = new JButton("7"));
			panel.add(eightBtn = new JButton("8"));
			panel.add(nineBtn = new JButton("9"));
			panel.add(divBtn = new JButton("/"));
			panel.add(fourBtn = new JButton("4"));
			panel.add(fiveBtn = new JButton("5"));
			panel.add(sixBtn = new JButton("6"));
			panel.add(multBtn = new JButton("*"));
			panel.add(oneBtn = new JButton("1"));
			panel.add(twoBtn = new JButton("2"));
			panel.add(threeBtn = new JButton("3"));
			panel.add(subBtn = new JButton("-"));
			panel.add(tenBtn = new JButton("0"));
			panel.add(decBtn = new JButton("."));
			panel.add(addBtn = new JButton("+"));
			panel.add(solvBtn = new JButton("="));

			JPanel panelTwo = new JPanel();
			panelTwo.setLayout(new FlowLayout());
			panelTwo.add(result = new JTextField(20));
			result.setHorizontalAlignment(JTextField.RIGHT);
			result.setEditable(false);

			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(panelTwo);
			p.add(panel);
			add(p);
			oneBtn.addActionListener(new OneListener());
			oneBtn.setPreferredSize(buttonSize);
			twoBtn.addActionListener(new TwoListener());
			threeBtn.addActionListener(new ThreeListener());
			fourBtn.addActionListener(new FourListener());
			fiveBtn.addActionListener(new FiveListener());
			sixBtn.addActionListener(new SixListener());
			svnBtn.addActionListener(new SevenListener());
			eightBtn.addActionListener(new EightListener());
			nineBtn.addActionListener(new NineListener());
			tenBtn.addActionListener(new ZeroListener());
			addBtn.addActionListener(new AddListener());
			subBtn.addActionListener(new SubListener());
			multBtn.addActionListener(new MultListener());
			divBtn.addActionListener(new DivListener());
			solvBtn.addActionListener(new SolveListener());
			decBtn.addActionListener(new DecimalListener());

		}

		class DecimalListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + ".");
			}
		}

		class OneListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "1");
			}
		}

		class TwoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "2");
			}
		}

		class ThreeListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "3");
			}
		}

		class FourListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "4");
			}
		}

		class FiveListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "5");
			}
		}

		class SixListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "6");
			}
		}

		class SevenListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "7");
			}
		}

		class EightListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "8");
			}
		}

		class NineListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "9");
			}
		}

		class ZeroListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				display = result.getText();
				result.setText(display + "0");
			}
		}

		class AddListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				temp = Double.parseDouble(result.getText());
				result.setText("");
				add = true;

			}
		}

		class SubListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				temp = Double.parseDouble(result.getText());
				result.setText("");
				sub = true;
			}
		}

		class MultListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				temp = Double.parseDouble(result.getText());
				result.setText("");
				multiply = true;

			}
		}

		class DivListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				temp = Double.parseDouble(result.getText());
				result.setText("");
				divide = true;
			}
		}

		class SolveListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				tempCalc = Double.parseDouble(result.getText());
				if (add == true)
					tempCalc = tempCalc + temp;

				else if (sub == true)
					tempCalc = temp - tempCalc;
				else if (multiply == true)
					tempCalc = tempCalc * temp;
				else if (divide == true)
					tempCalc = temp / tempCalc;
				result.setText(Double.toString(tempCalc));
				add = false;
				sub = false;
				multiply = false;
				divide = false;

			}
		}

	}

	public static void main(String[] args) {
		JFrame frame = new Calculator();
	}
}