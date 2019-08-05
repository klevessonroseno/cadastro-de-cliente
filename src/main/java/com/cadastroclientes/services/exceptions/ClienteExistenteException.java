package com.cadastroclientes.services.exceptions;

public class ClienteExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2267607157312838552L;
	
	public ClienteExistenteException(String mensagem) {
		super(mensagem);
	}
	public ClienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
