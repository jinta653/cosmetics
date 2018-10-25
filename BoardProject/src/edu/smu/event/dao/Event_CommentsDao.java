package edu.smu.event.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.event.vo.Event_Comments;

public class Event_CommentsDao {
	
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
	
	public void comSave(Event_Comments cmt) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into EVENT_reply(event_num, Event_Comments_num, event_contents, event_regdate) values(?,event_reply_seq.nextval, ?, sysdate)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, cmt.getEvent_num());
		ps.setString(2, cmt.getEvent_contents());
		
		ps.executeUpdate();//4
			
		ps.close();
		con.close();
	}
	
	public ArrayList<Event_Comments> search(int num) throws SQLException{
		ArrayList<Event_Comments> result = new ArrayList<Event_Comments>();
		Connection con = getConnection();
		String sql = "select * from EVENT_reply where event_num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int comment_num = rs.getInt("event_Comments_NUM");
			String contents=rs.getString("Event_contents");
			Date regdate=rs.getDate("Event_regdate");
						
			Event_Comments c = new Event_Comments(comment_num, num,contents,regdate);
			result.add(c);
		}
		ps.close();
	    con.close();
	    return result;
	}
	

}
