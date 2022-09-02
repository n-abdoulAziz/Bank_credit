package sn.bankcredit.controllers;

import java.util.List;

import javax.validation.Valid;

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

import lombok.RequiredArgsConstructor;
import sn.bankcredit.dto.ClientDto;
import sn.bankcredit.services.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClientController {

	private ClientService service;
	
	@GetMapping("/clients")
	public ResponseEntity<List<ClientDto>> getClients(){
		return ResponseEntity.ok(service.getAllClients());
	}
	@PostMapping("/createClient")
	public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto clientDto) {
		return new ResponseEntity<>(service.saveClient(clientDto),HttpStatus.CREATED);
	}
	// pense a metre les types de retour en responseEntity de maniere generale
	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientDto>  getClient(@Valid @PathVariable("id") Long id){
		return ResponseEntity.ok(service.getClient(id));
	}
	@PutMapping("/clients/{id}")
	public ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDto clientDto) {
		return ResponseEntity.ok(service.updateClient(clientDto));
	}
	
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@Valid @PathVariable("id") Long id) {
		service.deleteClientById(id);
	}
	
}
