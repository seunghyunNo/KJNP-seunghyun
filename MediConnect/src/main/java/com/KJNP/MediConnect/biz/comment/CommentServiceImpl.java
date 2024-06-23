package com.KJNP.MediConnect.biz.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDAO;

	@Override
	public List<CommentDTO> selectAll(CommentDTO commentDTO) {
		return commentDAO.selectAll(commentDTO);
	}

	@Override
	public CommentDTO selectOne(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		return commentDAO.selectOne(commentDTO);
	}

	@Override
	public boolean insert(CommentDTO commentDTO) {
		return commentDAO.insert(commentDTO);
	}

	@Override
	public boolean update(CommentDTO commentDTO) {
		return commentDAO.update(commentDTO);
	}

	@Override
	public boolean delete(CommentDTO commentDTO) {
		return commentDAO.delete(commentDTO);
	}
}
