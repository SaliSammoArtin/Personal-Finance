package personalFinance.Model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private double amount;
    private Instant date;
    private String description;

    private static final DateTimeFormatter INPUT_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);

    public Transaction(double amount, String dateString, String description) {
        this.amount = amount;

        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.date = localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String dateString) {
        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.date = localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        LocalDate localDate = date.atZone(ZoneOffset.UTC).toLocalDate();
        return amount + ", " + localDate + ", " + description;
    }
}
