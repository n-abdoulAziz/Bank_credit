package sn.bankcredit.services;

import java.util.List;

import sn.bankcredit.dto.CreditDto;

public interface CreditService {
		CreditDto saveCreditDto(CreditDto CreditDto);
		CreditDto updateCreditDto(String creditNumber, CreditDto creditdto);
		void deleteCreditByCreateNumber(String creditNumber);
		CreditDto getCreditDto(String num);
		List<CreditDto> getAllCreditDtos();
	}


