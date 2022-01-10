package project.frames.customers_frames.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CustomersDAO {

private Connection conn = null;
private PreparedStatement stmt = null;
private ResultSet rs = null;

private final String LOGIN = "select * from management where id = ? and password = ?";
private final String INSERT = "insert into management(seq,id,password,name,gender,tel,email,createdate) "
        + "values((select ifnull(max(seq),0)+1 from management as a),?,?,?,?,?,?,NOW())";
private final String LIST = "select * from management";


private CustomersDAO() {}
private static CustomersDAO instance = new CustomersDAO();

public static CustomersDAO getInstance() {
    return instance;
}


public int insertMember(CustomersDTO mdto) {

    conn = CustomersDB.getConnection();

    try {
        stmt = conn.prepareStatement(INSERT);

        stmt.setString(1, mdto.getPhone());
        stmt.setString(2, mdto.getName());
        stmt.setString(3, mdto.getAddress());
        stmt.setDate(4, mdto.getSubscriptionDate());
        stmt.setDouble(5, mdto.getMembershipPoint());
        
        stmt.executeUpdate();
        return 1;

    } catch(Exception e) {
        e.printStackTrace();
    }
    return -1;
}

public List<CustomersDTO> managementList() {
        conn = CustomersDB.getConnection();
    List<CustomersDTO> list = new ArrayList<CustomersDTO>();

    try {
        stmt = conn.prepareStatement(LIST);
        rs = stmt.executeQuery();
        while (rs.next()) {
            CustomersDTO mdto = new CustomersDTO();
            mdto.setPhone(rs.getString("phone"));
            mdto.setName(rs.getString("customers_name"));    
            mdto.setAddress(rs.getString("customers_address"));
            mdto.setSubscriptionDate(rs.getDate("subscription_date"));
            mdto.setMembershipPoint(rs.getDouble("membership_point"));
            list.add(mdto);

        }

        return list;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
  }
}
