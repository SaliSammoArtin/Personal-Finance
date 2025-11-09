package personalFinance.Repository;

import personalFinance.Model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccountRepository implements IAccountRepository {
    private final String filePath;

    public FileAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(" ", 3);
                double amount = Double.parseDouble(parts[0]);
                String date = parts[1];
                String description = parts.length >= 3 ? parts[2] : "";

                transactions.add(new Transaction(amount, date, description));
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not load transactions", e);
        }
        return transactions;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(transaction.getAmount() + " " + transaction.getDate() + " " + transaction.getDescription() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Could not save transaction", e);
        }
    }

    @Override
    public void removeTransaction(Transaction transaction) {
        List<Transaction> transactions = getAllTransactions();
        transactions.removeIf(t ->
                t.getAmount() == transaction.getAmount() &&
                        t.getDate().equals(transaction.getDate()) &&
                        t.getDescription().equals(transaction.getDescription())
        );

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Transaction t : transactions) {
                writer.write(t.getAmount() + " " + t.getDate() + " " + t.getDescription() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not remove transaction", e);
        }
    }
}

