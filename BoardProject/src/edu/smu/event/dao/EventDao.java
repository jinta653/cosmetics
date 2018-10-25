package edu.smu.event.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.event.vo.Event;


public class EventDao {
   
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
   
   public void save(Event b) throws SQLException {
      Connection con=getConnection();//2
      String sql="Insert into Event(num, title, img_filename, content, regdate, event_start, event_end) "
            + "values(Event_SEQ.nextval,?,?,?,sysdate,?,?)";
      PreparedStatement ps=con.prepareStatement(sql);//3
      ps.setString(1, b.getTitle());
      ps.setString(2, b.getImg_filename());
      ps.setString(3, b.getContent());
      ps.setString(4, b.getEvent_start());
      ps.setString(5, b.getEvent_end());
      
      ps.executeUpdate();//4
      
      ps.close();
      con.close();
   }
   public ArrayList<Event> search() throws SQLException{
      ArrayList<Event> result = new ArrayList<Event>();
      Connection con = getConnection();
      String sql = "select num, title, img_filename, content, regdate, to_char(event_start,'YYYY-MM-DD') event_start,to_char(event_end,'YYYY-MM-DD')  event_end from event ORDER by num desc";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
         int num=rs.getInt("num");
         String title=rs.getString("title");
         String img_filename=rs.getString("img_filename");
         String content=rs.getString("content");
         Date regdate=rs.getDate("regdate");
         String event_start=rs.getString("event_start");
         String event_end=rs.getString("event_end");
         
         Event b = new Event(num,regdate,title,img_filename,content,event_start,event_end);
         result.add(b);
      }
      ps.close();
       con.close();
       return result;
   }
   
   public Event search(int num) throws SQLException {
      Event n=null;
      Connection con=getConnection();//2
      String sql="Select * from Event where num=?";
      PreparedStatement ps=con.prepareStatement(sql);//3
      ps.setInt(1, num);
      ResultSet rs=ps.executeQuery();//4
      if(rs.next()) {
         //int num2=rs.getInt(1);
         String img_filename=rs.getString("img_filename");
         String title=rs.getString("title");
         String content=rs.getString("content");
         Date regdate = rs.getDate("regdate");
         String event_start=rs.getString("event_start");
         String event_end=rs.getString("event_end");
         
         n = new Event(num,regdate,title,img_filename,content,event_start,event_end);
         
         
      }   
      ps.close();
      con.close();
      return n;
   }

   
   public void delete(int num) throws SQLException {
      Connection con=getConnection();//2
      String sql="Delete from Event where num=?";
      PreparedStatement ps=con.prepareStatement(sql);//3
      ps.setInt(1, num);
      ps.executeUpdate();
      ps.close();
      con.close();
   }
   
}
