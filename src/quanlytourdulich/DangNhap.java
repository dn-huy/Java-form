/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Pham Quy
 */
public class DangNhap extends JFrame{
    private JButton btnDangNhap, btnThoat;
    private JLabel lblTaiKhoan, lblMatKhau;
    private JTextField txtTK;
    private JPasswordField txtMK;
    public DangNhap(){
        ThemControl();
        GanSuKien();
        TaoJframe();
    }
    public void TaoJframe(){
        this.setTitle("JFrame Đăng Nhập Hệ Thống");
        this.setSize(400, 300);// kích thước
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ấn X thì đóng chương trình
        this.setLocationRelativeTo(null); // hiện giữa
        setLayout(null);
        this.setVisible(true); // hiện thị
        this.setResizable(false); // ko cho kéo giãn jframe
    }
    public void ThemControl(){
        lblTaiKhoan = new JLabel("Tài Khoản:");
        this.lblTaiKhoan.setBounds(35, 50, 80, 30);
        
        
        lblMatKhau = new JLabel("Mật Khẩu:");
        this.lblMatKhau.setBounds(35, 100, 80, 30);
        
        txtTK = new JTextField();
        this.txtTK.setBounds(150, 50, 150, 30);

        txtMK = new JPasswordField();
        this.txtMK.setBounds(150, 100, 150, 30);

        btnDangNhap = new JButton("Đăng nhập");
       this.btnDangNhap.setBounds(60, 200, 100, 30);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(200, 200, 100, 30);
        
        this.add(btnDangNhap);
        this.add(btnThoat);
        
        this.add(txtTK);
        this.add(txtMK);
        this.add(lblTaiKhoan);
        this.add(lblMatKhau);
        
        
       
    }
    public void GanSuKien(){
        this.btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDangNhapActionPerformed(e);
            }
        });
        this.btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThoatActionPerformed(e);
            }
        });
    }
    public void btnThoatActionPerformed(ActionEvent e){
            System.exit(0);
    }
    public void btnDangNhapActionPerformed(ActionEvent e){
        if(txtTK.getText().equals("") || txtMK.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Tai Khoản Hoặc Mật Khẩu");
        }
        else{
            if(txtTK.getText().equals("admin") && txtMK.getText().equals("0000")){
                JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
                this.setVisible(false);
                new HeThong();
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Đăng Nhập Thất Bại");
            }
        }
    }
    public static void main(String[] args) {
        new DangNhap();
    }
}
