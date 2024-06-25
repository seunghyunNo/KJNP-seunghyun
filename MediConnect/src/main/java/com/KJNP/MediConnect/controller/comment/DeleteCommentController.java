package com.KJNP.MediConnect.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KJNP.MediConnect.biz.comment.CommentDTO;
import com.KJNP.MediConnect.biz.comment.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeleteCommentController {

	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value="/deleteComment",method=RequestMethod.GET)
	public @ResponseBody boolean deleteComment(CommentDTO commentDTO,HttpSession session) {
		return commentService.delete(commentDTO);
	}
}
