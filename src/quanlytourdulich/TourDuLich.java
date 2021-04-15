/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytourdulich;

/**
 *
 * @author Pham Quy
 */
public class TourDuLich {
    private String MaTour;
    private String TenTour;
    private int SoNgay;
    private String LoaiTour;
    private float ChiPhi;

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    public void setTenTour(String TenTour) {
        this.TenTour = TenTour;
    }

    public void setNgay(int SoNgayDiTour) {
        this.SoNgay = SoNgayDiTour;
    }

    public void setLoaiTour(String LoaiTour) {
        this.LoaiTour = LoaiTour;
    }

    public void setChiPhi(float ChiPhi) {
        this.ChiPhi = ChiPhi;
    }

    public String getMaTour() {
        return MaTour;
    }

    public String getTenTour() {
        return TenTour;
    }

    public int getNgay() {
        return SoNgay;
    }

    public String getLoaiTour() {
        return LoaiTour;
    }

    public float getChiPhi() {
        return ChiPhi;
    }

    public TourDuLich(String MaTour, String TenTour, int SoNgayDiTour, String LoaiTour, float ChiPhi) {
        this.MaTour = MaTour;
        this.TenTour = TenTour;
        this.SoNgay = SoNgayDiTour;
        this.LoaiTour = LoaiTour;
        this.ChiPhi = ChiPhi;
    }

}
