import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        toAccount.deposit(amount);
        return true;
    }
}

class Bank {
    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

public class ATM_Simulator {
    private static Bank bank;
    private static Scanner scanner;

    public static void main(String[] args) {
        bank = new Bank();
        scanner = new Scanner(System.in);

        // Adding some initial accounts
        bank.addAccount("12345", 500.00);
        bank.addAccount("67890", 1000.00);

        System.out.println("Welcome to the ATM Simulator!");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM Simulator. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawCash() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Current balance: $" + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transferFunds() {
        System.out.print("Enter source account number: ");
        String fromAccountNumber = scanner.next();
        Account fromAccount = bank.getAccount(fromAccountNumber);

        if (fromAccount != null) {
            System.out.print("Enter destination account number: ");
            String toAccountNumber = scanner.next();
            Account toAccount = bank.getAccount(toAccountNumber);

            if (toAccount != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                if (fromAccount.transfer(toAccount, amount)) {
                    System.out.println("Transfer successful. Current balance: $" + fromAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds.");
                }
            } else {
                System.out.println("Destination account not found.");
            }
        } else {
            System.out.println("Source account not found.");
        }
    }
}
