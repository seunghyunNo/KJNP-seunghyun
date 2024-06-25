package com.KJNP.MediConnect.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KJNP.MediConnect.biz.comment.CommentDTO;
import com.KJNP.MediConnect.biz.comment.CommentService;
import com.KJNP.MediConnect.biz.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class WriteCommentController {

	
	@Autowired
	private CommentService commentService;
	
//	@Autowired
//	private MemberService memberService;
	
	@RequestMapping(value="/writeComment", method=RequestMethod.POST)
	public @ResponseBody CommentDTO wrtieComment(CommentDTO commentDTO,HttpSession session, MemberDTO memberDTO) {
		
		
		// 세션에서 로그인한 사용자 정보 가져오기
        MemberDTO loginData = (MemberDTO) session.getAttribute("member");

        // 'WRITER' 필드에 사용자 정보 설정
        commentDTO.setWriter(loginData.getId());
		
		// 인서트
		boolean commentInsert=commentService.insert(commentDTO);
		
		System.out.println("댓글 작성 성공");
		
		return commentDTO;
	}
}
