

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDAO adminDAO;
	UsersDAO usersDAO;
	SurveyDAO surveyDAO;
	TakeSurveyDAO takeSurveyDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	usersDAO = new UsersDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	adminDAO = new AdminDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	surveyDAO = new SurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	takeSurveyDAO = new TakeSurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		System.out.println(email + "\t" + pass);
		HttpSession session=request.getSession();  
	         
		try {
			Users u = usersDAO.getUser(email, pass);
			System.out.println(u.getUid());
			
			
			if(u.getUid()!=0) {
				session.setAttribute("s_uid",u.getUid());
				List<Survey> l = takeSurveyDAO.viewGivenSurveys(u);
				request.setAttribute("surveyTaken", l);
				request.setAttribute("s_uid", u.getUid());
				RequestDispatcher dispatcher=request.getRequestDispatcher("UserHome.jsp");
				dispatcher.include(request, response);	
			}
			else {

				AdminBean a = adminDAO.getAdmin(email, pass);
				System.out.println(a.getAid()+"\t" + a.getAemail() + "\t" + a.getApass());
				if(a.getAid()!=0) {
				session.setAttribute("s_aid",a.getAid());
				session.setAttribute("s_aname",a.getAemail());
				List<Survey> l = surveyDAO.listAllSurvey();
				request.setAttribute("listSurvey", l);
				request.setAttribute("myname",(a.getAemail()).substring(0, (a.getAemail()).indexOf("@")));
				RequestDispatcher disp = request.getRequestDispatcher("AdminHome.jsp");
				disp.forward(request, response);
				}
				else {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
					disp.include(request, response);
					out.println("<script type=\"text/javascript\">\r\n" + 
							"        	alert(\"Wrong username or password\");\r\n" + 
							"        </script>    ");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
