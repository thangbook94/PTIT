
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MSI
 */
public class MyConnection {

    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/medical_con_user";
    private final String user = "root";
    private final String pass = "Thangbook@94";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    private String table = "user";

    public boolean connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối database thành công");
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kết nối database thất bại");
            return false;
        }
    }

    public boolean insert(User u) {
        String sqlCommand = "insert into " + table + " value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setString(1, u.getCmt());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getHoten());
            pst.setString(5, u.getDate());
            pst.setString(6, u.getStatus());
            pst.setInt(7, u.getRegion());
            pst.setDouble(8, u.getSalary());
            pst.setDouble(9, u.getAllowance());
            pst.setString(10, u.getTrain());
            pst.setString(11, u.getWarning());
            pst.setString(12, u.getType());
            pst.setDouble(13, u.getMoney());
            pst.setString(14, u.getStatuscal());
            if (pst.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
                return true;
            } else {
                System.out.println("Thêm không thành công");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Thêm không thành công");
            return false;
        }
    }

    public boolean update(String cmt, User u) {
        String sqlCommand = "update " + table + " set status=?, region=?, salary=?, allowance=?, train=?, warning=?, type=? where cmt=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setString(8, u.getCmt());
            pst.setString(1, u.getStatus());
            pst.setInt(2, u.getRegion());
            pst.setDouble(3, u.getSalary());
            pst.setDouble(4, u.getAllowance());
            pst.setString(5, u.getTrain());
            pst.setString(6, u.getWarning());
            pst.setString(7, u.getType());
            if (pst.executeUpdate() > 0) {
                System.out.println("Cập nhật thông tin thành công");
                return true;
            } else {
                System.out.println("Cập nhật thông tin không thành công");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Cập nhật thông tin không thành công");
            return false;
        }
    }

    public boolean updateMoney(String cmt, User u) {
        String sqlCommand = "update " + table + " set money=?, statuscal=? where cmt=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setString(3, u.getCmt());
            pst.setDouble(1, u.getMoney());
            pst.setString(2, u.getStatuscal());

            if (pst.executeUpdate() > 0) {
                System.out.println("Tính tiền thành công");
                return true;
            } else {
                System.out.println("Tính tiền lỗi");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Tính tiền lỗi");
            return false;
        }
    }

    public ResultSet getDataCmt(String cmt) {
        ResultSet rs = null;
        String sqlCommand = "select * from " + table + " where cmt=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setString(1, cmt);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("Lấy dữ liệu lỗi");
        }
        return rs;
    }

    public ResultSet getData() {
        ResultSet rs = null;
        String sqlCommand = "select * from " + table;
        Statement st;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(sqlCommand);
        } catch (SQLException e) {
            System.out.println("Lấy dữ liệu lỗi");
        }
        return rs;
    }

}
