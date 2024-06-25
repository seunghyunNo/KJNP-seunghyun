package com.KJNP.MediConnect.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/updateBoard",method=RequestMethod.GET)
	public String updateBoardPage(BoardDTO boardDTO, Model model) {
		boardDTO = boardService.selectOne(boardDTO);
		model.addAttribute("updateBoard",boardDTO);
		return "board/updateBoard";
	}
	
	@RequestMapping(value="/updateBoard",method = RequestMethod.POST)
	public String updateBoard(BoardDTO boardDTO,HttpSession session,Model model) {
		
		
		boardDTO.setWriter((String) session.getAttribute("writer"));
		
//		model.addAttribute("loginData",session.getAttribute("member"));
		boardService.update(boardDTO);
		System.out.println("업데이트 "+boardDTO);
		System.out.println("수정 성공");
		
		return "redirect:boardList";
	}
}
