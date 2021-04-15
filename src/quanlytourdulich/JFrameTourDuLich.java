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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import quanlytourdulich.HeThong;
import quanlytourdulich.SuaTourDuLich;
import quanlytourdulich.TourDuLich;

/**
 *
 * @author Section
 */
public class JFrameTourDuLich extends JFrame implements ActionListener{
    private JLabel lbMa, lbTen, lbNgay, lbLoai, lbChiPhi, lbTable;
    private JTextField txtMa, txtTen, txtNgay, txtChiPhi, txtLoai;
    private JButton btThem, btSua, btXoa, btThoat;
    private JTable table;
    private JScrollPane scroll;
    private ArrayList<TourDuLich> arr;
    DefaultTableModel tableModel;
    private int index;
    TourDuLich T1 = new TourDuLich("T01", "Du lịch đảo Cát Bà", 5, "VIP", 3500);
    TourDuLich T2 = new TourDuLich("T02", "Thăm quan phố cổ Hà Nội", 2, "Thường", 1000);
    TourDuLich T3 = new TourDuLich("T03", "Thăm quan Văn miếu Quốc Tử Giám", 1, "Thường", 500);
    
    public JFrameTourDuLich(){
        form();
        setLocationRelativeTo(null);
        arr = new ArrayList<TourDuLich>();
        tableModel = (DefaultTableModel) table.getModel();
        arr.add(T1);
        arr.add(T2);
        arr.add(T3);
    }
    
    private void form(){
        lbTable = new JLabel("Bảng tour du lịch");
        lbTable.setBounds(900,10,300,30);
        lbTable.setFont(new Font("Serif", Font.BOLD, 25));
        table = new JTable();
        scroll = new JScrollPane();
        scroll.setBounds(400,50,1050,500);
        scroll.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][]{
                {T1.getMaTour(),T1.getTenTour(),T1.getNgay(),T1.getLoaiTour(),T1.getChiPhi()},
                {T2.getMaTour(),T2.getTenTour(),T2.getNgay(),T2.getLoaiTour(),T2.getChiPhi()},
                {T3.getMaTour(),T3.getTenTour(),T3.getNgay(),T3.getLoaiTour(),T3.getChiPhi()}
            },
            new String[]{"Mã tour","Tên tour","Số ngày đi","Loại tour","Chi phí($)"}
        ));
        table.setAutoResizeMode(table.AUTO_RESIZE_NEXT_COLUMN);
        
        lbMa = new JLabel("Mã tour:");
        lbMa.setBounds(30,70,80,30);
        txtMa = new JTextField();
        txtMa.setBounds(100,70,250,30);
        
        lbTen = new JLabel("Tên tour:");
        lbTen.setBounds(30,130,80,30);
        txtTen = new JTextField();
        txtTen.setBounds(100,130,250,30);
        
        lbNgay = new JLabel("Số ngày:");
        lbNgay.setBounds(30,190,80,30);
        txtNgay = new JTextField();
        txtNgay.setBounds(100,190,250,30);
        
        lbLoai = new JLabel("Loại tour:");
        lbLoai.setBounds(30,250,80,30);
        txtLoai = new JTextField();
        txtLoai.setBounds(100,250,250,30);
        
        lbChiPhi = new JLabel("Chi phí:");
        lbChiPhi.setBounds(30,310,80,30);
        txtChiPhi = new JTextField();
        txtChiPhi.setBounds(100,310,250,30);
        
        btThem = new JButton("Thêm");
        btThem.setBounds(50,400,80,30);
        btThem.setActionCommand("them");
        btThem.addActionListener(this);
        
        btSua = new JButton("Sửa");
        btSua.setBounds(250,400,80,30);
        btSua.setActionCommand("sua");
        btSua.addActionListener(this);
        
        btXoa = new JButton("Xóa");
        btXoa.setBounds(50,470,80,30);
        btXoa.setActionCommand("xoa");
        btXoa.addActionListener(this);
        
        btThoat = new JButton("Thoát");
        btThoat.setBounds(250,470,80,30);
        btThoat.setActionCommand("thoat");
        btThoat.addActionListener(this);
        
        add(lbTable);
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
       
        add(scroll);
        add(btThem);
        add(btSua);
        add(btXoa);
        add(btThoat);
        
        setTitle("Tour du lịch");
        setSize(1500,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void showData(){
        tableModel.setRowCount(0);
        for(TourDuLich T : arr)
        {
            tableModel.addRow(new Object[]
            {
                T.getMaTour(),T.getTenTour(),T.getNgay(),T.getLoaiTour(),T.getChiPhi()
            });
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameTourDuLich().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("them")){
            if(txtMa.getText().equals("") || txtTen.getText().equals("") || txtNgay.getText().equals("")
            || txtLoai.getText().equals("") || txtChiPhi.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Chưa nhập đầy đủ thông tin!");
            }
            else{
                try{
                    TourDuLich t =new TourDuLich(txtMa.getText(), txtTen.getText(), Integer.parseInt(txtNgay.getText()),
                                        txtLoai.getText(), Float.parseFloat(txtChiPhi.getText()));
                    arr.add(t);
                    showData();
                    txtMa.setText("");
                    txtTen.setText("");
                    txtNgay.setText("");
                    txtLoai.setText("");
                    txtChiPhi.setText("");                    
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
                }
            }
        }
        else if(ae.getActionCommand().equals("sua")){
            index = table.getSelectedRow();
            if(arr.size() == 0)
                JOptionPane.showMessageDialog(null, "Thêm thông tin rồi mới sửa được");
            else if(index < 0)
                JOptionPane.showMessageDialog(this, "Chọn thông tin cần sửa để sửa");
            else{
                SuaTourDuLich st = new SuaTourDuLich(this, false);
                st.setVisible(true);
                st.setEditData(arr.get(index));
            }
        }
        else if(ae.getActionCommand().equals("xoa")){
            index = table.getSelectedRow();
            if(index < 0)
                JOptionPane.showMessageDialog(null, "Hãy chọn dữ liệu để xóa");
            else{
                int x = JOptionPane.showConfirmDialog(null, "Xóa", "Question", JOptionPane.YES_NO_OPTION);
                if(x == JOptionPane.YES_OPTION){
                    arr.remove(index);
                    showData();
                }
            }
        }
        else if(ae.getActionCommand().equals("thoat")){
            int x = JOptionPane.showConfirmDialog(null, "Thoát?", "Alert", JOptionPane.YES_NO_OPTION);
            if(x == JOptionPane.YES_OPTION){
                setVisible(false);
                new HeThong();
            }
        }
    }
    
    public void update(TourDuLich T) {
        arr.remove(index);
        arr.add(T);
        showData();
    }
    
}
