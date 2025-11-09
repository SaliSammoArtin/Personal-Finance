package personalFinance.Command;

import personalFinance.Service.AccountService;

import java.util.Scanner;

public class AddTransactionCommand implements ICommand {

    private final AccountService service;
    private final Scanner input;

    public AddTransactionCommand(AccountService service, Scanner input) {
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

        service.addTransaction(amount, date, description);
        System.out.println("Transaction added!");
    }
}