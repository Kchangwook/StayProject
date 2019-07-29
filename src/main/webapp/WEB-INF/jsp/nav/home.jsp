<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<input type="hidden" id="msg" value="${msg}">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light py-3" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/">Stay Project</a>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto my-2 my-lg-0">
                <li class="nav-item">
                    <img src="${sessionScope.member.image}" id="nav-profile" class="nav-profile-img">
                </li>
                <li class="nav-item my-auto ml-2">
                    <a class="nav-link js-scroll-trigger text-white" href="/member">${sessionScope.member.name}</a>
                </li>
                <li class="nav-item my-auto">
                    <a class="nav-link js-scroll-trigger text-white" data-toggle="modal" data-target="#join">호스팅 현황</a>
                </li>
                <li class="nav-item my-auto">
                    <a class="nav-link js-scroll-trigger text-white" data-toggle="modal" data-target="#join">예약 현황</a>
                </li>
                <li class="nav-item my-auto">
                    <a class="nav-link js-scroll-trigger text-white" href="/logout">로그아웃</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>