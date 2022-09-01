package sn.bankcredit.mapping;

import org.mapstruct.Mapper;

import sn.bankcredit.dto.CreditDto;
import sn.bankcredit.entity.Credit;

@Mapper
public interface CreditMapper {
	Credit toCredit(CreditDto creditDto);
	CreditDto toCreditDto(Credit credit);

}
