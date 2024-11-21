<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Monan522" %>
<%
    Monan522 dish = (Monan522) request.getAttribute("dish");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Món Ăn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Sửa Món Ăn</h1>
    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= dish.getId() %>">
        
        <label for="name">Tên Món Ăn</label>
        <input type="text" id="name" name="name" value="<%= dish.getName() %>" required>
        
        <label for="price">Đơn Giá</label>
        <input type="number" id="price" name="price" value="<%= dish.getDongia() %>" required>
        
        <button type="submit">Cập Nhật</button>
    </form>
</body>
</html>
