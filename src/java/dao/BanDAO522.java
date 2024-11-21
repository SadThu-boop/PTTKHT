package dao;

import model.Monan522;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ban522;

public class BanDAO522 extends DAO{
    
    public BanDAO522() {
        super();
    }
    
    public Ban522 getBanById(int id) {
        String query = "SELECT * FROM Ban522 WHERE id = ?";
        Ban522 ban = null;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ban = new Ban522();
                ban.setId(rs.getInt("id"));
                ban.setTrangthai(rs.getBoolean("trangthai"));
            }
                
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ban;
    }
    
    public boolean setDaDatBan(int tableId) {
        String query = "UPDATE Ban522 SET trangthai = FALSE WHERE id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,tableId);
            
            return ps.executeUpdate() > 0;
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Ban522> getBanTrong() {
        String query = "SELECT * FROM Ban522 WHERE trangthai = TRUE";
        List<Ban522> list = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Ban522 ban = new Ban522();
                ban.setId(rs.getInt("id"));
                ban.setTrangthai(rs.getBoolean("trangthai"));
                list.add(ban);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        BanDAO522 banDAO = new BanDAO522();
        List<Ban522> list = banDAO.getBanTrong();
        for(Ban522 x:list) {
            System.out.println(x.getId()+" "+x.isTrangthai());
        }
    }


}
