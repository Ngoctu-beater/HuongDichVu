<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý</title>
        <link rel="stylesheet" href="css/vehiclemanagement.css" />
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>
    <body style="margin: 0; padding: 0">
        <div class="container" style="display: flex; max-width: 100%">
            <div class="menu" style="width: 18%">
                <jsp:include page="menu.jsp" />
            </div>

            <div class="content" style="width: 82%">
                <h2>Quản lý xe</h2>

                <button class="add-button" onclick="toggleForm()">Thêm xe</button>

                <!-- Form Thêm Xe -->
                <div id="addForm" style="display: none;">
                    <h3>Thêm xe mới</h3>
                    <form action="AddController" method="post">
                        <div class="form-group">
                            <label for="carName">Tên xe</label>
                            <input type="text" id="carName" name="carName" required>
                        </div>
                        <div class="form-group">
                            <label for="carPrice">Giá chữ</label>
                            <input type="text" id="carPrice" name="carPriceTitle" required>
                        </div>
                        <div class="form-group">
                            <label for="carPrice">Giá số</label>
                            <input type="text" id="carPrice" name="carPrice" required>
                        </div>
                        <div class="form-group">
                            <label for="carYear">Năm sản xuất</label>
                            <input type="text" id="carYear" name="carYear" required>
                        </div>
                        <div class="form-group">
                            <label for="carStatus">Tình trạng</label>
                            <input type="text" id="carStatus" name="carStatus" required>
                        </div>
                        <div class="form-group">
                            <label for="carHasgone">Đã đi</label>
                            <input type="text" id="carHasgone" name="carHasgone" required>
                        </div>
                        <div class="form-group">
                            <label for="carOrigin">Xuất xứ</label>
                            <input type="text" id="carOrigin" name="carOrigin" required>
                        </div>
                        <div class="form-group">
                            <label for="carStyle">Kiểu dáng</label>
                            <input type="text" id="carStyle" name="carStyle" required>
                        </div>
                        <div class="form-group">
                            <label for="carGearbox">Hộp số</label>
                            <input type="text" id="carGearbox" name="carGearbox" required>
                        </div>
                        <div class="form-group">
                            <label for="carEngine">Động cơ</label>
                            <input type="text" id="carEngine" name="carEngine" required>
                        </div>
                        <div class="form-group">
                            <label for="carExterior">Ngoại thất</label>
                            <input type="text" id="carExterior" name="carExterior" required>
                        </div>
                        <div class="form-group">
                            <label for="carInterior">Nội thất</label>
                            <input type="text" id="carInterior" name="carInterior" required>
                        </div>
                        <div class="form-group">
                            <label for="carSeats">Chỗ ngồi</label>
                            <input type="text" id="carSeats" name="carSeats" required>
                        </div>
                        <div class="form-group">
                            <label for="carDoors">Số cửa</label>
                            <input type="text" id="carDoors" name="carDoors" required>
                        </div>
                        <div class="form-group">
                            <label for="carDrive">Dẫn động</label>
                            <input type="text" id="carDrive" name="carDrive" required>
                        </div>
                        <div class="form-group">
                            <label for="carDescribe">Mô tả</label>
                            <input type="text" id="carDescribe" name="carDescribe" required>
                        </div>
                        <div class="form-group">
                            <label for="carLink">Link</label>
                            <input type="text" id="carLink" name="carLink" required>
                        </div>
                        <button type="submit" class="save-button">Thêm</button>
                    </form>
                </div>

                <!-- Search -->
                <form action="CarController" method="post" class="form-search">
                    <div class="search-box">
                        <input value="${txtSearch}" name="txt" type="text" placeholder="Search" />
                        <button type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </form>

                <!-- bảng hiển thị -->
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Năm SX</th>
                            <th>Tình trạng</th>
                            <th>Xuất xứ</th>
                            <th>Ngoại thất</th>
                            <th>Nội thất</th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listCar}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.title}</td>
                                <td>${o.pricetitle}</td>
                                <td>${o.year}</td>
                                <td>${o.status}</td>
                                <td>${o.origin}</td>
                                <td>${o.exterior}</td>
                                <td>${o.interior}</td>
                                <td>
                                    <a href="LoadController?cid=${o.id}"><button class="edit-button">Sửa</button></a>
                                    <a href="DeleteController?cid=${o.id}"><button class="delete-button">Xóa</button></a>
                                </td>
                            </tr>   
                        </c:forEach>  
                    </tbody>
                </table>

                <!-- các trang -->
                <div class="pagination" style="justify-content: center">
                    <c:if test="${tag > 1}">
                        <a href="CarController?index=${tag - 1}"><< Prev</a>
                    </c:if>
                    <!-- Hiển thị trang đầu tiên nếu trang hiện tại không nằm ở đầu -->
                    <c:if test="${tag > 3}">
                        <a href="CarController?index=1&txt=${txtSearch != null ? txtSearch : ''}">1</a>
                        <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                    </c:if>

                    <!-- Hiển thị 2 trang trước trang hiện tại, trang hiện tại, và 2 trang sau trang hiện tại -->
                    <c:forEach begin="${tag - 2 > 1 ? tag - 2 : 1}" end="${tag + 2 < numPage ? tag + 2 : numPage}" var="i">
                        <a class="${tag == i ? 'active' : ''}" href="CarController?index=${i}&txt=${txtSearch != null ? txtSearch : ''}">${i}</a>
                    </c:forEach>

                    <!-- Hiển thị trang cuối cùng nếu trang hiện tại không nằm ở cuối -->
                    <c:if test="${tag < numPage - 2}">
                        <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                        <a href="CarController?index=${numPage}&txt=${txtSearch != null ? txtSearch : ''}">${numPage}</a>
                    </c:if>
                    <c:if test="${tag < numPage}">
                        <a href="CarController?index=${tag + 1}">Next >></a>
                    </c:if>
                </div>
            </div>
        </div>

        <script>
            function toggleForm() {
                var form = document.getElementById("addForm");
                if (form.style.display === "none" || form.style.display === "") {
                    form.style.display = "block";  // Hiển thị form
                } else {
                    form.style.display = "none";   // Ẩn form
                }
            }
        </script>
    </body>
</html>
