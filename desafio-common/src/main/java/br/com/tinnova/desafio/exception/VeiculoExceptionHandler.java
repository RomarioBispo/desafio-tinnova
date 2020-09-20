package br.com.tinnova.desafio.exception;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.tinnova.desafio.domain.error.ErrorMessage;

@ControllerAdvice
public class VeiculoExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { VeiculoNaoEncontradoException.class})
  protected ResponseEntity<ErrorMessage> userNotFoundHandler(RuntimeException ex, WebRequest request) {
	 ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), "Record not found", ex.getMessage());
	  return new ResponseEntity<>(errorMessage, NOT_FOUND);
  }
}
