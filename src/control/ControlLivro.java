/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.DaoLivro;
import model.Editora;

/**
 *
 * @author tillm
 */
public class ControlLivro {

    private Livro livro;
    private DaoLivro dl;
    private List<Livro> livros;
    private String mensagem;
    private static ControlLivro instancia;

    public static ControlLivro getInstancia() {
        if (instancia == null) {
            instancia = new ControlLivro();
            return instancia;
        } else {
            return instancia;
        }
    }

    private ControlLivro() {
        this.livro = null;
        this.dl = new DaoLivro();
        this.livros = new ArrayList<>();
        preencherLivros();
    }

    public void preencherLivros() {
        livros.clear();
        for (Livro l : dl.list()) {
            livros.add(l);
        }
    }

    public boolean gravar(String titulo, int numeroPag, String autores, Editora editora) {
        if (livro == null) {
            livro = new Livro();
            livro.setTitulo(titulo);
            livro.setAutores(autores);
            livro.setNumeroPag(numeroPag);
            livro.setEditora(editora);
            if (dl.insert(livro)) {
                this.livro = new Livro();
                mensagem = "Inserido com sucesso";
                return true;
            } else {
                return false;
            }
        } else {
            livro.setTitulo(titulo);
            livro.setAutores(autores);
            livro.setNumeroPag(numeroPag);
            livro.setEditora(editora);
            if (dl.edit(livro)) {
                this.livro = new Livro();
                mensagem = "Editado com sucesso";
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean excluir(Livro l) {
        if (dl.remove(l)) {
            return true;
        } else {
            return false;
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public DaoLivro getDl() {
        return dl;
    }

    public void setDl(DaoLivro dl) {
        this.dl = dl;
    }

    public List<Livro> getLivros() {
        preencherLivros();
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
