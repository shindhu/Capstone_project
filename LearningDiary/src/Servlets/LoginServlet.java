package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Domain.Users;
import Managers.UsersManager;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    public LoginServlet() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/WEB-INF/login.jsp";
		String action = request.getParameter("action");
		UsersManager um = new UsersManager(ds);
		ArrayList<Users> usersList = null;
		
		if(action == null) {
			url = "/WEB-INF/login.jsp";
		}
	
		if(("login").equalsIgnoreCase(action)) {
			
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Users theFoundUser = null;
			try {
				theFoundUser = new UsersManager(ds).findUserWithNameAndPassword(username, password);
				
			} catch (SQLException e) {
				url = "/dberror.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			// if found the user's username and password set the user on the request and forward to the main page
			// else send them back to the login page.
			
			if(theFoundUser != null) {
				if (username == "admin" && password == "admin") {
					try {
						usersList = um.getUsers();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(usersList);
				} 
			
				request.setAttribute("user", theFoundUser);
				
				HttpSession session = request.getSession();
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("capName", theFoundUser.getCapitalizedUsername());
				session.setAttribute("user_id", theFoundUser.getId());
				
				request.setAttribute("email", theFoundUser.getEmail());
				
				url = "/WEB-INF/category.jsp";
				response.sendRedirect("/LearningDiary/category?user_id="+theFoundUser.getId());
				return;
			
			} else {
				request.setAttribute("error", "The username or password was incorrect! ");
				url = "/WEB-INF/login.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}

