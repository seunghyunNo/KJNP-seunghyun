package com.KJNP.MediConnect.controller.nsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.KJNP.MediConnect.controller.nsh.biz.BoardDTO;
import com.KJNP.MediConnect.controller.nsh.biz.BoardService;

@Controller
public class UpdateController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/updateBoard",method=RequestMethod.GET)
	public String updateBoardPage(BoardDTO boardDTO, Model model) {
		boardDTO = boardService.selectOne(boardDTO);
		model.addAttribute("updateBoard",boardDTO);
		return "nsh/updateBoard";
	}
	
	@RequestMapping(value="/updateBoard",method = RequestMethod.POST)
	public String updateBoard(BoardDTO boardDTO) {
		
		
		boardService.update(boardDTO);
		System.out.println("수정 성공");
		
		return "redirect:boardList";
	}
}
