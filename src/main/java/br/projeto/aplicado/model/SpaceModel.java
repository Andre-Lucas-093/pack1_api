package br.projeto.aplicado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Space")
public class SpaceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vaccant_slots")
	private Long vaccantSlots;

	@Column(name = "available")
	private Boolean available;

	
	
	public SpaceModel() {
		
	}

	public SpaceModel(Long vaccantSlots, Boolean available) {
		super();
		this.vaccantSlots = vaccantSlots;
		this.available = available;
	}

	public Long getVaccantSlots() {
		return vaccantSlots;
	}

	public void setVaccantSlots(Long vaccantSlots) {
		this.vaccantSlots = vaccantSlots;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Long getId() {
		return id;
	}

}
