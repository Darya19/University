package domain;

public class Student {
    private int studentCode;
    private int groupId;
    private String lastName;
    private String firstName;

    public Student() {
    }

    public Student(int studentCode, int groupId, String lastName, String firstName) {
        this.studentCode = studentCode;
        this.groupId = groupId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentCode != student.studentCode) return false;
        if (groupId != student.groupId) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        return firstName != null ? firstName.equals(student.firstName) : student.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = studentCode;
        result = 31 * result + groupId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode=" + studentCode +
                ", groupId=" + groupId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
