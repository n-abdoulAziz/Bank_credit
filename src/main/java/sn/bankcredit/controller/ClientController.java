package sn.bankcredit.controller;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.bankcredit.domain.Client;
import sn.bankcredit.service.ClientService;


@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

    ClientService clientService;

    @GetMapping
    public Page<Client> getClients(Pageable pageable) {
        return clientService.getClients(pageable);
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public Client updateClient(@PathVariable("id") Long id, @Valid @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }

}