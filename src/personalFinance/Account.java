package personalFinance;

import java.time.temporal.WeekFields;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

    public class Account implements Accountable {
        private final ArrayList<Transaction> transactions;

        public Account() {
            this.transactions = new ArrayList<>();
        }

        public Account(List<Transaction> myTransactions) {
            this.transactions = new ArrayList<>(myTransactions);
        }

        public void addTransaction(double amount, String date, String description) {
            Transaction t = new Transaction(amount, date, description);
            transactions.add(t);
        }

        public void removeTransaction(double amount, String date, String description) {
            Transaction t = new Transaction(amount, date, description);
            transactions.remove(t);
        }

        @Override
        public List<Transaction> getTransactions() {
            return new ArrayList<>(transactions);
        }

        public double getBalance() {
            double balance = 0;
            for (Transaction t : transactions) balance += t.amount;
            return balance;
        }

        public double getIncome(String period, int userYear, int userMonth, int userWeek, int userDay) {
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
            return income;
        }

        public double getExpenses(String period, int userYear, int userMonth, int userWeek, int userDay) {
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
            return expenses;
        }
    }

    /*
public void askAndViewExpenses() {
    System.out.println("Do you want to view expenses by year, month, week, or day?");

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
    } */