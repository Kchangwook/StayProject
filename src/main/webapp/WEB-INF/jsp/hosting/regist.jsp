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
<div class="container">
    <div class="row">
        <div class="host-list mt-4 mx-auto">
            <h1 class="search-main-text">호스팅하기</h1>
            <div class="custom-content row">
                <div class="col-5">
                    <div class="mt-4">
                        <label for="name" class="home-main-label">이름</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="mt-3">
                        <label for="addr" class="home-main-label">주소</label>
                        <input type="text" class="form-control" id="addr" name="password" required>
                    </div>
                    <div class="mt-3">
                        <label for="domain" class="home-main-label">홈페이지</label>
                        <input type="text" class="form-control" id="domain" name="password" required>
                    </div>
                    <div class="mt-3">
                        <label for="rooms" class="home-main-label">객실 수</label>
                        <input type="number" class="form-control" id="rooms" min="1" name="password" required>
                    </div>
                    <div class="mt-3">
                        <label for="people" class="home-main-label">객실당 인원</label>
                        <input type="number" class="form-control" id="people" min="1" name="password" required>
                    </div>
                    <div class="mt-3">
                        <label for="price" class="home-main-label">가격</label>
                        <input type="number" class="form-control" id="price" name="password" required>
                    </div>
                </div>
                <div class="col-7 mt-4 pt-2 pl-3">
                    <label for="pf-img-input" class="home-main-label">이미지</label><br>
                    <img src="./img/profile.png" id="pf-img" class="profile-img">
                    <input type="file" id="pf-img-input">
                    <div class="mt-3">
                        <label for="intro" class="home-main-label">소개</label>
                        <textarea id="intro" class="form-control" rows="4"></textarea>
                    </div>
                </div>
            </div>
            <div class="mt-4">
                <button class="btn btn-success font-custom">등록</button>
                <button class="btn btn-danger font-custom">취소</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
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
<script>
    $('#pf-img').on('click',function(){
        $('#pf-img-input').click();
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#pf-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#pf-img-input').change(function(){
            readURL(this);
        }
    );

</script>
</body>
</html>