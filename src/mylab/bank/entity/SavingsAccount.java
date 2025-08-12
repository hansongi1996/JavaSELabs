package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // % 단위 (예: 3.0)

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    // 이자 적용: 이자만큼 deposit을 먼저 하여 입금 메시지도 출력되게 함
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        if (interest <= 0) return;
        super.deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return "계좌번호: " + getAccountNumber()
                + ", 소유자: " + getOwnerName()
                + ", 잔액: " + balance + "원"
                + ", 이자율: " + interestRate + "%";
    }
}