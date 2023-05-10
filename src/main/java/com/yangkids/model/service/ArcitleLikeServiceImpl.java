/**
 * 
 */
package com.yangkids.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.ArticleDao;
import com.yangkids.model.dao.ArticleLikeDao;
import com.yangkids.model.dto.ArticleLike;

/**
 * @author user
 *
 */
@Service
public class ArcitleLikeServiceImpl implements ArticleLikeService {
	// 
	@Autowired
	private ArticleLikeDao articleLikeDao;
	
//	@Autowired
//	private ArticleDao articleDao;

	@Override
	public int countLike(ArticleLike articleLike) {
		return articleLikeDao.select(articleLike);
	}

	@Override
	public int insertLike(ArticleLike articleLike) {
		int added = articleLikeDao.insert(articleLike);
		//새로운 좋아요가 생겼다는 뜻
		if(added == 1)
			return articleLikeDao.updateLikeCnt(articleLike.getArticleId(),1);
		return 0;
	}

	// 좋아요 안눌렀는데 delete 누르면 어떻게 처리하지? -> Service에서 처리할게여
	@Override
	public int deleteLike(ArticleLike articleLike) {
		int deleted = articleLikeDao.delete(articleLike);
		//어떠한 좋아요가 사라졌다는 뜻
		if(deleted == 1)
			// 이거 void 처리 할 필요가 있나?
			return articleLikeDao.updateLikeCnt(articleLike.getArticleId(),-1);
		return 0;
	}
}
