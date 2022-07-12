package br.projeto.aplicado.dto;

import java.util.Date;

public class ReservationDTO {
	private Long id;
	
	private Date reservedSession;
	
	public ReservationDTO() {
		
	}

	public ReservationDTO(Long id, Date reservedSession) {
		super();
		this.id = id;
		this.reservedSession = reservedSession;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReservedSession() {
		return reservedSession;
	}

	public void setReservedSession(Date reservedSession) {
		this.reservedSession = reservedSession;
	}
	
	
}
