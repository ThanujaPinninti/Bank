import java.util.Scanner;

// Base class Account
class Account {
    private String accountNumber;  // Private to Account class
    protected double balance;      // Protected to allow access in subclasses

    // Constructor
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Public method to deposit money, accessible to all
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Public method to withdraw money, accessible to all
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Protected method to display account details, accessible in subclasses
    protected void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Subclass SavingAccount
class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // Public method to calculate and add interest
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
    }

    // Overriding display method to include interest rate
    @Override
    protected void display() {
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass CheckingAccount
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    // Public method to withdraw money with overdraft protection
    public void withdrawWithOverdraft(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Transaction declined. Overdraft limit exceeded.");
        }
    }

    // Overriding display method to include overdraft limit
    @Override
    protected void display() {
        super.display();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Main class
public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating SavingAccount object
        SavingAccount savingAccount = new SavingAccount("SA001", 5.0);
        
        // Taking deposit input for SavingAccount
        System.out.print("Enter amount to deposit in Saving Account: ");
        double depositAmount = scanner.nextDouble();
        savingAccount.deposit(depositAmount);

        // Calculating interest for SavingAccount
        savingAccount.calculateInterest();
        savingAccount.display();

        // Creating CheckingAccount object
        CheckingAccount checkingAccount = new CheckingAccount("CA001", 500);
        
        // Taking deposit input for CheckingAccount
        System.out.print("Enter amount to deposit in Checking Account: ");
        depositAmount = scanner.nextDouble();
        checkingAccount.deposit(depositAmount);

        // Taking withdrawal input for CheckingAccount
        System.out.print("Enter amount to withdraw from Checking Account: ");
        double withdrawAmount = scanner.nextDouble();
        checkingAccount.withdraw(withdrawAmount);

        // Taking withdrawal with overdraft input for CheckingAccount
        System.out.print("Enter amount to withdraw with overdraft from Checking Account: ");
        withdrawAmount = scanner.nextDouble();
        checkingAccount.withdrawWithOverdraft(withdrawAmount);
        
        checkingAccount.display();

        scanner.close();
    }
}

/*PS E:\Programming\anudip> javac BankApplication.java
PS E:\Programming\anudip> java BankApplication      
Enter amount to deposit in Saving Account: 125000
125000.0 deposited successfully.
6250.0 deposited successfully.
Account Number: SA001
Balance: 131250.0
Interest Rate: 5.0%
Enter amount to deposit in Checking Account: 25000
25000.0 deposited successfully.
Enter amount to withdraw from Checking Account: 200
200.0 withdrawn successfully.
Enter amount to withdraw with overdraft from Checking Account: 35000
Transaction declined. Overdraft limit exceeded.
Account Number: CA001
Balance: 24800.0
Overdraft Limit: 500.0
PS E:\Programming\anudip>  */