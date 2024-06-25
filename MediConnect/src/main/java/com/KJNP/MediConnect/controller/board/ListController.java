package com.KJNP.MediConnect.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;

@Controller
public class ListController {
	
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public String BoardList(Model model,BoardDTO boardDTO) {
		
		List<BoardDTO> boardList = boardService.selectAll(boardDTO);
		
		model.addAttribute("boardList",boardList);
		
		System.out.println("boardList "+boardList);
		
		return "board/boardList";
	}
}
