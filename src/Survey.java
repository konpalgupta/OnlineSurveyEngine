

public class Survey {
	protected int Sid;
	protected int Aid;
	protected String Sname;
	protected int Snq;
	protected String Doc;
	protected String Dom;
	protected int Nor;
	
	public Survey() {
		
	}
	
	
	public Survey(int aid, String sname, int snq, String doc, String dom, int nor) {
		super();
		Aid = aid;
		Sname = sname;
		Snq = snq;
		Doc = doc;
		Dom = dom;
		Nor = nor;
	}


	public int getSid() {
		return Sid;
	}
	public void setSID(int sID) {
		Sid = sID;
	}
	public int getAid() {
		return Aid;
	}
	public void setAID(int aID) {
		Aid = aID;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSnq() {
		return Snq;
	}
	public void setSnq(int snq) {
		Snq = snq;
	}
	public String getDoc() {
		return Doc;
	}
	public void setDoc(String doc) {
		Doc = doc;
	}
	public String getDom() {
		return Dom;
	}
	public void setDom(String dom) {
		Dom = dom;
	}
	public int getNor() {
		return Nor;
	}
	public void setNor(int nor) {
		Nor = nor;
	}

}
