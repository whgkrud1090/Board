package kr.or.ddit.post.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;

public class PostServiceTest {

	private IPostService postService;
	@Before
    public void setup() {
		postService = new PostService();
    }
	
	//@Test
	public void getPostListTest() {
		
		/***Given***/
		int boardId = 49;

		/***When***/
		List<Post> postList = postService.getPostList(boardId);
		
		/***Then***/
		assertEquals(postList.size(), 11);
	}

	//@Test
	public void getPostPagingList() {
		/***Given***/
		Post post = new Post();
		post.setPage(2);
		post.setPagesize(10);
		post.setBoardId(49);
		
		/***When***/
		List<Post> postList = postService.getPostPagingList(post);
		
		/***Then***/
		assertEquals(10, postList.size());
	}
	
	@Test
	public void getPostCount() {
		/***Given***/
		int boardId = 49;
		/***When***/
		int totalCnt = postService.getPostCount(boardId);
		/***Then***/
		assertEquals(1, totalCnt);
	}
	
	@Test
	public void getPost() {
		/***Given***/
		int postId = 35;

		/***When***/
		Post post = postService.getpost(postId);

		/***Then***/
		assertEquals(post.getUserId(), "sally");
	}
	
	//@Test
	public void insertFile() {
		/***Given***/
		Attachment atta = new Attachment();
		atta.setPostId(2);
		atta.setUpFilenm("테스트2");
		atta.setDetailFile("e:/");
		
		/***When***/
		int insertFile = postService.insertAtta(atta);
		
		/***Then***/
		assertEquals(1, insertFile);
	}
	
	//@Test
	public void getFileListTest() {
		/***Given***/
		int postId = 2;
		/***When***/
		List<Attachment> fileList = postService.getFile(postId);
		
		/***Then***/
		assertEquals(6, fileList.size());
	}
	
	@Test
	public void newPostTest() {
		/***Given***/
		Post post = new Post();
		post.setBoardId(49);
		post.setUserId("sally");
		post.setPostNm("test post");
		post.setPostCont("test post content");
		
		
		/***When***/
		int insertPost = postService.newPost(post);
		
		/***Then***/
		assertEquals(1, insertPost);
	}
}
