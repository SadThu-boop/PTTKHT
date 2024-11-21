<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Nhanvien522" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang Chủ</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom CSS */
        body {
            background-color: #f4f7f6;
            font-family: 'Arial', sans-serif;
        }
        .user-badge {
            position: absolute;
            top: 15px;
            right: 20px;
            background-color: #e9ecef;
            padding: 8px 15px;
            border-radius: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .dashboard-card {
            margin-top: 50px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            padding: 30px;
        }
        .action-btn {
            margin: 10px;
            padding: 12px 25px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            Nhanvien522 user = (Nhanvien522) session.getAttribute("loggedInUser");
            if (user != null) {
        %>
        <div class="user-badge text-muted">
            Xin chào, <strong><%= user.getTen() %></strong>
        </div>
        <%
            }
        %>

        <div class="row justify-content-center">
            <div class="col-md-8 dashboard-card text-center">
                <h1 class="mb-4">Trang Chủ</h1>
                
                <a href="listMonAn" class="btn btn-primary btn-lg action-btn">
                    Sửa Món Ăn
                </a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>