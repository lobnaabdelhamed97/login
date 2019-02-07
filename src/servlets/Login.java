package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.UserImplementation;
import connections.UserInterface;
import connections.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "/Login" , urlPatterns={"/home"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email" );
		String password = request.getParameter("password" );
		
		UserInterface uu = new UserImplementation();
	
		//object from userinterface to deal with user implementation
		Users u = uu.getUsers(email, password);
	if(u==null)
	{	request.setAttribute("message", "data is not found go to register");
	request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	else
	{
		request.setAttribute("message", u.getUsername());
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}
	}

}
