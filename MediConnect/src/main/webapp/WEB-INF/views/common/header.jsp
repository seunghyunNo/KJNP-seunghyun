<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ======= Top Bar ======= -->
  <div id="topbar" class="d-flex align-items-center fixed-top">
    <div class="container d-flex align-items-center justify-content-center justify-content-md-between">
      <div class="align-items-center d-none d-md-flex">
        <i class="bi bi-clock"></i> Monday - Saturday, 8AM to 10PM
      </div>
      <div class="d-flex align-items-center">
        <i class="bi bi-phone"></i> Call us now +1 5589 55488 55
      </div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <a href="/" class="logo me-auto"><img src="resources/assets/img/logo.png" alt=""></a>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <h1 class="logo me-auto"><a href="index.html">Medicio</a></h1> -->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto " href="/">Home</a></li>
          <li><a class="nav-link scrollto" href="/boardList">게시판</a></li>
          <li><a class="nav-link scrollto" href="/phmAPI">박현민 병원위치 API</a></li>
          <li><a class="nav-link scrollto" href="/nshAPI">노승현 병원위치 API</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      	<!-- 로그인 여부에 따라 보여지는 메뉴 -->
		<!-- 비 로그인 시 로그인 페이지 및 회원가입 페이지로 이동 -->
		<c:if test="${member == null}">
			<ul class="header-links pull-right">
				<li style="display: inline-block;"><a href="/login" class="appointment-btn scrollto">로그인</a></li>
				<li style="display: inline-block;"><a href="/join" class="appointment-btn scrollto">회원가입</a></li>
			</ul>
		</c:if>
		<!-- 로그인 시 로그아웃 요청 및 마이페이지로 이동 -->
		<c:if test="${member != null}">
			<ul class="header-links pull-right">
				<li style="display: inline-block;"><a href="/logout" class="appointment-btn scrollto">로그아웃</a></li>
				<li style="display: inline-block;"><a href="/myPage" class="appointment-btn scrollto">마이페이지</a></li>
			</ul>
		</c:if>

    </div>
  </header><!-- End Header -->
</body>
</html>