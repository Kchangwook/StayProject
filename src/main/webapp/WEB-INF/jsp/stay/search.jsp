<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<c:if test="${empty member }">
	<jsp:include page="../nav/no-other.jsp"/>
</c:if>
<c:if test="${not empty member }">
	<jsp:include page="../nav/other.jsp"/>
</c:if>

<div class="container">
    <div class="search-nav mb-5">
        <h2 class="home-main-text">검색</h2>
        <form action="/stay/search" method="post">
        <div class="mt-4">
            <label for="dest" class="home-main-label">목적지</label>
            <input type="text" class="form-control" id="dest" name="address" value="${address}" required>
        </div>
        <div class="mt-2">
            <div>
                <label for="check-in" class="home-main-label">체크인</label>
                <div class='input-group date'>
                    <input type='text' class="form-control" id="check-in" name="checkIn" value="${reservation.checkIn}" required>
                </div>
            </div>
            <div>
                <label for="check-out" class="home-main-label">체크아웃</label>
                <div class='input-group date'>
                    <input type='text' class="form-control" id="check-out" name="checkOut" value="${reservation.checkOut}" required>
                </div>
            </div>
        </div>
        <div class="mt2">
            <label for="people" class="home-main-label">인원</label>
            <input type="number" class="form-control" id="people" min="0" name="people" value="${reservation.people}" required>
        </div>
        <div class="search-btn mt-3 mb-2">
            <button class="btn btn-custom2" type="submit">검색</button>
        </div>
        </form>
    </div>
    <div class="stay-list mt-4">
        <h1 class="search-main-text">검색 결과</h1>
        <input type="hidden" value="${list}">
        <c:forEach items="${list}" var="stay">
        <div class="stay-item mt-4 row">
            <img src="${stay.image}" class="search-img col-4">
            <div class="col-8">
                <p class="mt-2"><b>${stay.name}</b></p>
                <p class="">${stay.intro}</p>
                <div class="search-content mt-4">
                    인원 수: ${stay.people}<br>
                    가격: ${stay.price}<br>
                </div>
            </div>
        </div>
        </c:forEach>
        

    </div>
</div>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Custom scripts for this template -->
<script src="/js/creative.min.js"></script>
<script src="/js/backstretch.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

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