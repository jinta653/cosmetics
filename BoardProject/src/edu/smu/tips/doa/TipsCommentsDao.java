package edu.smu.tips.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.tips.vo.TipsComments;

public class TipsCommentsDao {
	
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
	
	public void tips_comSave(TipsComments cmt) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into Tips_reply(tips_num, tips_comments_num, tips_contents, tips_regdate) values(?,tips_reply_seq.nextval, ?, sysdate)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, cmt.getTips_num());
		ps.setString(2, cmt.getTips_contents());
		
		int count = ps.executeUpdate();//4
		
		System.out.println(count);
		
		ps.close();
		con.close();
	}
	
	public ArrayList<TipsComments> tips_search(int num) throws SQLException{
		ArrayList<TipsComments> result = new ArrayList<TipsComments>();
		Connection con = getConnection();
		String sql = "select * from Tips_reply where tips_num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int comment_num = rs.getInt("tips_COMMENTS_NUM");
			String contents=rs.getString("tips_contents");
			Date regdate=rs.getDate("tips_regdate");
						
			TipsComments tc = new TipsComments(comment_num, num,contents,regdate);
			result.add(tc);
		}
		ps.close();
	    con.close();
	    return result;
	}
	


}
