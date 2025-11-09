package personalFinance.Command;

public class ExitCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}

