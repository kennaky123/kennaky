/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlyotovaxemay;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author chipt
 */
public class dangnhap extends javax.swing.JFrame {

    /**
     * Creates new form dangnhap
     */
    public dangnhap() {
        initComponents();
    }
//    ResultSet rs;
    Statement st;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btndn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdn = new javax.swing.JTextField();
        txtmk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        btndn.setText("Login");
        btndn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndnActionPerformed(evt);
            }
        });

        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btndn)
                        .addComponent(txtmk, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(txtdn)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btndn)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdnActionPerformed

    private void btndnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndnActionPerformed
        // TODO add your handling code here:
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe1", "root", "");
            if(txtdn.getText().equals("admin") && txtmk.getText().equals("admin")){
                giaodien test = new giaodien();
                test.setVisible(true);
                this.dispose();
            }
            else{
            //tạo câu truy vấn trong sql
            String sql="select*from account where USERNAME =? and PASS =? ";//cau truy vấn đến sql
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString(1,txtdn.getText());// lấy dữ liệu khi người dùng nhập vào biến ps
            ps.setString(2,txtmk.getText());
            ResultSet  rs = ps.executeQuery();// xong rồi nó sẽ nhập 2 cái dữ liệu trong biến ps vào cái ? trên câu lệnh SQL
            //nếu đúng username và pass thì nó sẽ chuyển dữ liệu của bảng đó qua cho biến rs
            // cái biến resultSet này dùng để lưu kết quả của câu truy vấn
        if(txtdn.getText().equals("") || txtmk.getText().equals ("")){
        JOptionPane.showMessageDialog (this, "chua nhap user va pass");
        }
        else if(rs.next()) {//có dữ liệu trong rs thì nó sẽ in ra giao diện xe
            giaodien2 ql=new giaodien2();
            ql.setVisible (true);
            this.dispose();
            JOptionPane.showMessageDialog (this, "đăng nhập thành công");
        }
        else{
            JOptionPane.showMessageDialog(this, "sai tài khoản hoặc tài khoản không tồn tại.") ;
        }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btndnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dangki l = new dangki();
        l.setVisible(true); //hiển thị màn hình form đăng ký
        this.dispose();// thoát khỏi cửa sổ form đăng ký khi đã nhấn vào đăng ký
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dangnhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtdn;
    private javax.swing.JTextField txtmk;
    // End of variables declaration//GEN-END:variables
}
