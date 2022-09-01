package sn.bankcredit.mapping;


import org.mapstruct.Mapper;

import sn.bankcredit.dto.ClientDto;
import sn.bankcredit.entity.Client;

@Mapper
public interface ClientMapper {
	ClientDto toClientDto(Client client);
	Client toClient(ClientDto clientDto);
	/* we add mapstruct depences and plugin, propertie*/
}
