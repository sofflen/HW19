public class BankAccount {

    private static int cash;
    private static int count = 0;

    public static int getCount() {
        synchronized (BankAccount.class) {
            return count++;
        }
    }

    public static int getCash() {
        synchronized (BankAccount.class){
            return cash;
        }
    }

    public static void setCash(int cash) {
        synchronized (BankAccount.class) {
            BankAccount.cash = cash;
        }
    }

    public BankAccount(int cash) {
        BankAccount.cash = cash;
    }
}
