import javax.swing.JFrame;


public class Test 
{
	public static void main(String[] args)
	{
		BankAccount a = new BankAccount(5000);
		JFrame myFrame = new BankFrame(a);
	}
}
