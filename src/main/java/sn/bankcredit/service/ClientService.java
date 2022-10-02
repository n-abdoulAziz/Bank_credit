package sn.bankcredit.service;

import java.util.Locale;

import javax.persistence.EntityNotFoundException;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sn.bankcredit.domain.Client;
import sn.bankcredit.exceptions.RequestException;
import sn.bankcredit.mapping.ClientMapper;
import sn.bankcredit.repository.ClientRepository;
import sn.bankcredit.repository.CreditRepository;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {

    ClientRepository clientRepository;
    CreditRepository creditRepository;
    ClientMapper clientMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toClient);
    }

    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientMapper.toClient(clientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Client createClient(Client client) {
        clientRepository.findById(client.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("client.exists", new Object[]{client.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return clientMapper.toClient(clientRepository.save(clientMapper.fromClient(client)));
    }

    @Transactional
    public Client updateClient(Long id, Client client){
        return clientRepository.findById(id)
                .map(entity -> {
                    client.setId(id);
                    return clientMapper.toClient(clientRepository.save(clientMapper.fromClient(client)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("client.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("client.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}