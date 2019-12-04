public class ThreadTwo extends Thread {
    private volatile boolean isTopUp = false;
    private int amount;

    public ThreadTwo(int amount){
        this.amount = amount;
    }

    public void change(){
        isTopUp = !isTopUp;
    }

    @Override
    public void run() {
        do{
            if (!Thread.interrupted()){
                if (isTopUp) {
                    BankAccount.setCash(BankAccount.getCash() + amount);
                    System.out.println("Thread Two > Add money > amount: " + BankAccount.getCash() + "Count > " + BankAccount.getCount());
                } else {
                    BankAccount.setCash(BankAccount.getCash() - amount);
                    System.out.println("Thread Two > Withdraw money > amount: " + BankAccount.getCash() + "Count > " + BankAccount.getCount());
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
