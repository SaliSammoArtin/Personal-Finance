package personalFinance.Command;

import personalFinance.Service.AccountService;

import java.util.Scanner;

public class ViewExpensesCommand implements ICommand {

    private final AccountService service;
    private final Scanner input;

    public ViewExpensesCommand(AccountService service, Scanner input) {
        this.service = service;
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println("Enter year:");
        int year = input.nextInt();
        System.out.println("Enter month:");
        int month = input.nextInt();
        System.out.println("Enter week:");
        int week = input.nextInt();
        System.out.println("Enter day:");
        int day = input.nextInt();
        input.nextLine();

        double expenses = service.getExpenses("month", year, month, week, day);
        System.out.println("Total expenses: " + expenses);
    }
}
