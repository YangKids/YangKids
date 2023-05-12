package com.yangkids.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.CommentDao;
import com.yangkids.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getCommentList(int articleId) {
		return commentDao.selectAll(articleId);
	}

	@Transactional
	@Override
	public int writeComment(Comment comment) {
		int result = commentDao.insertComment(comment);
		return result;
	}

	@Transactional
	@Override
	public int removeComment(int commentId) {
		int result = commentDao.deleteComment(commentId);
		return result;
	}

	@Transactional
	@Override
	public int modifyComment(Comment comment) {
		int result = commentDao.updateComment(comment);
		return result;
	}

}
