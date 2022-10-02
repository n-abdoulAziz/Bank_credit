package sn.bankcredit.mapping;

import org.mapstruct.Mapper;

import sn.bankcredit.domain.Credit;
import sn.bankcredit.entity.CreditEntity;

@Mapper
public interface CreditMapper {
	Credit toCredit(CreditEntity creditEntity);
    CreditEntity fromCredit(Credit credit);
}
