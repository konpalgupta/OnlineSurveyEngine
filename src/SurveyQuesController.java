

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SurveyQuesController
 */
@WebServlet("/SurveyQuesController")
public class SurveyQuesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SurveyDAO surveyDAO;
    QuestionDAO quesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyQuesController() {
        super();
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	surveyDAO = new SurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
    	quesDAO = new QuestionDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getServletPath();

		System.out.println(action);
		try 
		{
			switch(action) 
			{
			case "/createSurvey":
				SurveyDetails(request, response);
				break;
			case "/addQuestion":
				System.out.println("Inside switch");
				QuestionDetails(request,response);
				break;
			case "/saveSurvey":
				System.out.println("Inside switch");
				saveSurveycreated(request,response);
				break;
			}			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SurveyDetails(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException,ServletException
			{
			HttpSession session=request.getSession(false);  
	        int s_aid=(int)session.getAttribute("s_aid");
	        String s_aname=(String)session.getAttribute("s_aname");
	        String survey_name=request.getParameter("survey_name");
	        if(survey_name!="")
	        {
	        	Date date1 = new Date();
	        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        	String date= formatter.format(date1);
	        Survey survey= new Survey(s_aid,survey_name,0,date,date,0);
	        int sid = surveyDAO.insertSurveyDetails(survey);
	        System.out.println("Survey id created ="+sid);
	        request.setAttribute("myname",(s_aname).substring(0, (s_aname).indexOf("@")));
	        request.setAttribute("display", "Good to Go! Enter questions into Survey: "+survey_name);
	        request.setAttribute("jsp_sid", sid);
	        RequestDispatcher dispatcher=request.getRequestDispatcher("CreateSurvey.jsp");
			dispatcher.include(request, response);
	        }
	        else
	        {   request.setAttribute("display", "Enter a valid survey name");
	        	RequestDispatcher dispatcher=request.getRequestDispatcher("CreateSurvey.jsp");
			    dispatcher.forward(request,response);
	        }
			}
	public void QuestionDetails(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session=request.getSession(false);  
        int s_aid=(int)session.getAttribute("s_aid");
        String s_aname=(String)session.getAttribute("s_aname");
		int sid=Integer.parseInt(request.getParameter("sid"));
		System.out.println(sid);
		String ques_stmt=request.getParameter("ques_stmt");
		System.out.println(ques_stmt);
		String type = request.getParameter("r1");
		String options = request.getParameter("options");
		String ans=request.getParameter("ans");
		System.out.println("Hello");
		if(ques_stmt!="")
        {
        Questions ques= new Questions(sid,ques_stmt, type,options,ans);
        boolean r = quesDAO.insertQuestion(ques);
        System.out.println("output="+r);
        List<Questions> list_questions = quesDAO.listSurveyQuestions(sid);
        request.setAttribute("s_aid",s_aid);
        request.setAttribute("myname",(s_aname).substring(0, (s_aname).indexOf("@")));
        request.setAttribute("list_questions", list_questions);
        request.setAttribute("jsp_sid", sid);request.setAttribute("jsp_sid", sid);
        RequestDispatcher dispatcher=request.getRequestDispatcher("CreateSurvey.jsp");
		dispatcher.forward(request, response);
        }
	}
	
	public void saveSurveycreated(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session=request.getSession(false);  
        int s_aid=(int)session.getAttribute("s_aid");
        String s_aname=(String)session.getAttribute("s_aname");
        List<Survey> l = surveyDAO.listAllSurvey();
		request.setAttribute("listSurvey", l);
		request.setAttribute("s_aid",s_aid);
		request.setAttribute("myname",(s_aname).substring(0, (s_aname).indexOf("@")));
		RequestDispatcher disp = request.getRequestDispatcher("AdminHome.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
