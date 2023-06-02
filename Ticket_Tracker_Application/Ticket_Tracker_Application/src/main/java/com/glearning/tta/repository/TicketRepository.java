package com.glearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glearning.tta.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{
	
	@Query("SELECT t from Ticket t WHERE " +
            " t.strTicketTitle LIKE CONCAT('%', :query, '%') OR " +
            " t.strTicketShtDesc LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);

	Ticket findBystrTicketTitle(String title);

}//End