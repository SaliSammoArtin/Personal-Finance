import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(" ");
                double amount = Double.parseDouble(parts[0]);
                String date = parts[1];
                String description = parts[2];

                Transaction transaction = new Transaction(amount, date, description);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void addTransaction(double amount, String date, String description) {
        Transaction transaction = new Transaction(amount, date, description);
        transactions.add(transaction);
        //Gör en ny klass för filhantering
        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.amount + " " + t.date + " " + t.description + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void removeTransaction(double amount, String date, String description) {
        for (int i = transactions.size() - 1; i >= 0; --i) {
            Transaction transaction = transactions.get(i);
            if (transaction.amount == amount && transaction.date.equals(date) && transaction.description.equals(description)) {
                transactions.remove(i);
            }
        }

        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.amount + " " + t.date + " " + t.description + "\n");
            }

        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void getAllTransactions() {
        System.out.println("Your transactions are:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        System.out.println("Press 7 to see the menu again");
    }

    public void getBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.amount;
        }
        System.out.println("Your balance is: " + balance);
        System.out.println("Press 7 to see the menu again");
    }

    public void viewExpenses(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double expenses = 0;
        for (Transaction t : transactions) {

            if (t.amount >= 0) {
                continue;
            }
            LocalDate date = t.date;

            if (period.equalsIgnoreCase("year")) {
                if (date.getYear() == userYear) {
                    expenses += t.amount;
                }
            } else if (period.equalsIgnoreCase("month")) {
                if (date.getYear() == userYear && date.getMonthValue() == userMonth) {
                    expenses += t.amount;
                }
            } else if (period.equalsIgnoreCase("week")) {
                if (date.getYear() == userYear && date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                    expenses += t.amount;
                }
            } else if (period.equalsIgnoreCase("day")) {
                if (date.getDayOfMonth() == userDay && date.getMonthValue() == userMonth && date.getYear() == userYear) {
                    expenses += t.amount;
                }
            }
        }
        System.out.println("Total expenses for " + period + ": " + expenses);
    }

    public void askAndViewExpenses(Scanner input) {
        System.out.println("Do you want to view expenses by year, month, week, or day?");
        String period = input.nextLine();

        int userYear = 0;
        int userMonth = 0;
        int userWeek = 0;
        int userDay = 0;

        if (period.equalsIgnoreCase("year")) {
            System.out.println("Enter year:");
            userYear = input.nextInt();
            input.nextLine();
        } else if (period.equalsIgnoreCase("month")) {
            System.out.println("Enter year:");
            userYear = input.nextInt();
            System.out.println("Enter month (1-12):");
            userMonth = input.nextInt();
            input.nextLine();
        } else if (period.equalsIgnoreCase("week")) {
            System.out.println("Enter a date (yyyy-MM-dd):");
            String dateInput = input.nextLine();
            LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
            userYear = userDate.getYear();
            userWeek = userDate.get(WeekFields.ISO.weekOfWeekBasedYear());
        } else if (period.equalsIgnoreCase("day")) {
            System.out.println("Enter a date (yyyy-MM-dd):");
            String dateInput = input.nextLine();
            LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
            userYear = userDate.getYear();
            userMonth = userDate.getMonthValue();
            userDay = userDate.getDayOfMonth();
        }
        viewExpenses(period, userYear, userMonth, userWeek, userDay);
    }

    public void viewIncome(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double income = 0;
        for (Transaction t : transactions) {

            if (t.amount >= 0) {
                continue;
            }
            LocalDate date = t.date;

            if (period.equalsIgnoreCase("year")) {
                if (date.getYear() == userYear) {
                    income += t.amount;
                }
            } else if (period.equalsIgnoreCase("month")) {
                if (date.getYear() == userYear && date.getMonthValue() == userMonth) {
                    income += t.amount;
                }
            } else if (period.equalsIgnoreCase("week")) {
                if (date.getYear() == userYear && date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                    income += t.amount;
                }
            } else if (period.equalsIgnoreCase("day")) {
                if (date.getDayOfMonth() == userDay && date.getMonthValue() == userMonth && date.getYear() == userYear) {
                    income += t.amount;
                }
            }
        }
        System.out.println("Total income for " + period + ": " + income);
    }

    public void askAndViewIncome(Scanner input) {
        System.out.println("Do you want to view income by year, month, week, or day?");
        String period = input.nextLine();

        int userYear = 0;
        int userMonth = 0;
        int userWeek = 0;
        int userDay = 0;

        if (period.equalsIgnoreCase("year")) {
            System.out.println("Enter year:");
            userYear = input.nextInt();
            input.nextLine();
        } else if (period.equalsIgnoreCase("month")) {
            System.out.println("Enter year:");
            userYear = input.nextInt();
            System.out.println("Enter month (1-12):");
            userMonth = input.nextInt();
            input.nextLine();
        } else if (period.equalsIgnoreCase("week")) {
            System.out.println("Enter a date (yyyy-MM-dd):");
            String dateInput = input.nextLine();
            LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
            userYear = userDate.getYear();
            userWeek = userDate.get(WeekFields.ISO.weekOfWeekBasedYear());
        } else if (period.equalsIgnoreCase("day")) {
            System.out.println("Enter a date (yyyy-MM-dd):");
            String dateInput = input.nextLine();
            LocalDate userDate = LocalDate.parse(dateInput, Transaction.formatter);
            userYear = userDate.getYear();
            userMonth = userDate.getMonthValue();
            userDay = userDate.getDayOfMonth();
        }
        viewExpenses(period, userYear, userMonth, userWeek, userDay);
    }
}