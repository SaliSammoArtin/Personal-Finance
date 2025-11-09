package personalFinance.Model;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccountable {
    private final ArrayList<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public Account(List<Transaction> myTransactions) {
        this.transactions = new ArrayList<>(myTransactions);
    }

    @Override
    public void addTransaction(double amount, String date, String description) {
        Transaction t = new Transaction(amount, date, description);
        transactions.add(t);
    }

    @Override
    public void removeTransaction(double amount, String date, String description) {
        // Tar bort första matchande transaktion
        transactions.removeIf(t ->
                t.getAmount() == amount &&
                        t.getDescription().equals(description) &&
                        t.getDate().toString().contains(date)
        );
    }

    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public double getIncome(String period, int year, int month, int week, int day) {
        return 0;
    }

    @Override
    public double getExpenses(String period, int year, int month, int week, int day) {
        return 0;
    }
}
