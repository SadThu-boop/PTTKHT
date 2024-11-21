<%@page import="model.Chitietbandat522"%>
<%@page import="model.Chitietmonan522"%>
<%@page import="model.Monan522"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Lấy thông tin từ session
    Chitietbandat522 chitietbandat = (Chitietbandat522) session.getAttribute("chitietbandat");

    if (chitietbandat == null) {
        // Nếu không có thông tin đặt bàn, chuyển hướng về trang menu
        response.sendRedirect("gdChonMon522.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đặt bàn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        table th {
            background-color: #f4f4f4;
        }
        .summary {
            margin-top: 20px;
            font-size: 18px;
        }
        .button-container {
            margin-top: 30px;
            text-align: center; /* Căn giữa nội dung bên trong */
        }
        .action-btn {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            font-size: 16px;
            cursor: pointer;
        }
        .action-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Chi tiết đặt bàn</h1>
    
    <!-- Hiển thị thông tin khách hàng và bàn -->
    <p><strong>Khách hàng:</strong> <%= chitietbandat.getKhachhang().getTen()%></p>
    <p><strong>Bàn:</strong> <%= chitietbandat.getBan().getId()%></p>
    <p><strong>Ngày đặt:</strong> <%= chitietbandat.getNgayDat() %></p>
    
    <!-- Hiển thị danh sách món ăn -->
    <h2>Danh sách món ăn</h2>
    <table>
        <thead>
            <tr>
                <th>Tên món ăn</th>
                <th>Số lượng</th>
                <th>Giá mỗi món</th>
                <th>Thành tiền</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Chitietmonan522> chitietMonanList = chitietbandat.getChitietMonanList();
                double tongTien = 0;

                for (Chitietmonan522 chitietmonan : chitietMonanList) {
                    Monan522 monan = chitietmonan.getMonan();
                    int soLuong = chitietmonan.getSoLuong();
                    float giaMon = monan.getDongia();
                    double thanhTien = soLuong * giaMon;
                    tongTien += thanhTien;
            %>
            <tr>
                <td><%= monan.getName()%></td>
                <td><%= soLuong %></td>
                <td><%= giaMon %> VND</td>
                <td><%= thanhTien %> VND</td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <!-- Hiển thị tổng số lượng và tổng tiền -->
    <div class="summary">
        <p><strong>Tổng số lượng:</strong> <%= chitietbandat.getSoLuong() %></p>
        <p><strong>Tổng tiền:</strong> <%= tongTien %> VND</p>
    </div>

    <div class="button-container">
        <form action="save" method="post" style="display: inline-block; margin-right: 10px;">
            <input type="hidden" name="bookingId" value="<%= chitietbandat.getId() %>">
            <input type="hidden" name="totalPrice" value="<%= tongTien %>">
            <button type="submit" class="action-btn">Xác nhận bàn đặt</button>
        </form>
        <a class="action-btn" href="choose?id=<%= chitietbandat.getBan().getId()%>">Quay lại thực đơn</a>
    </div>
</body>
</html>
