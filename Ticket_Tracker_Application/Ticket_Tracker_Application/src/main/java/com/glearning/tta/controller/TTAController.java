package com.glearning.tta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.glearning.tta.service.TTAService;

import lombok.RequiredArgsConstructor;

 
import com.glearning.tta.entity.Ticket;


@Controller
@RequiredArgsConstructor

public class TTAController {
	@Autowired
	TTAService objTTAservice;
	@GetMapping("/admin/tickets")
	public String listTickets(Model objModel) {
		objModel.addAttribute("tickets", objTTAservice.getAllTickets());
		return "/admin/tickets";
	}
	
	@GetMapping("/admin/tickets/newticket")
	public String addTickets(Model model) {
		// add Tickets object to hold employee form data
		Ticket objTicket = new Ticket();
			model.addAttribute("ticket", objTicket);
			return "/admin/add_ticket";
	}
	@GetMapping("/admin/tickets/{id}/edit")
	public String editTicket(@PathVariable("id") long id, Model model) {
		 
		model.addAttribute("ticket", this.objTTAservice.getTicketById(id));
		return "/admin/edit_ticket";
	}
	
	@GetMapping("/admin/tickets/{id}/delete")
	public String editTicket(@PathVariable("id") long id) {
		this.objTTAservice.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}
	
	@PostMapping("/admin/tickets/{id}")
	public String updateTicket(
			@PathVariable("id") long id,
			@ModelAttribute("ticket") Ticket objTicket,
			Model model) {
		Ticket existingTicket = this.objTTAservice.getTicketById(id);
		existingTicket.setStrTicketShtDesc(objTicket.getStrTicketShtDesc());
		existingTicket.setStrTicketTitle(objTicket.getStrTicketTitle());
		existingTicket.setStrTicketContent(objTicket.getStrTicketContent());
		this.objTTAservice.updateTicket(existingTicket);
		return "redirect:/admin/tickets";
	}
	
	@GetMapping("/admin/tickets/search")
	public String searchTicket(@RequestParam("q") String query, Model model) {
		List<Ticket> listTickets = this.objTTAservice.searchForTicket(query);
		model.addAttribute("tickets", listTickets);
		return "/admin/tickets";
	}
	
	 @GetMapping("/admin/tickets/{id}/view")
	    public String viewTicket(@PathVariable("id") long id,
	                           Model model){
		 Ticket objTicket = objTTAservice.getTicketById(id);
	        model.addAttribute("ticket", objTicket);
	        return "admin/view_ticket";

	    }
	 
	 @PostMapping("/admin/tickets")
		public String saveTickets(@ModelAttribute("ticket") Ticket objTicket) {

		 this.objTTAservice.saveTicket(objTicket);
			return "redirect:/admin/tickets";
		}

}
