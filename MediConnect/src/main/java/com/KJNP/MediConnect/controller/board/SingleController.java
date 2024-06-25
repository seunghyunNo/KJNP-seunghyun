package com.KJNP.MediConnect.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;
import com.KJNP.MediConnect.biz.comment.CommentDTO;
import com.KJNP.MediConnect.biz.comment.CommentService;
import com.KJNP.MediConnect.biz.member.MemberDTO;
import com.KJNP.MediConnect.biz.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SingleController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/boardSingle")
	public String boardList(HttpSession session, Model model,BoardDTO boardDTO, CommentDTO commentDTO,MemberDTO memberDTO) {

		BoardDTO boardSingle=boardService.selectOne(boardDTO);
		
		commentDTO.setBoardIdx(boardDTO.getBoardIdx());

		List<CommentDTO> commentList = commentService.selectAll(commentDTO);
		
		MemberDTO loginData = (MemberDTO) session.getAttribute("member");

		model.addAttribute("loginData",loginData);
		model.addAttribute("boardSingle", boardSingle);
		model.addAttribute("commentList", commentList);

		return "board/boardSingle";
	}
}
