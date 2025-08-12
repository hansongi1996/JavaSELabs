package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    private final String accountNumber;   // AC1000 ���� ��ȣ
    private final String ownerName;       // ������
    protected double balance;             // �ܾ� (��ȣ: ����Ŭ�������� ���)

    protected Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // ĸ��ȭ: �ʿ��� �����ڸ�
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    // �Ա�
    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
        System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    // ���(���� ��Ģ: �ܾ� �����̸� ����)
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) return;
        if (amount > balance) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + balance + "��");
        }
        balance -= amount;
        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    // �� Ÿ�Ժ� ��� ������ ����Ŭ��������
    @Override
    public abstract String toString();
}