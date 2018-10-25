package edu.smu.tips.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.tips.vo.Tips;

public class TipsDao {
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
	
	public void save(Tips t) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into Tips(tip_num,tip_title, tip_writer, tip_content, tip_regdate, tip_kind) "
				+ "values(Tips_SEQ.nextval,?,?,?,sysdate,?)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setString(1, t.getTips_title());
		ps.setString(2, t.getTips_writer());
		ps.setString(3, t.getTips_content());
		ps.setString(4, t.getTips_kind());
		
		ps.executeUpdate();//4
		
		ps.close();
		con.close();
	}
	
	public ArrayList<Tips> list(int page) throws SQLException{
		ArrayList<Tips> t_result = new ArrayList<Tips>();
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
				"                    tips" + 
				"                ORDER BY" + 
				"                    tip_num desc" + 
				"             " + 
				"            ) A" + 
				"    ) where RNUM > ? AND RNUM <= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page*10)-9);
		ps.setInt(2, page*10);
		ResultSet t_rs = ps.executeQuery();
		while(t_rs.next()) {
			int num=t_rs.getInt("tip_num");
			String kind=t_rs.getString("tip_kind");
			String title=t_rs.getString("tip_title");
			String writer=t_rs.getString("tip_writer");
			String content=t_rs.getString("tip_content");
			Date regdate=t_rs.getDate("tip_regdate");
			int rate=t_rs.getInt("tip_rate");
			
			Tips t = new Tips(num,kind,title,writer,content,regdate,rate);
			t_result.add(t);
		}
		ps.close();
	    con.close();
	    return t_result;
	}
	
	public Tips search(int tips_num) throws SQLException {
		Tips t=null;
		Connection con=getConnection();//2
		String sql="Select * from Tips where tip_num=?";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, tips_num);
		ResultSet rs=ps.executeQuery();//4
		if(rs.next()) {
			//int num2=rs.getInt(1);
			String kind=rs.getString("tip_kind");
			String writer=rs.getString("tip_writer");
			String title=rs.getString("tip_title");
			String content=rs.getString("tip_content");
			Date regdate = rs.getDate("tip_regdate");
			int rate=rs.getInt("tip_rate");
			t=new Tips(tips_num,kind,title,writer,content,regdate,rate);
		}	
		ps.close();
		con.close();
		return t;
	}
	
	public void tips_updateRate(int num) throws SQLException {
		Connection con = getConnection();
		String rateQ = "update Tips set tip_rate = tip_rate+1 where tip_num = ?";
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
