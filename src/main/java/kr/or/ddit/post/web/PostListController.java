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
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.PostService;

@WebServlet("/postPage")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PostService postService;
	private BoardService boardService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		System.out.println(boardList);
		
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		System.out.println(pageStr);
		System.out.println(pagesizeStr);
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		System.out.println(boardId);
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);
		System.out.println(page);
		System.out.println(pagesize);
		
		Post post = new Post(page, pagesize, boardId);
		request.setAttribute("post", post);
   		
		System.out.println(post);
		List<Post> postList = postService.getPostPagingList(post);
		int countpostList = postService.getPostCount(boardId);
		System.out.println(postList);
		System.out.println(countpostList);
		
		request.setAttribute("postList", postList);
		request.setAttribute("countpostList", countpostList);
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}
}
