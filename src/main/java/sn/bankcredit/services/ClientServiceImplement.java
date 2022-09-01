package sn.bankcredit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import sn.bankcredit.dto.ClientDto;
import sn.bankcredit.entity.Client;
import sn.bankcredit.mapping.ClientMapper;
import sn.bankcredit.repository.ClientRepository;

@AllArgsConstructor
public class ClientServiceImplement implements ClientService {
	
	private ClientRepository repos;
	private ClientMapper map;
	@Override
	public ClientDto saveClient(ClientDto clientDto) {
		return map.toClientDto(repos.save(map.toClient(clientDto)));
	}

	@Override
	public ClientDto updateClient(ClientDto client) {
	
		return null;
	}

	@Override
	public void deleteClient(ClientDto client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClientById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientDto getClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientDto> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
