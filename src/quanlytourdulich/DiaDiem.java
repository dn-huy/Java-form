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
public class DiaDiem {
    private String MaDiaDiem;
    private String TenDiaDiem;
    private String ViTri;
    private String MoTa;

    public void setMaDiaDiem(String MaDiaDiem) {
        this.MaDiaDiem = MaDiaDiem;
    }

    public void setTenDiaDiem(String TenDiaDiem) {
        this.TenDiaDiem = TenDiaDiem;
    }

    public String getMaDiaDiem() {
        return MaDiaDiem;
    }

    public String getTenDiaDiem() {
        return TenDiaDiem;
    }

    public String getViTri() {
        return ViTri;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public DiaDiem(String MaDiaDiem, String TenDiaDiem, String ViTri, String MoTa) {
        this.MaDiaDiem = MaDiaDiem;
        this.TenDiaDiem = TenDiaDiem;
        this.ViTri = ViTri;
        this.MoTa = MoTa;
    }
}
