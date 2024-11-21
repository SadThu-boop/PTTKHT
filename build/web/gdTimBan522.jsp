<%@page import="model.Khachhang522"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm bàn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            margin-top: 100px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            width: 40%;
            margin: auto;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4CAF50;
        }
        label {
            font-weight: bold;
        }
        input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 15px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            margin: 15px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #45a049;
        }
        p.error {
            color: red;
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
    
    <div class="container">
        <h1>Tìm bàn</h1>
        <!-- Hiển thị thông báo lỗi nếu có -->
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <!-- Form nhập số điện thoại -->
        <form action="find" method="post">
            <label for="phone">Nhập số điện thoại của bạn:</label><br>
            <input type="text" id="phone" name="phoneNumber" placeholder="Nhập số điện thoại" required><br>
            <button type="submit">Tìm bàn</button>
        </form>
    </div>
</body>
</html>
