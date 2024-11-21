/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BanDAO522;
import dao.MonAnDAO522;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Ban522;
import model.Chitietbandat522;
import model.Chitietmonan522;
import model.Khachhang522;
import model.Monan522;

/**
 *
 * @author dhmhm
 */
@WebServlet(name = "AddDishToOrder", urlPatterns = {"/addDishToOrder"})
public class AddDishToOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddDishToOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDishToOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MonAnDAO522 monAnDAO = new MonAnDAO522();
        BanDAO522 banDAO = new BanDAO522();

        // Lấy dishId từ tham số request
        String dishIdStr = request.getParameter("dishId");
        int dishId = Integer.parseInt(dishIdStr);

        // Lấy số lượng từ tham số request
        String quantityStr = request.getParameter("quantity_" + dishId);
        int quantity = Integer.parseInt(quantityStr);

        // Lấy thông tin bàn và khách hàng từ session
        HttpSession session = request.getSession();
        Ban522 selectedTable = (Ban522) session.getAttribute("selectedTable");
        Khachhang522 khachhang = (Khachhang522) session.getAttribute("khachhang");

        // Kiểm tra và tạo mới Chitietbandat522 nếu chưa có
        Chitietbandat522 chitietbandat = (Chitietbandat522) session.getAttribute("chitietbandat");
        if (chitietbandat == null) {
            chitietbandat = new Chitietbandat522();
            chitietbandat.setKhachhang(khachhang);
            chitietbandat.setBan(selectedTable);
            chitietbandat.setNgayDat(new Date());
            chitietbandat.setSoLuong(0);
            chitietbandat.setChitietMonanList(new ArrayList<>());
            session.setAttribute("chitietbandat", chitietbandat);
        }

        // Lấy thông tin món ăn từ cơ sở dữ liệu hoặc danh sách món ăn
        Monan522 dish = monAnDAO.getMonAnById(dishId);

        // Kiểm tra danh sách món ăn trong chitietbandat
        List<Chitietmonan522> chitietMonanList = chitietbandat.getChitietMonanList();
        boolean itemExists = false;

        // Lặp qua danh sách để kiểm tra xem món ăn đã tồn tại hay chưa
        for (Chitietmonan522 existingChitietmonan : chitietMonanList) {
            if (existingChitietmonan.getMonan().getId() == dishId) {
                // Nếu món ăn đã tồn tại, tăng số lượng
                int newQuantity = existingChitietmonan.getSoLuong() + quantity;
                existingChitietmonan.setSoLuong(newQuantity);
                itemExists = true;
                break;
            }
        }

        // Nếu món ăn chưa tồn tại, thêm món ăn mới vào danh sách
        if (!itemExists) {
            Chitietmonan522 chitietmonan = new Chitietmonan522();
            chitietmonan.setChitietbandat(chitietbandat);
            chitietmonan.setMonan(dish);
            chitietmonan.setSoLuong(quantity);
            chitietMonanList.add(chitietmonan);
        }

        // Cập nhật tổng số lượng món trong chitietbandat
        int currentSoLuong = chitietbandat.getSoLuong();
        chitietbandat.setSoLuong(currentSoLuong + quantity);

        // Lưu chitietbandat vào session
        session.setAttribute("chitietbandat", chitietbandat);

        // Chuyển hướng về trang thực đơn hoặc trang xác nhận
        request.getRequestDispatcher("gdChiTietBanDat522.jsp").forward(request, response);
    }


        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

    }
