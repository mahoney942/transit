package Test.Models;

import java.text.DecimalFormat;

public class CreditCard extends BankCard {
    private double creditLimit;
    private double currentDebt;
    private double ownFunds;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.currentDebt = 0;
        this.ownFunds = 0;

        updateBalance();
    }

    @Override
    public void deposit(double amount) {
        if (this.currentDebt > 0) {
            if (amount <= this.currentDebt) {
                this.currentDebt -= amount;
            } else {
                this.ownFunds += amount - this.currentDebt;
                this.currentDebt = 0;
            }
        } else {
            this.ownFunds += amount;
        }
        updateBalance();
    }

    @Override
    public boolean pay(double amount) throws Exception {
        if (this.balance < amount) {
            throw new Exception("На балансе недостаточно средств");
        }

        if (amount <= this.ownFunds) {
            this.ownFunds -= amount;

        } else {
            double remainingAmount = amount - this.ownFunds;
            this.ownFunds = 0;
            this.currentDebt += remainingAmount;
        }

        updateBalance();
        return true;
    }

    @Override
    public String showBalance() {
        return "Баланс = " + this.balance;
    }

    @Override
    public String showAvailableFunds() {
        return "Баланс = " + this.balance + ", из них Собственные средства = " + this.ownFunds + ", Кредитные средства = " + (Math.round((this.creditLimit - this.currentDebt) * 100.0) / 100.0) + " , Кредитный лимит = " + this.creditLimit;

    }

    private void updateBalance() {
        double notRoundedBalance = this.ownFunds + (this.creditLimit - this.currentDebt);

        this.balance = Math.round(notRoundedBalance * 100.0) / 100.0;
        this.ownFunds = Math.round(this.ownFunds * 100.0) / 100.0;

    }
}
