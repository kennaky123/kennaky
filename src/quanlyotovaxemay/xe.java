/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyotovaxemay;

/**
 *
 * @author chipt
 */
public class xe {
    int id;
    String BienSo, PhanKhoi, LoaiXe;
    int LePhiTieuThuDB, SoChoNgoi;

    public xe() {
    }

    public xe(int id, String BienSo, String PhanKhoi, String LoaiXe, int LePhiTieuThuDB, int SoChoNgoi) {
        this.id = id;
        this.BienSo = BienSo;
        this.PhanKhoi = PhanKhoi;
        this.LoaiXe = LoaiXe;
        this.LePhiTieuThuDB = LePhiTieuThuDB;
        this.SoChoNgoi = SoChoNgoi;
    }
    
    // do ID có thể nhập rỗng để nó tự động tăng nên sẽ có 1 hàm ko có ID cho không lỗi
    public xe(String BienSo, String PhanKhoi, String LoaiXe, int LePhiTieuThuDB, int SoChoNgoi) {
        this.BienSo = BienSo;
        this.PhanKhoi = PhanKhoi;
        this.LoaiXe = LoaiXe;
        this.LePhiTieuThuDB = LePhiTieuThuDB;
        this.SoChoNgoi = SoChoNgoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public String getPhanKhoi() {
        return PhanKhoi;
    }

    public void setPhanKhoi(String PhanKhoi) {
        this.PhanKhoi = PhanKhoi;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }

    public void setLoaiXe(String LoaiXe) {
        this.LoaiXe = LoaiXe;
    }

    public int getLePhiTieuThuDB() {
        return LePhiTieuThuDB;
    }

    public void setLePhiTieuThuDB(int LePhiTieuThuDB) {
        this.LePhiTieuThuDB = LePhiTieuThuDB;
    }

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int SoChoNgoi) {
        this.SoChoNgoi = SoChoNgoi;
    }
    
    
}
