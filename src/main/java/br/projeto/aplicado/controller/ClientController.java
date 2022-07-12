package br.projeto.aplicado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.aplicado.dto.ClientDTO;
import br.projeto.aplicado.exception.ClientException;
import br.projeto.aplicado.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/{idClient}")
	public ClientDTO getClientById(@PathVariable int idClient) throws ClientException {
		return clientService.searchById(idClient);
	}

	@GetMapping
	public List<ClientDTO> getAllClient() {
		return clientService.searchAll();
	}

	@PostMapping
	public ResponseEntity<String> postClient(@RequestBody ClientDTO clientDTO) {
		return ResponseEntity.ok(clientService.save(clientDTO));
	}

	@PutMapping("/{idClient}")
	public ResponseEntity<String> putClient(@RequestBody ClientDTO clientDTO, @PathVariable int idClient)
			throws ClientException {
		return ResponseEntity.ok(clientService.update(idClient, clientDTO));
	}
	@PostMapping("/save-list")
	public ResponseEntity<String> saveClientList(@RequestBody List<ClientDTO> listClientDTO){
		return ResponseEntity.ok(clientService.postClientList(listClientDTO));	
	}
	
	
}
