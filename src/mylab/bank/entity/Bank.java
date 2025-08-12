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

    // ���� ����
    public SavingsAccount createSavingsAccount(String owner, double initial, double rate) {
        SavingsAccount acc = new SavingsAccount(generateAccountNumber(), owner, initial, rate);
        accounts.add(acc);
        System.out.println("���� ���°� �����Ǿ����ϴ�: " + acc);
        return acc;
    }

    public CheckingAccount createCheckingAccount(String owner, double initial, double limit) {
        CheckingAccount acc = new CheckingAccount(generateAccountNumber(), owner, initial, limit);
        accounts.add(acc);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + acc);
        return acc;
    }

    // ���� ã��
    public Account findByNumber(String accountNumber) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) return a;
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }

    // �Ա�/���/��ü
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
        src.withdraw(amount);   // ��� �޽��� ���
        dst.deposit(amount);    // �Ա� �޽��� ���
        System.out.println(amount + "���� " + from + "���� " + to + "�� �۱ݵǾ����ϴ�.");
    }

    // ���/���
    public void printAllAccounts() {
        System.out.println("\n=== ��� ���� ��� ===");
        for (Account a : accounts) System.out.println(a);
        System.out.println("===================");
    }

    public List<Account> getAccounts() { return accounts; } // �ʿ�� ���
}