package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		
		User user = userService.getUser(userId);

		if(user == null)
			doGet(request, response);
		else if(user.checkLoginValidate(userId, pass)){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("S_USERVO", user);
			request.setAttribute("elTest", "elTestValue");
			
			BoardService boardService = new BoardService();
			List<Board> boardList = boardService.getBoardList();
			
			request.setAttribute("boardList", boardList);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}
		else {
			doGet(request, response);
		}
		
		
	}

}










