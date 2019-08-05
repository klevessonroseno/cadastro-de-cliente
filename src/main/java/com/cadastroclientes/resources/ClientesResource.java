package com.cadastroclientes.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroclientes.domain.Cliente;
import com.cadastroclientes.event.RecursoCriadoEvent;
import com.cadastroclientes.services.ClientesService;

@RestController
@RequestMapping(value="/clientes")
public class ClientesResource {
	
	@Autowired
	private ClientesService clientesService;
	
	@Autowired
	private ApplicationEventPublisher publisher;	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.listarTodos());
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloCodigo(@Valid @PathVariable("codigo") Long codigo){
		Cliente cliente = clientesService.buscarUm(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente, HttpServletResponse response){
		Cliente clienteSalvo = clientesService.salvar(cliente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> atualizarCliente(@RequestBody Cliente cliente,@PathVariable("codigo") Long codigo){
		cliente.setCodigo(codigo);
		clientesService.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletarCliente(@PathVariable("codigo") Long codigo){
		clientesService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}

}
