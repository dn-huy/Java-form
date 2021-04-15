/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Section
 */
public class JFrameDiaDiem extends JFrame {

    private JButton btnThem, btnSua, btnXoa, btnThoat;
    private JLabel lbMaDiaDiem, lbTenDiaDiem, lbViTri, lbMoTa, lblTieuDe;
    private JTextField txtMa, txtTen, txtViTri;
    private JTextArea txtMoTa;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private ArrayList<DiaDiem> DS;
    DefaultTableModel tableModel;
    private int selectedIndex;

    DiaDiem DD1 = new DiaDiem("DD01", "Du Lịch Đảo Cát Bà", "Quảng Ninh", "Là một hòn đảo");
    DiaDiem DD2 = new DiaDiem("DD02", "Du Lich Biển Sầm Sơn", "Thanh Hóa", "Du lịch biển");
    DiaDiem DD3 = new DiaDiem("DD03", "Phố Cổ Hà Nội", "Hà Nội", "Phố Hà Nội");
    DiaDiem DD4 = new DiaDiem("DD04", "Văn Miếu Quốc Tử Gíam", "Hà Nội", "Thuộc Hà Nội");
    DiaDiem DD5 = new DiaDiem("DD05", "Tam Đảo - Vĩnh Phúc", "Vĩnh Phúc", "Đảo ở Vĩnh Phúc");

    public JFrameDiaDiem() {
        themView();
        this.setLocationRelativeTo(null);
        DS = new ArrayList<DiaDiem>();
        tableModel = (DefaultTableModel) jTable.getModel();
        DS.add(DD1);
        DS.add(DD2);
        DS.add(DD3);
        DS.add(DD4);
        DS.add(DD5);

    }

    public void showData() {
        tableModel.setRowCount(0);
        for (DiaDiem T : DS) {
            tableModel.addRow(new Object[]{
                T.getMaDiaDiem(), T.getTenDiaDiem(), T.getViTri(), T.getMoTa()
            });
        }
    }

    public void themDiadiem(DiaDiem T) {
        DS.add(T);
        showData();
    }

    private void themView() {
        lblTieuDe = new JLabel("Thông tin địa điểm");
        lblTieuDe.setBounds(300, 10, 400, 30);
        lblTieuDe.setFont(new Font("Serif", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLACK);
        jTable = new JTable();
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(50, 50, 700, 200);
        jScrollPane.setViewportView(jTable);
        jTable.setModel(new DefaultTableModel(
                new Object[][]{
                    {DD1.getMaDiaDiem(), DD1.getTenDiaDiem(), DD1.getViTri(), DD1.getMoTa(),},
                    {DD2.getMaDiaDiem(), DD2.getTenDiaDiem(), DD2.getViTri(), DD2.getMoTa(),},
                    {DD3.getMaDiaDiem(), DD3.getTenDiaDiem(), DD3.getViTri(), DD3.getMoTa(),},
                    {DD4.getMaDiaDiem(), DD4.getTenDiaDiem(), DD4.getViTri(), DD4.getMoTa(),},
                    {DD5.getMaDiaDiem(), DD5.getTenDiaDiem(), DD5.getViTri(), DD5.getMoTa(),}
                },
                new String[]{
                    "Mã địa điểm", "Tên địa điểm", "Vị trí", "Mô tả"
                }
        ));
        jTable.setAutoResizeMode(jTable.AUTO_RESIZE_NEXT_COLUMN);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lbMaDiaDiem = new JLabel("Mã địa điểm: ");
        lbMaDiaDiem.setBounds(150, 300, 150, 30);
        txtMa = new JTextField();
        txtMa.setBounds(320, 300, 300, 30);

        lbTenDiaDiem = new JLabel("Tên địa điểm: ");
        lbTenDiaDiem.setBounds(150, 350, 150, 30);
        txtTen = new JTextField();
        txtTen.setBounds(320, 350, 300, 30);

        lbViTri = new JLabel("Vị trí: ");
        lbViTri.setBounds(150, 400, 150, 30);
        txtViTri = new JTextField();
        txtViTri.setBounds(320, 400, 300, 30);

        lbMoTa = new JLabel("Mô tả :");
        lbMoTa.setBounds(150, 450, 150, 30);
        txtMoTa = new JTextArea();
        txtMoTa.setBounds(320, 450, 300, 120);

        btnThem = new JButton("Thêm");
        btnThem.setBounds(160, 600, 80, 30);
        btnSua = new JButton("Sửa");
        btnSua.setBounds(280, 600, 80, 30);
        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(400, 600, 80, 30);
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(520, 600, 80, 30);

        add(lbMaDiaDiem);
        add(lbTenDiaDiem);
        add(lbViTri);
        add(lbMoTa);

        add(txtMa);
        add(txtTen);
        add(txtViTri);
        add(txtMoTa);

        add(jScrollPane);
        add(lblTieuDe);
        add(btnSua);
        add(btnThem);
        add(btnXoa);
        add(btnThoat);

//        add sự kiện
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThem(e);
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSua(e);
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXoa(e);
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThoat(e);
            }
        });

        setTitle("Địa điểm");
        setSize(800, 700);
        setLayout(null);
        setVisible(true);
        this.setResizable(false); // ko cho kéo giãn jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ấn X thì đóng chương trình
    }

    private void btnThoat(ActionEvent e) {
        int click = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát?",
                "THOÁT", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            setVisible(false);
            new HeThong();
        }
    }

    private void btnXoa(ActionEvent e) {
        selectedIndex = jTable.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null,
                    "Hãy chọn vị trí muốn xóa!");
        } else {
            int click = JOptionPane.showConfirmDialog(null,
                    "Bạn muốn xóa thông tin đặt tour này?",
                    "XÓA", JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
                DS.remove(selectedIndex);
                showData();
            } else if (click == JOptionPane.NO_OPTION) {
                return;
            }
        }
    }

    private void btnSua(ActionEvent e) {
        selectedIndex = jTable.getSelectedRow();
        if (DS.size() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy nhập thêm thêm thông tin rồi sửa!");
        } else if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy chọn dòng có thông tin tour cần sửa rồi ấn Sửa!");
        } else {
            ChinhSuaDiaDiem F = new ChinhSuaDiaDiem(this, false);
            F.setEditData(DS.get(selectedIndex));
            F.setVisible(true);
        }
    }

    private void btnThem(ActionEvent e) {
        if (txtMa.getText().equals("")
                || txtTen.getText().equals("") || txtViTri.getText().equals("")
                || txtMoTa.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng nhập đầy đủ thông tin!");
        } else {
            String ma = "", ten = "", vitri = "", mota = "";
            ma = txtMa.getText();
            ten = txtTen.getText();
            vitri = txtViTri.getText();
            mota = txtMoTa.getText();

            DiaDiem dd = new DiaDiem(ma, ten, vitri, mota);
            DS.add(dd);
            showData();
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
            txtMa.setText("");
            txtTen.setText("");
            txtViTri.setText("");
            txtMoTa.setText("");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameDiaDiem().setVisible(true);
            }
        });
    }

    public void CapNhat(DiaDiem T) {
        DS.remove(selectedIndex);
        DS.add(T);
        showData();
    }
}
