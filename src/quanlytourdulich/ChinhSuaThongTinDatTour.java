
package quanlytourdulich;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChinhSuaThongTinDatTour extends JDialog{
    private ThongTinDatTour TTDT;
    private JLabel lblMaPhieu, lblMaTour, lblMaKH, lblNgay, lblChiPhi, lblTieuDe;
    private JTextField txtMaPhieu, txtMaTour, txtMaKH, txtNgay, txtChiPhi;
    private JButton btnLuu, btnHuy;
    public ChinhSuaThongTinDatTour(Frame parent, boolean modal){
        super(parent, modal);
        lblMaPhieu = new JLabel("Mã Phiếu: ");
        lblMaPhieu.setBounds(30, 30, 150, 30);
        txtMaPhieu= new JTextField();
        txtMaPhieu.setBounds(200, 30, 150, 30);

        lblMaTour = new JLabel("Mã Tour: ");
        lblMaTour.setBounds(30, 80, 150, 30);
        txtMaTour = new JTextField();
        txtMaTour.setBounds(200, 80, 150, 30);

       lblMaKH = new JLabel("Mã Khách Hàng: ");
        lblMaKH.setBounds(30, 130, 150, 30);
       txtMaKH = new JTextField();
        txtMaKH.setBounds(200, 130, 150, 30);

        lblNgay = new JLabel("Ngày Khởi Hành: ");
        lblNgay.setBounds(30, 180, 150, 30);
        txtNgay = new JTextField();
        txtNgay.setBounds(200, 180, 150, 30);

        lblChiPhi = new JLabel("Chi Phí: ");
        lblChiPhi.setBounds(30, 230, 150, 30);
        txtChiPhi = new JTextField();
        txtChiPhi.setBounds(200, 230, 150, 30);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(50, 300, 80, 30);
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(230, 300, 80, 30);

        add(btnLuu);
        add(btnHuy);
        add(lblMaPhieu);
        add(lblMaTour);
        add(lblMaKH);
        add(lblNgay);
        add(lblChiPhi);
        add(txtMaPhieu);
        add(txtMaTour);
        add(txtMaKH);
        add(txtNgay);
        add(txtChiPhi);

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
        setTitle("Sửa Thông Tin Đặt Tour Du Lịch");
        setSize(400, 400);
        this.setLocationRelativeTo(null); // hiện giữa

        setVisible(true);
        this.setLocationRelativeTo(null);
        TTDT = (ThongTinDatTour) parent;
    }
    private void btnHuy(ActionEvent e) {
        this.dispose();
    }
    private void btnLuu(ActionEvent e) {
        String MaKH = txtMaKH.getText();
        String MaTour = txtMaTour.getText();
        String MaPhieu = txtMaPhieu.getText();
        String  Ngay = txtNgay.getText();
        float ChiPhi = 0;
        boolean OK = true;

        try {
            ChiPhi = Float.parseFloat(txtChiPhi.getText());
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chi Phi phải nhập số thực không được nhập kiểu Chuoi!");
            OK = false;
        }
        if (OK) {
            ThongTinDatTourDuLich T = new ThongTinDatTourDuLich(MaPhieu, MaTour, MaKH , Ngay, ChiPhi);
            TTDT.CapNhat(T);
            JOptionPane.showMessageDialog(rootPane,
                    "Sửa thành công!");
            this.dispose();
        }
    }
    public void setEditData(ThongTinDatTourDuLich T) {
        txtMaPhieu.setText(T.getMaPhieu());
//        không cho sửa mã phieesu
        txtMaPhieu.setEditable(false);
        txtMaKH.setText(T.getMaKH());
        txtMaTour.setText(T.getMaTour());
        txtChiPhi.setText(T.getChiPhi()+"");
        txtNgay.setText(T.getNgayKhoiHanh());
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChinhSuaThongTinDatTour dialog = new ChinhSuaThongTinDatTour(new JFrame(), true);
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
