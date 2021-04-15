/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Section
 */
public class ChinhSuaDiaDiem extends JDialog{
    private JFrameDiaDiem DD;
    private JLabel lbMa, lbTen, lbViTri,lbMoTa;
    private JTextField txtMa, txtTen, txtViTri;
    private JTextArea txtMoTa;
    private JButton btnLuu, btnHuy;
    public ChinhSuaDiaDiem(Frame parent, boolean modal){
        super(parent, modal);
        lbMa = new JLabel("Mã địa điểm: ");
        lbMa.setBounds(30, 30, 150, 30);
        txtMa= new JTextField();
        txtMa.setBounds(120, 30, 220, 30);

        lbTen = new JLabel("Tên địa điểm: ");
        lbTen.setBounds(30, 80, 150, 30);
        txtTen = new JTextField();
        txtTen.setBounds(120, 80, 220, 30);

        lbViTri = new JLabel("Vị Trí: ");
        lbViTri.setBounds(30, 130, 150, 30);
       txtViTri = new JTextField();
        txtViTri.setBounds(120, 130, 220, 30);

        lbMoTa = new JLabel("Mô tả: ");
        lbMoTa.setBounds(30, 180, 150, 30);
        txtMoTa = new JTextArea();
        txtMoTa.setBounds(120, 180, 220, 100);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(50, 300, 80, 30);
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(230, 300, 80, 30);

        add(btnLuu);
        add(btnHuy);
        add(lbMa);
        add(lbTen);
        add(lbViTri);
        add(lbMoTa);
        add(txtMa);
        add(txtTen);
        add(txtViTri);
        add(txtMoTa);

//        add sự kiện
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLuu(e);
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHuy(e);
            }
        });
//        cài đặt frame
        setLayout(null);
        setTitle("Sửa thông tin địa điểm");
        setSize(400, 400);
        this.setLocationRelativeTo(null); // hiện giữa
        setVisible(true);
        this.setLocationRelativeTo(null);
        DD = (JFrameDiaDiem) parent;
    }
    private void btnHuy(ActionEvent e) {
        this.dispose();
    }
    private void btnLuu(ActionEvent e) {
        String Ma = txtMa.getText();
        String Ten = txtTen.getText();
        String ViTri = txtViTri.getText();
        String  MoTa = txtMoTa.getText();

        DiaDiem d = new DiaDiem(Ma,Ten,ViTri,MoTa);
            DD.CapNhat(d);
            JOptionPane.showMessageDialog(rootPane,
                    "Sửa thành công!");
            this.dispose();
    }
    public void setEditData(DiaDiem d) {
        txtMa.setText(d.getMaDiaDiem());
//        không cho sửa mã phieesu
        txtMa.setEditable(false);
        txtTen.setText(d.getTenDiaDiem());
        txtViTri.setText(d.getViTri());
        txtMoTa.setText(d.getMoTa());
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChinhSuaDiaDiem dialog = new ChinhSuaDiaDiem(new JFrame(), true);
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
