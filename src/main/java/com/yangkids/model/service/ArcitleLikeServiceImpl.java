/**
 * 
 */
package com.yangkids.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangkids.model.dao.ArticleDao;
import com.yangkids.model.dao.ArticleLikeDao;
import com.yangkids.model.dto.ArticleLike;

/**
 * @author user
 *
 */
@Service
public class ArcitleLikeServiceImpl implements ArticleLikeService {

	private ArticleLikeDao articleDao;
	
	// selectLike로 아... 뭐할라고 했지?
	// like 눌렀는지 안눌렀는지 Article에 알려주..?엥?
	@Autowired
	public void setBoardDao(ArticleLikeDao articleDao) {
		this.articleDao = articleDao;
	}
	// selectLike는 뭐니? -> 한명의 user가 특정 articleId에 좋아요 누른 개수 => 0개면 insert 가능, 1개면 delete 가능
	@Override
	public int selectLike(ArticleLike articleLike) {
		return articleDao.findLike(articleLike);
	}

	// 좋아요 2번눌렀어. 이거 중복처리는 어디서 해주나요? -> Controller 단에서 처리해보자
	@Override
	public void insert(ArticleLike articleLike) {
		articleDao.likeup(articleLike);
	}
	
	// 좋아요 안눌렀는데 delete 누르면 어떻게 처리하지? -> Controller 단에서 처리해보자
	@Override
	public void delete(ArticleLike articleLike) {
		articleDao.likeDown(articleLike);		
	}
}
