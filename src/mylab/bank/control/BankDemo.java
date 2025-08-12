package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        SavingsAccount s1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        CheckingAccount c1 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        SavingsAccount s2 = bank.createSavingsAccount("이영희", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(s1.getAccountNumber(), 5000.0);
            bank.withdraw(c1.getAccountNumber(), 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        s1.applyInterest(); // deposit 메시지 + '이자 적용' 메시지

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(s2.getAccountNumber(), c1.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.printAllAccounts();

        // 예외 시나리오
        try {
            bank.withdraw(c1.getAccountNumber(), 7000.0); // 한도 초과
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.withdraw(c1.getAccountNumber(), 6000.0); // 한도 초과(다시)
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.withdraw("AC9999", 1000.0); // 없는 계좌
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}