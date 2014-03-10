import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BankAccount 
{
	private double balance;
	
	BankAccount(double d)
	{
		balance = d;
	}
	
	public void withdraw(double d)
	{
		balance -= d;
	}
	
	public void deposit(double d)
	{
		balance += d;
	}
	
	public double getBalance()
	{
		return balance;
	
	}
}
	
