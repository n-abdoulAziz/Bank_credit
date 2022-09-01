package sn.bankcredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bankcredit.entity.Credit;

public interface CreditRepository extends JpaRepository<Credit, String> {

}
