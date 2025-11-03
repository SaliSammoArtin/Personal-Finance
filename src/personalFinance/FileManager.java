package personalFinance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
public List<Transaction> loadTransactions() {
    List<Transaction> transactions = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(" ");
            double amount = Double.parseDouble(parts[0]);
            String date = parts[1];
            String description = parts[2];

            Transaction transaction = new Transaction(amount, date, description);
            transactions.add(transaction);
        }
    } catch (IOException e) {
        System.out.println("Something went wrong!");
    } return transactions;
}
    public void saveTransactions(List<Transaction> transactions) {
        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.amount + " " + t.date + " " + t.description + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}
