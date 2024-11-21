package dao;

import model.Monan522;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonAnDAO522 extends DAO{
    
    public MonAnDAO522() {
        super();
    }
    
    public Monan522 getMonAnById(int id) {
        String query = "SELECT * FROM Monan522 WHERE id = ?";
        Monan522 dish = null;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                dish = new Monan522();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("ten"));
                dish.setDongia(rs.getFloat("dongia"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }
    
    public boolean updateMonan(Monan522 dish) {
        String query = "UPDATE Monan522 SET ten = ?, dongia = ? WHERE id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,dish.getName());
            ps.setFloat(2,dish.getDongia());
            ps.setInt(3,dish.getId());
            
            int rows = ps.executeUpdate();
            return rows > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Monan522> seachDishes(String keyword) {
        String query = "SELECT * FROM Monan522 WHERE ten LIKE ?";
        List<Monan522> list = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,"%"+keyword+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Monan522 dish = new Monan522();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("ten"));
                dish.setDongia(rs.getFloat("dongia"));
                list.add(dish);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Monan522> getAllMonAn() {
        List<Monan522> monAnList = new ArrayList<>();
        String query = "SELECT * FROM Monan522";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Monan522 monAn = new Monan522();
                monAn.setId(rs.getInt("id"));
                monAn.setName(rs.getString("ten"));
                monAn.setDongia(rs.getFloat("dongia"));
                monAnList.add(monAn);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return monAnList;
    }
    public Monan522 getMonAnByName(String name) {
        return null;
    }

    public static void main(String[] args) {
    MonAnDAO522 monAnDAO = new MonAnDAO522();
    
    // Lấy thông tin món ăn từ cơ sở dữ liệu
    Monan522 dish = monAnDAO.getMonAnById(1);
    
    // Thay đổi thông tin món ăn
    dish.setName("Pho bo");
    dish.setDongia(55000);

    // Cập nhật món ăn vào cơ sở dữ liệu
    boolean isUpdated = monAnDAO.updateMonan(dish);

    // Kiểm tra kết quả
    if (isUpdated) {
        System.out.println("Cập nhật thành công: " + dish.toString());
    } else {
        System.out.println("Cập nhật thất bại.");
    }
}


}
