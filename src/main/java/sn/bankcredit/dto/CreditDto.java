package sn.bankcredit.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.bankcredit.entity.Gender;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreditDto {
	@NotNull
	private String creditNumber;
	@NotNull
	private Double amount;
	@NotNull
	private Integer duration;


}
