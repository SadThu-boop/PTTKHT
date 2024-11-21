<%@page import="model.Khachhang522"%>
<%@page import="java.util.List"%>
<%@page import="model.Ban522"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách bàn trống</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        button {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button.edit {
            background-color: #FFC107;
            color: white;
        }
        button.delete {
            background-color: #F44336;
            color: white;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
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
            Khachhang522 kh = (Khachhang522) session.getAttribute("khachhang");
            if (kh != null) {
        %>
        <!-- Hiển thị thông tin người dùng ở góc phải -->
        <div class="user-info">
            Xin chào, <strong><%= kh.getTen()%></strong>
        </div>
        <%
            }
        %>
    
    <h1>Danh sách bàn trống</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <% 
            List<Ban522> list = (List<Ban522>) request.getAttribute("tables");
            if (list != null && !list.isEmpty()) {
                for(Ban522 i : list) {
        %>
        <tr>
            <td><%=i.getId() %></td>
            <td><%=i.isTrangthai()? "Trống" : "Đã đặt" %></td>
            <td>
                <!-- Nút đặt -->
                <a href="choose?id=<%=i.getId() %>">
                    <button class="edit">Đặt bàn</button>
                </a>

            
            </td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="3">Không có bàn trống nào.</td>
        </tr>
        <% 
            }
        %>
    </table>

    <!-- Nút quay lại -->
    <div style="text-align: center; margin-top: 20px;">
        <a href="gdTimBan522.jsp">
            <button style="padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px;">Quay lại</button>
        </a>
    </div>
</body>
</html>
