
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AdminDAO {

	private String dbURL;
	private String dbUsername;
	private String dbPassword;	
	Connection con=null;
	public AdminDAO(String dbURL, String dbUsername, String dbPassword) {
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
	
	boolean insert(AdminBean ab) throws SQLException
	{
		connect();
		PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?)");
		ps.setInt(1, ab.getAid());
		ps.setString(2, ab.getAemail());
		ps.setString(3, ab.getApass());
		boolean ans=ps.executeUpdate()>0;
		ps.close();
		con.close();
		return ans;
	}
	
	boolean delete(AdminBean ab) throws SQLException
	{
		connect();
		PreparedStatement ps=con.prepareStatement("delete from admin where id=?");
		ps.setInt(1, ab.getAid());
		boolean ans=ps.executeUpdate()>0;
		ps.close();
		con.close();
		return ans;
	}
	
	
	boolean update(AdminBean ab) throws SQLException
	{
		connect();
		PreparedStatement ps=con.prepareStatement("update admin set aemail=? apass where aid=?");
		ps.setString(1, ab.getAemail());
		ps.setString(2, ab.getApass());
		ps.setInt(3, ab.getAid());
		boolean ans=ps.executeUpdate()>0;
		ps.close();
		con.close();
		return ans;
	}
	
	public List<AdminBean> listAdmin(AdminBean ab) throws SQLException
	{
		connect();
		List<AdminBean> list=new ArrayList<>();
		 Statement statement = con.createStatement();
	       ResultSet rs = statement.executeQuery("select * from admin");
		while(rs.next())
		{
			int aid=rs.getInt("aid");
			String aemail=rs.getString("aemail");
			String apass=rs.getString("apass");
			AdminBean admin=new AdminBean(aid,aemail,apass);
			list.add(admin);
		}
		return list;
		
	}
	
	public AdminBean getAdmin(String email, String pass) throws SQLException {
		
		connect();
		AdminBean a=new AdminBean();
		
		PreparedStatement ps = con.prepareStatement("select aid, aemail, apass from admin where aemail = ? and apass = ?");
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		/*boolean state=rs.next();
		System.out.println(state + " " + rs.getInt(1) + rs.getString(2) + rs.getString(3));*/
		if(rs.next()) {
			a.setAid(rs.getInt(1));
			a.setAemail(rs.getString(2));
			a.setApass(rs.getString(3));
			return a;
		}
		else {
			
			return a;
		}
	
			
	}
}
