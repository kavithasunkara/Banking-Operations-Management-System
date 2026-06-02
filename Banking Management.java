import java.util.Scanner;

class ATM {
    private double balance = 10000; // Initial balance
    private final int PIN = 1234;

    Scanner sc = new Scanner(System.in);

    // Method for PIN verification
    public void checkPin() {
        System.out.print("Enter Your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Incorrect PIN");
            checkPin();
        }
    }

    // ATM Menu
    public void menu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option;

            try {
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        checkBalance();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        System.out.println("Thank You for Using ATM!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Option");
                }

            } catch (Exception e) {
                System.out.println("Please Enter Valid Input");
                sc.next(); // Clear invalid input
            }
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }

    // Deposit Money
    public void depositMoney() {
        try {
            System.out.print("Enter Amount to Deposit: ₹");
            double amount = sc.nextDouble();

            if (amount > 0) {
                balance += amount;
                System.out.println("₹" + amount + " Deposited Successfully");
            } else {
                System.out.println("Invalid Amount");
            }

        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.next();
        }
    }

    // Withdraw Money
    public void withdrawMoney() {
        try {
            System.out.print("Enter Amount to Withdraw: ₹");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid Amount");
            } else if (amount > balance) {
                System.out.println("Insufficient Balance");
            } else {
                balance -= amount;
                System.out.println("Please Collect Your Cash");
            }

        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.next();
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}