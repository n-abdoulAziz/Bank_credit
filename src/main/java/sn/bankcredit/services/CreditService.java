package sn.bankcredit.services;

import java.util.List;

import sn.bankcredit.dto.CreditDto;

public interface CreditService {
		CreditDto saveCreditDto(CreditDto CreditDto);
		CreditDto updateCreditDto(CreditDto client);
		void deleteClient(CreditDto client);
		void deleteCreditDtoByCreateNumber(String num);
		CreditDto getCreditDto(Long id);
		List<CreditDto> getAllCreditDtos();
	}


