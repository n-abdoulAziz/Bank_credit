package sn.bankcredit.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit implements Serializable {
    @NotNull(message = "Credit is not null")
    private String creditNumber;
    @NotNull
    private double amount;
    @NotNull
    private int duration;
    @NotNull
    private Client client;
}