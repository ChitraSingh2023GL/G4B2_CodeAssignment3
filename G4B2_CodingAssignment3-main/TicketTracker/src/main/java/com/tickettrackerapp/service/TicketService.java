package com.tickettrackerapp.service;

import java.util.List;

import com.tickettrackerapp.entity.Ticket;

public interface TicketService {
	public List<Ticket> findAll();
	
	public void save(Ticket theTicket);

	public Ticket findById(int ticketId);

	public void deleteById(int ticketId);

	public List<Ticket> findByTilte(String subject);
}
