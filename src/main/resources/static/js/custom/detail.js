
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