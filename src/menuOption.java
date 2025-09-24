import java.util.ArrayList;

public class menuOption {
    Account account = new Account();

    public static class Menu {
        ArrayList<Options> menuOption = new ArrayList<>();
        public Menu(ArrayList<Options> menuOptions) {
            System.out.println("Menu:\n Your options are:");
            this.menuOption = menuOptions;
        }
    }
}
