package Test.Models;

public abstract class BankCard {
    protected double balance;

    public void deposit(double amount) {
        this.balance += amount;
    }

    public abstract boolean pay(double amount) throws Exception;

    public abstract String showBalance();

    public String showAvailableFunds() {
        return showBalance();
    }
}
