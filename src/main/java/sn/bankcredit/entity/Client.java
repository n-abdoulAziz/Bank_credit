package sn.bankcredit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=150,nullable = false)
	private  String firstname;
	@Column(length=150,nullable = false)
	private  String lastname;
	@Enumerated(EnumType.STRING)
	private  Gender gender  ;
	@Column(length=150,nullable = false)
	private  String country;
	@Column(length=150,nullable = false)
	private  String city;
	@Column(nullable = false)
	private String adress;
	@OneToMany(mappedBy="client")
	private List<Credit> credits;

}
