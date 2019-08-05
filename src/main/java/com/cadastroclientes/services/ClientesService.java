package com.cadastroclientes.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastroclientes.domain.Cliente;
import com.cadastroclientes.repository.ClientesRepository;
import com.cadastroclientes.services.exceptions.ClienteExistenteException;
import com.cadastroclientes.services.exceptions.ClienteNaoEncontradoException;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	//Find all clients
	public List<Cliente> listarTodos(){
		return clientesRepository.findAll();
	}
	
	//Find one client
	public Cliente buscarUm(Long codigo) {
		Cliente cliente = clientesRepository.findOne(codigo);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado.");
		}
		return cliente;
	}
	
	//Save a client
	public Cliente salvar(Cliente cliente) {
		if(cliente.getCodigo() != null){
			Cliente clienteBuscado = clientesRepository.findOne(cliente.getCodigo());
			
			if(clienteBuscado != null) {
				throw new ClienteExistenteException("É possível que este cliente já esteja cadastrado.");
			}
		}
		cliente.setDataCadastro(new Date());
		return clientesRepository.save(cliente);
	}
	private void verificarExistencia(Cliente cliente) {
		buscarUm(cliente.getCodigo());
	}
	//update a client
	public void atualizar(Cliente cliente) {
		verificarExistencia(cliente);
		cliente.setDataCadastro(new Date());
		clientesRepository.save(cliente);
	}
	//delete a client
	public void deletar(Long codigo) {
		try {
			clientesRepository.delete(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado.");
		}
	}

	
}
