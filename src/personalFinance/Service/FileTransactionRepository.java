package personalFinance.Service;

import personalFinance.Model.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileTransactionRepository implements TransactionRepository {

    @Override
    public List<Transaction> loadTransactions() throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(" ");
                double amount = Double.parseDouble(parts[0]);
                LocalDate date = LocalDate.parse(parts[1]);
                String description = parts[2];
                Transaction transaction = new Transaction(date, amount, description);
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) throws IOException {
        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.getAmount() + " " + t.getDate() + " " + t.getDescription() + "\n");
            }
        }
    }
}
