package dao;

import domain.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDao extends DaoFactory<Faculty, Integer> {
    private static final String SELECT_ALL_FACULTIES = "SELECT * FROM UNIVERSITY.FACULTY";
    private static final String SELECT_BY_ID = "SELECT * FROM UNIVERSITY.FACULTY WHERE facultyId = ?";
    private static final String UPDATE_FACULTY_QUERY ="UPDATE UNIVERSITY.FACULTY SET facultyName = ? WHERE facultyId = ?)";
    private static final String DELETE_FACULTY_QUERY = "DELETE FROM UNIVERSITY.FACULTY WHERE id = ?";
    private static final String CREATE_FACULTY_QUERY = "INSERT INTO UNIVERSITY.FACULTY (facultyId, facultyName)values (?,?)";

    public FacultyDao() {
        super();
    }

    @Override
    public List<Faculty> getAll() {
        List<Faculty> list = new ArrayList<Faculty>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_FACULTIES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyId(rs.getInt(1));
               faculty.setFacultyName(rs.getString(2));
                list.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

@Override
    public void update(Faculty faculty) {
        PreparedStatement ps = getPrepareStatement(UPDATE_FACULTY_QUERY);
        try{ ps.setInt(1, faculty.getFacultyId());
            ps.setString(2, faculty.getFacultyName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    public Faculty getFacultyById(Integer facultyId) {
        Faculty faculty = new Faculty();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_ID);
           try{ ps.setInt(1, facultyId);
            ResultSet rs = ps.executeQuery();
                faculty.setFacultyId(rs.getInt(1));
                faculty.setFacultyName(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return faculty;
    }

    @Override
    public void delete(Faculty faculty) {
        PreparedStatement ps = getPrepareStatement(DELETE_FACULTY_QUERY);
        try {
            ps.setInt(1, faculty.getFacultyId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    @Override
    public void create(Faculty faculty) {
        PreparedStatement ps = getPrepareStatement(CREATE_FACULTY_QUERY);
        try {
            ps.setInt(1, faculty.getFacultyId());
            ps.setString(2, faculty.getFacultyName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }
}
