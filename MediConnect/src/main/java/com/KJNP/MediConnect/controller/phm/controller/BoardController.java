package com.KJNP.MediConnect.controller.phm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.KJNP.MediConnect.biz.board.BoardDTO;
import com.KJNP.MediConnect.biz.board.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(BoardDTO boardDTO, Model model) {
		model.addAttribute("board", boardService.selectAll(boardDTO));
		System.out.println(model.getAttribute("board"));
		
		return "phm/board";
	}
	
	@GetMapping("/boardWritePage")
	public String boardWrtiePage() {
		
		return "phm/boardWrite";
	}
	
	@PostMapping("/boardWrite")
	public String boardWrtie(BoardDTO boardDTO) {
		boardService.insert(boardDTO);
		return "redirect:/board";
	}
	
	@PostMapping("/boardDelete")
	public String boardDelete(@RequestParam("title") String title, BoardDTO boardDTO) {
		boardDTO.setTitle(title);
		boardService.delete(boardDTO);
		return "redirect:/board";
	}
	
	@GetMapping("/boardUpdatePage")
	public String boardUpdatePage(BoardDTO boardDTO, Model model) {
		model.addAttribute("boardData", boardService.selectOne(boardDTO));
		System.out.println(model.getAttribute("boardData"));
		return "phm/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardDTO boardDTO) {
		System.out.println("수정: "+boardDTO);
		boardService.update(boardDTO);
		return "redirect:/board";
	}
}
