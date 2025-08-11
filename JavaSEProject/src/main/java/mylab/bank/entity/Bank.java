package mylab.bank.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import mylab.bank.exception.AccountNotFoundException;

public class Bank {
    private final Map<String, Account> accounts = new LinkedHashMap<>();
    private int seq = 1000; // AC1000부터

    /* 생성기 */
    public SavingsAccount createSavingsAccount(String owner, double initBalance, double interestRate) {
        String no = nextNo();
        SavingsAccount acc = new SavingsAccount(no, owner, initBalance, interestRate);
        accounts.put(no, acc);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc.toString());
        return acc;
    }

    public CheckingAccount createCheckingAccount(String owner, double initBalance, double withdrawLimit) {
        String no = nextNo();
        CheckingAccount acc = new CheckingAccount(no, owner, initBalance, withdrawLimit);
        accounts.put(no, acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc.toString());
        return acc;
    }

    /* 기본 기능 */
    public void deposit(String accountNumber, double amount) {
        Account a = findAccount(accountNumber);
        a.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account a = findAccount(accountNumber);
        a.withdraw(amount);
    }

    public void transfer(String from, String to, double amount) {
        Account src = findAccount(from);
        Account dst = findAccount(to);
        src.withdraw(amount);
        dst.deposit(amount);
        System.out.println(amount + "원이 " + from + "에서 " + to + "로 송금되었습니다.");
    }

    public Account findAccount(String accountNumber) {
        Account a = accounts.get(accountNumber);
        if (a == null) throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
        return a;
    }

    public void printAllAccounts() {
        System.out.println("\n=== 모든 계좌 목록 ===");
        for (Account a : accounts.values()) {
            System.out.println(a.toString());
        }
        System.out.println("===================");
    }

    /* 내부 */
    private String nextNo() {
        return "AC" + (seq++);
    }
}
