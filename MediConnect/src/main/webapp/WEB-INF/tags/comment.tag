<%@ tag language="java" pageEncoding="UTF-8"
    import="KJNP.MediConnect.biz.comment.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="comment"%>

<div class="comment">

<div style="display: flex;">
        <p>${fn:length(commentList)}&nbsp;Responses</p>
        <!-- 로그인 했을때 토글 효과로 하단에 작성폼이 출력 -->
        <c:if test="${member != null}">
            <!-- 댓글 작성용 아이콘을 출력하는 태그, 버튼 이벤트를 연결할 수 있도록 onclick으로 #toggleWriteBtnLogin 에 연결 -->
            <i class="ion-ios-pricetag"
                onclick="document.getElementById('toggleWriteBtnLogin').click();"
                style="cursor: pointer; font-size: 25px; margin-left: 61%; justify-content: flex-end; text-decoration: underline;">Write a comment
                </i>
            <!-- 댓글 작성 버튼의 클릭 이벤트를 담당하는 태그, hidden 속성으로 화면에 미 출력 -->
            <input style="display: none;" id="toggleWriteBtnLogin" type="button"
                value="Write Responses" onclick="toggleWrite(this)">
        </c:if>
        <!-- 비 로그인 유저일때 로그인 후 이용할 수 있도록 메세지를 출력. -->
        <c:if test="${member == null}">
            <!-- 댓글 작성용 아이콘을 출력하는 태그, 버튼 이벤트를 연결할 수 있도록 onclick으로 #toggleWriteBtnLogOut 에 연결 -->
            <i class="ion-ios-pricetag"
                onclick="document.getElementById('toggleWriteBtnLogOut').click();"
                style="cursor: pointer; font-size: 25px; margin-left: 61%; justify-content: flex-end; text-decoration: underline;">Write a comment
                </i>
            <!-- 댓글 작성 버튼의 클릭 이벤트를 담당하는 태그, hidden 속성으로 화면에 미 출력 -->
            <input style="display: none;" class="btn btn-primary btn-rounded"
                id="toggleWriteBtnLogOut" type="button" value="Write Responses"
                onclick="message()">
        </c:if>
    </div>
    
    <br>
    <!-- 댓글 입력 폼 위 작성 버튼을 클릭 하지 않을 경우 미출력 -->
    <div id="writeResponseForm" style="display: none;">
        <form id="commentForm" action="/writeComment" method="post"
            class="row">
            <!-- 댓글 작성시 카테고리 별로 게시글 번호를 보내는 태그 (40번째 ~ 50번째) -->
            <c:if test="${not empty baordSingle}">
                <input type="hidden" name="boardIdx"
                    value="${boardSingle.boardIdx}">
            </c:if>
            <!-- 댓글 내용 입력 칸 -->
            <div class="form-group col-md-12" style="text-align: left;">
                <label for="message">작성 <span class="required"></span></label>
                <textarea class="form-control" name="commentContent"
                    placeholder="댓글을 입력해주세요."></textarea>
            </div>
            <!-- 댓글 작성완료 버튼 -->
            <div class="form-group col-md-12" style="text-align: right;">
                <button class="btn btn-primary btn-rounded">작성 완료</button>
            </div>
        </form>
    </div>
    
    <div class="comment-list">
        <!-- 댓글이 없을 경우 출력 문구 -->
        <c:if test="${commentList == null || fn:length(commentList) <= 0}">
            <h5 style="text-align: center;">작성된 댓글이 없습니다.</h5>
        </c:if>
        
        <!-- 댓글이 있을 경우 목록 출력 -->
        <c:if test="${fn:length(commentList) > 0 }">
            <c:forEach var="commentList" items="${commentList}">

                <!-- 댓글 내용 출력 -->
                <div class="item" id="item_${commentList.commentIdx}">
                    <div class="user">
                    
                   	<div class="details">
                   		<div class="description" style="word-break: break-all;" id="commentContent_${commentList.commentIdx}">${commentList.content}</div>
                   		<!-- 댓글 버튼 수정,삭제는 작성자 본인일때만 -->
                   		<div style="display:flex; flex-wrap:wrap; justify-content:flex-end;">
                   			<!--작성자 본인일 경우-->
                   			<c:if test="${commentList.writer==member}">
                   				<!-- 댓글 수정 버튼-->
                   				<i id="commentUpdateBtnIcon_${commentList.commentIdx}" 
                   					onclick="document.getElementById('commentUpdateBtn_${commentList.commentIdx}').click();
                   					style="cursor:pointer;"></i>
                   				<input type="button" style="display:none;" value="수정"
                   					id="commentUpdateBtn_${commentList.commentIdx}"
                   					onclick="commentUpdate(${commentList.commentIdx}, '${commentList.content}')"/>
                   					
                   				<!--댓글 삭제 버튼 -->
                   				<i id="commentDeleteBtnIcon_${commentList.commentIdx}"
                   					onclick="document.getElementById('commentDeleteBtn_${commentList.commentIdx}').click();"
                   					style="cursor:pointer;"></i>
                   				<input type="button" style="display:none;" value="삭제"
                   					id="commentDeleteBtn_${commentList.commentIdx}"
                   					onclick="commentDelete('${commentList.commentIdx}')">
                   			</c:if>
                   			
 </div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>

var member = '${member}';

// 댓글 작성
$(document).ready(function() {
    $('#commentForm').submit(function(event) {
        event.preventDefault(); // 폼의 기본 제출 동작 방지

        var formData = $(this).serialize(); // 폼 데이터 직렬화

        $.ajax({
            type: "POST",
            url: "/writeComment",
            data: formData,
            dataType: "json", // 서버로부터 응답을 JSON으로 받음
            success: function(response) {
                history.go(0);
            },
            error: function() {
                // 댓글 작성 실패 시 동작
                swal({
                    title: "실패!",
                    text: "댓글 작성에 실패했습니다.",
                    icon: "error",
                    button: "확인",
                });
            }
        });
    });
});

// 비 로그인 시
function message() {
        swal({
            title: "fail",
            text: "로그인 후 이용해주세요.",
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "OK",
            closeOnConfirm: true
        }, function() {
            // "OK" 버튼 누르면 실행될 코드
            window.location.href = "/main"; // 메인(로그인) 페이지로 이동
        });
    }


// 댓글 수정
$(document).ready(function(){
	window.commentUpdate = function(commentIdx,content){
	
	// 댓글 수정 버튼
	var updateBtn=$('#commentUpdateBtn_'+commentIdx);
	
	// 댓글 수정 버튼 아이콘
	var updateBtnIcon = $('#commentUpdateBtnIcon_'+commentIdx);
	
	// 수정 버튼 클릭
	if(updateBtn.val()==='수정'){
		
		var divContent = $('#commentContent_'+commentIdx).text();
		var textarea = $('<textarea class = "form-control">').val(divContent.trim()).attr('rows',5).attr('id','textarea_'+commentIdx);
		$('#commentContent_'+commentIdx).empty().append(textarea);
		
		// 버튼을 '저장으로 변경'
		updateBtn.val('저장')	
		//updateBtnIcon.attr('class','ion-compose');
	}else {
		// 저장 버튼이 클릭된 경우
		var updateContents =$('#textarea_'+commentIdx).val();
		
		if(updateContents.trim() === ''){
			swal("fail","내용을 입력하세요.","error",{
				button:"OK",
			});
			return;
			
		}
		
		$.ajax({
			url:"/updateComment",
			type:"POST",
			data:{
				'commentIdx' : commentIdx,
				'content':updateContent
			},
			dataType:'text',
			success:function(response){
				
				var responseData = JSON.parse(response);
				
				var commentContentDiv = $('<div>').addClass('description').text(responseData.commentContent);
				
				// 기존 내용 비우기
				$('#commentContent_'+commentIdx).empty().append(commentContentDiv);
				
				// 버튼을 수정으로 변경
				updateBtn.val('수정');
				updateBtnIcon.attr('attr','ion-android-refresh');
			},
			error:function(error){
				console.error('에러 발생',error);
			}
		});
	}
};

window.commentDelete = function(commentIdx){

	$.ajax({
		url:"/deleteComment",
		type:"POST",
		data:{
			'commentidx':commentIdx
		},
		dataType:'text',
		success:function(response){
			console.log('삭제 완료 : ',response);
			
			swal({
				title:"success",
				text:"댓글이 성공적으로 삭제되었습니다.",
				type:"success"
			},function(){
				$('#item_'+commentIdx).remove();
			});
		},
		error:function(error){
			console.error('에러발생 : ',error);
		}
	})
}
	
</script>	
                   					
                   					
                   					
                   					
