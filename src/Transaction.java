import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public double amount;
    public LocalDate date;
    public String description;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Transaction(double amount, String date, String description) {
        this.amount = amount;
        this.date = LocalDate.parse(date, formatter);
        this.description = description;
    }
    public String toString() {
        return amount + ", " + date.format(formatter) + ", " + description;
    }
}
