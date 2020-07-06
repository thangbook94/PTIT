<%-- 
    Document   : demo
    Created on : Dec 4, 2019, 10:19:44 AM
    Author     : SA Nice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="">
            <input type="text" name="hoTen" placeholder="Hãy Nhập Vào Họ Và Tên"><br><br>
            <input type="text" name="queQuan" placeholder="Hãy Nhập Vào Quê Quán"><br><br>
            <select required>
              <option value="" disabled selected>Hãy Chọn Giới Tính</option>
              <option value="nam">Nam</option>
              <option value="nu">Nữ</option>
            </select><br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
