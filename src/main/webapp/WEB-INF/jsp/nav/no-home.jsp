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
                    <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#login">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#join">회원가입</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body modal-mx">
            <form action="/" method="post">
                <div class="mt-4">
                    <img src="img/basic/logo-icon.png" class="d-block mx-auto">
                </div>
                <div>
                    <div class="mt-4">
                        <input type="text" class="form-control modal-input-text" placeholder="이메일" name="email" required>
                    </div>
                    <div class="mt-4">
                        <input type="password" class="form-control modal-input-text" placeholder="비밀번호" name="password" required>
                    </div>
                </div>
                <button class="btn btn-custom2 mt-4 btn-modal mb-4" type="submit">로그인</button>
               </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="join" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body modal-mx">
                <div class="mt-4">
                    <img src="img/basic/logo-icon.png" class="d-block mx-auto">
                </div>
                <form action="member" method="post" id="join-frm">
                    <div>
                        <div class="mt-4">
                            <label for="join-email" class="home-main-label">이메일</label>
                            <input type="email" class="form-control" id="join-email" name="email" required>
                            <span class="home-main-label home-warning mt-3" id="warning">중복된 이메일이 존재합니다.</span>
                        </div>
                        <div class="mt-2">
                            <label for="join-password" class="home-main-label">비밀번호</label>
                            <input type="password" class="form-control" id="join-password" name="password" required>
                        </div>
                        <div class="mt-2">
                            <label for="join-name" class="home-main-label">이름</label>
                            <input type="text" class="form-control" id="join-name" name="name" required>
                        </div>
                        <div class="mt-2">
                            <label for="join-phone" class="home-main-label">연락처</label>
                            <input type="tel" class="form-control" id="join-phone" pattern="(010)-\d{3,4}-\d{4}"
                                   placeholder="010-xxxx-xxxx" name="phone" required>
                        </div>
                    </div>
                    <button class="btn btn-custom2 mt-4 btn-modal mb-4" id="join-btn" type="submit">회원가입</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>