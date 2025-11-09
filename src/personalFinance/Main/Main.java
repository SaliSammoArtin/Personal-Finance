package personalFinance.Main;

import personalFinance.Repository.FileAccountRepository;
import personalFinance.Repository.IAccountRepository;
import personalFinance.Service.AccountService;

import personalFinance.Command.*;
import personalFinance.Model.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IAccountRepository repo = new FileAccountRepository("transactions.txt");
        AccountService service = new AccountService(repo);
        Scanner input = new Scanner(System.in);

        Map<Integer, ICommand> commands = Map.of(
                1, new AddTransactionCommand(service, input),
                2, new RemoveTransactionCommand(service, input),
                3, new ViewTransactionsCommand(service),
                4, new ViewBalanceCommand(service),
                5, new ViewIncomeCommand(service, input),
                6, new ViewExpensesCommand(service, input),
                0, new ExitCommand()
        );

        Menu menu = new Menu(ICommand, input);
        menu.show();
    }
}