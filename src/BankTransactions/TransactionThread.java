package BankTransactions;

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
