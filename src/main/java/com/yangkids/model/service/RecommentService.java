package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Recomment;

public interface RecommentService {
	// 대댓글 목록
	public List<Recomment> getRecommentList(int commentId);

	// 대댓글 등록
	public int writeRecomment(Recomment recomment);

	// 대댓글 삭제
	public int removeRecomment(int recommentId);

	// 대댓글 수정
	public int modifyRecomment(Recomment recomment);
}
