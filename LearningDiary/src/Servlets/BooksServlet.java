package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Domain.Books;
import Domain.Category;
import Managers.BooksManager;
import Managers.CategoryManager;

@WebServlet({ "/BooksServlet", "/books" })
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    public BooksServlet() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/viewbooks.jsp";
		
		BooksManager bm = new BooksManager(ds);
	
		ArrayList<Books> theBooks = null;// order books by id
		String booksByOrder; // order books by name in alphabetical  
	
		HttpSession session = request.getSession();
		Boolean loggedInBoolean = (Boolean) session.getAttribute("isLoggedIn");
		
		if(loggedInBoolean != null) {
			boolean loggedIn = loggedInBoolean.booleanValue();
			if(loggedIn) {
				int user_id = (Integer) session.getAttribute("user_id");
				
				try {
					
					booksByOrder = request.getParameter("order");
					if(booksByOrder != null && booksByOrder.equals("name"))
					{
						theBooks = bm.getBooksOrderByName(user_id);
						System.out.println(theBooks);
					} else {
						theBooks = bm.getBooks(user_id);
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
					getServletContext().getRequestDispatcher(url).forward(request, response);
					
				}
			}
		}
		
		request.setAttribute("booksList", theBooks);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
}
