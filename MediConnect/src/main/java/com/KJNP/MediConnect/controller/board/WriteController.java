package com.KJNP.MediConnect.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WriteController {

	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/writeBoard", method = RequestMethod.GET)
	public String writeBoardPage() {
		
		return "nsh/writeBoard";
	}
	
	@RequestMapping(value="/writeBoard",method=RequestMethod.POST)
	public String wrtieBoard(BoardDTO boardDTO, HttpSession session) {
		
		boardDTO.setWriter((String) session.getAttribute("writer"));
		
		boardService.insert(boardDTO);
		
		return "redirect:boardList";
	}
	
}
