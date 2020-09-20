package br.com.tinnova.desafio.domain.error;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ErrorMessage {
	private LocalDateTime timestamp;
	private String message;
	private String reason;
}
