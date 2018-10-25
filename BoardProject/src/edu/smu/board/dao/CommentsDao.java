package edu.smu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.board.vo.Comments;

public class CommentsDao {
	
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
	
	public void comSave(Comments cmt) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into board_reply(num, comments_num, contents, regdate, userid) values(?,reply_seq.nextval, ?, sysdate, ?)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, cmt.getNum());
		ps.setString(2, cmt.getContents());
		ps.setString(3, cmt.getUserid());
		
		ps.executeUpdate();//4
		
		ps.close();
		con.close();
	}
	
	public ArrayList<Comments> search(int num) throws SQLException{
		ArrayList<Comments> result = new ArrayList<Comments>();
		Connection con = getConnection();
		String sql = "select * from board_reply where num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int comment_num = rs.getInt("COMMENTS_NUM");
			String contents=rs.getString("contents");
			String userid=rs.getString("userid");
			Date regdate=rs.getDate("regdate");
						
			Comments c = new Comments(comment_num, num,userid,contents,regdate);
			result.add(c);
		}
		ps.close();
	    con.close();
	    return result;
	}
	

}
