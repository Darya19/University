package dao;

import domain.Mark;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkDao extends DaoFactory<Mark, Integer> {
    private static final String SELECT_ALL_MARKS = "SELECT * FROM UNIVERSITY.MARK";
    private static final String SELECT_BY_STUDENTCODE = "SELECT * FROM UNIVERSITY.MARK WHERE studentCode = ?";
    private static final String SELECT_BY_SUBJECTID = "SELECT * FROM UNIVERSITY.MARK WHERE subjectId = ?";
    private static final String UPDATE_MARK_QUERY ="UPDATE UNIVERSITY.MARK SET subjectId = ?, mark = ? WHERE studentCode = ?)";
    private static final String DELETE_MARK_QUERY = "DELETE FROM UNIVERSITY.MARK WHERE studentCode = ?";
    private static final String CREATE_MARK_QUERY = "INSERT INTO UNIVERSITY.MARK (studentCode, subjectId, mark)values (?,?,?)";

    public MarkDao() {
        super();
    }

    @Override
    public List<Mark> getAll() {
        List<Mark> list = new ArrayList<Mark>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_MARKS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setStudentCode(rs.getInt(1));
                mark.setSubjectId(rs.getInt(2));
                mark.setMark(rs.getInt(3));
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

    @Override
    public void update(Mark mark) {
        PreparedStatement ps = getPrepareStatement(UPDATE_MARK_QUERY);
        try{ps.setInt(1, mark.getStudentCode());
            ps.setInt(2, mark.getSubjectId());
            ps.setInt(3, mark.getMark());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    public  List<Mark> getMarksByStudentCode(Integer studentCode) {
        List<Mark> list = new ArrayList<Mark>();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_STUDENTCODE);
        try{ ps.setInt(1, studentCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              Mark mark = new Mark();
            mark.setStudentCode(rs.getInt(1));
            mark.setSubjectId(rs.getInt(2));
            mark.setMark(rs.getInt(3));
            list.add(mark);}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

    public  List<Mark> getMarksBySubjectId(Integer subjectId) {
        List<Mark> list = new ArrayList<Mark>();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_SUBJECTID);
        try{ ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setStudentCode(rs.getInt(1));
                mark.setSubjectId(rs.getInt(2));
                mark.setMark(rs.getInt(3));
                list.add(mark);}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

    public void delete(Mark mark) {
        PreparedStatement ps = getPrepareStatement(DELETE_MARK_QUERY);
        try {
            ps.setInt(1, mark.getStudentCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    public void create(Mark mark) {
        PreparedStatement ps = getPrepareStatement(CREATE_MARK_QUERY);
        try {ps.setInt(1, mark.getStudentCode());
            ps.setInt(2, mark.getSubjectId());
            ps.setInt(3, mark.getMark());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }
}
