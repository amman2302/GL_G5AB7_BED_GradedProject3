package com.glearning.tta.service;

import java.util.List;

 

import com.glearning.tta.entity.Ticket;


public interface  TTAService {

		List<Ticket> getAllTickets();
	
		Ticket saveTicket(Ticket objTicket);
	
		Ticket getTicketById(Long id);
	
		Ticket updateTicket(Ticket objTicket);
	
		void deleteTicketById(Long id);
		
		Ticket fetchTicketByTitle(String title);
		
		List<Ticket> searchForTicket(String query);

}
