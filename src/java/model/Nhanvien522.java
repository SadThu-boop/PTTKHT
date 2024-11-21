package model;

import java.util.Date;

public class Nhanvien522 {
    private int id;
    private String tendangnhap;
    private String matkhau;
    private String ten;
    private Date ngaysinh;
    private String email;
    private String sodienthoai;
    private HoTen522 hoTen;
    private String diachi;
    
    public Nhanvien522() {
        
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Nhanvien522(String tendangnhap, String matkhau, Date ngaysinh, String email, String sodienthoai, HoTen522 hoTen, String diachi) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.hoTen = hoTen;
        this.diachi = diachi;
    }
    
    

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public HoTen522 getHoTen() {
        return hoTen;
    }

    public void setHoTen(HoTen522 hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String toString() {
        return tendangnhap+" "+matkhau;
    }
}

