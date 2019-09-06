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

@WebServlet("/boardadminPage")
public class BoardAdminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/boardadmin.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String param = request.getParameter("param");
		
		if(param.equals("0")) {
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			String useCk = request.getParameter("useCk");
			
			Board board = new Board(boardId, useCk);
			boardService.updateBoard(board);
			
			boardId = 0;
			useCk = null;
			
			
		}else if(param.equals("1")) {
			String newuserId = request.getParameter("userId");
			String newboardNm = request.getParameter("newBoardNm");
			String newuseCk = request.getParameter("newUseCk");
			
			Board NewBoard = new Board(newuserId, newboardNm, newuseCk);
			
			boardService.insertNewBoard(NewBoard);
		}
		
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/boardadmin.jsp").forward(request, response);
		
	}

}







