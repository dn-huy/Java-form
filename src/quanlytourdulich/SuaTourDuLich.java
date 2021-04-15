/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import quanlytourdulich.TourDuLich;

/**
 *
 * @author Section
 */
public class SuaTourDuLich extends JDialog{
    private JFrameTourDuLich T;
    private JLabel lbMa, lbTen, lbNgay,lbLoai, lbChiPhi;
    private JTextField txtMa, txtTen, txtLoai, txtNgay, txtChiPhi;
    private JButton btnLuu, btnHuy;
    public SuaTourDuLich(Frame parent, boolean modal){
        super(parent, modal);
        lbMa = new JLabel("Mã tour: ");
        lbMa.setBounds(30, 30, 100, 30);
        txtMa= new JTextField();
        txtMa.setBounds(120, 30, 220, 30);

        lbTen = new JLabel("Tên tour: ");
        lbTen.setBounds(30, 80, 100, 30);
        txtTen = new JTextField();
        txtTen.setBounds(120, 80, 220, 30);

        lbNgay = new JLabel("Số ngày: ");
        lbNgay.setBounds(30, 130, 100, 30);
        txtNgay = new JTextField();
        txtNgay.setBounds(120, 130, 220, 30);

        lbLoai = new JLabel("Loại tour: ");
        lbLoai.setBounds(30, 180, 100, 30);
        txtLoai = new JTextField();
        txtLoai.setBounds(120, 180, 220, 30);
        
        lbChiPhi = new JLabel("Chi phí:");
        lbChiPhi.setBounds(30,230,100,30);
        txtChiPhi = new JTextField();
        txtChiPhi.setBounds(120,230,220,30);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(50, 300, 80, 30);
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(230, 300, 80, 30);

        add(btnLuu);
        add(btnHuy);
        add(lbMa);
        add(lbTen);
        add(lbNgay);
        add(lbLoai);
        add(lbChiPhi);
        
        add(txtMa);
        add(txtTen);
        add(txtNgay);
        add(txtLoai);
        add(txtChiPhi);
//        add sự kiện
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuClick();
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoatClick();
            }
        });
//        cài đặt frame
        setLayout(null);
        setTitle("Sửa tuor du lịch");
        setSize(400, 400);
        this.setLocationRelativeTo(null); // hiện giữa
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        T = (JFrameTourDuLich) parent;
    }
    
    private void thoatClick(){
        this.dispose();
    }
    
    private void luuClick(){
        if(txtTen.getText().equals("") || txtNgay.getText().equals("") || txtLoai.getText().equals("") || txtChiPhi.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Thiếu thông tin");
        else{
            try{
                TourDuLich tour = new TourDuLich(txtMa.getText(),txtTen.getText(),Integer.parseInt(txtNgay.getText()),
                                                    txtLoai.getText(),Float.parseFloat(txtChiPhi.getText()));
                T.update(tour);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.dispose();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,"Dữ liệu không hợp lệ");
            }
        }
    }
    
    public void setEditData(TourDuLich T) {
        txtMa.setText(T.getMaTour());
//        không cho sửa mã phieesu
        txtMa.setEditable(false);
        txtTen.setText(T.getTenTour());
        txtNgay.setText(String.valueOf(T.getNgay()));
        txtLoai.setText(T.getLoaiTour());
        txtChiPhi.setText(String.valueOf(T.getChiPhi()));
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SuaTourDuLich dialog = new SuaTourDuLich(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                   public void windowOpened(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
