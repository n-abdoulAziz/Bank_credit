package sn.bankcredit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.bankcredit.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, String> {
	Optional<Credit> findByCreditNumberIgnoreCase(String creditnumber);
	Credit findByCreditNumber(String creditNumber);

}
