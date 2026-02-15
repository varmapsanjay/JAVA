import java.util.Scanner;
class BankAccount 
{
    private String accountHolder;
    private double balance;    
    public BankAccount(String accountHolder, double initialBalance) 
	{
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public void deposit(double amount) 
	{
        if (amount > 0) 
		{
            balance += amount;
            System.out.println("Deposited: " + amount);
        } 
		else 
		{
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount) 
	{
        if (amount > 0 && amount <= balance) 
		{
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } 
		else 
		{
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    public void displayBalance() 
	{
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}
public class BankAccountSystem 
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);    
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(name, initialBalance);
        while (true) 
		{
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();    
            switch (choice) 
			{
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}