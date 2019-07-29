package br.com.glp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, String> marcaProduto;
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> tipoProduto;
	public static volatile SingularAttribute<Produto, Integer> quantidade;

	public static final String MARCA_PRODUTO = "marcaProduto";
	public static final String ID = "id";
	public static final String TIPO_PRODUTO = "tipoProduto";
	public static final String QUANTIDADE = "quantidade";

}

