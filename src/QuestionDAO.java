

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionDAO {
		private String dbURL;
		private String dbUsername;
		private String dbPassword;	
		Connection con=null;
		QuestionDAO(String dbURL,String dbUsername,String dbPassword)
		{
			this.dbURL=dbURL;
			this.dbUsername=dbUsername;
			this.dbPassword=dbPassword;
			
		}
	   void connect() throws SQLException
	   {
	        if(con == null|| con.isClosed()) 
	        {
	            try
	            {
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	            } 
	            catch(ClassNotFoundException e) 
	            {
	                throw new SQLException(e);
	            }
	            
	            con = DriverManager.getConnection(dbURL, dbUsername,dbPassword);
	        }	
	   }
	   
	   boolean insertQuestion(Questions que) throws SQLException 
	   {
	       String sql = "INSERT INTO questions(sid,qstmt,qtype,qoptions,qans)VALUES (?,?,?,?,?)";
	       connect();
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setInt(1,que.getsid());
	       ps.setString(2,que.getqstmt());
	       ps.setString(3,que.getqtype());
	       ps.setString(4,que.getqoptions());
	       ps.setString(5,que.getqans());
	       boolean rowInserted = ps.executeUpdate() > 0;
	       ps.close();
	       con.close();
	       return rowInserted;
	   }
	   
	   public boolean deleteQuestion(Questions que) throws SQLException {
	       String sql = "DELETE FROM questions where (sid,qstmt)= (?,?)";
	       connect();
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setInt(1, que.getsid());
	       ps.setString(2, que.getqstmt());
	       boolean rowDeleted = ps.executeUpdate() > 0;
	       ps.close();
	       con.close();
	       return rowDeleted;     
	   }
	    
	   
/*	   public boolean updateQuestion(Questions que) throws SQLException {
		String sql = "UPDATE questions SET qstmt =?, qtype =?, qoptions =?,qans=?";
		sql += " WHERE (sid = ?) AND (qid=?)";
		connect();
		          
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, que.getqstmt());
		statement.setString(2, que.getqtype());
		statement.setString(3, que.getqoptions());
		statement.setString(4, que.getqans());
		statement.setInt(5, que.getsid());
		statement.setInt(5, que.getqid());
	        boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		con.close();
		return rowUpdated;     
	   }*/
	   
	   public  List<Questions> listAllquestions() throws SQLException {
	        List<Questions> list_question = new ArrayList<>();
	        String sql = "SELECT * FROM questions";
	        connect();
	        Statement statement = con.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        while(resultSet.next()) {
	           int sid = resultSet.getInt("sid");
	           String qstmt = resultSet.getString("qstmt");
	           String  qtype= resultSet.getString("qtype");
	           String qoptions = resultSet.getString("qoptions");
	           String qans = resultSet.getString("qans");
	           Questions que = new Questions(sid,qstmt, qtype,qoptions,qans);
	           list_question.add(que); 
	       }
	        
	       resultSet.close();
	       statement.close();
	       con.close();
	       return list_question;
	   }
	   
	   public  List<Questions> listSurveyQuestions(int sid) throws SQLException {
	        List<Questions> list_question = new ArrayList<>();
	        String sql = "SELECT * FROM QUESTIONS WHERE SID = ?";
	        connect();
	        PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, sid);
			System.out.println("inside dao");
	        ResultSet resultSet = statement.executeQuery();
	        System.out.println("inside dao");
	        while(resultSet.next()) {
	           String qstmt = resultSet.getString("qstmt");
	           String  qtype= resultSet.getString("qtype");
	           String qoptions = resultSet.getString("qoptions");
	           String qans = resultSet.getString("qans");
	           Questions que = new Questions(sid,qstmt, qtype,qoptions,qans);
	           list_question.add(que); 
	       }
	        
	       resultSet.close();
	       statement.close();
	       con.close();
	       return list_question;
	   }


	}
