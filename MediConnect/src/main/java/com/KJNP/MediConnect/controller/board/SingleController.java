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

import jakarta.servlet.http.HttpSession;

@Controller
public class SingleController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;

	@RequestMapping("/boardSingle")
	public String boardList(HttpSession session, Model model, BoardDTO boardDTO, CommentDTO commentDTO) {

		boardService.selectOne(boardDTO);
		commentDTO.setBoardIdx(boardDTO.getBoardIdx());

		List<CommentDTO> commentList = commentService.selectAll(commentDTO);

		model.addAttribute("loginData",session.getAttribute("member"));
		System.out.println(model.getAttribute("loginData"));
		model.addAttribute("boardSingle", boardDTO);
		model.addAttribute("commentList", commentList);

		return "nsh/boardSingle";
	}
}
