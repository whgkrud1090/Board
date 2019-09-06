package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;

public class PostDao implements IPostDao{
	@Override
	public List<Post> getPostList(SqlSession sqlSession, int boardId) {
		List<Post> postList = sqlSession.selectList("post.getPostList", boardId);
		sqlSession.close();
		return postList;
	}

	@Override
	public List<Post> getPostPagingList(SqlSession sqlSession, Post post) {
		return sqlSession.selectList("post.getPostPagingList", post);
	}

	@Override
	public int getPostCount(SqlSession sqlSession, int boardId) {
		return sqlSession.selectOne("post.getPostTotalCnt", boardId);
	}

	@Override
	public Post getpost(SqlSession sqlSession, int postId) {
		return sqlSession.selectOne("post.getPostRead", postId);
	}

	@Override
	public int insertAtta(SqlSession sqlSession, Attachment atta) {
		return sqlSession.insert("post.insertFile", atta);
	}

	@Override
	public List<Attachment> getFile(SqlSession sqlSession, int postId) {
		return sqlSession.selectList("post.getFile", postId);
	}

	@Override
	public int newPost(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.newPost", post);
	}
}
