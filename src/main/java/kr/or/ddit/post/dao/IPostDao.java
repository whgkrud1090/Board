package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;

public interface IPostDao {

	/**
	* Method : getPostList
	* 작성자 : PC-03
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 조회
	 */
	List<Post> getPostList(SqlSession sqlSession, int boardId);
	
	/**
	* Method : getPostPagingList
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param post
	* @return
	* Method 설명 : 포스터 페이지 리스트 조회
	 */
	List<Post> getPostPagingList(SqlSession sqlSession, Post post);
	
	int getPostCount(SqlSession sqlSession, int boardId);
	
	Post getpost(SqlSession sqlSession, int postId);
	
	int insertAtta(SqlSession sqlSession, Attachment atta);
	
	List<Attachment> getFile(SqlSession sqlSession, int postId);
	
	int newPost(SqlSession sqlSession, Post post);
	
}
