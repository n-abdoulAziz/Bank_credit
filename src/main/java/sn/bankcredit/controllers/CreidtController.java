package sn.bankcredit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.bankcredit.annotation.IsAdmin;
import sn.bankcredit.dto.CreditDto;
import sn.bankcredit.services.CreditService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CreidtController {
	
	private CreditService service;
	
	    @GetMapping("/credits")
	    public ResponseEntity< List<CreditDto>>getCredits() {
	        return ResponseEntity.ok(service.getAllCreditDtos());
	    }
	    @GetMapping("/credits/{creditNumber}")
	    public ResponseEntity<CreditDto> getCredit(@PathVariable("creditNumber") String creditNumber) {
	        return ResponseEntity.ok(service.getCreditDto(creditNumber));
	    }

	    @PostMapping("/createCredit")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    @IsAdmin
	    public ResponseEntity<CreditDto> createCredit(@Valid @RequestBody CreditDto creditdto) {
	        return new ResponseEntity<>(service.saveCreditDto(creditdto),HttpStatus.CREATED);
	    }

	    @PutMapping("credits/{creditNumber}")
	    @IsAdmin
	    public ResponseEntity<CreditDto> updateCountry(@PathVariable("creditNumber") String creditNumber, @Valid @RequestBody CreditDto creditdto) {
	        return  ResponseEntity.ok(service.updateCreditDto(creditNumber, creditdto));
	    }

	    @DeleteMapping("credits/{creditNumber}")
	    @IsAdmin
	    public void deleteCountry(@PathVariable("creditNumber") String creditNumber) {
	        service.deleteCreditByCreateNumber(creditNumber);
	    }

}
