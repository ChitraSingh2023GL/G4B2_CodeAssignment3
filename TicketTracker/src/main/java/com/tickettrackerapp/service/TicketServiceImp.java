package com.tickettrackerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tickettrackerapp.entity.Ticket;
import com.tickettrackerapp.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {

	@Autowired
	private TicketRepository ticketrepository;

	@Override
	public List<Ticket> findAll() {

		List<Ticket> tickets = ticketrepository.findAll();
		return tickets;
	}

	@Override
	public void save(Ticket theTicket) {
		ticketrepository.save(theTicket);
	}

	@Override
	public Ticket findById(int ticketId) {
		return ticketrepository.findById(ticketId).get();
	}

	@Override
	public void deleteById(int ticketId) {
		ticketrepository.deleteById(ticketId);
	}

	@Override
	public List<Ticket> findByTilte(String keyword) {

		List<Ticket> tickets = ticketrepository.findByKeyword(keyword);
		return tickets;
	}
}
