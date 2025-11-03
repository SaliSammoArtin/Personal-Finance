package personalFinance;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Accountable account;
    private final Scanner input;

    public Menu(Accountable account) {
        this.account = account;
        this.input = new Scanner(System.in);
    }

    public void show() {
        while(true) {
            printOptions();
            int option = input.nextInt();
            input.nextLine();
            handleOptions(option);
        }
    }

    private void printOptions() {
        System.out.println("1. Add transaction");
        System.out.println("2. Remove transaction");
        System.out.println("3. View transactions");
        System.out.println("4. View balance");
        System.out.println("5. View income");
        System.out.println("6. View expenses");
        System.out.println("7. Show menu");
        System.out.println("0. Exit");
    }

    private void handleOptions(int option) {
        switch (option) {
            case 0 -> System.exit(0);
            case 1 -> addTransaction();
            case 2 -> removeTransaction();
            case 3 -> viewAllTransactions();
            case 4 -> viewBalance();
            case 5 -> viewIncome();
            case 6 -> viewExpenses();
            case 7 -> printOptions();
            default -> System.out.println("Invalid option!");
        }
    }

    private void addTransaction() {
        System.out.println("Enter amount:");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter date (yyyy-MM-dd):");
        String date = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        account.addTransaction(amount, date, description);
    }

    private void removeTransaction() {
        System.out.println("Enter amount:");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter date:");
        String date = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        account.removeTransaction(amount, date, description);
    }

    private void viewAllTransactions() {
        List<Transaction> all = account.getTransactions();

        if (all.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transactions:");
            for (Transaction t : all) {
                System.out.println(t);
            }
        }
    }

    private void viewBalance() {
        double balance = account.getBalance();
        System.out.println("Current balance: " + balance);
    }

    private void viewIncome() {
        System.out.println("Enter year:");
        int year = input.nextInt();
        System.out.println("Enter month:");
        int month = input.nextInt();
        System.out.println("Enter week:");
        int week = input.nextInt();
        System.out.println("Enter day:");
        int day = input.nextInt();
        input.nextLine();

        double income = account.getIncome("month", year, month, week, day);
        System.out.println("Income: " + income);
    }

    private void viewExpenses() {
        System.out.println("Enter year:");
        int year = input.nextInt();
        System.out.println("Enter month:");
        int month = input.nextInt();
        System.out.println("Enter week:");
        int week = input.nextInt();
        System.out.println("Enter day:");
        int day = input.nextInt();
        input.nextLine();

        double expenses = account.getExpenses("month", year, month, week, day);
        System.out.println("Expenses: " + expenses);
    }
}
