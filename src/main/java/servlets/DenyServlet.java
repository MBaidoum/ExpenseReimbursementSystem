package servlets;

import dao.DaoFactory;
import dao.TicketDao;
import entities.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DenyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int ticketId = Integer.parseInt(request.getParameter("ticketId"));

        TicketDao ticketDao = DaoFactory.getTicketDao();
        Ticket ticket = ticketDao.getTicketById(ticketId);
        ticketDao.updateTicket("denied", ticket);

        RequestDispatcher rd = request.getRequestDispatcher("view");
        rd.forward(request, response);
        out.println("<p>Ticket approved</p>");
    }
}
