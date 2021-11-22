package servlets;

import dao.DaoFactory;
import dao.TicketDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MakeTransactionServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");

        int expense = Integer.parseInt(request.getParameter("expense"));

        TicketDao ticketDao = DaoFactory.getTicketDao();
        ticketDao.addTicket(expense, id);

        RequestDispatcher rd = request.getRequestDispatcher("/maketicket.html");
        rd.include(request, response);
        out.println("Ticket made! It will be looked at soon");
    }
}
