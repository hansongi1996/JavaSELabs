package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
    private double withdrawalLimit; // 1회 출금 한도

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double limit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = limit;
    }

    public double getWithdrawalLimit() { return withdrawalLimit; }
    public void setWithdrawalLimit(double withdrawalLimit) { this.withdrawalLimit = withdrawalLimit; }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                "출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원"
            );
        }
        super.withdraw(amount); // 한도 통과 후 일반 출금 규칙 적용
    }

    @Override
    public String toString() {
        return "계좌번호: " + getAccountNumber()
                + ", 소유자: " + getOwnerName()
                + ", 잔액: " + balance + "원"
                + ", 출금 한도: " + withdrawalLimit + "원";
    }
}