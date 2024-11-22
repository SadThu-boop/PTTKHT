<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Lấy tham số thành công từ URL
    String success = request.getParameter("success");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đặt bàn</title>
    <style>
        /* CSS cho box thông báo */
        .notification-box {
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 15px;
            background-color: #28a745;
            color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            display: none; /* Mặc định ẩn */
            z-index: 1000;
        }
        .notification-box.error {
            background-color: #dc3545;
        }
    </style>
    <script>
        // JavaScript để hiển thị box thông báo
        function showNotification(message, isError) {
            const box = document.getElementById('notification-box');
            box.textContent = message;
            if (isError) {
                box.classList.add('error');
            } else {
                box.classList.remove('error');
            }
            box.style.display = 'block';
            setTimeout(() => {
                box.style.display = 'none';
            }, 3000); // Ẩn sau 3 giây
        }

        // Chuyển hướng sau 5 giây
        function redirectAfterDelay(url, delay) {
            setTimeout(() => {
                window.location.href = url;
            }, delay);
        }
    </script>
</head>
<body>
    <div id="notification-box" class="notification-box"></div>
    <% if ("true".equals(success)) { %>
        <script>
            showNotification('Thêm bàn đặt thành công!', false);
            redirectAfterDelay('gdChinhKH522.jsp', 5000); // Chuyển hướng sau 5 giây
        </script>
    <% } else if ("false".equals(success)) { %>
        <script>
            showNotification('Thêm bàn đặt thất bại!', true);
            redirectAfterDelay('gdChinhKH522.jsp', 5000); // Chuyển hướng sau 5 giây
        </script>
    <% } %>
    
   
</body>
</html>
