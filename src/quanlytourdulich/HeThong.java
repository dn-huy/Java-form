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
public class HeThong extends JFrame{
    private JMenuBar MenuBar;
    private JMenu MenuQuanLy,  MenuTienIch;
    private JMenuItem ItemTourDuLich, ItemDiaDiem, ItemNhanVien,ItemThongTinDatTour, ItemThoat;
    private JLabel lblNoiDung;
    
    public HeThong() {
        AddControl();
         TaoJframe();
         //this.setBackground(Color.MAGENTA);
    }
    
    public void TaoJframe(){
        this.setTitle("Hệ Thống Quản Lý");
       
        this.setSize(700, 400);// kích thước
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ấn X thì đóng chương trình
        this.setLocationRelativeTo(null); // hiện giữa
        //setLayout(null);
        this.setVisible(true); // hiện thị
        this.setResizable(false); // ko cho kéo giãn jframe
    }
    public void AddControl(){
        MenuBar = new JMenuBar();
        MenuQuanLy = new JMenu("Menu Quản Lý Hệ Thống");
        MenuTienIch = new JMenu("Tiện ích");
        
        ItemTourDuLich = new JMenuItem("Thông Tin Tour Du Lịch");
        ItemDiaDiem = new JMenuItem("Thông Tin Các Địa Điểm");
        //ItemNhanVien = new JMenuItem("Thông Tin Nhân Viên");
        ItemThongTinDatTour = new JMenuItem("Thông Tin Đặt Tour Du Lịch");
        ItemThoat = new JMenuItem("Thoát");
        MenuQuanLy.add(ItemDiaDiem);
        MenuQuanLy.add(ItemTourDuLich);
        //MenuQuanLy.add(ItemNhanVien);
        MenuQuanLy.add(ItemThongTinDatTour);
        MenuQuanLy.add(ItemThoat);
        MenuBar.add(MenuQuanLy);
         MenuBar.add(MenuTienIch);
        this.setJMenuBar(MenuBar);
        ItemThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int click = JOptionPane.showConfirmDialog(null,
//                        "Bạn Có Muốn Thoát Không?", "Thoát Hệ Thống Quản Lý", JOptionPane.YES_NO_OPTION);
//                if(click == JOptionPane.YES_OPTION){
//                    setVisible(false);
//                    new DangNhap();
//                }else if(click == JOptionPane.NO_OPTION) {
//                    return;
//                }
                    setVisible(false);
                    new DangNhap();
            }
        });
        
        ItemTourDuLich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JFrameTourDuLich();
            }
        });
        ItemDiaDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JFrameDiaDiem();
            }
        });
        ItemThongTinDatTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 new ThongTinDatTour();
            }
        });
        lblNoiDung = new JLabel("Hệ Thống Quản Lý Tour Du Lịch 2020");
        lblNoiDung.setFont(new Font("Serif", Font.BOLD, 40));
        lblNoiDung.setForeground(Color.BLACK);
        lblNoiDung.setBounds(15, 50, 200, 30);
        this.add(lblNoiDung);
    }
    public static void main(String[] args) {
        new HeThong();
        
    }
}
