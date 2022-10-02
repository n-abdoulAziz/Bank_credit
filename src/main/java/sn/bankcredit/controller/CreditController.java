package sn.bankcredit.controller;

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

import lombok.AllArgsConstructor;
import sn.bankcredit.annotation.IsAdmin;
import sn.bankcredit.domain.Credit;
import sn.bankcredit.service.CreditService;

@RestController
@RequestMapping("/credits")
@AllArgsConstructor
public class CreditController {

    CreditService creditService;

    @GetMapping
    public List<Credit> getCredits() {
        return creditService.getCredits();
    }

    @GetMapping("/{creditNumber}")
    public ResponseEntity<Credit> getCredit(@PathVariable("creditNumber") String creditNumber) {
        return ResponseEntity.ok(creditService.getCredit(creditNumber));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @IsAdmin
    public ResponseEntity<Credit> createCredit(@Valid @RequestBody Credit credit) {
        return new ResponseEntity<>(creditService.createCredit(credit), HttpStatus.CREATED);
    }

    @PutMapping("/{creditNumber}")
    //@IsAdmin
    public Credit updateCredit(@PathVariable("creditNumber") String creditNumber, @Valid @RequestBody Credit credit) {
        return creditService.updateCredit(creditNumber, credit);
    }

    @DeleteMapping("/{creditNumber}")
    //@IsAdmin
    public void deleteCredit(@PathVariable("creditNumber") String creditNumber) {
        creditService.deleteCredit(creditNumber);
    }
}