package project.frames.customers_frames;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersDB {

public static Connection dbConn;
public static Connection getConnection() {

    Connection conn = null;
    try {
        String url = "";
        Class.forName("com.mysql.cj.jdbc.Driver");        
        conn = DriverManager.getConnection(url);

        System.out.println("Database 연결 성공");

    } catch (Exception e) {
        System.out.println("Database 연결 실패");
        e.printStackTrace();
    }
    return conn;     
}

public static void close(PreparedStatement stmt, Connection conn) {
    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }

    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
    if (rs != null) {
        try {
            if (!rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }
    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void main(String[] args) {
    getConnection();
  }
}
