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
	<form action="/updateBoard" method="post">
	<input type="hidden" name="boardNum" value="${updateBoard.boardNum}"/>
	<div>제목 작성</div>
	<input type="text" name="title" value="${updateBoard.title}" placeholder="title"/>
	
	
	<div>내용작성</div>
	<input type="text" name="content" value="${updateBoard.content}" placeholder="content"/>
	
	<div>작성일</div>
	<p name="regDate">${updateBoard.regDate}</p>
	<button>수정 완료</button>
        
        
    </div>
</body>
</html>
