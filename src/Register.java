

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO usersDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	usersDAO = new UsersDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		char g = ' ';
		if(gender.equals("Male"))
			g = 'M';
		else if(gender.equals("Female"))
			g = 'F';
		Users u = new Users(fname,lname,email,pass,dob,g,city);
		try {
			System.out.println(usersDAO.registerUser(u));
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
