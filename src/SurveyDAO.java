
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SurveyDAO {
	private String dbURL;
	private String dbUsername;
	private String dbPassword;	
	Connection con=null;
	SurveyDAO(String dbURL,String dbUsername,String dbPassword)
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
     
  /* void disconnect() throws SQLException 
   {
       if(con != null  && !con.isClosed()) 
           con.close();
   }*/
   
   /*boolean insertSurveyId(Survey survey) throws SQLException
   {
	   String sql = "INSERT INTO Surveys (SID,AID) VALUES (?,?)";
       connect();
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, survey.getSid());
       ps.setInt(2, survey.getAid());
       boolean rowInserted = ps.executeUpdate() > 0;
       ps.close();
       con.close();
       return rowInserted;
   }*/
   
   int insertSurveyDetails(Survey survey) throws SQLException
   {
	   String sql = "INSERT INTO SURVEYS (AID, SNAME, SNQ, SDOC, SDOM, SNOR) VALUES (?,?,?,?,?,?)";

       connect();
       
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, survey.getAid());
       statement.setString(2, survey.getSname());
       statement.setInt(3, survey.getSnq());
       statement.setString(4, survey.getDoc());
       statement.setString(5, survey.getDom());
       statement.setInt(6, survey.getNor());
       
       
       boolean rowUpdated = statement.executeUpdate() > 0;
       statement.close();
       int sid=0;
       String sql2 ="SELECT * FROM SURVEYS where SID = ( SELECT MAX(SID) FROM SURVEYS)"; 
       Statement statement2 = con.createStatement();
       ResultSet resultSet = statement2.executeQuery(sql2);
       if(resultSet.next()) {
       sid=resultSet.getInt("SID");}
    		   
       con.close();
       return sid;
   }
   
   public List<Survey> listAllSurvey() throws SQLException {
       List<Survey> listSurvey = new ArrayList<>();
        String sql = "SELECT * FROM Surveys";
        connect();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
        	// int Sid=resultSet.getInt("SID");
        	int Aid=resultSet.getInt("AID");
        	String Sname=resultSet.getString("SNAME");
        	int Snq=resultSet.getInt("SNQ");
        	String Doc=resultSet.getString("SDOC");
        	String Dom=resultSet.getString("SDOM");
        	int Nor=resultSet.getInt("SNOR");
            Survey survey = new Survey(Aid, Sname, Snq, Doc, Dom, Nor);
            listSurvey.add(survey); 
       }
        
         resultSet.close();
         statement.close();
         con.close();
         return listSurvey;
    }
        
    boolean deleteSurvey(Survey survey) throws SQLException {
        String sql = "DELETE FROM Surveys where SID= ?";
        connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, survey.getSid());
        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        con.close();
        return rowDeleted;             
   }
   
    public Survey getSurvey(int Sid) throws SQLException {
       Survey survey = null;
       String sql = "SELECT * FROM Surveys WHERE SID= ?";
       connect();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, Sid);
        
       ResultSet resultSet = statement.executeQuery();
        
       if(resultSet.next()) {
       	int Aid=resultSet.getInt("AID");
       	String Sname=resultSet.getString("SNAME");
       	int Snq=resultSet.getInt("SNQ");
       	String Doc=resultSet.getString("SDOC");
       	String Dom=resultSet.getString("SDOM");
       	int Nor=resultSet.getInt("SNOR");
            
        survey= new Survey(Aid, Sname, Snq, Doc, Dom, Nor);
       }
        
       resultSet.close();
       statement.close();
       return survey;
   }

}