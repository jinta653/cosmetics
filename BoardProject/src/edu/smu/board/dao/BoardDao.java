package edu.smu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.board.vo.Board;



public class BoardDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//1
	}
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection conn=DriverManager.getConnection(url, "scott", "tiger");
		return conn;
	}
	
	public void save(Board b) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into board(num, title, writer, content, regdate) "
				+ "values(BOARD_SEQ.nextval,?,?,?,sysdate)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getWriter());
		ps.setString(3, b.getContent());
		
		ps.executeUpdate();//4
		
		ps.close();
		con.close();
	}
	public ArrayList<Board> list(int page) throws SQLException{
		ArrayList<Board> result = new ArrayList<Board>();
		Connection con = getConnection();
		String sql = "SELECT * FROM(" + 
				"        SELECT" + 
				"            A.*," + 
				"            ROWNUM AS RNUM," + 
				"            COUNT(*) OVER() AS TOTCNT" + 
				"        FROM" + 
				"            (" + 
				"                SELECT" + 
				"                    *" + 
				"                FROM" + 
				"                    board" + 
				"                ORDER BY" + 
				"                    num desc" + 
				"             " + 
				"            ) A" + 
				"    ) where RNUM > ? AND RNUM <= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page*10)-9);
		ps.setInt(2, page*10);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int num=rs.getInt("num");
			String title=rs.getString("title");
			String writer=rs.getString("writer");
			String content=rs.getString("content");
			Date regdate=rs.getDate("regdate");
			int rate=rs.getInt("rate");
			
			Board b = new Board(num,regdate,title,writer,content,rate);
			result.add(b);
		}
		ps.close();
	    con.close();
	    return result;
	}
	
	public Board search(int num) throws SQLException {
		Board n=null;
		Connection con=getConnection();//2
		String sql="Select * from Board where num=?";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, num);
		ResultSet rs=ps.executeQuery();//4
		if(rs.next()) {
			//int num2=rs.getInt(1);
			String writer=rs.getString("writer");
			String title=rs.getString("title");
			String content=rs.getString("content");
			Date regdate = rs.getDate("regdate");
			int rate=rs.getInt("rate");
			n=new Board(num, regdate, title,writer,content,rate);
		}	
		ps.close();
		con.close();
		return n;
	}

	
	public void delete(int num) throws SQLException {
		Connection con=getConnection();//2
		String sql="Delete from Board where num=?";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, num);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public void updateRate(int num) throws SQLException {
		Connection con = getConnection();
		String rateQ = "update board set rate = rate+1 where num = ?";
		PreparedStatement ps = con.prepareStatement(rateQ);
		ps.setInt(1, num);
		
		ps.executeUpdate();	
		
		ps.close();
		con.close();
		
	}
	
	public int getCount() throws SQLException {
		
		Connection con = getConnection();
		String rateQ = "select count(*) from board";
		PreparedStatement ps = con.prepareStatement(rateQ);
		ResultSet rs=ps.executeQuery();//4
		rs.next();
		int count = rs.getInt(1);
				
		ps.close();
		con.close();
		
		return count;
		
	}
	
		
}
