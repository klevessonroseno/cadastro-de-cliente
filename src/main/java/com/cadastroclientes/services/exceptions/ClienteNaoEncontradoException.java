package com.cadastroclientes.services.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1185201619625244409L;
	
	public ClienteNaoEncontradoException(String message) {
		super(message);
	}
	public ClienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
