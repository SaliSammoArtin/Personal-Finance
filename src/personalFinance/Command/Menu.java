package personalFinance.Command;

import personalFinance.Service.AccountService;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final AccountService service;
    private final Scanner input;
    private final Map<Integer, ICommand> commands;

    public Menu(AccountService service) {
        this.service = service;
        this.input = new Scanner(System.in);

        this.commands = Map.of(
                1, new AddTransactionCommand(service, input),
                2, new RemoveTransactionCommand(service, input),
                3, new ViewTransactionsCommand(service),
                4, new ViewBalanceCommand(service),
                5, new ViewIncomeCommand(service, input),
                6, new ViewExpensesCommand(service, input),
                0, new ExitCommand()
        );
    }

    public void show() {
        System.out.println("\n=== Personal Finance Manager ===");
        while (true) {
            printOptions();
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            ICommand command = commands.get(option);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    private void printOptions() {
        System.out.println("""
                
                1. Add transaction
                2. Remove transaction
                3. View transactions
                4. View balance
                5. View income
                6. View expenses
                0. Exit
                """);
    }
}
