package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // % ���� (��: 3.0)

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    // ���� ����: ���ڸ�ŭ deposit�� ���� �Ͽ� �Ա� �޽����� ��µǰ� ��
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        if (interest <= 0) return;
        super.deposit(interest);
        System.out.println("���� " + interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public String toString() {
        return "���¹�ȣ: " + getAccountNumber()
                + ", ������: " + getOwnerName()
                + ", �ܾ�: " + balance + "��"
                + ", ������: " + interestRate + "%";
    }
}