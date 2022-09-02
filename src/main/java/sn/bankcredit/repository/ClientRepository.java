package sn.bankcredit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sn.bankcredit.entity.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {	


}
