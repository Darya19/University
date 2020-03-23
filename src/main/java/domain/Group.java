package domain;

public class Group {
    private int groupId;
    private String groupName;
    private int facultyId;

    public Group() {
    }

    public Group(int groupId, String groupName, int facultyId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.facultyId = facultyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (groupId != group.groupId) return false;
        if (facultyId != group.facultyId) return false;
        return groupName != null ? groupName.equals(group.groupName) : group.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + facultyId;
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + groupName + '\'' +
                ", facultyId=" + facultyId +
                '}';
    }
}
