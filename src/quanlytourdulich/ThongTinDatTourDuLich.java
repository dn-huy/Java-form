/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;

import java.util.Date;

/**
 *
 * @author Pham Quy
 */
public class ThongTinDatTourDuLich {
    private String MaTour;
    private String MaKH;
    private String MaPhieu;
    private String NgayKhoiHanh;
    private float ChiPhi;

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public void setNgayKhoiHanh(String NgayKhoiHanh) {
        this.NgayKhoiHanh = NgayKhoiHanh;
    }

    public void setChiPhi(float ChiPhi) {
        this.ChiPhi = ChiPhi;
    }

    public String getMaTour() {
        return MaTour;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getNgayKhoiHanh() {
        return NgayKhoiHanh;
    }

    public float getChiPhi() {
        return ChiPhi;
    }

    public ThongTinDatTourDuLich() {
    }

    public ThongTinDatTourDuLich(String MaTour, String MaKH, String MaPhieu,String NgayKhoiHanh, float ChiPhi) {
        this.MaTour = MaTour;
        this.MaKH = MaKH;
        this.MaPhieu = MaPhieu;
        this.NgayKhoiHanh = NgayKhoiHanh;
        this.ChiPhi = ChiPhi;
    }
}
