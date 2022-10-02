package sn.bankcredit.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIException {
	String message;
    HttpStatus status;
    LocalDateTime timestamp;
}