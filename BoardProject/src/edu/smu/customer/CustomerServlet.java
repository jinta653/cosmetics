package edu.smu.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.smu.customer.dao.CustomerDao;
import edu.smu.customer.vo.Customer;


@WebServlet("/Customer.do")
public class CustomerServlet extends HttpServlet {
	
	CustomerDao cdao = new CustomerDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
	 		
 		String action = request.getParameter("action"); 
 		
 		try {
			switch (action) {
			case "register":
				register(request, response);
				break;
				
			case "delete":
				delete(request, response);
				break;
				
			case "update":
				update(request, response);
				break;
			
			case "login":
				login(request, response);
				break;
				
			case "search":
				search(request, response);
				break;
				
			case "logout":
		        HttpSession s = request.getSession(false);
		        s.invalidate(); 
		        request.getRequestDispatcher("index.jsp").forward(request, response);
		        break;

		
			default:
				break;
			}//end switch
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String name = request.getParameter("name");
		
		String yyyy = request.getParameter("yyyy");
		String mm = request.getParameter("mm");
		String dd = request.getParameter("dd");
		
		String gender = request.getParameter("gender");
		int telnum = Integer.parseInt(request.getParameter("telnum"));
		
		Customer c = new Customer(email, password, name, yyyy+mm+dd, gender, telnum);
	      
	    String next = null;
	    try {
	       cdao.update(c);
	       next = "main.jsp";
	       request.setAttribute("msg", "회원정보를 수정하였습니다.");
	    } catch (Exception e) {
	       request.setAttribute("msg", e.getMessage());
	       next = "error.jsp";
	    }
	      request.getRequestDispatcher(next).forward(request, response);
	      
	   }
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String name = request.getParameter("name");
		
		String yyyy = request.getParameter("yyyy");
		String mm = request.getParameter("mm");
		String dd = request.getParameter("dd");
		
		String gender = request.getParameter("gender");
		int telnum = Integer.parseInt(request.getParameter("telnum"));
		
		Customer b = new Customer(email, password, name, yyyy+mm+dd, gender, telnum);
		
		cdao.save(b);
			
		String url = "index.jsp";
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      CustomerDao dao = new CustomerDao();
	      String email = request.getParameter("email");
	      String pass = request.getParameter("password");
	   
	      String nextPage = null;
	      try {
	         String pass2 = dao.search(email);
	         if (pass2.isEmpty()) {
	            request.setAttribute("msg", "아이디가 없습니다.");
	            nextPage = "error.jsp";
	         } else if (pass2.equals(pass)) {
	            Customer c = dao.search(email, pass);
	            request.setAttribute("Info", c);
	            nextPage = "update.jsp";
	         } else {
	            request.setAttribute("msg", "비밀번호가 다릅니다. 다시 입력해주세요.");
	            nextPage = "error.jsp";
	         }
	      } catch (Exception e) {
	         request.setAttribute("msg", e.getMessage());
	         nextPage = "error.jsp";
	      }
	      request.getRequestDispatcher(nextPage).forward(request, response);
	   }
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      CustomerDao dao = new CustomerDao();
	      String email = request.getParameter("email");
	      String pass = request.getParameter("password");
	      String next = "main.jsp"; 
	      try {
	         String pass2 = dao.search(email);
	         if (pass2.equals("")) {
	            request.setAttribute("msg", "아이디가 없습니다.");
	            next = "error.jsp";
	         } else if (pass2.equals(pass)) {
	            request.setAttribute("msg", "로그인");
	            HttpSession httpSession = request.getSession();
	            httpSession.setAttribute("userid", email);
	         } else {
	            request.setAttribute("msg", "비밀번호가 다릅니다.");
	            next = "error.jsp";
	         }
	      } catch (SQLException e) {
	         request.setAttribute("msg", e.getMessage());
	         next = "error.jsp";
	      }
	      request.getRequestDispatcher(next).forward(request, response);
	   }
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {

	      String email = request.getParameter("email");
	      String password = request.getParameter("password");
	      String nextPage = "";
	      CustomerDao cdao = new CustomerDao();
	      try {
	    	 
	         String pass2 = cdao.search(email);
	         if (pass2.isEmpty()) {
	            request.setAttribute("msg", "아이디가 없습니다.");
	            nextPage = "error.jsp";
	         } else if (pass2.equals(password)) {
	            cdao.delete(email);
	            nextPage = "index.jsp";
	         } else {
	            request.setAttribute("msg", "비밀번호가 다릅니다. 다시 입력해주세요.");
	            nextPage = "error.jsp";
	         }
	         
	                 
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         request.setAttribute("msg", "회원탈퇴 실패하였습니다.");
	      }
	      request.getRequestDispatcher(nextPage).forward(request, response);
	   }


}
