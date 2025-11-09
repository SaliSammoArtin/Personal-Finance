package personalFinance.Model;

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

    public void addTransaction(double amount, LocalDate date, String description) {
        Transaction t = new Transaction(date, amount, description);
        transactions.add(t);
    }

    @Override
    public void addTransaction(double amount, String date, String description) {

    }

    @Override
    public void removeTransaction(double amount, String date, String description) {

    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : transactions) balance += t.getAmount();
        return balance;
    }

    public double getIncome(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double income = 0;
        for (Transaction t : transactions) {
            if (t.getAmount() >= 0) {
                continue;
            }
            LocalDate date = LocalDate.from(t.getDate());

            if (period.equalsIgnoreCase("year")) {
                if (date.getYear() == userYear) {
                    income += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("month")) {
                if (date.getYear() == userYear && date.getMonthValue() == userMonth) {
                    income += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("week")) {
                if (date.getYear() == userYear && date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                    income += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("day")) {
                if (date.getDayOfMonth() == userDay && date.getMonthValue() == userMonth && date.getYear() == userYear) {
                    income += t.getAmount();
                }
            }
        }
        return income;
    }

    public double getExpenses(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double expenses = 0;
        for (Transaction t : transactions) {
            if (t.getAmount() >= 0) {
                continue;
            }
            LocalDate date = LocalDate.from(t.getDate());

            if (period.equalsIgnoreCase("year")) {
                if (date.getYear() == userYear) {
                    expenses += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("month")) {
                if (date.getYear() == userYear && date.getMonthValue() == userMonth) {
                    expenses += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("week")) {
                if (date.getYear() == userYear && date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                    expenses += t.getAmount();
                }
            } else if (period.equalsIgnoreCase("day")) {
                if (date.getDayOfMonth() == userDay && date.getMonthValue() == userMonth && date.getYear() == userYear) {
                    expenses += t.getAmount();
                }
            }
        }
        return expenses;
    }
}