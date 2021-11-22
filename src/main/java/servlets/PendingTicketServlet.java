package servlets;

import dao.DaoFactory;
import dao.TicketDao;
import entities.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PendingTicketServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String userType = (String)session.getAttribute("type");

        TicketDao ticketDao = DaoFactory.getTicketDao();
        List<Ticket> tickets;
        RequestDispatcher rd;
        if(userType.equals("employee")) {
            int id = (int) session.getAttribute("id");
            tickets = ticketDao.getTicketsByEmployee(id);
            rd = request.getRequestDispatcher("/employeetable.jsp");
        } else {
            tickets = ticketDao.getTickets();
            rd = request.getRequestDispatcher("/managertable.jsp");
        }

        session = request.getSession();
        session.setAttribute("tickets", tickets);
        rd.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String userType = (String)session.getAttribute("type");

        TicketDao ticketDao = DaoFactory.getTicketDao();
        List<Ticket> tickets;
        RequestDispatcher rd;
        if(userType.equals("employee")) {
            int id = (int) session.getAttribute("id");
            tickets = ticketDao.getTicketsByEmployee(id);
            rd = request.getRequestDispatcher("/employeetable.jsp");
        } else {
            tickets = ticketDao.getTickets();
            rd = request.getRequestDispatcher("/managertable.jsp");
        }

        session = request.getSession();
        session.setAttribute("tickets", tickets);
        rd.include(request, response);
    }
}
