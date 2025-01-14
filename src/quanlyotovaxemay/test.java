/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyotovaxemay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/xe1?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = ""; // Thay bằng mật khẩu của bạn

        try {
            // Kết nối tới cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }
    }
}



