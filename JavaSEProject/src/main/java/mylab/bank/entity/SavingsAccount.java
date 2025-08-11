package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // 예: 3.0 = 3%

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public void applyInterest() {
        double interest = Math.floor(getBalance() * (interestRate / 100.0) * 100) / 100.0;
        if (interest > 0) {
            deposit(interest);
            System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}
