public class ThreadTwo extends Thread {
    private volatile boolean isTopUp = false;
    private int amount;

    public ThreadTwo(int amount) {
        this.amount = amount;
    }

    public void change() {
        isTopUp = !isTopUp;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                synchronized (BankAccount.class) {
                    if (isTopUp) {
                        BankAccount.setCash(BankAccount.getCash() + amount);
                        System.out.println("Thread Two > Add money > amount: " + BankAccount.getCash());
                    } else {
                        BankAccount.setCash(BankAccount.getCash() - amount);
                        System.out.println("Thread Two > Withdraw money > amount: " + BankAccount.getCash());
                    }
                }
            } else
                return;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}
