package com.tickettrackerapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tickettrackerapp.entity.Ticket;
import com.tickettrackerapp.service.TicketService;

@Controller
@RequestMapping("/tickets")

public class TicketController {

	@Autowired
	private TicketService ticketservice;

	@GetMapping("/view")
	public String listTickets(@RequestParam("ticketId") int ticketId, Model model) {
		// get all tickets
		Ticket theTicket = ticketservice.findById(ticketId);

		model.addAttribute("ticket", theTicket);
		return "tickets/view_tickets";
	}

	@GetMapping("/showFromForAddTicket")
	public String showFromForAdd(Model model) {
		// Add new ticket
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "tickets/ticket_form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFromForUpdate(@RequestParam("ticketId") int ticketId, Model model) {

		// get the ticket from the database
		Ticket theTicket = ticketservice.findById(ticketId);
		model.addAttribute("ticket", theTicket);
		return "tickets/edit_form";

	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {
		ticketservice.save(theTicket);
		return "redirect:/tickets/list";

	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int ticketId) {
		// delete the ticket
		ticketservice.deleteById(ticketId);
		return "redirect:/tickets/list";

	}

	@RequestMapping(path = { "/list", "/search" })
	public String search(@RequestParam(name = "keyword", required = false) String keyword, Ticket Ticket, Model model) {
		if (keyword != null) {
			List<Ticket> tempTicket1 = ticketservice.findByTilte(keyword);
			model.addAttribute("tickets", tempTicket1);
		} else {
			List<Ticket> tempTicket = ticketservice.findAll();
			model.addAttribute("tickets", tempTicket);
		}
		return "tickets/list_tickets";

	}

}
