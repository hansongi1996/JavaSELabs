package mylab.student.exception;

/** 학년 범위를 벗어나면 던질 사용자 정의 예외 */
public class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}