package misc;

import dao.DaoFactory;
import dao.TicketDao;
import dao.UserDao;
import entities.Ticket;
import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InitializeDB {

    public static void main(String[] args) {

        UserDao userDao = DaoFactory.getUserDao();
        TicketDao ticketDao = DaoFactory.getTicketDao();
        //listUsers(userDao);
        //Ticket ticket = new Ticket(17, 350, 13, "pending");
        //ticketDao.updateTicket("approved", ticket);
        addTicket(ticketDao, 100, 10);
        listTickets(ticketDao);

    }

    public static void addUser() {
        Session session = ConfigurationFactory.getSession();

        Transaction t = session.beginTransaction();

        User user = new User();
        user.setUsername("Secretary");
        user.setPassword("Pudding");
        user.setUserType("manager");

        session.save(user);

        t.commit();

        session.close();
    }

    public static void listUsers(UserDao userDao){
        List<User> users = userDao.getUsersByType("employee");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUsername() + " with id " + users.get(i).getId());
        }
    }

    public static void addTicket(TicketDao ticketDao, int ex, int id) {
        ticketDao.addTicket(ex, id);
    }

    public static void listTickets(TicketDao ticketDao){
        List<Ticket> tickets = ticketDao.getTickets();
        for(int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).getExpense() + " with id " + tickets.get(i).getId() + " and employeeID " +
                    tickets.get(i).getEmployeeId());
        }
    }
}
