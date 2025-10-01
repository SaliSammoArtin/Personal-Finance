import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner input = new Scanner(System.in);

        System.out.println("Menu");
        System.out.print("Choose an option: \n");

        for (int i = 0; i < Options.values().length - 1; i++) {
            System.out.println((i + 1) + ". " + (Options.values()[i]));
        }

        while (true) {
            int option = input.nextInt();
            input.nextLine();
            if (option == 0) {
                break;
            }

            if (option == 7) {
                for (int i = 0; i < Options.values().length; i++) {
                    System.out.println((i + 1) + ". " + (Options.values()[i]));
                }
            }

            if (option == 1) {
                System.out.println("Enter amount:");
                double amount = input.nextDouble();
                input.nextLine();

                System.out.println("Enter date (yyyy-MM-dd):");
                String date = input.nextLine();

                System.out.println("Enter description:");
                String description = input.nextLine();

                account.addTransaction(amount, date, description);
                System.out.println("Transaction has been added.\nPress 7 to see the menu again");

            } else if (option == 2) {
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
    }
}