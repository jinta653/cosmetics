package edu.smu.tips;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.smu.board.vo.PageNavigation;
import edu.smu.tips.doa.TipsCommentsDao;
import edu.smu.tips.doa.TipsDao;
import edu.smu.tips.vo.Tips;
import edu.smu.tips.vo.TipsComments;


@WebServlet("/Tips.do")
public class TipsServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
   
	TipsDao tdao = new TipsDao();
	TipsCommentsDao tcmtdao = new TipsCommentsDao();
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
 		
 		String action = request.getParameter("action");
 		
 		try {
		switch (action) {
			case "tips_cmt_insert":
				tips_cmt_insert(request, response);
			break;
			
			case "tips_list":
				tips_list(request, response);
				break;
				
			case "tips_insert":
				tips_insert(request, response);
				break;
				
			case "tips_view":
				tips_view(request, response);
				break;
			
			default:
				break;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}


	private void tips_cmt_insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String contents = request.getParameter("tips_contents");
 		String num = request.getParameter("num");
		
		
		TipsComments t = new TipsComments(contents,new Integer(num));
		
		tcmtdao.tips_comSave(t);
			
					
		String url = "/Tips/TipsList.jsp";
		response.sendRedirect("Tips.do?action=tips_view&num="+num);
				
	}


	private void tips_view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TipsComments> tcmtList;
		String num=request.getParameter("num");//2
		String nextPage="/Tips/TipsView.jsp";
		try {
			tcmtList = tcmtdao.tips_search(Integer.parseInt(num));
			request.setAttribute("tips_cmtList", tcmtList);
			
			Tips tips_result=tdao.search(Integer.parseInt(num));//3
			tdao.tips_updateRate(Integer.parseInt(num));
			request.setAttribute("tips_result", tips_result);//4
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "");
			nextPage="Error.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);//5	
	}
	


	private void tips_insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String kind = request.getParameter("tips_kind"); 
		String title = request.getParameter("tips_title"); 
		String writer = request.getParameter("tips_writer"); 
		String content = request.getParameter("tips_content");
		
		Tips t = new Tips(kind, title, writer, content);
		
		tdao.save(t);
			
		String url = "/Tips/TipsList.jsp";
		response.sendRedirect("Tips.do?action=tips_list");
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}


	private void tips_list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Tips> tResult;
		String nextPage = "/Tips/TipsList.jsp";
		
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
				tResult = tdao.list(nowPage);
				request.setAttribute("tips_resultList", tResult);
				
				int rowTotal = tdao.getCount();
				// ��ü�� �����Ѵ� (����������, ��ü�ۼ�, ��������ǥ���� ���Ǽ�, �ѹ��� ǥ���� ����¡��ϼ�)    
				PageNavigation pageNav = new PageNavigation(nowPage, rowTotal , 10, 5);
				
				pageNav.Debug();
				
				request.setAttribute("pageIsPrev",    pageNav.isPrevPage());    // ���������� ����� ��������
				request.setAttribute("pageIsNext",    pageNav.isNextPage());    // ���������� ����� ��������
				request.setAttribute("pageStart",    pageNav.getStartPage());// ���������� ��ȣ
				request.setAttribute("pageEnd",        pageNav.getEndPage());    // ���������� ��ȣ
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher(nextPage).forward(request, response);	
		
	}

	
}
