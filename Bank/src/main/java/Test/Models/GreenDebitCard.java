package Test.Models;

public class GreenDebitCard extends DebitCard {

    private int bonusPoint;

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public boolean pay(double amount) throws Exception {
        if (this.balance < amount) {
            throw new Exception("На  балансе недостаточно средств");
        }

        this.balance -= amount;
        //Бонусные баллы в размере 1% от покупок
        this.bonusPoint = (int) (amount * 0.01);

        return true;
    }

    @Override
    public String showBalance() {
        return super.showBalance();
    }

    @Override
    public String showAvailableFunds() {
        return "Баланс = " + Math.round(this.balance * 100.0) / 100.0 + ", бонусные баллы = " + this.bonusPoint;
    }
}
