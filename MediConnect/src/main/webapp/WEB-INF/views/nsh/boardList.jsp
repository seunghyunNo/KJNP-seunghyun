<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 리스트</title>
</head>
<body>
    <h1>게시판 리스트</h1>
    <hr/>
    <div>

        <c:forEach var="board" items="${boardList}">
            <input type="hidden" name="boardNum" value="${board.boardNum}">
            <div>${board.boardNum}</div>
            <div>${board.title}</div>
            <div>${board.content}</div>
            <div>${board.regDate}</div>

            <div>
                <a href="/updateBoard?boardNum=${board.boardNum}">수정</a>
                <a href="/deleteBoard?boardNum=${board.boardNum}">삭제</a>
            </div>
            <hr/>
        </c:forEach>
        
        
        <div>
        	<a href="/writeBoard">작성</a>
        </div>
    </div>
</body>
</html>
