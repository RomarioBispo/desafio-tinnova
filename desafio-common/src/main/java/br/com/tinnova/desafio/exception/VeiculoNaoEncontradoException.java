package br.com.tinnova.desafio.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VeiculoNaoEncontradoException() {
        super("User not found");
    }
	
	public VeiculoNaoEncontradoException(String msg) {
        super(msg);
    }
}