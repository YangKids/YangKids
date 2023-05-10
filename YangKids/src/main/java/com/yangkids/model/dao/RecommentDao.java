package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Recomment;

public interface RecommentDao {
	// 대댓글 목록
	public List<Recomment> selectAll(int commentId);

	// 대댓글 등록
	public int insertRecomment(Recomment recomment);

	// 대댓글 삭제
	public int deleteRecomment(int recommentId);

	// 대댓글 수정
	public int updateRecomment(Recomment recomment);
}
