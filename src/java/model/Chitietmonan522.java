package model;

public class Chitietmonan522 {
    private int id;
    private Chitietbandat522 chitietbandat; // Liên kết với Chitietbandat522 (chi tiết bàn đặt)
    private Monan522 monan; // Liên kết với Monan522 (món ăn)
    private int soLuong; // Số lượng món ăn được đặt

    // Constructor không tham số
    public Chitietmonan522() {
    }

    // Constructor đầy đủ tham số
    public Chitietmonan522(int id, Chitietbandat522 chitietbandat, Monan522 monan, int soLuong) {
        this.id = id;
        this.chitietbandat = chitietbandat;
        this.monan = monan;
        this.soLuong = soLuong;
    }

    // Getter và Setter cho thuộc tính 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getter và Setter cho thuộc tính 'chitietbandat'
    public Chitietbandat522 getChitietbandat() {
        return chitietbandat;
    }

    public void setChitietbandat(Chitietbandat522 chitietbandat) {
        this.chitietbandat = chitietbandat;
    }

    // Getter và Setter cho thuộc tính 'monan'
    public Monan522 getMonan() {
        return monan;
    }

    public void setMonan(Monan522 monan) {
        this.monan = monan;
    }

    // Getter và Setter cho thuộc tính 'soLuong'
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "Chitietmonan522{" +
                "id=" + id +
                ", chitietbandat=" + chitietbandat +
                ", monan=" + monan +
                ", soLuong=" + soLuong +
                '}';
    }
}
