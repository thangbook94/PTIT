package entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String hoTen;
    private String namSinh;
    private String queQuan;
    private String hocVan;
    private String chuyenMon;
    private String daoTao;
    private String lamViec;
    private String status;
    private String vaiTro;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getHocVan() {
        return hocVan;
    }

    public void setHocVan(String hocVan) {
        this.hocVan = hocVan;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getDaoTao() {
        return daoTao;
    }

    public void setDaoTao(String daoTao) {
        this.daoTao = daoTao;
    }

    public String getLamViec() {
        return lamViec;
    }

    public void setLamViec(String lamViec) {
        this.lamViec = lamViec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}
