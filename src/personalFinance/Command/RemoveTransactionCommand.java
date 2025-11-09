package personalFinance.Command;

import personalFinance.Service.AccountService;

import java.time.LocalDate;
import java.util.Scanner;

public class RemoveTransactionCommand implements ICommand {

    private final AccountService service;
    private final Scanner input;

    public RemoveTransactionCommand(AccountService service, Scanner input) {
        this.service = service;
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println("Enter amount:");
        double amount = input.nextDouble();
        input.nextLine();

        System.out.println("Enter date (yyyy-MM-dd):");
        String date = input.nextLine();

        System.out.println("Enter description:");
        String description = input.nextLine();

        service.removeTransaction(amount, LocalDate.parse(date), description);
        System.out.println("Transaction removed!");
    }
}
