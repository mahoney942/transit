package Test.Models;

public class WhiteDebitCard extends DebitCard {
    @Override
    public void deposit(double amount) {
        super.deposit(amount);

        // Накопление в размере 0.005% от суммы пополнений.
        double bonus = amount * 0.00005;
        this.balance += bonus;
    }

    @Override
    public boolean pay(double amount) throws Exception {
        return super.pay(amount);
    }

    @Override
    public String showBalance() {
        return super.showBalance();
    }

    @Override
    public String showAvailableFunds() {
        return super.showAvailableFunds();
    }
}
