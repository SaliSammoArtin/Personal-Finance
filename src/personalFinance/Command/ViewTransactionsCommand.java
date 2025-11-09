package personalFinance.Command;

import personalFinance.Service.AccountService;

public class ViewTransactionsCommand implements ICommand {

    private final AccountService service;

    public ViewTransactionsCommand(AccountService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        var transactions = service.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transactions:");
            transactions.forEach(System.out::println);
        }
    }
}