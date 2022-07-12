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

import br.projeto.aplicado.dto.SpaceDTO;
import br.projeto.aplicado.exception.SpaceException;
import br.projeto.aplicado.service.SpaceService;

@RestController
@RequestMapping("/space")
public class SpaceController {
	
	@Autowired
	SpaceService spaceService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody SpaceDTO spaceDTO) throws SpaceException {
		return ResponseEntity.ok(spaceService.save(spaceDTO));
	}
	
	@GetMapping("/search/{idSpace}")
	public ResponseEntity<SpaceDTO> searchById(@PathVariable Integer idSpace) throws SpaceException {
		return ResponseEntity.ok(spaceService.searchById(idSpace));
	}
	
	@DeleteMapping("/{idSpace}")
	public ResponseEntity<Void> delete(@PathVariable Integer idSpace) {
		spaceService.delete(idSpace);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{idSpace}")
	public ResponseEntity<String> update(@PathVariable Integer idSpace, @RequestBody SpaceDTO spaceDTO) throws SpaceException {
		return ResponseEntity.ok(spaceService.update(idSpace, spaceDTO));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<SpaceDTO>> listAll() {
		return ResponseEntity.ok(spaceService.searchAll());
	}

	@PostMapping("/save-list")
	public ResponseEntity<Void> saveList(@RequestBody List<SpaceDTO> listSpaceDTO) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
