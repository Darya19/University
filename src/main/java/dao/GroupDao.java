package dao;

import domain.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao extends DaoFactory<Group, Integer> {
    private static final String SELECT_ALL_GROUPS = "SELECT * FROM UNIVERSITY.GROUP";
    private static final String SELECT_BY_GROUPID = "SELECT * FROM UNIVERSITY.GROUP WHERE groupId = ?";
    private static final String SELECT_BY_FACULTYID = "SELECT * FROM UNIVERSITY.GROUP WHERE facultyId = ?";
    private static final String UPDATE_GROUP_QUERY ="UPDATE UNIVERSITY.GROUP SET groupName = ?, facultyId = ? WHERE groupId = ?)";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM UNIVERSITY.GROUP WHERE groupId = ?";
    private static final String CREATE_GROUP_QUERY = "INSERT INTO UNIVERSITY.GROUP (groupId, groupName, facultyId)values (?,?,?)";

    public GroupDao() {
        super();
    }

    @Override
    public List<Group> getAll() {
        List<Group> list = new ArrayList<Group>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_GROUPS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setGroupId(rs.getInt(1));
                group.setGroupName(rs.getString(2));
                group.setFacultyId(rs.getInt(3));
                list.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

@Override
    public void update(Group group) {
        PreparedStatement ps = getPrepareStatement(UPDATE_GROUP_QUERY);
        try{ ps.setInt(1, group.getGroupId());
            ps.setString(2, group.getGroupName());
            ps.setInt(3, group.getFacultyId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }


    public Group getGroupByGroupId(Integer groupId) {
        Group group = new Group();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_GROUPID);
        try{ ps.setInt(1, groupId);
            ResultSet rs = ps.executeQuery();
            group.setGroupId(rs.getInt(1));
            group.setGroupName(rs.getString(2));
            group.setFacultyId(rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return group;
    }

    public List<Group> getGroupsByFacultyId(Integer FacultyId) {
        List<Group> list = new ArrayList<Group>();
        PreparedStatement ps = getPrepareStatement(SELECT_BY_FACULTYID);
        try{ ps.setInt(1, FacultyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setGroupId(rs.getInt(1));
                group.setGroupName(rs.getString(2));
                group.setFacultyId(rs.getInt(3));
                list.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return list;
    }

    @Override
    public void delete(Group group) {
        PreparedStatement ps = getPrepareStatement(DELETE_GROUP_QUERY);
        try {
            ps.setInt(1, group.getGroupId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }

    @Override
    public void create(Group group) {
        PreparedStatement ps = getPrepareStatement(CREATE_GROUP_QUERY);
        try {
            ps.setInt(1, group.getGroupId());
            ps.setString(2, group.getGroupName());
            ps.setInt(3, group.getFacultyId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
    }
}
