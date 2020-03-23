package dao;

import domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends DaoFactory<Student, Integer> {
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM UNIVERSITY.STUDENT";
    private static final String SELECT_BY_STUDENTCODE = "SELECT * FROM UNIVERSITY.STUDENT WHERE studentCode = ?";
    private static final String SELECT_BY_GROUPID = "SELECT * FROM UNIVERSITY.STUDENT WHERE groupId = ?";
    private static final String UPDATE_STUDENT_QUERY ="UPDATE UNIVERSITY.STUDENT SET groupId = ?, LastName = ?, firstName = ? WHERE studentCode = ?)";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM UNIVERSITY.STUDENT WHERE studentCode = ?";
    private static final String CREATE_STUDENT_QUERY = "INSERT INTO UNIVERSITY.STUDENT (studentCode, groupId, lastName, firstName)values (?,?,?,?)";

    public StudentDao() {
        super();
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<Student>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_STUDENTS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentCode(rs.getInt(1));
                student.setGroupId(rs.getInt(2));
                student.setLastName(rs.getString(3));
                student.setFirstName(rs.getString(4));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

 @Override
    public void update(Student student) {
        PreparedStatement ps = getPrepareStatement(UPDATE_STUDENT_QUERY);
        try{ps.setInt(1, student.getStudentCode());
            ps.setInt(2, student.getGroupId());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getFirstName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    public Student getStudentByStudentCode(Integer studentCode) {
        Student student = new Student();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_STUDENTCODE);
        try{ ps.setInt(1, studentCode);
            ResultSet rs = ps.executeQuery();
            student.setStudentCode(rs.getInt(1));
            student.setGroupId(rs.getInt(2));
            student.setLastName(rs.getString(3));
            student.setFirstName(rs.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return student;
    }

    public List<Student> getStudentsByGroupId(Integer groupId) {
        List<Student> list = new ArrayList<Student>();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_GROUPID);
        try{ ps.setInt(1, groupId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentCode(rs.getInt(1));
                student.setGroupId(rs.getInt(2));
                student.setLastName(rs.getString(3));
                student.setFirstName(rs.getString(4));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

    @Override
    public void delete(Student student) {
        PreparedStatement ps = getPrepareStatement(DELETE_STUDENT_QUERY);
        try {
            ps.setInt(1, student.getStudentCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    @Override
    public void create(Student student) {
        PreparedStatement ps = getPrepareStatement(CREATE_STUDENT_QUERY);
        try {ps.setInt(1, student.getStudentCode());
            ps.setInt(2, student.getGroupId());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getFirstName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }
}
