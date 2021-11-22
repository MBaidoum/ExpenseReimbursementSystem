package servlets;

import dao.DaoFactory;
import dao.UserDao;
import entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ValidateServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.checkUser(username, password);


        if(user == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.include(request, response);
            out.println("<p>Sorry, invalid username or password </p>");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("type", user.getUserType());
            RequestDispatcher rd;
            if(user.getUserType().equals("employee")) {
                rd = request.getRequestDispatcher("/employeewelcome.html");
            } else {
                rd = request.getRequestDispatcher("/managerwelcome.html");
            }
            rd.forward(request, response);
        }

    }
}
