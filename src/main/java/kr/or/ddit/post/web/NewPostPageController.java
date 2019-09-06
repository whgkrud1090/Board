package kr.or.ddit.post.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import org.omg.CORBA.RepositoryIdHelper;

import javafx.scene.control.Alert;
import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.PostService;

@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
@WebServlet("/newPostPage")
public class NewPostPageController extends HttpServlet {
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
		
		
		request.getRequestDispatcher("/board/newpost.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String postNm = request.getParameter("newPostNm");
		String postCont = request.getParameter("smarteditor");
		String boardName = request.getParameter("boardNm");
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		System.out.println(userId);
		System.out.println(postNm);
		System.out.println(postCont);
		System.out.println(boardId);
		
		if(postNm == null || postCont == null) {
			
			doGet(request, response);
		}else {
			Post post = new Post(boardId, userId, postNm, postCont);
			
			int insertPost = 0;
			
			try {
				insertPost = postService.newPost(post);

				if(insertPost == 1) {
					String boardNm = URLEncoder.encode(boardName);
					response.sendRedirect("/boardPage?userId=" + userId + "&boardId=" + boardId  +"&boardNm=" + boardNm);
				}
			} catch (Exception e) {
				doGet(request, response);
			}
		}
	}
}
