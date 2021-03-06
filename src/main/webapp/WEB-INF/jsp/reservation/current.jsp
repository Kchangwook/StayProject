<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Stay Project</title>

<!-- Font Awesome Icons -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS - Includes Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/creative.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="/img/basic/logo-icon.png">
<link href="css/custom.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


</head>
<body>

<jsp:include page="../nav/other.jsp"/>

	<div class="container">
		<div class="row">
			<div class="host-list mt-4 mx-auto">
				<h1 class="search-main-text">예약 현황</h1>
				<div class="custom-content row">
					<c:if test="${empty list}">
				      <h4 class="search-main-text mt-5">현재 진행중인 예약이 없습니다.</h4>
					</c:if>
					<c:if test="${not empty list}">
					<table class="table table-hover reservation-table mt-4">
						<thead>
							<tr>
								<td>숙소 명</td>
								<td>인원 수</td>
								<td>가격</td>
								<td>체크인</td>
								<td>체크아웃</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="book">
							<tr id="${book.code}">
								<td>${book.stayName}</td>
								<td>${book.people}</td>
								<td>${book.price}</td>
								<td>${book.checkIn}</td>
								<td>${book.checkOut}
								<button type="button" class="close" aria-label="Close" onClick="deletes('${book.code}')">
  									<span aria-hidden="true">&times;</span>
								</button>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
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
	function deletes(code){
		if(confirm('예약을 취소하시겠습니까?')){
			
			$.ajax({
				url: '/reservation/'+code ,
				method:'delete',
				success: function(data){
					if(data == true){
						alert('예약이 취소되셨습니다.');
						$('#'+code).remove();
					}
				}
			});
			
		}
	}
	</script>
</body>
</html>