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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic'
          rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS - Includes Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/creative.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="img/logo-icon.png">
    <link href="css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


</head>
<body>

<jsp:include page="../nav/other.jsp"/>

<!-- Masthead -->
<div class="container">
    <div class="row">
        <div class="host-list mt-4 mx-auto">
            <h1 class="search-main-text">호스팅 현황</h1>
            <div class="btn-group hosting-toggle">
                <button class="btn btn-custom2" id="stay">숙소</button>
                <button class="btn btn-default" id="reservation">예약</button>
            </div>
            <div id="hosting-content">
                <h3 class="search-main-text mt-5">내가 호스팅 하는 숙소</h3>
                <div class="stay-item mt-4 row">
                    <img src="img/stay.jpg" class="search-img col-4">
                    <div class="col-8">
                        <p class="mt-2"><b>이름</b></p>
                        <p>소개</p>
                        <div class="search-content mt-4">
                            객실 수<br>
                            인원 수<br>
                            가격<br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
<script src="js/jquery.tmpl.min.js"></script>
<script id="hosting-stay" type="text/template">
    <h3 class="search-main-text mt-5">내가 호스팅 하는 숙소</h3>
    <div class="stay-item mt-4 row">
        <img src="img/stay.jpg" class="search-img col-4">
        <div class="col-8">
            <p class="mt-2"><b>이름</b></p>
            <p>소개</p>
            <div class="search-content mt-4">
                객실 수<br>
                인원 수<br>
                가격<br>
            </div>
        </div>
    </div>
</script>
<script id="hosting-reservation" type="text/template">
    <h3 class="search-main-text mt-5">예약 현황</h3>
    <table class="table table-hover reservation-table mt-4">
        <thead>
        <tr>
            <td>예약자</td>
            <td>숙소 명</td>
            <td>인원 수</td>
            <td>가격</td>
            <td>체크인</td>
            <td>체크아웃</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>예약자</td>
            <td>숙소 명</td>
            <td>인원 수</td>
            <td>가격</td>
            <td>체크인</td>
            <td>체크아웃</td>
        </tr>
        <tr>
            <td>예약자</td>
            <td>숙소 명</td>
            <td>인원 수</td>
            <td>가격</td>
            <td>체크인</td>
            <td>체크아웃</td>
        </tr>
        <tr>
            <td>예약자</td>
            <td>숙소 명</td>
            <td>인원 수</td>
            <td>가격</td>
            <td>체크인</td>
            <td>체크아웃</td>
        </tr>
        </tbody>
    </table>
</script>
<script>

    $('#stay').on('click', function () {
        if ($(this).hasClass('btn-default')) {
            $(this).removeClass('btn-default');
            $(this).addClass('btn-custom2');
            $('#reservation').removeClass('btn-custom2');
            $('#reservation').addClass('btn-default');
            $('#hosting-content').empty();
            $('#hosting-stay').tmpl().appendTo('#hosting-content');
        }
    });

    $('#reservation').on('click', function () {
        if ($(this).hasClass('btn-default')) {
            $(this).removeClass('btn-default');
            $(this).addClass('btn-custom2');
            $('#stay').removeClass('btn-custom2');
            $('#stay').addClass('btn-default');
            $('#hosting-content').empty();
            $('#hosting-reservation').tmpl().appendTo('#hosting-content');
        }
    });

</script>
</body>
</html>