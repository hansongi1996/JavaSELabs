package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // getter / setter (studentId, name, major)
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    // grade: 1~4�� ���, �ƴϸ� ����
    public int getGrade() { return grade; }
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 1 || grade > 4) {
            throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�.");
        }
        this.grade = grade;
    }
}