package br.com.glp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contato.class)
public abstract class Contato_ {

	public static volatile SingularAttribute<Contato, Boolean> whatsapp;
	public static volatile SingularAttribute<Contato, String> telefone;
	public static volatile SingularAttribute<Contato, Pessoa> pessoa;
	public static volatile SingularAttribute<Contato, String> celular;
	public static volatile SingularAttribute<Contato, Long> id;
	public static volatile SingularAttribute<Contato, String> email;

	public static final String WHATSAPP = "whatsapp";
	public static final String TELEFONE = "telefone";
	public static final String PESSOA = "pessoa";
	public static final String CELULAR = "celular";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

