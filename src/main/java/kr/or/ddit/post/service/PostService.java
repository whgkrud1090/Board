package kr.or.ddit.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {
	
	private IPostDao postDao;
	public PostService() {
		postDao = new PostDao();
	}

	@Override
	public List<Post> getPostList(int boardId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Post> postList = postDao.getPostList(sqlSession, boardId);
		
		sqlSession.close();
		return postList;
	}

	@Override
	public List<Post> getPostPagingList(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Post> postList = postDao.getPostPagingList(sqlSession, post);
		
		sqlSession.close();
		return postList;
	}

	@Override
	public int getPostCount(int boardId) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int countpost = postDao.getPostCount(sqlSession, boardId);
		
		int count = (int) Math.ceil(countpost/5);
		return count;
	}

	@Override
	public Post getpost(int postId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Post post = postDao.getpost(sqlSession, postId);
		sqlSession.close();
		return post;
	}

	@Override
	public int insertAtta(Attachment atta) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int insertFile = postDao.insertAtta(sqlSession, atta);
		sqlSession.commit();
		sqlSession.close();
		return insertFile;
	}

	@Override
	public List<Attachment> getFile(int postId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Attachment> fileList = postDao.getFile(sqlSession, postId);
		sqlSession.close();
		return fileList;
	}

	@Override
	public int newPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int insertpost = postDao.newPost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		
		return insertpost;
	}
}
