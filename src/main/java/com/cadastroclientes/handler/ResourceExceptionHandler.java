package com.cadastroclientes.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cadastroclientes.domain.DetalhesErro;
import com.cadastroclientes.services.exceptions.ClienteExistenteException;
import com.cadastroclientes.services.exceptions.ClienteNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException(ClienteNaoEncontradoException e, HttpServletRequest request ) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O cliente não pôde ser encontrado.");
		erro.setMensagemDesenvolvedor("https://erros.cadastrocliente.com/404");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handleClienteExistenteException(ClienteExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("É possível que este cliente já esteja cadastrado.");
		erro.setMensagemDesenvolvedor("https://erros.cadastrocliente.com/409");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.algaworks.socialbooks.com/400");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
