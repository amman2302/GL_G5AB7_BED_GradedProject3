package com.glearning.tta.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.tta.service.TTAService;
import com.glearning.tta.entity.Ticket;
import com.glearning.tta.exception.InvalidPostIdException;
import com.glearning.tta.repository.TicketRepository;

@Service
public class TTAServiceImpl implements TTAService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket> listTicket = ticketRepository.findAll();
		return listTicket;
	}

	@Override
	public Ticket saveTicket(Ticket objTicket) {
		// TODO Auto-generated method stub
		Ticket objPTicket = this.ticketRepository.save(objTicket);
		return objPTicket;
	}

	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		Ticket objRTicket = this.ticketRepository.findById(id)
				.orElseThrow(() -> new InvalidPostIdException("Invalid post"));
		return objRTicket;
	}

	@Override
	public Ticket updateTicket(Ticket objTicket) {
		// TODO Auto-generated method stub
		Ticket objPTicket = this.ticketRepository.save(objTicket);
		return objPTicket;
	}

	@Override
	public void deleteTicketById(Long id) {
		// TODO Auto-generated method stub
		this.ticketRepository.deleteById(id);
	}
	
	@Override
	public List<Ticket> searchForTicket(String query) {
		 List<Ticket> listTicket = this.ticketRepository.searchTickets(query);
	        return listTicket.stream()
	                .collect(Collectors.toList());
	}

	@Override
	public Ticket fetchTicketByTitle(String title) {
		return this.ticketRepository.findBystrTicketTitle(title);
	}

}
