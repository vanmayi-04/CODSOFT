import java.util.Scanner;

class BankAccount {
    private double bal;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.bal = initialBalance;
        } else {
            this.bal = 0;
        }
    }

    public double getBalance() {
        return bal;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
            System.out.println("Successfully deposited: $" + amt);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Successfully withdrew: $" + amt);
            return true;
        } else if (amt > bal) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.bankAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amt = scanner.nextDouble();
        bankAccount.deposit(amt);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}
class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000.00); // Initial balance of $1000
        ATM atm = new ATM(myAccount);
        atm.showMenu();
    }
}
