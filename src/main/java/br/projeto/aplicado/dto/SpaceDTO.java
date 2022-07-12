package br.projeto.aplicado.dto;

public class SpaceDTO {
	private Long id;

	private Long vaccantSlots;

	private Boolean available;
	
	public SpaceDTO() {
		
	}

	public SpaceDTO(Long id, Long vaccantSlots, Boolean available) {
		super();
		this.id = id;
		this.vaccantSlots = vaccantSlots;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
