package model;

import java.util.Date;
import java.util.List;

public class Chitietbandat522 {
    private int id;
    private Khachhang522 khachhang; // Liên kết với Khachhang522
    private Ban522 ban; // Liên kết với Ban522
    private Date ngayDat;
    private int soLuong;
    
    private List<Chitietmonan522> chitietMonanList; // Danh sách món ăn

    public List<Chitietmonan522> getChitietMonanList() {
        return chitietMonanList;
    }

    public void setChitietMonanList(List<Chitietmonan522> chitietMonanList) {
        this.chitietMonanList = chitietMonanList;
    }


    // Constructor không tham số
    public Chitietbandat522() {
    }

    // Constructor đầy đủ tham số
    public Chitietbandat522(int id, Khachhang522 khachhang, Ban522 ban, Date ngayDat, int soLuong) {
        this.id = id;
        this.khachhang = khachhang;
        this.ban = ban;
        this.ngayDat = ngayDat;
        this.soLuong = soLuong;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Khachhang522 getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang522 khachhang) {
        this.khachhang = khachhang;
    }

    public Ban522 getBan() {
        return ban;
    }

    public void setBan(Ban522 ban) {
        this.ban = ban;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Chitietbandat522{" +
                "id=" + id +
                ", khachhang=" + khachhang +
                ", ban=" + ban +
                ", ngayDat=" + ngayDat +
                ", soLuong=" + soLuong +
                '}';
    }
}
