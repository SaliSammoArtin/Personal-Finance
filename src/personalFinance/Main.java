package personalFinance;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        List<Transaction> loadedTransactions = fm.loadTransactions();
        Accountable account = new Account(loadedTransactions);
        Menu menu = new Menu(account);
        menu.show();
    }
}



        /*else if (option == 2) {
                System.out.println("Enter amount:");
                double amount = input.nextDouble();
                input.nextLine();

                System.out.println("Enter date:");
                String date = input.nextLine();

                System.out.println("Enter description:");
                String description = input.nextLine();

                account.removeTransaction(amount, date, description);
                System.out.println("Transaction has been deleted.\nPress 7 to see the menu again");

            } else if (option == 3) {
                account.getAllTransactions();

            } else if (option == 4) {
                account.getBalance();

            } else if (option == 5) {
                account.askAndViewExpenses(input);

            } else if (option == 6) {
                account.askAndViewIncome(input);
            }
    }
         */