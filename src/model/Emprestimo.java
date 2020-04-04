/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name="emprestimo")
public class Emprestimo implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private Date data;
    private Date dataDevolucao;
    private boolean devolvido;
    @ManyToOne
    @JoinColumn(name="id_livro")
    private Livro livro;
    @ManyToOne
    @JoinColumn(name="id_aluno")
    private Aluno aluno;

    public Emprestimo() {
    }

    public Emprestimo(int id, Date data, Date dataDevolucao, boolean devolvido, Livro livro, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
        this.livro = livro;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
