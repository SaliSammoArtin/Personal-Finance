package personalFinance.Service;

import personalFinance.Model.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTransactionRepository implements ITransactionRepository {

    @Override
    public List<Transaction> loadTransactions() throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(" ", 3);

                double amount = Double.parseDouble(parts[0]);
                String date = parts[1];
                String description = parts.length > 2 ? parts[2] : "";

                transactions.add(new Transaction(amount, date, description));
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
