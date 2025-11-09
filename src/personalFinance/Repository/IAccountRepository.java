package personalFinance.Repository;

import personalFinance.Model.Transaction;

import java.util.List;

public interface IAccountRepository {
    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    void removeTransaction(Transaction transaction);
}
