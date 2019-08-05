package com.cadastroclientes.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {
	
	public static volatile SingularAttribute<Cliente, Long> codigo;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, Date> dataNascimento;
	public static volatile SingularAttribute<Cliente, Date> dataCadastro;
	public static volatile SingularAttribute<Cliente, Endereco> endereco;
	public static volatile SingularAttribute<Cliente, Contato> contato;

}
