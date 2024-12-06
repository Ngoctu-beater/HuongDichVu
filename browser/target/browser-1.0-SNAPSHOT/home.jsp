<%-- 
    Document   : home
    Created on : Dec 4, 2024, 1:56:15 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Include the above in your HEAD tag -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <style>
            .compare-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                margin: 20px auto;
                max-width: 800px;
            }

            .compare-items {
                display: flex;
                justify-content: space-between;
                width: 100%;
            }

            .product-slot {
                width: 200px;
                height: 250px;
                border: 1px dashed #ccc;
                text-align: center;
                padding: 10px;
                margin: 5px;
                position: relative;
            }

            .product-slot img {
                max-width: 100%;
                max-height: 150px;
                object-fit: contain;
            }

            .product-slot .remove-product {
                position: absolute;
                top: 5px;
                right: 5px;
                cursor: pointer;
                color: red;
            }

            .add-slot {
                display: flex;
                align-items: center;
                justify-content: center;
                color: #888;
                cursor: pointer;
                font-size: 24px;
            }
        </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Car</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Thống kê</a>
                        </li>
                    </ul>

                    <!-- search -->
                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị ô tô chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu</p>
            </div>
        </section>

        <!--end of menu-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listCC}" var="o">
                                <li class="list-group-item text-white"><a href="#">${o.cname}</a></li>
                                </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Last product</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${p.image}" />
                            <h5 class="card-title">${p.name}</h5>
                            <p class="card-text">${p.title}</p>
                            <p class="bloc_left_price">${p.price}</p>
                        </div>
                    </div>
                </div>

                <div id="col-sm-9" class="col-sm-9">
                    <div class="row" id="product-list">
                        <!-- Danh sách xe -->
                        <c:forEach items="${listCar}" var="o">
                            <div class="col-12 col-md-6 col-lg-4" style="margin-bottom: 10px">
                                <div class="card product-card" data-id="${o.id}" data-name="${o.tenXe}" data-image="${o.anh}" data-price="${o.gia}">
                                    <img class="card-img-top" src="${o.anh}" alt="${o.tenXe}">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt">
                                            <a href="#" title="View Product">${o.tenXe}</a>
                                        </h4>
                                        <p class="card-text show_txt">${o.tenXe}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.gia}</p>
                                            </div>
                                            <div class="col">
                                                <button class="btn btn-primary btn-block add-to-compare">
                                                    Thêm vào so sánh
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <!-- Khung hiển thị các sản phẩm đã chọn để so sánh -->
                <div id="compare-items" class="compare-items"></div>

                <!-- Nút hành động -->
                <div class="actions">
                    <button id="compare-now" class="btn btn-success"><a href="compare.jsp">So sánh ngay</a></button>
                    <button id="clear-all" class="btn btn-secondary">Xóa tất cả sản phẩm</button>
                </div>
            </div>
        </div>

        <!-- các trang -->
        <div class="pagination" style="justify-content: center">
            <c:if test="${tag > 1}">
                <a style="margin: 0 10px" href="search?index=${tag - 1}&txt=${txtSearch != null ? txtSearch : ''}"><< Prev</a>
            </c:if>
            <!-- Hiển thị trang đầu tiên nếu trang hiện tại không nằm ở đầu -->
            <c:if test="${tag > 3}">
                <a style="margin: 0 10px" href="search?index=1&txt=${txtSearch != null ? txtSearch : ''}">1</a>
                <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
            </c:if>

            <!-- Hiển thị 2 trang trước trang hiện tại, trang hiện tại, và 2 trang sau trang hiện tại -->
            <c:forEach begin="${tag - 2 > 1 ? tag - 2 : 1}" end="${tag + 2 < numPage ? tag + 2 : numPage}" var="i">
                <a class="${tag == i ? 'active' : ''}" style="margin: 0 10px" href="search?index=${i}&txt=${txtSearch != null ? txtSearch : ''}">${i}</a>
            </c:forEach>

            <!-- Hiển thị trang cuối cùng nếu trang hiện tại không nằm ở cuối -->
            <c:if test="${tag < numPage - 2}">
                <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                <a style="margin: 0 10px" href="search?index=${numPage}&txt=${txtSearch != null ? txtSearch : ''}">${numPage}</a>
            </c:if>
            <c:if test="${tag < numPage}">
                <a style="margin: 0 10px" href="search?index=${tag + 1}&txt=${txtSearch != null ? txtSearch : ''}">Next >></a>
            </c:if>
        </div>

        <!-- Footer -->
        <footer class="text-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                        <h5>Others links</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> My company</li>
                            <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                            <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                            <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                        <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
                    </div>
                </div>
            </div>
        </footer>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const maxCompare = 3;
                const selectedProducts = [];

                const compareItemsContainer = document.getElementById("compare-items");
                const productList = document.getElementById("product-list");
                const compareNowButton = document.getElementById("compare-now");
                const clearAllButton = document.getElementById("clear-all");

                // Hiển thị danh sách sản phẩm trong khung so sánh
                function renderCompareList() {
                    compareItemsContainer.innerHTML = "";

                    for (let i = 0; i < maxCompare; i++) {
                        if (selectedProducts[i]) {
                            const product = selectedProducts[i];
                            const productSlot = document.createElement("div");
                            productSlot.classList.add("product-slot");
                            productSlot.innerHTML = `
                    <img src="${product.anh}" alt="${product.tenXe}">
                    <p>${product.tenXe}</p>
                    <p class="price">${product.gia}</p>
                    <span class="remove-product" data-index="${i}">×</span>
                `;
                            compareItemsContainer.appendChild(productSlot);
                        } else {
                            const addSlot = document.createElement("div");
                            addSlot.classList.add("product-slot", "add-slot");
                            addSlot.innerHTML = `<span>+</span> Thêm sản phẩm`;
                            compareItemsContainer.appendChild(addSlot);
                        }
                    }

                    // Disable nút "Thêm vào so sánh" nếu đạt giới hạn
                    document.querySelectorAll(".add-to-compare").forEach(button => {
                        const productId = button.closest(".product-card").dataset.id;
                        button.disabled = selectedProducts.some(product => product.id === productId) || selectedProducts.length >= maxCompare;
                    });
                }

                // Thêm sản phẩm vào danh sách so sánh
                productList.addEventListener("click", function (event) {
                    if (event.target.classList.contains("add-to-compare")) {
                        const productCard = event.target.closest(".product-card");
                        const productId = productCard.dataset.id;
                        const productName = productCard.dataset.tenXe;
                        const productImage = productCard.dataset.anh;
                        const productPrice = productCard.dataset.gia;

                        // Kiểm tra và thêm sản phẩm
                        if (selectedProducts.length < maxCompare && !selectedProducts.some(product => product.id === productId)) {
                            selectedProducts.push({
                                id: productId,
                                name: productName,
                                image: productImage,
                                price: productPrice
                            });
                            renderCompareList();
                        } else {
                            alert("Bạn chỉ có thể so sánh tối đa 3 sản phẩm.");
                        }
                    }
                });

                // Xóa sản phẩm khỏi danh sách
                compareItemsContainer.addEventListener("click", function (event) {
                    if (event.target.classList.contains("remove-product")) {
                        const index = event.target.dataset.index;
                        selectedProducts.splice(index, 1);
                        renderCompareList();
                    }
                });

                // So sánh các sản phẩm
                compareNowButton.addEventListener("click", () => {
                    if (selectedProducts.length > 1) {
                        const compareIds = selectedProducts.map(product => product.id).join(",");
                        window.location.href = `/comparecar?ids=${compareIds}`;
                    } else {
                        alert("Vui lòng chọn ít nhất 2 sản phẩm để so sánh.");
                    }
                });

                // Xóa tất cả sản phẩm khỏi danh sách
                clearAllButton.addEventListener("click", () => {
                    selectedProducts.length = 0;
                    renderCompareList();
                });

                // Khởi tạo giao diện
                renderCompareList();
            });

        </script>
    </body>
</html>
