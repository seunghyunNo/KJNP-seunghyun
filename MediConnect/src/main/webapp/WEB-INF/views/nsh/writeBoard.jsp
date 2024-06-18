<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>작성 페이지</title>
</head>
<body>
    <h1>작성 페이지</h1>
    <hr/>
    <div>
	<form action="/writeBoard" method="post">
	
	
	<div>제목 작성</div>
	<input type="text" name="title" placeholder="title"/>
	
	<div>내용작성</div>
	<input type="text" name="content" placeholder="content"/>
	
	<button>작성 완료</button>
        
        
    </div>
</body>
</html>
