/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BanDAO522;
import dao.ChiTietBanDat522DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Ban522;
import model.Chitietbandat522;

/**
 *
 * @author dhmhm
 */
@WebServlet(name = "doLuuBanDat522", urlPatterns = {"/save"})
public class doLuuBanDat522 extends HttpServlet {

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
            out.println("<title>Servlet doLuuBanDat522</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doLuuBanDat522 at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChiTietBanDat522DAO dao = new ChiTietBanDat522DAO();
        BanDAO522 banDAO = new BanDAO522();
        HttpSession session = request.getSession();
        Chitietbandat522 chitietbandat = (Chitietbandat522) session.getAttribute("chitietbandat");
        Ban522 table = (Ban522) session.getAttribute("selectedTable");
        
        boolean daDat = banDAO.setDaDatBan(table.getId());        
        boolean isSaved = dao.saveBanDat(chitietbandat);
        
        session.removeAttribute("selectedTable");
        session.removeAttribute("chitietbandat");
        if (isSaved) {
            // Chuyển hướng kèm thông báo
            response.sendRedirect("doLuuBanDat522.jsp?success=true");
        } else {
            // Chuyển hướng kèm thông báo lỗi
            response.sendRedirect("doLuuBanDat522.jsp?success=false");
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
