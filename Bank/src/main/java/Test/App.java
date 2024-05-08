package Test;

import Test.Models.*;

import java.sql.SQLOutput;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        //проверка debitCard
        DebitCard debitCard1 = new DebitCard();

        System.out.println("(до использования дебит карты) " + debitCard1.showBalance());

        debitCard1.deposit(1000);
        System.out.println("(после внесения на дебит карту 1000) " + debitCard1.showBalance());
        System.out.println();

        //проверка creditCard
        CreditCard creditCard1 = new CreditCard(10000);

        System.out.println("(до использования кредитной карты) " + creditCard1.showBalance());
        System.out.println(creditCard1.showAvailableFunds());
        System.out.println();

        creditCard1.deposit(1000);
        System.out.println("(после внесения на кредитную карту 1000) " + creditCard1.showBalance());
        System.out.println(creditCard1.showAvailableFunds());
        System.out.println();

        creditCard1.pay(2000.22);
        System.out.println("(после оплаты с кредитной карты 2000.22) " + creditCard1.showBalance());
        System.out.println(creditCard1.showAvailableFunds());
        System.out.println();

        creditCard1.deposit(2000.22);
        System.out.println("(после внесения на кредитную карту 2000.22) " + creditCard1.showAvailableFunds());
        System.out.println();

        //проверка whiteDebitCard c Накоплением в размере 0.005% от суммы пополнений
        WhiteDebitCard whiteDebitCard = new WhiteDebitCard();
        System.out.println("(начальный баланс whiteDebitCard) " + whiteDebitCard.showBalance());
        whiteDebitCard.deposit(5000);
        System.out.println("(пополняем на 5000 и получаем к балансу дополнительно 0,25р.) " + whiteDebitCard.showBalance());
        System.out.println();

        //проверка greenDebitCard c "Бонусные баллы в размере 1% от покупок"
        GreenDebitCard greenDebitCard = new GreenDebitCard();
        System.out.println("(начальный баланс greenDebitCard) " + greenDebitCard.showBalance());
        greenDebitCard.deposit(5000);
        greenDebitCard.pay(1000);
        System.out.println("(пополняем на 5000, тратим 1000 и получаем бонусные баллы в размере 1% от покупок) " + greenDebitCard.showAvailableFunds());
        System.out.println();

        //проверка yellowCreditCard c "Условный кэшбэк 5% от покупок при условии трат больше 5 000 тыс."
        YellowCreditCard yellowCreditCard = new YellowCreditCard(10000);
        System.out.println("(начальный баланс yellowCreditCard) " + yellowCreditCard.showBalance());
        System.out.println(yellowCreditCard.showAvailableFunds());
        yellowCreditCard.deposit(5500);
        yellowCreditCard.pay(5500);
        System.out.println("(пополняем на 5500, тратим 5500 и получаем кэшбэк 5% от покупок) " + yellowCreditCard.showAvailableFunds());
        System.out.println();
    }
}
