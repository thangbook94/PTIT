package entity;

import java.io.Serializable;

public class Phong implements Serializable {
    private int id;
    private String so;
    private String tang;
    private String loai;
    private String gia;
    private String status;

    public Phong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
