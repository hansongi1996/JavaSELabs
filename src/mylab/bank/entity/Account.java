package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    private final String accountNumber;   // AC1000 같은 번호
    private final String ownerName;       // 소유자
    protected double balance;             // 잔액 (보호: 하위클래스에서 사용)

    protected Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // 캡슐화: 필요한 접근자만
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    // 입금
    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    // 출금(공통 규칙: 잔액 부족이면 예외)
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) return;
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    // 각 타입별 출력 포맷은 하위클래스에서
    @Override
    public abstract String toString();
}