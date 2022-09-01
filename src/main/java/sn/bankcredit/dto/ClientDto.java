package sn.bankcredit.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import sn.bankcredit.entity.Credit;
import sn.bankcredit.entity.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	private Long id;
	@NotNull
	private  String firstname;
	@NotNull
	private  String lastname;
	@NotNull
	private  Gender gender ;
	@NotNull
	private  String country;
	@NotNull
	private  String city;
	@NotNull
	private String adress;
	

}
