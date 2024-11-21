package dao;


import dao.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Nhanvien522;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dhmhm
 */
public class NhanvienDAO522 extends DAO{
    public NhanvienDAO522() {
        super();
    }
    
    public Nhanvien522 checkLogin(String username, String password) {
        String query = "SELECT * FROM Nhanvien522 where tendangnhap = ? and matkhau = ?";
        Nhanvien522 user = null;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
               user = new Nhanvien522();
               user.setTendangnhap(rs.getString("tendangnhap"));
               user.setMatkhau(rs.getString("matkhau"));
               user.setTen(rs.getString("ten"));
               user.setNgaysinh(rs.getDate("ngaysinh"));
               user.setEmail(rs.getString("email"));
               user.setSodienthoai(rs.getString("sodienthoai"));
               user.setDiachi(rs.getString("diachi"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static void main(String[] args) {
        NhanvienDAO522 nhanVienDAO = new NhanvienDAO522();
        Nhanvien522 user = nhanVienDAO.checkLogin("admin", "admin");
        System.out.println(user.toString());
    }
}
