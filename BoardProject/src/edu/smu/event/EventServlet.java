package edu.smu.event;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.smu.event.dao.EventDao;
import edu.smu.event.dao.Event_CommentsDao;
import edu.smu.event.vo.Event;
import edu.smu.event.vo.Event_Comments;


@WebServlet("/Event.do")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	EventDao dao = new EventDao();
	Event_CommentsDao ecmtDao = new Event_CommentsDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	} 	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		request.setCharacterEncoding("UTF-8");
 		
 		String action = request.getParameter("action"); 
 		
 		if(action == null) {
 			action = "list";
 		}
 		
 		try {
			switch (action) {
			/*case "insert":
				insert(request, response);
				break;*/
				
			case "cmt_insert":
				cmt_insert(request, response);
				break;
				
			case "list":
				list(request, response);
				break;
				
			case "view":
				view(request, response);
				break;
			/*case "delete":
				delete(request, response);
				break;*/

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
	 		
		Event_Comments b = new Event_Comments(contents,new Integer(num));
		
		ecmtDao.comSave(b);
			
		response.sendRedirect("Event.do?action=view&num="+num);
		
		//request.getRequestDispatcher(url).forward(request, response);
		
	}
 	
 	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Event> result;
		String nextPage="/event/EventList.jsp";
		try {
			result = dao.search();
			request.setAttribute("resultList", result);		
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", e);
			nextPage="Error.jsp";
		}
	    request.getRequestDispatcher(nextPage).forward(request, response);
	}

	
	
	/*protected void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String title = request.getParameter("title"); 
		String img_filename = request.getParameter("img_filename"); 
		String content = request.getParameter("content");
		
		Event b = new Event(title, img_filename, content);
		
		dao.save(b);
			
		String url = "/Event/InsertOk.jsp";
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}*/
	
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Event_Comments> ecmtList;
		String num=request.getParameter("num");//2
		String nextPage="/event/EventView.jsp";
		try {
			ecmtList = ecmtDao.search(Integer.parseInt(num));
			request.setAttribute("cmtList", ecmtList);
			
			Event result=dao.search(Integer.parseInt(num));//3
			request.setAttribute("result", result);//4
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "");
			nextPage="Error.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);//5	
	}
	
	/*protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}*/
	
	
	

}

