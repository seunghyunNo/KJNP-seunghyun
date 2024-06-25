package com.KJNP.MediConnect.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;

@Controller
public class DeleteController {

	@Autowired
	private BoardService boardSerivce;
	
	@RequestMapping(value = "/deleteBoard",method = RequestMethod.GET)
	public String deleteBoard(BoardDTO boardDTO) {
		
		boardSerivce.delete(boardDTO);
		System.out.println("삭제 성공");
		
		return "redirect:boardList";
	}
}
