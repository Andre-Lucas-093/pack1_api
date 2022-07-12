package br.projeto.aplicado.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Reservation")
public class ReservationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "reserved_session")
	private Date reservedSession;

	public ReservationModel() {

	}

	public ReservationModel(Date reservedSession) {
		super();
		this.reservedSession = reservedSession;

	}

	public Date getReservedSession() {
		return reservedSession;
	}

	public void setReservedSession(Date reservedSession) {
		this.reservedSession = reservedSession;
	}

	public Long getId() {
		return id;
	}

}
