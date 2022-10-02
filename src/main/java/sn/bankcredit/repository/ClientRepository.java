package sn.bankcredit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sn.bankcredit.entity.ClientEntity;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {
}