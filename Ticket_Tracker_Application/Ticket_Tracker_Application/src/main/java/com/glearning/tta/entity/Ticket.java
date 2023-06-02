package com.glearning.tta.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name="ticket")
public class Ticket {
	
	public Ticket()
	{
		
	}
 	
	public Ticket(Long id, String strTicketTitle, String strTicketContent, String strTicketShtDesc,
			LocalDateTime objTicketCreatedDate, LocalDateTime objTicketUpdatedDate) {
		super();
		this.id = id;
		this.strTicketTitle = strTicketTitle;
		this.strTicketContent = strTicketContent;
		this.strTicketShtDesc = strTicketShtDesc;
		this.objTicketCreatedDate = objTicketCreatedDate;
		this.objTicketUpdatedDate = objTicketUpdatedDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="ticket_title", nullable=false)
	private String strTicketTitle;
		
	@Lob
	@Column(name="ticket_content",nullable = false)
	private String strTicketContent;
	
	@Column(name="ticket_sht_desc", nullable=false)
	private String strTicketShtDesc;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime objTicketCreatedDate;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime objTicketUpdatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrTicketTitle() {
		return strTicketTitle;
	}

	public void setStrTicketTitle(String strTicketTitle) {
		this.strTicketTitle = strTicketTitle;
	}

	public String getStrTicketContent() {
		return strTicketContent;
	}

	public void setStrTicketContent(String strTicketContent) {
		this.strTicketContent = strTicketContent;
	}

	public String getStrTicketShtDesc() {
		return strTicketShtDesc;
	}

	public void setStrTicketShtDesc(String strTicketShtDesc) {
		this.strTicketShtDesc = strTicketShtDesc;
	}

	public LocalDateTime getObjTicketCreatedDate() {
		return objTicketCreatedDate;
	}

	public void setObjTicketCreatedDate(LocalDateTime objTicketCreatedDate) {
		this.objTicketCreatedDate = objTicketCreatedDate;
	}

	public LocalDateTime getObjTicketUpdatedDate() {
		return objTicketUpdatedDate;
	}

	public void setObjTicketUpdatedDate(LocalDateTime objTicketUpdatedDate) {
		this.objTicketUpdatedDate = objTicketUpdatedDate;
	}
	

}
