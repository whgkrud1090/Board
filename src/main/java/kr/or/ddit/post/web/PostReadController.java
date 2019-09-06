package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.post.model.Attachment;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.PostService;

@WebServlet("/readPost")
public class PostReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
	private PostService postService;
	
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		postService = new PostService();
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		List<Attachment> file = postService.getFile(postId);
		
		
		request.setAttribute("file", file);

		System.out.println(file);

		int countfile = file.size();
		request.setAttribute("countfile", countfile);
		
		Post post = postService.getpost(postId);
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/board/postread.jsp").forward(request, response);
	}
}
