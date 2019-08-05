package com.cadastroclientes.domain;

public class DetalhesErro {
	
	private String titulo;
	
	private Long status;
	
	private Long timeStamp;
	
	private String mensagemDesenvolvedor;
	
	public DetalhesErro() {
		
	}

	public DetalhesErro(String titulo, Long status, Long timeStamp, String mensagemDesenvolvedor) {
		super();
		this.titulo = titulo;
		this.status = status;
		this.timeStamp = timeStamp;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
}
