package mylab.bank.exception;

// �䱸����: �ܾ׺��� ���ܸ� ���
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) { super(message); }
}