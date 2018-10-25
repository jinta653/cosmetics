package edu.smu.cosmetics;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.smu.cosmetics.dao.CommentsDao;
import edu.smu.cosmetics.dao.CosmeticsDao;
import edu.smu.cosmetics.dao.Cosmetics_BrandDao;
import edu.smu.cosmetics.dao.Cosmetics_Brand_KindDao;
import edu.smu.cosmetics.vo.Comments;
import edu.smu.cosmetics.vo.Cosmetics;
import edu.smu.cosmetics.vo.CosmeticsBrandKindVo;
import edu.smu.cosmetics.vo.CosmeticsBrandVo;

@WebServlet("/Cosmetics.do")
public class CosmeticsServlet extends HttpServlet {
	
	CosmeticsDao cDao = new CosmeticsDao();
	CommentsDao cmtDao = new CommentsDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	} 	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		request.setCharacterEncoding("UTF-8");
 		
 		String action = request.getParameter("action"); 
 		
 		try {
			switch (action) {
			case "list":
				list(request, response);
				break;
			
			case "all_list":
				all_list(request, response);
				break;
				
			case "cmt_insert":
				cmt_insert(request, response);
				break;
							
			case "view":
				view(request, response);
				break;
				
			case "brand_kind":
				brand_kind(request, response);
				break;
				
			default:
				break;
			}//end switch
		} catch (Exception e) {
			e.printStackTrace();
		}
 	 		
 		
	}
	
 	protected void all_list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cosmetics> result;
		String nextPage="/cosmetics/CosmeticsList.jsp";
		try {
			result = cDao.all_search();
			request.setAttribute("result", result);	
			
			get_menu_data(request);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", e);
			nextPage="Error.jsp";
		}
	    request.getRequestDispatcher(nextPage).forward(request, response);
	}
 	
 	
 	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cosmetics> result;
		String nextPage="/cosmetics/CosmeticsList.jsp";
		try {
			result = cDao.search();
			request.setAttribute("resultList", result);	
			
			get_menu_data(request);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", e);
			nextPage="Error.jsp";
		}
	    request.getRequestDispatcher(nextPage).forward(request, response);
	}

	private void get_menu_data(HttpServletRequest request) throws SQLException {
		Cosmetics_BrandDao cbDao = new Cosmetics_BrandDao();
		ArrayList<CosmeticsBrandVo> cblist = cbDao.list();//브랜드목록
		request.setAttribute("cblist", cblist);

		Cosmetics_Brand_KindDao cbkDao = new Cosmetics_Brand_KindDao();//브랜드별 종류 목록
		HashMap<Integer, ArrayList<CosmeticsBrandKindVo>> cbkHash = new HashMap<>(); //브랜드번호별 종류저장
		for (CosmeticsBrandVo cbvo : cblist) {
			int cobrn_num = cbvo.getCobrn_num()   ;//브랜드번호  
			ArrayList<CosmeticsBrandKindVo> cbklist = cbkDao.list(cobrn_num);
			cbkHash.put(cobrn_num, cbklist);
		}
		request.setAttribute("cbkHash", cbkHash);
	}

	
	
	
	
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Comments> cmtList;
		String num=request.getParameter("num");//2
		String nextPage="/cosmetics/CosmeticsView.jsp";
		try {
			cmtList = cmtDao.search(Integer.parseInt(num));
			request.setAttribute("cmtList", cmtList);
			
			Cosmetics result=cDao.search(Integer.parseInt(num));//3
			request.setAttribute("result", result);//4
			get_menu_data(request);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "");
			nextPage="Error.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);//5	
	}
	
	protected void brand_kind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cosmetics> cmtList;
		String cobrn_num=request.getParameter("cobrn_num");//2
		String cokin_num=request.getParameter("cokin_num");//2
		String nextPage="/cosmetics/CosmeticsList.jsp";
		try {
			
			ArrayList<Cosmetics> result=cDao.search(Integer.parseInt(cobrn_num),Integer.parseInt(cokin_num));//3
			request.setAttribute("result", result);//4
			get_menu_data(request);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "");
			nextPage="Error.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);//5	
	}
	
	
	private void cmt_insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
 		
 		String contents = request.getParameter("contents");
 		String num = request.getParameter("num");
 		
		Comments b = new Comments(contents,new Integer(num));
		
		cmtDao.comSave(b);
			
					
		String url = "/board/InsertOk.jsp";
		response.sendRedirect("Cosmetics.do?action=view&num="+num);
		
		//request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	

}
