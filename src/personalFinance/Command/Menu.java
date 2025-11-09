package personalFinance.Command;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, ICommand> commands;
    private final Scanner input;

    public Menu(Map<Integer, ICommand> commands, Scanner input) {
        this.commands = commands;
        this.input = input;
    }

    public void show() {
        while (true) {
            printOptions();
            int option = input.nextInt();
            input.nextLine();

            ICommand command = commands.get(option);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid option!");
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