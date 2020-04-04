/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Aluno;
import model.DaoEmprestimo;
import model.Emprestimo;
import model.Livro;

/**
 *
 * @author tillm
 */
public class ControlEmprestimo {

    private Emprestimo emprestimo;
    private DaoEmprestimo de;
    private List<Emprestimo> emprestimos;
    private String mensagem;
    private static ControlEmprestimo instancia;

    public static ControlEmprestimo getInstancia() {
        if (instancia == null) {
            instancia = new ControlEmprestimo();
            return instancia;
        } else {
            return instancia;
        }
    }

    public ControlEmprestimo() {
        this.emprestimo = null;
        this.de = new DaoEmprestimo();
        this.emprestimos = new ArrayList<>();
        preencherEmprestimos();
    }

    public void preencherEmprestimos() {
        emprestimos.clear();
        for (Emprestimo e : de.list()) {
            emprestimos.add(e);
        }
    }

    public boolean gravar(String data, Livro livro, Aluno aluno) throws ParseException {
        if (emprestimo == null) {
            SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
            Date date = form.parse(data);
            emprestimo.setData(date);
            emprestimo.setLivro(livro);
            emprestimo.setAluno(aluno);
            emprestimo.setDevolvido(false);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, +15);
            Date dataDevolucao = c.getTime();
            emprestimo.setDataDevolucao(dataDevolucao);
            if (de.insert(emprestimo)) {
                this.emprestimo = new Emprestimo();
                mensagem = "Inserido com sucesso";
                return true;
            } else {
                return false;
            }
        }else{
            SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
            Date date = form.parse(data);
            emprestimo.setData(date);
            emprestimo.setLivro(livro);
            emprestimo.setAluno(aluno);
            emprestimo.setDevolvido(false);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, +15);
            Date dataDevolucao = c.getTime();
            emprestimo.setDataDevolucao(dataDevolucao);
            if (de.edit(emprestimo)) {
                this.emprestimo = new Emprestimo();
                mensagem = "Editado com sucesso";
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean excluir(Emprestimo e) {
        if (de.remove(e)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean devolver(Emprestimo e) {
        e.setDevolvido(true);
        if (de.edit(e)) {
            return true;
        } else {
            return false;
        }
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public DaoEmprestimo getDe() {
        return de;
    }

    public void setDe(DaoEmprestimo de) {
        this.de = de;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

}
