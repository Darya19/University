package dao;

import domain.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao extends DaoFactory<Subject, Integer> {
        private static final String SELECT_ALL_SUBJECTS = "SELECT * FROM UNIVERSITY.SUBJECT";
        private static final String SELECT_BY_ID = "SELECT * FROM UNIVERSITY.SUBJECT WHERE subjectId = ?";
        private static final String UPDATE_SUBJECT_QUERY ="UPDATE UNIVERSITY.SUBJECT SET subjectName = ? WHERE subjectId = ?)";
        private static final String DELETE_SUBJECT_QUERY = "DELETE FROM UNIVERSITY.SUBJECT WHERE subjectId = ?";
        private static final String CREATE_SUBJECT_QUERY = "INSERT INTO UNIVERSITY.SUBJECT (subjectId, subjectName)values (?,?)";

    public SubjectDao() {
            super();
        }

        @Override
        public List<Subject> getAll() {
            List<Subject> list = new ArrayList<Subject>();
            PreparedStatement ps = getPrepareStatement(SELECT_ALL_SUBJECTS);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(rs.getInt(1));
                    subject.setSubjectName(rs.getString(2));
                    list.add(subject);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closePrepareStatement(ps);
            }
            return list;
        }

        @Override
        public void update(Subject subject) {
            PreparedStatement ps = getPrepareStatement(UPDATE_SUBJECT_QUERY);
            try{ps.setInt(1, subject.getSubjectId());
                ps.setString(2, subject.getSubjectName());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closePrepareStatement(ps);
            }
        }

        public Subject getSubjectById(Integer subjectId) {
            Subject subject = new Subject();
            PreparedStatement ps = getPrepareStatement(SELECT_BY_ID);
            try{ ps.setInt(1, subjectId);
                ResultSet rs = ps.executeQuery();
                subject.setSubjectId(rs.getInt(1));
                subject.setSubjectName(rs.getString(2));

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closePrepareStatement(ps);
            }
            return subject;
        }
@Override
        public void delete(Subject subject) {
            PreparedStatement ps = getPrepareStatement(DELETE_SUBJECT_QUERY);
            try {
                ps.setInt(1, subject.getSubjectId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closePrepareStatement(ps);
            }
        }
@Override
        public void create(Subject subject) {
            PreparedStatement ps = getPrepareStatement(CREATE_SUBJECT_QUERY);
            try {ps.setInt(1, subject.getSubjectId());
                ps.setString(2, subject.getSubjectName());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closePrepareStatement(ps);
            }
        }
}
