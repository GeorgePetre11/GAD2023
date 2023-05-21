package BankTransactions;

public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        balance -= amount;
        System.out.println(name + " withdrew $" + amount + ". New balance: $" + balance);
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount.");
        }
        balance += amount;
        System.out.println(name + " deposited $" + amount + ". New balance: $" + balance);
    }
}

public class TransactionThread extends Thread {
    private String name;
    private BankAccount from;
    private BankAccount to;
    private double amount;

    public TransactionThread(String name, BankAccount from, BankAccount to, double amount) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(name + " is transferring $" + amount + " from " + from.getName() + " to " + to.getName());
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(name + " has completed the transfer.");
    }
}
    BankAccount account1 = new BankAccount("Alice", 1000.0);
    BankAccount account2 = new BankAccount("Bob", 500.0);

    Thread thread1 = new TransactionThread("Thread 1", account1, account2, 250.0);
    Thread thread2 = new TransactionThread("Thread 2", account2, account1, 100.0);
}

public static void main(String[] args) {thread1.start();
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