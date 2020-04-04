package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Livro.class)
public abstract class Livro_ {

	public static volatile SingularAttribute<Livro, Integer> numeroPag;
	public static volatile SingularAttribute<Livro, String> titulo;
	public static volatile SingularAttribute<Livro, Integer> id;
	public static volatile SingularAttribute<Livro, String> autores;
	public static volatile SingularAttribute<Livro, Editora> editora;

}

