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

<c:if test="${empty sessionScope.member }">
	<jsp:include page="../nav/no-other.jsp"/>
</c:if>
<c:if test="${not empty sessionScope.member }">
	<jsp:include page="../nav/other.jsp"/>
</c:if>

<div class="container">
    <div class="row">
        <div class="host-list mt-4 mx-auto">
            <h1 class="search-main-text">${stay.name}</h1>
            <div class="custom-content row">
                <div class="col-12">
                    <span id="address">${stay.address}</span>
                    <c:if test="${sessionScope.member.email ne stay.email}">
                    	<button class="btn btn-success font-custom float-right" id="booking">예약하기</button>
                    </c:if>
                    <c:if test="${sessionScope.member.email eq stay.email}">
                    	<button class="btn btn-success font-custom float-right" id="hosting-cancel">호스팅 취소하기</button>
                    </c:if>
                </div>
                <div class="stay-img mx-auto mt-3">
                    <img src="${stay.image}" class="stay-img">
                </div>
                <div class="stay-info mt-5 col-12">
                    <p>인원: ${stay.people}</p>
                    <p>가격: ${stay.price}</p>
                    <c:if test="${not empty stay.domain}">
                    <p>홈페이지: <a href="http://${stay.domain}">${stay.domain}</a></p>
                    </c:if>
                    <p>전화번호: ${stay.phone}</p>
                    <p>객실 소개: ${stay.intro}</p>
                </div>
                <div id="map" style="width:500px;height:400px;"></div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="book" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body modal-mx">
                <div class="mt-4">
                    <img src="/img/basic/logo-icon.png" class="d-block mx-auto">
                    <h3 class= "mt-3 text-center search-main-text">예약하기</h3>
                </div>
                <form action="/reservation" method="post" id="book-form">
                    <div>
                    	<input type="hidden" name="stayCode" value="${stay.code}"> 
                        <div class="mt-4">
                            <label for="name" class="home-main-label">숙소</label>
                            <input type="email" class="form-control" id="name" name="stayName" value="${stay.name}" readOnly>
                        </div>
                        <div>
                            <label for="check-in" class="home-main-label">체크인</label>
                            <div class='input-group date'>
                                <input type='text' class="form-control" id="check-in" name="checkIn" readOnly>
                            </div>
                        </div>
                        <div>
                            <label for="check-out" class="home-main-label">체크아웃</label>
                            <div class='input-group date'>
                                <input type='text' class="form-control" id="check-out" name="checkOut" readOnly>
                            </div>
                        </div>
                        <div class="mt2">
                            <label for="people" class="home-main-label">인원</label>
                            <input type="number" class="form-control" id="people" name="people" readOnly>
                        </div>
                        <div class="mt2">
                            <label for="price" class="home-main-label">가격</label>
                            <input type="number" class="form-control" id="price" name="price" value="${stay.price}"readOnly>
                        </div>
                    </div>
                    <button class="btn btn-custom2 mt-4 btn-modal mb-4" id="book-btn" type="button">예약하기</button>
                </form>
            </div>
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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f29c39d1142de3a550939ebd1a023bf7&libraries=services,clusterer,drawing"></script>
<script src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>

$('#hosting-cancel').on('click', function(){
	
	if(confirm('호스팅을 취소하시겠습니까?')){
	$.ajax({
		url: '/stay/${stay.code}',
		type: 'delete',
		success: function(data){
			if(data == true){
				alert('호스팅 숙소가 삭제되었습니다.');
				location.href='/';
			}else alert('호스팅 숙소 취소에 실패했습니다.');
		}
	});
}
});

$('#booking').on('click', function(){
	console.log('${sessionScope.member}');
	if('${sessionScope.member}' == '') alert('로그인 후 이용 가능합니다.');
	else $('#book').modal();
	
});

var IMP = window.IMP; // 생략가능
IMP.init('imp65623511'); 

$('#book-btn').on('click',function(){

	IMP.request_pay({
	    pg : 'kakaopay', // version 1.1.0부터 지원.
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '${stay.name}',
	    amount : '${stay.price}',
	    buyer_email : '${member.email}',
	    buyer_name : '${member.name}',
	    buyer_tel : '${stay.phone}',
	}, function(rsp) {
	    if ( rsp.success ) {
	    	alert('결제가 완료되었습니다.');
	    	$('#book-form').submit();
	    } else
	    	alert('결제에 실패하였습니다.');
	});
	
});


if($.cookie('people') != null) $('#people').val($.cookie('people'));
if($.cookie('checkIn') != null) $('#check-in').val($.cookie('checkIn'));
if($.cookie('checkOut') != null) $('#check-out').val($.cookie('checkOut'));

$('#reservation').on('click',function(){
    $('#book').modal();
 });

$(document).ready(function(){
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};  

	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	//주소로 좌표를 검색합니다
	geocoder.addressSearch($('#address').text(), function(result, status) {

	// 정상적으로 검색이 완료됐으면 
	 if (status === kakao.maps.services.Status.OK) {

	    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	    // 결과값으로 받은 위치를 마커로 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: coords
	    });

	    // 인포윈도우로 장소에 대한 설명을 표시합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">숙소</div>'
	    });
	    infowindow.open(map, marker);

	    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	    map.setCenter(coords);
	} 
	});    
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new kakao.maps.MapTypeControl();

	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
});
</script>
</body>
</html>