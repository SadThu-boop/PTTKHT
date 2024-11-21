package model;

public class Ban522 {
    private int id;
    private boolean trangthai;

    public Ban522(){}

   
    public Ban522(int id, boolean trangthai) {
        this.id = id;
        this.trangthai = trangthai;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Ban{id=" + id + ", status=" + (trangthai ? "Trống" : "Đã đặt") + "}";
    }
  
}
