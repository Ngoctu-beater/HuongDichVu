<%-- 
    Document   : compare
    Created on : Dec 5, 2024, 3:19:06 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>So sánh xe</title>
        <link href="css/compare.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 style="text-align: center">So sánh xe ô tô</h1>
        <button class="add-car-button">Thêm xe</button>
    <c:if test="${not empty carDetails}">
        <table border="1">
            <thead>
                <tr>
                    <th>Thông số</th>
            <c:forEach items="${carDetails}" var="car">
                <th>
                    <img src="${car.anh}" alt="${car.tenXe}" width="100"><br>
                    ${car.tenXe}
                </th>
            </c:forEach>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Giá xe</td>
            <c:forEach items="${carDetails}" var="car">
                <td>${car.gia}</td>
            </c:forEach>
            </tr>
            <tr>
                <td>Đời xe</td>
            <c:forEach items="${carDetails}" var="car">
                <td>${car.doiXe}</td>
            </c:forEach>
            </tr>
            <!-- Thêm các thông số khác tương tự -->
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty carDetails}">
        <p>Không có xe nào để so sánh.</p>
    </c:if>
</body>
</html>
