package sn.bankcredit.domain;

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
public class Client {
    Long id;
    @NotNull(message = "Firstname is not null")
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String address;
}