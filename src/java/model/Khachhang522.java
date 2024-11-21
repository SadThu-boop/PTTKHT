package model;

public class Khachhang522 {
    private int id;
    private String tendangnhap;
    private String matkhau;
    private String ten;
    private String sdt;
    private String diaChi;

    public Khachhang522() {
    }

    public Khachhang522(String tendangnhap, String matkhau, String ten, String sdt, String diaChi) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
