

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	
	AdminDAO adminDAO;
	UsersDAO usersDAO;
	TakeSurveyDAO takeSurveyDAO;
	SurveyDAO surveyDAO;
	QuestionDAO questionsDAO;
	
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	adminDAO = new AdminDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	usersDAO = new UsersDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	takeSurveyDAO = new TakeSurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	surveyDAO = new SurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	questionsDAO = new QuestionDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		try {
			switch(action) {
			case "/newSurvey":
				showNewSurveys(request,response);
				break;
			case "/deleteSurvey":
				deleteSurvey(request,response);
				break;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void showNewSurveys(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("id"));
		Users u = usersDAO.getUser(uid);
		List<Survey> l = takeSurveyDAO.viewNotTakenSurveys(u);
		request.setAttribute("surveyNotTaken", l);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TakeNewSurvey.jsp");
		dispatcher.forward(request, response);
	}
	private void deleteSurvey(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Survey s = new Survey();
		s.setSID(Integer.parseInt(request.getParameter("id")));
		surveyDAO.deleteSurvey(s);
		response.sendRedirect("AdminHome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
