package com.cadastroclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroclientes.domain.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long>{

}
