package br.com.glp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfil.class)
public abstract class Perfil_ {

	public static volatile SingularAttribute<Perfil, String> tipo;
	public static volatile SingularAttribute<Perfil, String> observacao;
	public static volatile SingularAttribute<Perfil, String> nome;
	public static volatile SingularAttribute<Perfil, Long> id;

	public static final String TIPO = "tipo";
	public static final String OBSERVACAO = "observacao";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

