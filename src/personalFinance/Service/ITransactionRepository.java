package personalFinance.Service;

import personalFinance.Model.Transaction;
import java.util.List;

    public interface ITransactionRepository {
        List<Transaction> loadTransactions() throws Exception;
        void saveTransactions(List<Transaction> transactions) throws Exception;
    }