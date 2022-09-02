package sn.bankcredit.services;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sn.bankcredit.dto.ClientDto;
import sn.bankcredit.entity.Client;
import sn.bankcredit.exceptions.ClientNotFoundException;
import sn.bankcredit.exceptions.RequestException;
import sn.bankcredit.mapping.ClientMapper;
import sn.bankcredit.repository.ClientRepository;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class ClientServiceImplement implements ClientService {
	
	private ClientRepository repos;
	private ClientMapper map;
	private MessageSource messageSource;
	@Override
	public ClientDto saveClient(ClientDto clientDto) {
		return map.toClientDto(repos.save(map.toClient(clientDto)));
	}
	
	@Override
	 @CacheEvict(key = "#id")
   @Transactional
	public ClientDto getClient(Long id) {
		try {
			return map.toClientDto(repos.findById(id).get());
        } catch (Exception e) {
            throw new ClientNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                    Locale.getDefault()));
        }	
		
	}
	@Override
	public List<ClientDto> getAllClients() {
		try {
			return StreamSupport.stream(repos.findAll().spliterator(), false)
	                .map(map::toClientDto)
	                .collect(Collectors.toList());
		} catch (Exception e) {
			throw new ClientNotFoundException((messageSource.getMessage("there is no client  :", new Object[]{},
                    Locale.getDefault())));
		}
		
	}

	@Override
	public ClientDto updateClient(ClientDto client) {
		Client cl=repos.save(map.toClient(client));
		return map.toClientDto(cl);
	}
	

	@Override
	public void deleteClient(ClientDto client) {
		try {
			repos.delete(map.toClient(client));
		} catch (Exception e) {
            throw new RequestException(messageSource.getMessage("there is no client  :"+client, new Object[]{client},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
	}
	@Override
	 @CacheEvict(key = "#id")
   @Transactional
	public void deleteClientById(Long id) {
		try {
           repos.deleteById(id);
       } catch (Exception e) {
           throw new RequestException(messageSource.getMessage("there no Client with this id :"+id, new Object[] {},
        		   Locale.getDefault()),
                   HttpStatus.CONFLICT);
       }	
	}

	
}
