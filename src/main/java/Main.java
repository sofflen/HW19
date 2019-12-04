public class Main {
    static ThreadOne thread1;
    static ThreadTwo thread2;

    public static void main(String[] args) throws InterruptedException {
        thread1 = new ThreadOne(50);
        thread2 = new ThreadTwo(25);
        BankAccount.setCash(150);

        thread1.start();
        thread2.start();

        for (int i = 1; i < 3; i++) {
            try {
                Thread.sleep(i * 2 * 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1.change();
            Thread.sleep(1000);
            thread2.change();
        }

        thread2.interrupt();
        Thread.sleep(1000);
        thread1.interrupt();

    }
}
