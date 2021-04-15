
package quanlytourdulich;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

 
public class ThongTinDatTour extends JFrame {
    private JButton btnThem, btnSua, btnXoa, btnThoat;
    private JLabel lblMaPhieu, lblMaTour, lblMaKH, llblNgay, lbLChiPhi,lblNgay, lblTieuDe;
    private JTextField txtMaPhieu, txtMaTour, txtMaKH, txtNgay, txtChiPhi;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private ArrayList<ThongTinDatTourDuLich> DS;
    DefaultTableModel tableModel;
    private int selectedIndex;

    ThongTinDatTourDuLich Tour01 = new ThongTinDatTourDuLich("Tour01", "KH01", "MP01", "05/10/2020",2000);
    public ThongTinDatTour() {
        themView();
        this.setLocationRelativeTo(null);
        DS = new ArrayList<ThongTinDatTourDuLich>();
        tableModel = (DefaultTableModel) jTable.getModel();
        DS.add(Tour01);
        
        
    }

    public void showData() {
        tableModel.setRowCount(0);
        for (ThongTinDatTourDuLich T : DS) {
            tableModel.addRow(new Object[]{
                    T.getMaPhieu(), T.getMaTour(), T.getMaKH(), T.getNgayKhoiHanh(), T.getChiPhi()
            });
        }
    }

    public void themDonDatHang(ThongTinDatTourDuLich T) {
        DS.add(T);
        showData();
    }

    private void themView() {
        lblTieuDe = new JLabel("THÔNG TIN ĐẶT TOUR DU LỊCH");
        lblTieuDe.setBounds(220, 10, 400, 30);
        lblTieuDe.setFont(new Font("Serif", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLACK);
        jTable = new JTable();
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(50, 50, 700, 200);
        jScrollPane.setViewportView(jTable);
        jTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {Tour01.getMaPhieu(), Tour01.getMaTour(), Tour01.getMaKH(), Tour01.getNgayKhoiHanh(), Tour01.getChiPhi()},
                        

                },
                new String[]{
                        "Mã Phiếu", "Mã Tour", "Mã Khách Hàng", "Ngày Khởi Hành", "Chi Phí ($)"
                }
        ));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblMaPhieu = new JLabel("Mã Phiếu: ");
        lblMaPhieu.setBounds(150, 300, 150, 30);
        txtMaPhieu = new JTextField();
        txtMaPhieu.setBounds(320, 300, 300, 30);

        lblMaTour = new JLabel("Mã Tour: ");
        lblMaTour.setBounds(150, 350, 150, 30);
        txtMaTour = new JTextField();
        txtMaTour.setBounds(320, 350, 300, 30);

        lblMaKH = new JLabel("Mã Khách Hàng: ");
        lblMaKH.setBounds(150, 400, 150, 30);
        txtMaKH = new JTextField();
        txtMaKH.setBounds(320, 400, 300, 30);

        lblNgay = new JLabel("Ngày Khởi Hành :");
        lblNgay.setBounds(150, 450, 150, 30);
        txtNgay = new JTextField();
        txtNgay.setBounds(320, 450, 300, 30);

        lbLChiPhi = new JLabel("Chi Phí: ");
        lbLChiPhi.setBounds(150, 500, 150, 30);
        txtChiPhi = new JTextField();
        txtChiPhi.setBounds(320, 500, 300, 30);

        btnThem = new JButton("Thêm");
        btnThem.setBounds(120, 600, 80, 30);
        btnSua = new JButton("Sửa");
        btnSua.setBounds(240, 600, 80, 30);
        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(360, 600, 80, 30);
        
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(480, 600, 80, 30);

        

        add(lblMaPhieu);
        add(lblMaTour);
        add(lblMaKH);
        add(lblNgay);
        add(lbLChiPhi);

        add(txtMaTour);
        add(txtMaPhieu);
        add(txtMaKH);
        add(txtNgay);
        add(txtChiPhi);

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
        
        setTitle("Thông Tin Đặt Tour Du Lịch");
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
        } else if (click == JOptionPane.NO_OPTION) {
            return;
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
            ChinhSuaThongTinDatTour F = new ChinhSuaThongTinDatTour(this, false);
            F.setEditData(DS.get(selectedIndex));
            F.setVisible(true);
        }
    }

    private void btnThem(ActionEvent e) {
        if (txtMaPhieu.getText().equals("")
                || txtMaTour.getText().equals("") || txtMaKH.getText().equals("")
                || txtNgay.getText().equals("") || txtChiPhi.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng nhập đầy đủ thông tin!");
        } else {
            String MAP = "", MAT = "", MAKH = "", Ngay = "";
            float ChiPhi = 0;
            MAP = txtMaPhieu.getText();
            MAT = txtMaTour.getText();
            MAKH = txtMaKH.getText();
            Ngay = txtNgay.getText();
            boolean OK = true;

            try {
                ChiPhi = Float.parseFloat(txtChiPhi.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(rootPane,
                        "Giá phải nhập số thực không được nhập kiểu khác!");
                OK = false;
            }


            if (OK) {
                ThongTinDatTourDuLich T = new ThongTinDatTourDuLich(MAP, MAT, MAKH, Ngay, ChiPhi);
                DS.add(T);
                showData();
                JOptionPane.showMessageDialog(rootPane,
                        "Thêm thành công!");
                txtMaPhieu.setText("");
                txtMaTour.setText("");
                txtMaKH.setText("");
                txtNgay.setText("");
                txtChiPhi.setText("");
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThongTinDatTour().setVisible(true);
            }
        });
    }

    public void CapNhat(ThongTinDatTourDuLich T) {
        DS.remove(selectedIndex);
        DS.add(T);
        showData();
    }

   
}
