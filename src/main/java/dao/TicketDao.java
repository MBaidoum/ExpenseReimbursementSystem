package dao;

import entities.Ticket;

import java.util.List;

public interface TicketDao {

    public void addTicket(int expense, int id);

    public void updateTicket(String status, Ticket ticket);

    public List<Ticket> getTickets();

    public List<Ticket> getTicketsByEmployee(int id);

    public List<Ticket> getTicketsByStatus(String status);

    public Ticket getTicketById(int id);
}
