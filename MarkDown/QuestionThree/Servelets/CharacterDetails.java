package Servelets;




import Tasks.BooksTask;
import Tasks.CharacterTask;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by faima on 4/11/17.
 */
@WebServlet("/employees")
public class CharacterDetails extends HttpServlet {
    @EJB
    BooksTask bookTask;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("BooksTask", bookTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBooks.jsp");
        dispatcher.forward(request, response);
    }
}
