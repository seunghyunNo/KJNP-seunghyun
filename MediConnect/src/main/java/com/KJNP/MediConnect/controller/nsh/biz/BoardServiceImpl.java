package com.KJNP.MediConnect.controller.nsh.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.selectAll(boardDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(boardDTO);
	}

	@Override
	public boolean insert(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.insert(boardDTO);
	}

	@Override
	public boolean update(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.update(boardDTO);
	}

	@Override
	public boolean delete(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.delete(boardDTO);
	}

}
