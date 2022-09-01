package sn.bankcredit.services;

import java.util.List;

import sn.bankcredit.dto.ClientDto;


public interface ClientService {
	
				ClientDto saveClient(ClientDto client);
				ClientDto updateClient(ClientDto client);
				void deleteClient(ClientDto client);
				void deleteClientById(Long id);
				ClientDto getClient(Long id);
				List<ClientDto> getAllClients();

}
