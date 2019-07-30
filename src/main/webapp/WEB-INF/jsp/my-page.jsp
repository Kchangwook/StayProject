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

<jsp:include page="./nav/other.jsp"/>

<!-- Masthead -->
<div class="container">
    <div class="row">
        <div class="host-list mt-4 mx-auto">
            <h1 class="search-main-text">마이 페이지</h1>
            <form action="/member" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_method" value="put"/>
            <div class="custom-content row">
                <div class="col-5">
                    <div class="mt-4">
                        <label for="join-email" class="home-main-label">이메일</label>
                        <input type="email" class="form-control" id="join-email" name="email" value="${member.email}" required readonly>
                    </div>
                    <div class="mt-2">
                        <label for="join-password" class="home-main-label">비밀번호</label>
                        <input type="password" class="form-control" id="join-password" name="password">
                    </div>
                    <div class="mt-2">
                        <label for="join-name" class="home-main-label">이름</label>
                        <input type="text" class="form-control" id="join-name" name="name" value="${member.name}">
                    </div>
                    <div class="mt-2">
                        <label for="join-phone" class="home-main-label">연락처</label>
                        <input type="tel" class="form-control" id="join-phone" pattern="(010)-\d{3,4}-\d{4}"
                               placeholder="010-xxxx-xxxx" name="phone" value="${member.phone}" >
                    </div>
                </div>
                <div class="col-7 mt-4 pt-2">
                	<label for="pf-img-input" class="home-main-label">이미지</label><br>
                    <img src="${member.image}" id="pf-img" class="profile-img">
                    <input type="file" id="pf-img-input" name="member_img">
                </div>
            </div>
            <div class="mt-4">
                <button class="btn btn-success font-custom" type="submit">수정</button>
                <button class="btn btn-danger font-custom" id="cacel">취소</button>
            </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
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
<script src="/js/jquery.tmpl.min.js"></script>
<script src="/js/custom/reader.js"></script>
</body>
</html>