/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.KhachHangDAO522;
import dao.NhanvienDAO522;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Khachhang522;
import model.Nhanvien522;

/**
 *
 * @author dhmhm
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request,response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Lấy thông tin từ form
    String tendangnhap = request.getParameter("username");
    String matkhau = request.getParameter("password");
    String role = request.getParameter("role"); // Lấy vai trò từ radio button

    // Gọi DAO phù hợp dựa trên role
    if ("customer".equals(role)) {
        // Kiểm tra trong bảng khách hàng
        KhachHangDAO522 khDAO = new KhachHangDAO522();
        Khachhang522 kh = khDAO.checkLogin(tendangnhap, matkhau);

        if (kh != null) {
            // Lưu thông tin khách hàng vào session
            request.getSession().setAttribute("khachhang", kh);
            // Chuyển hướng đến trang khách hàng
            request.getRequestDispatcher("gdChinhKH522.jsp").forward(request, response);
        } else {
            // Thông báo lỗi nếu thông tin không hợp lệ
            response.sendRedirect("login.jsp?error=invalid_customer");
        }
    } else if ("employee".equals(role)) {
        // Kiểm tra trong bảng nhân viên
        NhanvienDAO522 nhanVienDAO = new NhanvienDAO522();
        Nhanvien522 user = nhanVienDAO.checkLogin(tendangnhap, matkhau);

        if (user != null) {
            // Lưu thông tin nhân viên vào session
            request.getSession().setAttribute("loggedInUser", user);
            // Chuyển hướng đến trang nhân viên
            request.getRequestDispatcher("gdChinhNV522.jsp").forward(request, response);
        } else {
            // Thông báo lỗi nếu thông tin không hợp lệ
            response.sendRedirect("login.jsp?error=invalid_employee");
        }
    } else {
        // Quay lại trang đăng nhập nếu không có vai trò hợp lệ
        response.sendRedirect("login.jsp?error=invalid_role");
    }
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
