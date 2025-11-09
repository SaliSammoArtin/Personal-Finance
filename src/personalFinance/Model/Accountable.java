package personalFinance.Model;

import java.util.List;

public interface Accountable {
    void addTransaction(double amount, String date, String description);
    void removeTransaction(double amount, String date, String description);
    List<Transaction> getTransactions();
    double getBalance();
    double getIncome(String period, int year, int month, int week, int day);
    double getExpenses(String period, int year, int month, int week, int day);
}
