
public class AdminBean {

	private int aid;
	private String aemail;
	private String apass;
	
	
	public AdminBean() {
		aid = 0;
		aemail="";
		apass="";
	}
	
	public AdminBean(int aid, String aemail, String apass) {
		super();
		this.aid = aid;
		this.aemail = aemail;
		this.apass = apass;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	
	
	
}
