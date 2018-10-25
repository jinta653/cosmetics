package edu.smu.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.smu.board.dao.BoardDao;
import edu.smu.board.dao.CommentsDao;
import edu.smu.board.vo.Board;
import edu.smu.board.vo.Comments;
import edu.smu.board.vo.PageNavigation;

@WebServlet("/Board.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	BoardDao dao = new BoardDao();
	CommentsDao cmtDao = new CommentsDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	} 	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		request.setCharacterEncoding("UTF-8");
 		
 		String action = request.getParameter("action"); 
 		 		
 			 		 		
 		try {
			switch (action) {
			case "insert":
				insert(request, response);
				break;
			
			case "cmt_insert":
				cmt_insert(request, response);
				break;
				
			case "list":
				list(request, response);
				break;
				
			case "view":
				view(request, response);
				break;
			case "delete":
				delete(request, response);
				break;

			default:
				break;
			}//end switch
		} catch (Exception e) {
			e.printStackTrace();
		}
 	 		
 		
	}

 	private void cmt_insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
 		
 		String contents = request.getParameter("contents");
 		String num = request.getParameter("num");
 		String userid = request.getParameter("userid");
				
		Comments b = new Comments(contents,new Integer(num),userid);
		
		cmtDao.comSave(b);
			
					
		String url = "/board/BoardList.jsp";
		response.sendRedirect("Board.do?action=view&num="+num);
		
		//request.getRequestDispatcher(url).forward(request, response);
		
	}
 	
 	 	
 	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Board> result;
		String nextPage="/board/BoardList.jsp";
		int nowPage = 0;
		
		if(request.getParameter("page") == null){
			nowPage = 1;
		}
		else{
			nowPage = Integer.parseInt(request.getParameter("page"));
		    
		    if(nowPage < 1)
		    {
		        nowPage = 1;
		    }
		}

		try {
			result = dao.list(nowPage);
			request.setAttribute("resultList", result);		
			
			
			
			int rowTotal = dao.getCount();
			// 객체를 생성한다 (현재페이지, 전체글수, 페이지당표시할 글의수, 한번에 표시할 페이징블록수)    
			PageNavigation pageNav = new PageNavigation(nowPage, rowTotal , 10, 5);
			
			pageNav.Debug();
			
			request.setAttribute("pageIsPrev",    pageNav.isPrevPage());    // 이전페이지 블록의 존재유무
			request.setAttribute("pageIsNext",    pageNav.isNextPage());    // 다음페이지 블록의 존재유무
			request.setAttribute("pageStart",    pageNav.getStartPage());// 시작페이지 번호
			request.setAttribute("pageEnd",        pageNav.getEndPage());    // 종료페이지 번호
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", e);
			nextPage="Error.jsp";
		}
	    request.getRequestDispatcher(nextPage).forward(request, response);
		
	}

	
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String title = request.getParameter("title"); 
		String writer = request.getParameter("writer"); 
		String content = request.getParameter("content");
		
		Board b = new Board(title, writer, content);
		
		dao.save(b);
			
		String url = "/board/BoardList.jsp";
		response.sendRedirect("Board.do?action=list");
		
		
		//request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Comments> cmtList;
		String num=request.getParameter("num");//2
		String nextPage="/board/BoardView.jsp";
		try {
			cmtList = cmtDao.search(Integer.parseInt(num));
			request.setAttribute("cmtList", cmtList);
			
			Board result=dao.search(Integer.parseInt(num));//3
			dao.updateRate(Integer.parseInt(num));
			request.setAttribute("result", result);//4
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "");
			nextPage="Error.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);//5	
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.
		String num=request.getParameter("num");
		
		//3.
		try {
			dao.delete(Integer.parseInt(num));
			
			list(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","�궘�젣 �떎�뙣");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}
	

}

