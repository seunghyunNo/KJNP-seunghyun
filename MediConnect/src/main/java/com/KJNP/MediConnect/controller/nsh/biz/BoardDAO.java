package com.KJNP.MediConnect.controller.nsh.biz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECTALL = "SELECT BOARDNUM, TITLE, CONTENT, REGDATE FROM BOARD";
	private static final String SELECTONE = "SELECT BOARDNUM, TITLE, CONTENT,REGDATE FROM BOARD WHERE BOARDNUM=?";
	private static final String INSERT = "INSERT INTO BOARD (TITLE,CONTENT) VALUES(?,?)";
	private static final String UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BOARDNUM=?";
	private static final String DELETE = "DELETE FROM BOARD WHERE BOARDNUM = ?";

	public List<BoardDTO> selectAll(BoardDTO boardDTO) {

		List<BoardDTO> result = null;

		try {
			result = jdbcTemplate.query(SELECTALL, new BoardSelectAllRowMapper());
			System.out.println("boardDAO "+result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public BoardDTO selectOne(BoardDTO boardDTO) {
		
		BoardDTO result = null;
		try {
			Object[] args = {boardDTO.getBoardNum()};
			result = jdbcTemplate.queryForObject(SELECTONE, args, new BoardSelectOneRowMapper());
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 작성
	public boolean insert(BoardDTO boardDTO) {
		int result = 0;

		result = jdbcTemplate.update(INSERT, boardDTO.getTitle(), boardDTO.getContent());

		return true;
	}

	// 수정
	public boolean update(BoardDTO boardDTO) {
		int result = 0;
		result = jdbcTemplate.update(UPDATE, boardDTO.getTitle(), boardDTO.getContent(),boardDTO.getBoardNum());

		return true;
	}

	// 삭제
	public boolean delete(BoardDTO boardDTO) {
		int result = 0;

		result = jdbcTemplate.update(DELETE, boardDTO.getBoardNum());

		return true;
	}

	class BoardSelectAllRowMapper implements RowMapper<BoardDTO> {

		@Override
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

			BoardDTO boardDTO = new BoardDTO();

			boardDTO.setBoardNum(rs.getString("BOARDNUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setContent(rs.getString("CONTENT"));
			boardDTO.setRegDate(rs.getString("REGDATE"));

			return boardDTO;
		}

	}

	class BoardSelectOneRowMapper implements RowMapper<BoardDTO> {

		@Override
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

			BoardDTO boardDTO = new BoardDTO();

			boardDTO.setBoardNum(rs.getString("BOARDNUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setContent(rs.getString("CONTENT"));
			boardDTO.setRegDate(rs.getString("REGDATE"));

			return boardDTO;
		}

	}

}
