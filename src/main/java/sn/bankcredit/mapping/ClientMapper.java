package sn.bankcredit.mapping;


import org.mapstruct.Mapper;

import sn.bankcredit.domain.Client;
import sn.bankcredit.entity.ClientEntity;

@Mapper
public interface ClientMapper {
    Client toClient(ClientEntity clientEntity);
    ClientEntity fromClient(Client client);
}