package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        SavingsAccount s1 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        CheckingAccount c1 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        SavingsAccount s2 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit(s1.getAccountNumber(), 5000.0);
            bank.withdraw(c1.getAccountNumber(), 3000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        s1.applyInterest(); // deposit �޽��� + '���� ����' �޽���

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(s2.getAccountNumber(), c1.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        bank.printAllAccounts();

        // ���� �ó�����
        try {
            bank.withdraw(c1.getAccountNumber(), 7000.0); // �ѵ� �ʰ�
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        try {
            bank.withdraw(c1.getAccountNumber(), 6000.0); // �ѵ� �ʰ�(�ٽ�)
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        try {
            bank.withdraw("AC9999", 1000.0); // ���� ����
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}