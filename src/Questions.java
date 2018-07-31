
public class Questions {
 int Sid;
 String Qstmt;
 String Qtype;
 String Qoptions;
 String Qans;
		
		public Questions() {
			
		}
		
		public Questions( int sid,String qstmt,String qtype,String qoptions,String qans)
		{
			this.Sid=sid;
			this.Qstmt=qstmt;
			this.Qtype=qtype;
			this.Qoptions=qoptions;
			this.Qans=qans;
		}

		public int getsid() {
			return Sid;
		}

		public void setsid(int sid) {
			Sid = sid;
		}

		public String getqstmt() {
			return Qstmt;
		}
		

		public void setqstmt(String qstmt) {
			Qstmt = qstmt;
		}

		public String getqtype() {
			return Qtype;
		}
		
		public void setqtype(String qtype) {
			Qtype = qtype;
		}
		public String getqoptions() {
			return Qoptions;
		}
		public void setqoptions(String qoptions) {
			Qoptions = qoptions;
		}

		public String getqans() {
			return Qans;
		}
		public void setqans(String qans) {
			Qans = qans;
		}
		
	}