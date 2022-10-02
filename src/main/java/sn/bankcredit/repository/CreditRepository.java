package sn.bankcredit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.bankcredit.entity.CreditEntity;
@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, String> {
	Optional<CreditEntity> findByCreditNumberIgnoreCase(String creditNumber);

}
