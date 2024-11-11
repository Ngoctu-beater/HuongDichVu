<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="css/edit.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="edit-product-form">
            <h2>Chỉnh sửa</h2>
            <form action="EditController" method="post">
                <div class="form-group">
                    <label for="productId">ID</label>
                    <input value="${edit.id}" type="text" id="carId" name="carId" readonly>
                </div>
                <div class="form-group">
                    <label for="carName">Tên xe</label>
                    <input value="${edit.title}" type="text" id="carName" name="carName" required>
                </div>
                <div class="form-group">
                    <label for="carPrice">Giá chữ</label>
                    <input value="${edit.pricetitle}" type="text" id="carPrice" name="carPriceTitle" required>
                </div>
                <div class="form-group">
                    <label for="carPrice">Giá số</label>
                    <input value="${edit.price}" type="text" id="carPrice" name="carPrice" required>
                </div>   
                <div class="form-group">
                    <label for="carYear">Năm sản xuất</label>
                    <input value="${edit.year}" type="text" id="carYear" name="carYear" required>
                </div>    
                <div class="form-group">
                    <label for="carStatus">Tình trạng</label>
                    <input value="${edit.status}" type="text" id="carStatus" name="carStatus" required>
                </div>
                <div class="form-group">
                    <label for="carHasgone">Đã đi</label>
                    <input value="${edit.hasgone}" type="text" id="carHasgone" name="carHasgone" required>
                </div>
                <div class="form-group">
                    <label for="carOrigin">Xuất xứ</label>
                    <input value="${edit.origin}" type="text" id="carOrigin" name="carOrigin" required>
                </div>
                <div class="form-group">
                    <label for="carStyle">Kiểu dáng</label>
                    <input value="${edit.style}" type="text" id="carStyle" name="carStyle" required>
                </div>
                <div class="form-group">
                    <label for="carGearbox">Hộp số</label>
                    <input value="${edit.gearbox}" type="text" id="carGearbox" name="carGearbox" required>
                </div>
                <div class="form-group">
                    <label for="carEngine">Động cơ</label>
                    <input value="${edit.engine}" type="text" id="carEngine" name="carEngine" required>
                </div>
                <div class="form-group">
                    <label for="carExterior">Ngoại thất</label>
                    <input value="${edit.exterior}" type="text" id="carExterior" name="carExterior" required>
                </div>
                <div class="form-group">
                    <label for="carInterior">Nội thất</label>
                    <input value="${edit.interior}" type="text" id="carInterior" name="carInterior" required>
                </div>    
                <div class="form-group">
                    <label for="carSeats">Chỗ ngồi</label>
                    <input value="${edit.seats}" type="text" id="carSeats" name="carSeats" required>
                </div>    
                <div class="form-group">
                    <label for="carDoors">Số cửa</label>
                    <input value="${edit.doors}" type="text" id="carDoors" name="carDoors" required>
                </div>    
                <div class="form-group">
                    <label for="carDrive">Dẫn động</label>
                    <input value="${edit.drive}" type="text" id="carDrive" name="carDrive" required>
                </div>    
                <div class="form-group">
                    <label for="carDescribe">Mô tả</label>
                    <input value="${edit.describe}" type="text" id="carDescribe" name="carDescribe" required>
                </div>    
                <div class="form-group">
                    <label for="carLink">Link</label>
                    <input value="${edit.link}" type="text" id="carLink" name="carLink" required>
                </div>    
                <div class="form-group">
                    <input type="submit" class="submit-button" value="Cập nhật">
                </div>
            </form>
        </div>
    </body>
</html>
