package kr.or.ddit.post.respository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	
	private SqlSession sqlSession;
	private IPostDao postDao;
	
	@Before
	public void setup() {
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}
	
	@Test
	public void getPostListTest() {
		/***Given***/
		int boardId = 49;
		/***When***/
		List<Post> postList = postDao.getPostList(sqlSession, boardId);
		
		/***Then***/
		assertEquals(11, postList.size());
	}
	
	@Test
	public void getPostPagingList() {
		/***Given***/
		Post post = new Post();
		post.setPage(2);
		post.setPagesize(5);
		post.setBoardId(49);
		
		/***When***/
		List<Post> postList = postDao.getPostPagingList(sqlSession, post);
		
		/***Then***/
		assertEquals(5, postList.size());
	}
	
	@Test
	public void getPostCount() {
		/***Given***/
		int boardId = 49;
		/***When***/
		int totalCnt = postDao.getPostCount(sqlSession, boardId);
		/***Then***/
		assertEquals(11, totalCnt);
	}
	
	@Test
	public void getPost() {
		/***Given***/
		int postId = 1;

		/***When***/
		Post post = postDao.getpost(sqlSession, postId);

		/***Then***/
		assertEquals(post.getPostNm(), "첫번째 글입니다");
		assertEquals(post.getUserId(), "sally");
	}
	
	@Test
	public void insertFile() {
		/***Given***/
		Attachment atta = new Attachment();
		atta.setPostId(2);
		atta.setUpFilenm("테스트");
		atta.setDetailFile("e:/");
		
		/***When***/
		int insertFile = postDao.insertAtta(sqlSession, atta);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, insertFile);
	}
	@Test
	public void getFileListTest() {
		/***Given***/
		int postId = 2;
		/***When***/
		List<Attachment> fileList = postDao.getFile(sqlSession, postId);
		
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
		int insertPost = postDao.newPost(sqlSession, post);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, insertPost);
	}

}
