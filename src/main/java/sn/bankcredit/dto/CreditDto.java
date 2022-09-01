package sn.bankcredit.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {
	@NotNull
	private String creditNumber;
	@NotNull
	private Double amount;
	@NotNull
	private Integer duration;


}
