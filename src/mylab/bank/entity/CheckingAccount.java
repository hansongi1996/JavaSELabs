package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
    private double withdrawalLimit; // 1ȸ ��� �ѵ�

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
                "��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��"
            );
        }
        super.withdraw(amount); // �ѵ� ��� �� �Ϲ� ��� ��Ģ ����
    }

    @Override
    public String toString() {
        return "���¹�ȣ: " + getAccountNumber()
                + ", ������: " + getOwnerName()
                + ", �ܾ�: " + balance + "��"
                + ", ��� �ѵ�: " + withdrawalLimit + "��";
    }
}