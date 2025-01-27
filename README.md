# Bank Application
A simple Java-based banking application demonstrating object-oriented programming concepts like inheritance, method overriding, and encapsulation. The application supports two types of accounts:
Saving Account: Allows deposits, withdrawals, and interest calculations.
Checking Account: Supports deposits, withdrawals, and overdraft transactions.

## Features

1. Account Management:
Deposit funds.
Withdraw funds (with overdraft protection for checking accounts).
Calculate and add interest for saving accounts.

2. Object-Oriented Design:
Utilizes inheritance to extend account functionality.
Demonstrates method overriding for customized behavior.

3. Interactive CLI:
User-friendly command-line interface for account operations.

## Classes and Structure

1. Account (Base Class)
Attributes:
accountNumber (Private): Stores the unique account number.
balance (Protected): Tracks the account balance.
Methods:
deposit(amount): Adds funds to the account.
withdraw(amount): Deducts funds from the account if sufficient balance exists.
display(): Displays account details.

2. SavingAccount (Subclass)
Additional Attribute:
interestRate: Annual interest rate for the account.
Additional Method:
calculateInterest(): Calculates and adds interest to the balance.
Overrides:
display(): Includes interest rate information.

3. CheckingAccount (Subclass)
Additional Attribute:
overdraftLimit: Maximum amount allowed for overdraft.
Additional Method:
withdrawWithOverdraft(amount): Handles withdrawals with overdraft protection.
Overrides:
display(): Includes overdraft limit information.

## How to Run
How to Run
Clone the Repository:
git clone https://github.com/yourusername/BankApplication.git
(https://github.com/ThanujaPinninti/Bank)
cd BankApplication

Compile the Code:
javac BankApplication.java
## Run the Application:
Clone the Repository:
git clone https://github.com/yourusername/BankApplication.git
cd BankApplication
Compile the Code:
javac BankApplication.java
Run the Application:
java BankApplication

## Requirements
Java Development Kit (JDK) 8 or higher.
A terminal or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

## Project Structure
BankApplication.java  // Main program file containing all classes

## Learning Outcomes
Understanding of:
Inheritance and method overriding in Java.
Encapsulation and access modifiers.
Building interactive Java programs with user input.

## Future Enhancements
Add support for:
Multiple accounts managed dynamically.
File or database persistence for account data.
Enhanced error handling and validations.
