package Test.Models;

public class YellowCreditCard extends CreditCard {
    public YellowCreditCard(double creditLimit) {
        super(creditLimit);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public boolean pay(double amount) throws Exception {
        //Условный кэшбэк 5% от покупок при условии трат больше 5 000 тыс.
        if (this.balance >= amount && amount > 5000)
            deposit(amount * 0.05);

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
