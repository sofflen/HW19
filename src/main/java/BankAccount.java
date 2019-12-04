public class BankAccount {

    private static int cash;

    public static int getCash() {
        return cash;
    }

    public static void setCash(int cash) {
        BankAccount.cash = cash;
    }

    public BankAccount(int cash) {
        BankAccount.cash = cash;
    }
}
