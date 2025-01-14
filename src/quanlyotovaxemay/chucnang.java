/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyotovaxemay;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Thread;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author chipt
 */
public class chucnang {

    //lấy ra danh sách tất cả xe trong database
    public static List<xe> findAll() {
        // tạo 1 mảng kiểu xe để lưu các đối tượng xe từ sql
        List<xe> xeList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            
            //tạo câu truy vấn trong sql
            String sql = "select * from xe";
            // tạo đối tượng statement để thực thi câu lệnh sql
            statement = connection.createStatement();
            // rồi trả kết quả về dạng result set
            ResultSet resultSet = statement.executeQuery(sql);
            
//            resultSet.next(): Duyệt qua từng bản ghi trong kết quả truy vấn.
//            resultSet.getInt, resultSet.getString: Lấy giá trị của từng cột trong bảng.
//            new xe(...): Tạo một đối tượng xe với các giá trị từ cơ sở dữ liệu.
//            xeList.add(std): Thêm đối tượng xe vào danh sách xeList.
            while(resultSet.next()){
                xe std = new xe(resultSet.getInt("id"), 
                        resultSet.getString("bien_So"),
                        resultSet.getString("Phan_Khoi"),
                        resultSet.getString("Loai_Xe"),
                        resultSet.getInt("lephitieuthu_DB"),
                        resultSet.getInt("so_cho_ngoi"));
                xeList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return xeList;
    }
    //tạo 1 hàm chèn dữ liệu kế thừa lớp xe
    public static void insert(xe std){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            
            //tạo câu truy vấn trong sql
            String sql = "insert into xe(bien_So, so_cho_ngoi, Phan_Khoi, lephitieuthu_DB, Loai_Xe) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getBienSo());
            statement.setInt(2, std.getSoChoNgoi());
            statement.setString(3, std.getPhanKhoi());
            statement.setInt(4, std.getLePhiTieuThuDB());
            statement.setString(5, std.getLoaiXe());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

    }
     public static void update(xe std){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            
            //tạo câu truy vấn trong sql
            String sql = "update xe set bien_So = ?, so_cho_ngoi = ?, Phan_Khoi = ?, lephitieuthu_DB = ?, Loai_Xe = ? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getBienSo());
            statement.setInt(2, std.getSoChoNgoi());
            statement.setString(3, std.getPhanKhoi());
            statement.setInt(4, std.getLePhiTieuThuDB());
            statement.setString(5, std.getLoaiXe());
            statement.setInt(6, std.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

    }
      public static void delete(int Id){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            
            //tạo câu truy vấn trong sql
            String sql = "delete from xe where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, Id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

    }
      public static List<xe> findByBienSo(String BienSo) {
        List<xe> xeList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            
            //tạo câu truy vấn trong sql
            String sql = "select * from xe where bien_so like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+BienSo+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            
            
            while(resultSet.next()){
                xe std = new xe( resultSet.getInt("id"), 
                        resultSet.getString("bien_So"),
                        resultSet.getString("Phan_Khoi"),
                        resultSet.getString("Loai_Xe"),
                        resultSet.getInt("lephitieuthu_DB"),
                        resultSet.getInt("so_cho_ngoi"));
                xeList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return xeList;
    }
      
}
