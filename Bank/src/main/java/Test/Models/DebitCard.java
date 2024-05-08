package Test.Models;

public class DebitCard extends BankCard {

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public boolean pay(double amount) throws Exception {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }

        throw new Exception("На балансе недостаточно средств");

    }

    @Override
    public String showBalance() {
        return "Баланс = " + Math.round(this.balance * 100.0) / 100.0;

    }

}
