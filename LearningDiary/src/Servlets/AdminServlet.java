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
import javax.sql.DataSource;

import Domain.Books;
import Managers.BooksManager;

@WebServlet({ "/AdminServlet", "/admin" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Resource (name="jdbc/MyDB")
   DataSource ds;
   
    public AdminServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/userbooks.jsp";
		ArrayList<Books> userListsOfBooks = null;
		BooksManager bm = new BooksManager(ds);
		int user_id = new Integer(request.getParameter("user_id"));
		try {
			userListsOfBooks = bm.getBooksByUserID(user_id);
			System.out.println(userListsOfBooks);
			request.setAttribute("userBooks", userListsOfBooks);
			/*request.getRequestDispatcher("/WEB-INF/userbooks.jsp").forward(request, response);
			return;*/
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/WEB-INF/dberror.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
