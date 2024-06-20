package com.KJNP.MediConnect.biz.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDAO {
	List<CommentDTO> selectAll(CommentDTO commentDTO);
	CommentDTO selectOne(CommentDTO commentDTO);
	boolean insert(CommentDTO commentDTO);
	boolean update(CommentDTO commentDTO);
	boolean delete(CommentDTO commentDTO);
}
