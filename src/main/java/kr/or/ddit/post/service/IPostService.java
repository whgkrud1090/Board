package kr.or.ddit.post.service;

import java.util.List;

import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;

public interface IPostService {

	/**
	* Method : getPostList
	* 작성자 : PC-03
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 조회
	 */
	List<Post> getPostList(int boardId);
	
	/**
	* Method : getPostPagingList
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 포스터 페이지 리스트 조회
	 */
	List<Post> getPostPagingList(Post post);

	int getPostCount(int boardId);
	
	Post getpost(int postId);
	
	int insertAtta(Attachment atta);
	
	List<Attachment> getFile(int postId);
	
	int newPost(Post post);
}
