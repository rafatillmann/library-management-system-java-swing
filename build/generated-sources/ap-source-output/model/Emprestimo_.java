package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Emprestimo.class)
public abstract class Emprestimo_ {

	public static volatile SingularAttribute<Emprestimo, Aluno> aluno;
	public static volatile SingularAttribute<Emprestimo, Date> data;
	public static volatile SingularAttribute<Emprestimo, Boolean> devolvido;
	public static volatile SingularAttribute<Emprestimo, Livro> livro;
	public static volatile SingularAttribute<Emprestimo, Integer> id;
	public static volatile SingularAttribute<Emprestimo, Date> dataDevolucao;

}

