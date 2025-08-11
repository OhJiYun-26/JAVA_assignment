package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // === 계좌 생성 ===
        System.out.println("=== 계좌 생성 ===");
        SavingsAccount ac1000 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        CheckingAccount ac1001 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        SavingsAccount ac1002 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
        System.out.println();

        // === 모든 계좌 목록 ===
        bank.printAllAccounts();

        // === 입금/출금 테스트 ===
        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(ac1000.getAccountNumber(), 5000.0); // 10000 -> 15000
            bank.withdraw(ac1001.getAccountNumber(), 3000.0); // 20000 -> 17000
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // === 이자 적용 테스트 ===
        System.out.println("\n=== 이자 적용 테스트 ===");
        ac1000.applyInterest(); // 15000의 3% = 450 입금

        // === 계좌 이체 테스트 ===
        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(ac1002.getAccountNumber(), ac1001.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // === 모든 계좌 목록 === (최종)
        System.out.println();
        bank.printAllAccounts();

        // === 예외 처리 테스트 ===
        try {
            bank.withdraw(ac1001.getAccountNumber(), 6000.0); // 한도 초과
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw(ac1001.getAccountNumber(), 8000.0); // 한도 초과 (다시)
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999"); // 존재하지 않는 계좌
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
