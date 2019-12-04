public class ThreadOne extends Thread {

    private volatile boolean isTopUp = true;
    private int amount;


    public ThreadOne(int amount){
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
                    System.out.println("Thread One > Add money > amount: " + BankAccount.getCash() + "Count > " + BankAccount.getCount());

                } else {
                    BankAccount.setCash(BankAccount.getCash() - amount);
                    System.out.println("Thread One > Withdraw money > amount: " + BankAccount.getCash() + "Count > " + BankAccount.getCount());
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
