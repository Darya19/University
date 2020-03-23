package domain;

public class Faculty {
    private int facultyId;
    private String facultyName;

    public Faculty() {
    }

    public Faculty(int facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (facultyId != faculty.facultyId) return false;
        return facultyName != null ? facultyName.equals(faculty.facultyName) : faculty.facultyName == null;
    }

    @Override
    public int hashCode() {
        int result = facultyId;
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", name='" + facultyName + '\'' +
                '}';
    }
}
