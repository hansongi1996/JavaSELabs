package mylab.bank.exception;

// 요구사항: 잔액부족 예외를 상속
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) { super(message); }
}