package sn.bankcredit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditEntity {
	@Id
	private String creditNumber;
	private Double amount;
	private Integer duration;
	@ManyToOne
	private ClientEntity client;

}

