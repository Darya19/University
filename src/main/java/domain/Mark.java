package domain;

public class Mark {
    private int studentCode;
    private int subjectId;
    private int mark;

    public Mark() {
    }

    public Mark(int studentCode, int subjectId, int mark) {
        this.studentCode = studentCode;
        this.subjectId = subjectId;
        this.mark = mark;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (studentCode != mark1.studentCode) return false;
        if (subjectId != mark1.subjectId) return false;
        return mark == mark1.mark;
    }

    @Override
    public int hashCode() {
        int result = studentCode;
        result = 31 * result + subjectId;
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "studentCode=" + studentCode +
                ", subjectId=" + subjectId +
                ", mark=" + mark +
                '}';
    }
}
