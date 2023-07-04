import java.lang.*;
import java.util.*;
class BankAccount
{
	String name;
	String username;	
	String password;
	String accountno;
	Double balance=100000d;
	int transactions=0;
	String transactionHistory="";

	public void register()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter your name: ");
		this.name=sc.nextLine();
		System.out.print("\nEnter your user name: ");
		this.username=sc.nextLine();
		System.out.print("\nEnter your password: ");
		this.password=sc.nextLine();
		System.out.print("\nEnter your Account Number: ");
		this.accountno=sc.nextLine();
		System.out.print("\nRegisteration Successfully completed ...and the next step is plzz login \n");
	}

	public boolean login()
	{
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		while(!flag)
		{
			System.out.print("\nEnter your username : ");
			String Username=sc.nextLine();
			if(Username.equals(username))
			{	
				while(!flag)
				{
					System.out.print("\nEnter your password : ");
					String Password=sc.nextLine();
					if(Password.equals(password))
					{
						System.out.println("\nWelcome back to CENTRAL BANK OF INDIA...\n");
						flag=true;
					}
					else
					{
						System.out.println("Wrong password...plzz enter correctly...\n");
					}
				}
			}
			else
			{
				System.out.println("Username not found\n");
			}	
		}
		return flag;
	}	


	public void transactionhistory(){
		if( transactions==0 )
		{
			System.out.println("\nNo Any Transactions was done.......Empty");
		}
		else
		{
			System.out.println("\n "+ transactionHistory+ "\n");
		}
	}

	public void deposit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter your deposit Amount: ");
		Double amount=sc.nextDouble();
		try
		{
			if(amount<=100000d && amount>0)
			{
				transactions++;
				balance=balance+amount;
				String str= amount+".Rs Deposited Succesfully"+"\n";
				transactionHistory=transactionHistory.concat(str);
				System.out.println("\nSuccessfully Deposited Money\n");
			}
			else
			{
				System.out.print("\nSorry not Deposited. The Amount can be deposited with in Rs.100000.00\n");
			}
		}
		catch(Exception e){
		}
	}

	public void withdraw()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the amount to withdraw: ");
		Double amount=sc.nextDouble();
		try
		{
			if(amount<=5000d && amount>0)
			{
				if(balance>=amount)
				{
					transactions++;
					balance=balance-amount;
					String str=amount+" "+"Rs.Withdrawn Successfully"+"\n";
					transactionHistory=transactionHistory.concat(str);
					System.out.println("\nAmount Withdrawn Successfully\n");
				}
				else
				{
					System.out.println("Sorry your Account has Low Balance Amount\n");
				}
			}
			else
			{
				System.out.println("The Amount Limit is Rs.5000.00\n");
			}
		}
		catch(Exception e){
		}
	}


	public void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the Recipient name: ");
		String recipient=sc.nextLine();
		System.out.print("\nEnter the Amount to Transfer: ");
		Double amount=sc.nextDouble();	
		try
		{
			if(amount<=5000d && amount>0)
			{
				if(balance>=amount)
				{
					transactions++;
					balance=balance-amount;
					String str=amount+" "+".Rs is Transferred to "+recipient+"Successfully\n";	
					transactionHistory=transactionHistory.concat(str);
					System.out.println("Successfully Transfered\n");
				}
				else
				{
					System.out.println("\nInsuffient Balance\n");
				}
			}
			else
			{
				System.out.println("Sorry cannot Transfered.The Amount must be less than Rs.5000.0\n");
			}
		}
		catch(Exception e){

		}
	}


	public void check_balance()
	{
		System.out.println("\n"+"The Balance Amount in Your Account is: "+balance);
	}

}

	
public class PracticeBank
{

	public static int takeInputInteger(int limit)
	{
		int input=0;
		boolean flag=false;
		while(!flag)
		{
			try
			{	
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input>limit || input<1)
				{
					System.out.print("\nChoose the Correct Option "+limit);
				}
			}
			catch(Exception e){
				System.out.println("Enter Integer only...");

			}
		}
		return input;
	}

	public static void main(String[] args)
	{
		
		System.out.println("\n****************WELCOME TO CENTRAL BANK OF INDIA*******************");
		System.out.print("\n----------------------------------------------------------------------");
		System.out.print("\n1.Register \n2.Exit");
		System.out.print("\nEnter your option: ");
		int ch=takeInputInteger(2);
		if(ch==1)
		{
			BankAccount b=new BankAccount();
			b.register();
			while(true)
			{
				System.out.print("\n1.Login \n2.Exit");
				System.out.println("\nEnter option 1 or 2: ");
				int cho=takeInputInteger(2);
				if(cho==1)
				{
					b.login();
					System.out.print("\nWelcome back "+b.name);
					System.out.print("\n 1.Deposit \n 2.Withdraw \n 3.Transfer \n 4.CheckBalance \n 5.Transaction History \n 6.Exit\n");
					System.out.println("Enter your Option: ");
					int choice=takeInputInteger(6);
					if(choice==1)
					{
						b.deposit();
					}
					else if(choice==2)
					{
						b.withdraw();
					}
					else if(choice==3)
					{
						b.transfer();
					}
					else if(choice==4)
					{
						b.check_balance();
					}
					else if(choice==5)
					{
						b.transactionhistory();
					}
					else
					{
						System.exit(0);
					}
				}
				else
				{
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}
	
	
	}
}
