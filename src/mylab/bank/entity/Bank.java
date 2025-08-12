package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private final List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    private String generateAccountNumber() {
        return "AC" + (nextAccountNumber++);
    }

    // 계좌 생성
    public SavingsAccount createSavingsAccount(String owner, double initial, double rate) {
        SavingsAccount acc = new SavingsAccount(generateAccountNumber(), owner, initial, rate);
        accounts.add(acc);
        System.out.println("저축 계좌가 생성되었습니다: " + acc);
        return acc;
    }

    public CheckingAccount createCheckingAccount(String owner, double initial, double limit) {
        CheckingAccount acc = new CheckingAccount(generateAccountNumber(), owner, initial, limit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
        return acc;
    }

    // 계좌 찾기
    public Account findByNumber(String accountNumber) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) return a;
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 입금/출금/이체
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findByNumber(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findByNumber(accountNumber).withdraw(amount);
    }

    public void transfer(String from, String to, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account src = findByNumber(from);
        Account dst = findByNumber(to);
        src.withdraw(amount);   // 출금 메시지 출력
        dst.deposit(amount);    // 입금 메시지 출력
        System.out.println(amount + "원이 " + from + "에서 " + to + "로 송금되었습니다.");
    }

    // 출력/통계
    public void printAllAccounts() {
        System.out.println("\n=== 모든 계좌 목록 ===");
        for (Account a : accounts) System.out.println(a);
        System.out.println("===================");
    }

    public List<Account> getAccounts() { return accounts; } // 필요시 사용
}