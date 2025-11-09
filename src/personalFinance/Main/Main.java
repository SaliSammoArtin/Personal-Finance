package personalFinance.Main;

import personalFinance.Command.Menu;
import personalFinance.Repository.FileAccountRepository;
import personalFinance.Repository.IAccountRepository;
import personalFinance.Service.AccountService;

public class Main {
    public static void main(String[] args) {
        IAccountRepository repository = new FileAccountRepository("transactions.txt");
        AccountService service = new AccountService(repository);

        Menu menu = new Menu(service);
        menu.show();
    }
}
