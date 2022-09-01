package sn.bankcredit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import sn.bankcredit.entity.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
	
}
