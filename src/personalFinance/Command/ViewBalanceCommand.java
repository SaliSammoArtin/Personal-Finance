package personalFinance.Command;

import personalFinance.Service.AccountService;

public class ViewBalanceCommand implements ICommand {

    private final AccountService service;

    public ViewBalanceCommand(AccountService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        double balance = service.getBalance();
        System.out.println("Current balance: " + balance);
    }
}

