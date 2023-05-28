package BankTransactions;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);

        Thread thread1 = new TransactionThread("Thread 1", account1, account2, 250.0);
        Thread thread2 = new TransactionThread("Thread 2", account2, account1, 100.0);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balances:");
        System.out.println(account1.getName() + ": $" + account1.getBalance());
        System.out.println(account2.getName() + ": $" + account2.getBalance());
    }
}
