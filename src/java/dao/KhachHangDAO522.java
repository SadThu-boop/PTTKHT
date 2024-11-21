/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Khachhang522;

/**
 *
 * @author dhmhm
 */
public class KhachHangDAO522 extends DAO{
    public KhachHangDAO522() {
        super();
    }
    
    public Khachhang522 checkLogin(String username, String password) {
        String query = "SELECT * FROM Khachhang522 WHERE tendangnhap = ? AND matkhau = ?";
        Khachhang522 kh = null;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                kh = new Khachhang522();
                kh.setId(rs.getInt("id"));
                kh.setTendangnhap(rs.getString("tendangnhap"));
                kh.setMatkhau(rs.getString("matkhau"));
                kh.setTen(rs.getString("ten"));
                kh.setSdt(rs.getString("sodienthoai"));
                kh.setDiaChi(rs.getString("diachi"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }
    
    public boolean existsByPhone(String phone) {
        String query = "SELECT * FROM Khachhang522 where sodienthoai=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,phone);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        KhachHangDAO522 khDAO = new KhachHangDAO522();
        if(khDAO.existsByPhone("0845040403")) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
