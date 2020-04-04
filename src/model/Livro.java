/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name="livro")
public class Livro implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private int numeroPag;
    private String autores;
    @ManyToOne
    @JoinColumn(name="id_editora")
    private Editora editora;

    public Livro() {
    }

    public Livro(int id, String titulo, int numeroPag, String autores, Editora editora) {
        this.id = id;
        this.titulo = titulo;
        this.numeroPag = numeroPag;
        this.autores = autores;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    @Override
    public String toString() {
        return titulo;
    }
}
