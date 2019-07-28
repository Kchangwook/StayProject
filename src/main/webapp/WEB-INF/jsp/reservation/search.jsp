<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stay Project</title>

    <!-- Font Awesome Icons -->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic'
          rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS - Includes Bootstrap -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link href="/css/creative.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="/img/basic/logo-icon.png">
    <link href="/css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
<!-- Masthead -->
<main class="container">
    <div class="search-nav mb-5">
        <h2 class="home-main-text">검색</h2>
        <div class="mt-4">
            <label for="dest" class="home-main-label">목적지</label>
            <input type="text" class="form-control" id="dest" required>
        </div>
        <div class="mt-2">
            <div>
                <label for="check-in" class="home-main-label">체크인</label>
                <div class='input-group date'>
                    <input type='text' class="form-control" id="check-in" required>
                    </span>
                </div>
            </div>
            <div>
                <label for="check-out" class="home-main-label">체크아웃</label>
                <div class='input-group date'>
                    <input type='text' class="form-control" id="check-out" required>
                    </span>
                </div>
            </div>
        </div>
        <div class="mt2">
            <label for="people" class="home-main-label">인원</label>
            <input type="number" class="form-control" id="people" min="0" value="0" required>
        </div>
        <div class="search-btn mt-3 mb-2">
            <button class="btn btn-custom-search">검색</button>
        </div>
    </div>
    <div class="stay-list mt-4">
        <h1 class="search-main-text">검색 결과</h1>
        <div class="stay-item mt-4 row">
            <img src="img/stay.jpg" class="search-img col-4">
            <div class="col-8">
                <p class="mt-2"><b>이름</b></p>
                <p class="">소개</p>
                <div class="search-content mt-4">
                    남은 객실 수<br>
                    인원 수<br>
                    가격<br>
                </div>
            </div>
        </div>

    </div>
</main>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/creative.min.js"></script>
<script src="js/backstretch.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>

    $(document).ready(function () {

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);

        $('#check-in').datepicker({
            dateFormat: 'yy-mm-dd',
            minDate: new Date(),
            onClose: function () {
                $('#check-out').datepicker({
                    dateFormat: 'yy-mm-dd',
                    minDate: new Date($('#check-in').val())
                });
            }
        });

        $('#check-out').datepicker({
            dateFormat: 'yy-mm-dd',
            minDate: tomorrow
        });

    });

</script>
</body>
</html>