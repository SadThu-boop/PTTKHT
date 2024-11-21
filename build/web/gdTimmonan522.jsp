<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Monan522" %>
<%@page import="model.Nhanvien522" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý món ăn</title>
        <style>
            table {
                width: 80%;
                border-collapse: collapse;
                margin: 20px auto;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #f4f4f4;
                font-weight: bold;
            }
            button {
                padding: 5px 10px;
                font-size: 14px;
            }
            .add-button {
                margin: 20px auto;
                display: block;
                width: 200px;
                padding: 10px 15px;
                text-align: center;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
            }
            .search-bar {
                width: 80%;
                margin: 10px auto;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .search-bar input[type="text"] {
                width: 70%;
                padding: 8px;
                font-size: 16px;
            }
            .search-bar button {
                padding: 8px 16px;
                font-size: 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 4px;
            }
            .search-result {
                text-align: center;
                font-size: 16px;
                margin-top: 10px;
                color: #555;
            }
            .user-info {
                position: absolute;
                top: 10px;
                right: 20px;
                font-size: 16px;
                font-family: Arial, sans-serif;
                color: #333;
                background-color: #f4f4f4;
                padding: 5px 10px;
                border-radius: 5px;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            }
        </style>
    </head>
    <body>
        
        <%
            Nhanvien522 user = (Nhanvien522) session.getAttribute("loggedInUser");
            if (user != null) {
        %>
        <!-- Hiển thị thông tin người dùng ở góc phải -->
        <div class="user-info">
            Xin chào, <strong><%= user.getTen() %></strong>
        </div>
        <%
            }
        %>
        
        <h1 style="text-align: center;">Quản lý món ăn</h1>

        <!-- Thanh tìm kiếm -->
        <div class="search-bar">
            <form action="search" method="get">
                <input type="text" name="keyword" placeholder="Nhập tên món ăn..." value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : "" %>" required>
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>

        <!-- Hiển thị kết quả tìm kiếm -->
        <% if (request.getParameter("keyword") != null) { %>
            <div class="search-result">
                Kết quả tìm kiếm cho: "<strong><%= request.getParameter("keyword") %></strong>"
            </div>
        <% } %>

        
        <table>
            <tr>
                <th>ID</th>
                <th>Tên món</th>
                <th>Đơn giá</th>
                <th>Hành động</th>
            </tr>
            <% 
                List<Monan522> list = (List<Monan522>) request.getAttribute("data");
                if (list != null && !list.isEmpty()) {
                    for(Monan522 i : list) {
            %>
            <tr>
                <td><%=i.getId() %></td>
                <td><%=i.getName() %></td>
                <td><%=i.getDongia() %></td>
                <td>
                    <!-- Nút sửa -->
                    <a href="edit?id=<%=i.getId() %>">
                        <button style="background-color: #FFC107; color: white;">Sửa</button>
                    </a>
                    
                    <!-- Nút xóa -->
                    <a href="deleteDish?id=<%=i.getId() %>" onclick="return confirm('Bạn có chắc chắn muốn xóa món này?');">
                        <button style="background-color: #F44336; color: white;">Xóa</button>
                    </a>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="4">Không có món ăn nào trong danh sách.</td>
            </tr>
            <% 
                }
            %>
        </table>
    </body>
</html>
