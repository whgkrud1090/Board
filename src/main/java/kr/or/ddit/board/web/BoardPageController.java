package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.PostService;

@WebServlet("/boardPage")
public class BoardPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;
	
private PostService postService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		postService = new PostService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		List<Post> postList = postService.getPostList(boardId);
		request.setAttribute("postList", postList);
		System.out.println(postList);
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

}
