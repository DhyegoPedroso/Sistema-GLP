package br.com.glp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ extends br.com.glp.model.Pessoa_ {

	public static volatile ListAttribute<Cliente, Caminhao> caminhoes;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> nomeSocial;

	public static final String CAMINHOES = "caminhoes";
	public static final String CNPJ = "cnpj";
	public static final String NOME_SOCIAL = "nomeSocial";

}

