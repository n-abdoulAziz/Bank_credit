package sn.bankcredit.services;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sn.bankcredit.dto.CreditDto;
import sn.bankcredit.exceptions.ClientNotFoundException;
import sn.bankcredit.exceptions.CreditNotFoundException;
import sn.bankcredit.exceptions.RequestException;
import sn.bankcredit.mapping.CreditMapper;
import sn.bankcredit.repository.CreditRepository;

@Service
public class CreditServiceImplement implements CreditService {

	private CreditRepository repos;
	private CreditMapper map;
	private MessageSource messageSource;
	
	@Override
	public CreditDto saveCreditDto(CreditDto creditDto) {
		repos.findByCreditNumberIgnoreCase(creditDto.getCreditNumber())
		.ifPresent(entity -> {
			throw new RequestException(messageSource.getMessage("creditDto .exists", new Object[]{creditDto.getCreditNumber()},
					Locale.getDefault()), HttpStatus.CONFLICT);
		});
		return map.toCreditDto(repos.save(map.toCredit(creditDto)));
	}
	@Override
	public CreditDto getCreditDto(String creditNumber) {
		try {
			return  map.toCreditDto(repos.findByCreditNumber(creditNumber));
		} catch (Exception e) {
			throw new ClientNotFoundException(" there is no client in our db with this createdNumber :"+creditNumber);
		}	
	}

	@Override
	public List<CreditDto> getAllCreditDtos() {
		try {
			return StreamSupport.stream(repos.findAll().spliterator(), false)
					.map(map::toCreditDto)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ClientNotFoundException(messageSource.getMessage("No credit", null, null));
		}
	}


	@Override
	public CreditDto updateCreditDto(String creditNumber, CreditDto creditdto) {
		return repos.findByCreditNumberIgnoreCase(creditNumber)
        .map(a -> {
        	creditdto.setCreditNumber(creditNumber);
        	//creditdto.setAmount(null);
        	//creditdto.setDuration(null);
            return map.toCreditDto(
                    repos.save(map.toCredit(creditdto)));
        }).orElseThrow(() -> new CreditNotFoundException(messageSource.getMessage("credit  notfound", new Object[]{creditNumber},
                Locale.getDefault())));
}
	
	@Override
	public void deleteCreditByCreateNumber(String creditNumber) {
		 try {
	            repos.deleteById(creditNumber);
	        } catch (Exception e) {
	            throw new RequestException(messageSource.getMessage("there is no credit with this createNumber equal to :"+creditNumber, new Object[]{creditNumber},
	                    Locale.getDefault()),
	                    HttpStatus.CONFLICT);
	        }
	    }
}
