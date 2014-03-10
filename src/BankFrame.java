import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BankFrame extends JFrame implements ActionListener
{
	private BankAccount ba;
		
	BankFrame(BankAccount b)		
	{
		ba = b;
		bankPanel = new JPanel(new FlowLayout());
		balancePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		wButton = new JButton("Withdraw");
		wButton.addActionListener(this);
		dButton = new JButton("Deposit");
		dButton.addActionListener(this);
		amountText = new JTextField(10);
		amountText.setEditable(true);
		amountText.setFocusable(true);
		amountLabel = new JLabel("Amount:");
		balanceLabel = new JLabel("Balance = " + ba.getBalance());
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(480, 120));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(bankPanel, BorderLayout.NORTH);
		add(balancePanel, BorderLayout.CENTER);
		bankPanel.add(amountLabel);
		bankPanel.add(amountText);
		bankPanel.add(wButton);
		bankPanel.add(dButton);
		balancePanel.add(balanceLabel);
	}
	JButton wButton, dButton;
	JTextField amountText;
	JLabel amountLabel, balanceLabel;
	JPanel bankPanel, balancePanel;
	double amount;
	
	public void update()
	{
		balanceLabel.setText("Balance = " + ba.getBalance());
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == wButton)
		{
			amount = Double.parseDouble(amountText.getText());
			ba.withdraw(amount);
			update();
		}
		if(e.getSource() == dButton)
		{
			amount = Double.parseDouble(amountText.getText());
			ba.deposit(amount);
			update();
		}
	}
}