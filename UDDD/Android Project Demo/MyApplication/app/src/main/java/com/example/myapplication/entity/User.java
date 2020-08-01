package com.example.myapplication.entity;

public class User {
    private int id;
    private String ho;
    private String ten;
    private String nam_sinh;
    private String que_quan;
    private String trinh_do;
    private String chuyen_mon;
    private String dao_tao;
    private String lam_viec;
    private String status;
    private String phong;
    private String hoc_van;

    public String getHoc_van() {
        return hoc_van;
    }

    public void setHoc_van(String hoc_van) {
        this.hoc_van = hoc_van;
    }

    public String getStatus() {
        return status;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(int id, String ho, String ten,
                String nam_sinh, String que_quan, String trinh_do,
                String chuyen_mon, String dao_tao, String lam_viec) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.nam_sinh = nam_sinh;
        this.que_quan = que_quan;
        this.trinh_do = trinh_do;
        this.chuyen_mon = chuyen_mon;
        this.dao_tao = dao_tao;
        this.lam_viec = lam_viec;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNam_sinh() {
        return nam_sinh;
    }

    public void setNam_sinh(String nam_sinh) {
        this.nam_sinh = nam_sinh;
    }

    public String getQue_quan() {
        return que_quan;
    }

    public void setQue_quan(String que_quan) {
        this.que_quan = que_quan;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }

    public String getChuyen_mon() {
        return chuyen_mon;
    }

    public void setChuyen_mon(String chuyen_mon) {
        this.chuyen_mon = chuyen_mon;
    }

    public String getDao_tao() {
        return dao_tao;
    }

    public void setDao_tao(String dao_tao) {
        this.dao_tao = dao_tao;
    }

    public String getLam_viec() {
        return lam_viec;
    }

    public void setLam_viec(String lam_viec) {
        this.lam_viec = lam_viec;
    }
}
