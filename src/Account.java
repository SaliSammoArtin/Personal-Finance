import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

public class Account {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;
                String[] parts = line.split(" ");
                double amount = Double.parseDouble(parts[0]);
                String date = parts[1];
                String description = parts[2];

                Transaction transaction = new Transaction(amount, date, description);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void addTransaction(double amount, String date, String description) {
        Transaction transaction = new Transaction(amount, date, description);
        transactions.add(transaction);

        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.amount + " " + t.date + " " + t.description + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void removeTransaction(double amount, String date, String description) {
        for (int i = transactions.size() - 1; i >= 0; --i) {
            Transaction transaction = transactions.get(i);
            if (transaction.amount == amount && transaction.date.equals(date) && transaction.description.equals(description)) {
                transactions.remove(i);
            }
        }

        try (FileWriter file = new FileWriter("transactions.txt")) {
            for (Transaction t : transactions) {
                file.write(t.amount + " " + t.date + " " + t.description + "\n");
            }
        } catch(IOException e){
            System.out.println("Something went wrong!");
        }
    }

    public void getAllTransactions() {
        System.out.println("Your transactions are:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        System.out.println("Press 7 to see the menu again");
    }

    public void getBalance(){
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.amount;
        }
        System.out.println("Your balance is: " + balance);
        System.out.println("Press 7 to see the menu again");
    }

    public void viewExpenses(String period, int userYear, int userMonth, int userWeek, int userDay) {
        double expenses = 0;
        for (Transaction t : transactions) {

            if (t.amount < 0) {
                LocalDate date = t.date;

                if(period.equalsIgnoreCase("year")) {
                    if(date.getYear() == userYear) {
                        expenses += t.amount;
                    }
                }
                else if(period.equalsIgnoreCase("month")) {
                    if(date.getYear() == userYear && date.getMonthValue() == userMonth) {
                        expenses += t.amount;
                    }
                }
                else if(period.equalsIgnoreCase("week")) {
                    if(date.getYear () == userYear && date.get(WeekFields.ISO.weekOfWeekBasedYear()) == userWeek) {
                        expenses += t.amount;
                    }
                }
                else if(period.equalsIgnoreCase("day")) {
                    if(date.getDayOfMonth() == userDay && date.getMonthValue() == userMonth && date.getYear() == userYear) {
                        expenses += t.amount;
                    }
                }
            }
        }
        System.out.println("Total expenses for " + period + ": " + expenses);
    }
}