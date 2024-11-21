<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Monan522"%>
<%@page import="model.Ban522"%>
<%@page import="model.Khachhang522"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn món</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
        .user-info {
            position: absolute;
            top: 10px;
            right: 20px;
            font-size: 16px;
            background-color: #f4f4f4;
            padding: 5px 10px;
            border-radius: 5px;
        }
        .search-container {
            margin: 20px auto;
            text-align: center;
        }
        .search-result {
            text-align: center;
            font-size: 16px;
            margin-top: 10px;
            color: #555;
        }
    </style>
</head>
<body>
    <% 
        Khachhang522 kh = (Khachhang522) session.getAttribute("khachhang");
        if (kh != null) { 
    %>
    <div class="user-info">
        Xin chào, <strong><%= kh.getTen() %></strong>
    </div>
    <% } %>

    <h1 class="text-center">Chọn món ăn</h1>

    <!-- Hiển thị bàn đã chọn -->
    <p class="text-center">Bạn đang đặt món cho bàn: 
        <strong>
            <% 
                Ban522 selectedBan = (Ban522) session.getAttribute("selectedTable");
                out.print(selectedBan != null ? selectedBan.getId() : "Không xác định");
            %>
        </strong>
    </p>

    <!-- Form tìm kiếm -->
    <div class="search-container">
        <form action="tim" method="GET">
            <input type="text" name="search" placeholder="Nhập tên món ăn" class="form-control w-50 d-inline">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </form>
    </div>

    <!-- Bảng danh sách món ăn -->
    <form action="addDishToOrder" method="POST">
        <table>
            <tr>
                <th>ID</th>
                <th>Tên món</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Hành động</th>
            </tr>
            <% 
                List<Monan522> list = (List<Monan522>) request.getAttribute("data");
                if (list != null && !list.isEmpty()) {
                    for (Monan522 dish : list) {
            %>
            <tr>
                <td><%= dish.getId() %></td>
                <td><%= dish.getName() %></td>
                <td><%= dish.getDongia() %></td>
                <td>
                    <input type="number" name="quantity_<%= dish.getId() %>" id="quantity_<%= dish.getId() %>" min="1" value="1">
                </td>
                <td>
                    <button class="add btn btn-success" type="submit" name="dishId" value="<%= dish.getId() %>">Thêm món</button>
                </td>
            </tr>
            <% 
                    }
                } else { 
            %>
            <tr>
                <td colspan="5">Không có món ăn nào phù hợp.</td>
            </tr>
            <% 
                } 
            %>
        </table>
    </form>
</body>

</html>
