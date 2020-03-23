package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DaoFactory<E, K> {
    public static Connection connection;

    public DaoFactory() {
        try {
            String host = "jdbc:mysql://localhost:3306/dasha"+
            "?verifyServerCertificate=false"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "allowPublicKeyRetrieval=true&amp"+
                    "&serverTimezone=UTC";
            String uName = "root";
            String uPass = "1234";
            connection = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
    public abstract List<E> getAll();
    public abstract void update(E entity);
    public abstract void delete(E entity);
    public abstract void create(E entity);

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
