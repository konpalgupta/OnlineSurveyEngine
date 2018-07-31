import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakeSurveyDAO {
	private String dbURL;
	private String dbUsername;
	private String dbPassword;	
	Connection con=null;
	public TakeSurveyDAO(String dbURL, String dbUsername, String dbPassword) {
		this.dbURL = dbURL;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	void connect() throws SQLException{
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
	
	boolean addResponse(int userid, int sid, int qid, String ures) throws SQLException {
		boolean state = false;
		String sql = "insert into take_survey values ?,?,?,?,?,?,?,?,?";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		PreparedStatement statement = con.prepareStatement("select sname, qstmt, qans from surveys, questions where surveys.sid = questions.sid and questions.qid = ?");
		statement.setInt(1, qid);
		ResultSet rs = null;
		rs = statement.executeQuery();
		if(rs.next()) {
			ps.setInt(1, rs.getInt(1));
			ps.setInt(2, userid);
			ps.setInt(3, qid);
			ps.setString(4, rs.getString(1));
			ps.setString(7, rs.getString(2));
			ps.setString(8, rs.getString(3));
		}
		statement = con.prepareStatement("select ufname, ulname from users where userid = ?");
		statement.setInt(1, userid);
		rs = statement.executeQuery();
		if(rs.next()) {
			ps.setString(5, rs.getString(1));
			ps.setString(6, rs.getString(2));
		}
		ps.setString(9, ures);
		state = ps.executeUpdate()>0;
		return state;
	}
	
	List<Survey> viewGivenSurveys(Users u) throws SQLException{
		String sql = "select sid, sname from take_survey where userid = ?";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getUid());
		ResultSet rs = ps.executeQuery();
		List<Survey> l = new ArrayList<>();
		while(rs.next()) {
			Survey s = new Survey();
			s.setSID(rs.getInt(1));
			s.setSname(rs.getString(2));
			l.add(s);
		}
		return l;		
	}
	
	List<Survey> viewNotTakenSurveys(Users u) throws SQLException{
		String sql = "select sid, sname from surveys where sid NOT IN (select sid from take_survey where userid = ?)";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getUid());
		ResultSet rs = ps.executeQuery();
		List<Survey> l = new ArrayList<>();
		while(rs.next()) {
			Survey s = new Survey();
			s.setSID(rs.getInt(1));
			s.setSname(rs.getString(2));
			l.add(s);
		}
		return l;		
	}

}
