import java.util.Scanner;

public class ATM 
{
    private static final int limit = 500000;
    private static final int initialbalance = 120000;// balance = initial balance
    private static final int Pin_number = 1165;//My Anudip id AF0401165

    public static void main(String[] args) {
        int balance = initialbalance;
        int totalWithdrawnToday = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM :)");
        System.out.println("Please enter your PIN:");
        int pinEntered = scanner.nextInt();

        if (pinEntered == Pin_number) {
            System.out.println("PIN Accepted");

            while (true) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to withdraw:");
                        int withdrawAmount = scanner.nextInt();
                        if (withdrawAmount <= 0) {
                            System.out.println("Invalid amount!");
                            continue;
                        }
                        if (totalWithdrawnToday + withdrawAmount > limit) {
                            System.out.println("Daily withdrawal limit exceeded!");
                            continue;
                        }
                        if (withdrawAmount > balance) {
                            System.out.println("Insufficient Amount!");
                            continue;
                        }
                        balance -= withdrawAmount;
                        totalWithdrawnToday += withdrawAmount;
                        System.out.println("Withdrawal successful. \nNew balance: " + balance);
                        break;

                    case 2:
                        System.out.println("Enter amount to deposit:");
                        int depositAmount = scanner.nextInt();
                        if (depositAmount <= 0) {
                            System.out.println("Invalid amount");
                            continue;
                        }
                        balance += depositAmount;
                        System.out.println("Deposit successful. New balance: " + balance);
                        break;

                    case 3:
                        System.out.println("Current balance: " + balance);
                        break;

                    case 4:
                        System.out.println("Exiting... from ATM \n Thank You for using ATM *~*");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Exiting...");
        }
    }
}
