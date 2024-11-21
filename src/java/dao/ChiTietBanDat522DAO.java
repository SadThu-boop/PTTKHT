/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Chitietbandat522;
import model.Chitietmonan522;
import model.Monan522;
import java.sql.Statement;



/**
 *
 * @author dhmhm
 */
public class ChiTietBanDat522DAO extends DAO{
    public ChiTietBanDat522DAO() {
        super();
    }
    
    public boolean saveBanDat(Chitietbandat522 chitietbandat) {
        String sql = "INSERT INTO Chitietbandat522(id_khachhang,id_ban,ngaydat,soluong) VALUES (?,?,?,?)";
        String sqlMonAn = "INSERT INTO chitietbandat_monan522 (id_chitietbandat, id_monan, soluong) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // Bắt đầu transaction
            con.setAutoCommit(false);

            // Tạo PreparedStatement với RETURN_GENERATED_KEYS
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, chitietbandat.getKhachhang().getId());
            ps.setInt(2, chitietbandat.getBan().getId());
            ps.setDate(3, new java.sql.Date(chitietbandat.getNgayDat().getTime()));
            ps.setInt(4, chitietbandat.getSoLuong());
            ps.executeUpdate();

            // Lấy id tự động sinh
            rs = ps.getGeneratedKeys();
            int chitietbandatId = 0;
            if (rs.next()) {
                chitietbandatId = rs.getInt(1);
            }
            rs.close();
            ps.close();

            // Thêm chi tiết món ăn
            ps = con.prepareStatement(sqlMonAn);
            for (Chitietmonan522 ctma : chitietbandat.getChitietMonanList()) {
                ps.setInt(1, chitietbandatId);
                ps.setInt(2, ctma.getMonan().getId());
                ps.setInt(3, ctma.getSoLuong());
                ps.addBatch();
            }
            ps.executeBatch();

            // Commit transaction
            con.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback(); // Rollback nếu có lỗi
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                con.setAutoCommit(true); // Khôi phục chế độ auto-commit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
