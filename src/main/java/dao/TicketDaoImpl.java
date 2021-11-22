package dao;

import entities.Ticket;
import misc.ConfigurationFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TicketDaoImpl implements TicketDao {

    //Adds a ticket to the database with the passed expense and employeeId
    //New tickets are always pending
    @Override
    public void addTicket(int expense, int id){
        Session session = ConfigurationFactory.getSession();
        Transaction t = session.beginTransaction();

        Ticket ticket = new Ticket();
        ticket.setExpense(expense);
        ticket.setEmployeeId(id);
        ticket.setStatus("pending");

        session.save(ticket);
        t.commit();
        session.close();
    }

    //Updates the status of a ticket
    @Override
    public void updateTicket(String status, Ticket ticket){
        Session session = ConfigurationFactory.getSession();
        Transaction t = session.beginTransaction();

        ticket.setStatus(status);

        session.update(ticket);
        t.commit();
        session.close();
    }

    //Retrieves all tickets
    @Override
    public List<Ticket> getTickets() {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM Ticket";
        Query query = session.createQuery(hql);

        return query.list();
    }

    //Retrieves all tickets according to the employee who made it
    @Override
    public List<Ticket> getTicketsByEmployee(int id) {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM Ticket t WHERE t.employeeId = :employeeId";
        Query query = session.createQuery(hql);
        query.setParameter("employeeId", id);
        return query.list();
    }

    //Retrieves all tickets of a certain status
    @Override
    public List<Ticket> getTicketsByStatus(String status) {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM Ticket t WHERE t.status = :status";
        Query query = session.createQuery(hql);
        query.setParameter("status", status);
        return query.list();
    }

    public Ticket getTicketById(int id) {
        Session session = ConfigurationFactory.getSession();

        String hql = "FROM Ticket t WHERE t.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        List results = query.list();

        if(results.isEmpty()){
            return null;
        }

        Ticket ticket = (Ticket) results.get(0);
        return ticket;
    }
}
