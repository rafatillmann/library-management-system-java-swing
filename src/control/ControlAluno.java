/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.DaoAluno;
import model.DaoEditora;
import model.Editora;

/**
 *
 * @author tillm
 */
public class ControlAluno {

    private Aluno aluno;
    private DaoAluno da;
    private List<Aluno> alunos;
    private static ControlAluno instancia;
    private String mensagem;

    public static ControlAluno getInstancia() {
        if (instancia == null) {
            instancia = new ControlAluno();
            return instancia;
        } else {
            return instancia;
        }
    }

    private ControlAluno() {
        this.aluno = null;
        this.da = new DaoAluno();
        this.alunos = new ArrayList<>();
        preencherAlunos();
    }

    public void preencherAlunos() {
        alunos.clear();
        for (Aluno a : da.list()) {
            alunos.add(a);
        }
    }

    public boolean gravar(String nome, int matricula, String turma) {
        if (aluno == null) {
            aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            aluno.setTurma(turma);
            if (da.insert(aluno)) {
                this.aluno = new Aluno();
                mensagem = "Inserido com sucesso";
                return true;
            } else {             
                return false;
            }
        }else{
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            aluno.setTurma(turma);
            if (da.edit(aluno)) {
                this.aluno = new Aluno();
                mensagem = "Editado com sucesso";
                return true;
            } else {             
                return false;
            }
        }
    }

    public boolean excluir(Aluno a) {
        if (da.remove(a)) {
            return true;
        } else {
            return false;
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DaoAluno getDa() {
        return da;
    }

    public void setDa(DaoAluno da) {
        this.da = da;
    }

    public List<Aluno> getAlunos() {
        preencherAlunos();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    

}
