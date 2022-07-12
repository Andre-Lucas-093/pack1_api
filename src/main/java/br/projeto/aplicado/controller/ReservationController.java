package br.projeto.aplicado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.aplicado.dto.ReservationDTO;
import br.projeto.aplicado.exception.ReservationException;
import br.projeto.aplicado.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ReservationDTO reservationDTO) throws ReservationException{
		return ResponseEntity.ok(reservationService.save(reservationDTO));
	}
	
	@GetMapping("/search/{idReservation}")
	public ResponseEntity<ReservationDTO> searchById(@PathVariable Integer idReservation) throws ReservationException {
		return ResponseEntity.ok(reservationService.searchById(idReservation));
	}
	
	@DeleteMapping("/{idReservation}")
	public ResponseEntity<Void> delete(@PathVariable Integer idReservation) {
		reservationService.delete(idReservation);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{idReservation}")
	public ResponseEntity<String> update(@PathVariable Integer idReservation, @RequestBody ReservationDTO reservationDTO) throws ReservationException {
		return ResponseEntity.ok(reservationService.update(idReservation, reservationDTO));
	}

	@GetMapping("/list")
	public ResponseEntity<List<ReservationDTO>> listAll() {
		return ResponseEntity.ok(reservationService.searchAll());
	}
	
	@PostMapping("/save-list")
	public ResponseEntity<Void> saveList(@RequestBody List<ReservationDTO> listReservationDTO) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
