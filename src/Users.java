
public class Users {
	
	private String ufname, ulname, uemail, upass, udob;
	private char ugender;
	private String ucity;
	private int uid;
	
	Users(){
		uid = 0;
	}
	
	
	
	
	public Users(int uid, String ufname, String ulname, String uemail, String upass, String udob, char ugender, String ucity) {
		this.uid = uid;
		this.ufname = ufname;
		this.ulname = ulname;
		this.uemail = uemail;
		this.upass = upass;
		this.udob = udob;
		this.ugender = ugender;
		this.ucity = ucity;
	}

	public Users( String ufname, String ulname, String uemail, String upass, String udob, char ugender, String ucity) {
		
		this.ufname = ufname;
		this.ulname = ulname;
		this.uemail = uemail;
		this.upass = upass;
		this.udob = udob;
		this.ugender = ugender;
		this.ucity = ucity;
	}


	public int getUid() {
		return uid;
	}
	public void setUid(int id) {
		this.uid = uid;
	}
	public String getUfname() {
		return ufname;
	}
	public void setUfname(String ufname) {
		this.ufname = ufname;
	}
	public String getUlname() {
		return ulname;
	}
	public void setUlname(String ulname) {
		this.ulname = ulname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUdob() {
		return udob;
	}
	public void setUdob(String udob) {
		this.udob = udob;
	}
	public char getUgender() {
		return ugender;
	}
	public void setUgender(char ugender) {
		this.ugender = ugender;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
}
