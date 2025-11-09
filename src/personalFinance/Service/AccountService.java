package personalFinance.Service;

import personalFinance.Repository.IAccountRepository;
import personalFinance.Model.Transaction;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.List;

public class AccountService {

    private final IAccountRepository repository;

    public AccountService(IAccountRepository repository) {
        this.repository = repository;
    }

    public void addTransaction(double amount, String date, String description) {
        Transaction transaction = new Transaction(amount, date, description);
        repository.saveTransaction(transaction);
    }

    public void removeTransaction(double amount, String date, String description) {
        Transaction transaction = new Transaction(amount, date, description);
        repository.removeTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : repository.getAllTransactions()) {
            balance += t.getAmount();
        }
        return balance;
    }

    public double getIncome(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double income = 0;
        for (Transaction t : repository.getAllTransactions()) {
            if (t.getAmount() <= 0) continue;
            LocalDate date = t.getDate().atZone(ZoneId.of("UTC")).toLocalDate();

            if (period.equalsIgnoreCase("year") && date.getYear() == userYear) {
                income += t.getAmount();
            } else if (period.equalsIgnoreCase("month") && date.getYear() == userYear && date.getMonthValue() == userMonth) {
                income += t.getAmount();
            } else if (period.equalsIgnoreCase("week") && date.getYear() == userYear &&
                    date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                income += t.getAmount();
            } else if (period.equalsIgnoreCase("day") && date.getDayOfMonth() == userDay &&
                    date.getMonthValue() == userMonth && date.getYear() == userYear) {
                income += t.getAmount();
            }
        }
        return income;
    }

    public double getExpenses(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double expenses = 0;
        for (Transaction t : repository.getAllTransactions()) {
            if (t.getAmount() >= 0) continue;
            LocalDate date = t.getDate().atZone(ZoneId.of("UTC")).toLocalDate();

            if (period.equalsIgnoreCase("year") && date.getYear() == userYear) {
                expenses += t.getAmount();
            } else if (period.equalsIgnoreCase("month") && date.getYear() == userYear && date.getMonthValue() == userMonth) {
                expenses += t.getAmount();
            } else if (period.equalsIgnoreCase("week") && date.getYear() == userYear &&
                    date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                expenses += t.getAmount();
            } else if (period.equalsIgnoreCase("day") && date.getDayOfMonth() == userDay &&
                    date.getMonthValue() == userMonth && date.getYear() == userYear) {
                expenses += t.getAmount();
            }
        }
        return expenses;
    }
}
