import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
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
            }

            else if (option == 2) {
                System.out.println("Enter amount:");
                double amount = input.nextDouble();
                input.nextLine();

                System.out.println("Enter date:");
                String date = input.nextLine();

                System.out.println("Enter description:");
                String description = input.nextLine();

                account.removeTransaction(amount, date, description);
                System.out.println("Transaction has been deleted.\nPress 7 to see the menu again");
            }

            else if (option == 3) {
                account.getAllTransactions();
            }
            else if (option == 4) {
                account.getBalance();
            }
            else if (option == 5) {
                System.out.println("Do you want to view expenses by year, month, week, or day?");
                String period = input.nextLine();

                int userYear = 0;
                int userMonth = 0;
                int userWeek = 0;
                int userDay = 0;

                if (period.equalsIgnoreCase("year")
                        || period.equalsIgnoreCase("month")
                        || period.equalsIgnoreCase("week")
                        || period.equalsIgnoreCase("day")) {

                    if (period.equalsIgnoreCase("year")) {
                        System.out.println("Enter year:");
                        userYear = input.nextInt();
                        input.nextLine();
                    }

                    if (period.equalsIgnoreCase("month")) {
                        System.out.println("Enter month (1-12):");
                        userMonth = input.nextInt();
                        input.nextLine();
                    }

                    if (period.equalsIgnoreCase("week")) {
                        System.out.println("Enter a date (yyyy-MM-dd):");
                        String dateInput = input.nextLine();
                        LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
                        userWeek = userDate.get(WeekFields.ISO.weekOfWeekBasedYear());
                        userYear = userDate.getYear();
                    }

                    if (period.equalsIgnoreCase("day")) {
                        System.out.println("Enter a date (yyyy-MM-dd):");
                        String dateInput = input.nextLine();
                        LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
                        userYear = userDate.getYear();
                        userMonth = userDate.getMonthValue();
                        userDay = userDate.getDayOfMonth();
                    }
                    account.viewExpenses(period, userYear, userMonth, userWeek, userDay);
                    System.out.println("Press 7 to see the menu again");
                }
            }

            else if (option == 6)
                System.out.println("View income");
            else if (option == 7);
            }
        }
    }