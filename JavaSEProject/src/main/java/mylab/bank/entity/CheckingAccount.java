package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
    private double withdrawLimit; // 1회 출금 한도(원)

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawLimit = withdrawLimit;
    }

    public double getWithdrawLimit() { return withdrawLimit; }
    public void setWithdrawLimit(double withdrawLimit) { this.withdrawLimit = withdrawLimit; }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
        if (amount > withdrawLimit)
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawLimit + "원");
        if (amount > getBalance())
            throw new InsufficientBalanceException("잔액 부족");
        setBalance(getBalance() - amount);
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + getBalance() + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 출금 한도: " + withdrawLimit + "원";
    }
}
