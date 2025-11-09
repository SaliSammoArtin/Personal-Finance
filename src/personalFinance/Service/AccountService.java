package personalFinance.Service;

import personalFinance.Repository.IAccountRepository;
import personalFinance.Model.Transaction;

import java.time.LocalDate;
import java.util.List;

public class AccountService {

    private final IAccountRepository repository;

    public AccountService(IAccountRepository repository) {
        this.repository = repository;
    }

    public void addTransaction(double amount, LocalDate date, String description) {
        Transaction transaction = new Transaction(date, amount, description);
        repository.saveTransaction(transaction);
    }

    public void removeTransaction(double amount, LocalDate date, String description) {
        Transaction transaction = new Transaction(date, amount, description);
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

    public double getExpenses(String month, int year, int month1, int week, int day) {
        return 0;
    }

    public double getIncome(String month, int year, int month1, int week, int day) {
        return 0;
    }
}
