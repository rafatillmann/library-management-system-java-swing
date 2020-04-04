/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.DaoEditora;
import model.Editora;

/**
 *
 * @author tillm
 */
public class ControlEditora {

    private Editora editora;
    private DaoEditora de;
    private List<Editora> editoras;
    private static ControlEditora instancia;
    private String mensagem;
    
    public static ControlEditora getInstancia(){
        if(instancia == null){
            instancia = new ControlEditora();
            return instancia;
        }else{
            return instancia;
        }
    }

    private ControlEditora() {
        this.editora = null;
        this.de = new DaoEditora();
        this.editoras = new ArrayList<>();
        preencherEditoras();
    }

    public void preencherEditoras() {
        editoras.clear();
        for (Editora e : de.list()) {
            editoras.add(e);
        }
    }

    public boolean gravar(String nome, String cidade) {
        if (editora == null) {
            editora = new Editora();
            editora.setNome(nome);
            editora.setCidade(cidade);
            if (de.insert(editora)) {
                this.editora = new Editora();
                mensagem = "Inserido com sucesso";
                return true;
            } else {
                return false;
            }
        }else{
            editora.setCidade(cidade);
            editora.setNome(nome);
            if (de.edit(editora)) {
                this.editora = new Editora();
                mensagem = "Editado com sucesso";
                return true;
            } else {
                return false;
            }
        }

    }

    public boolean excluir(Editora e) {

        if (de.remove(e)) {
            this.editora = new Editora();
            return true;
        } else {
            return false;
        }
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public DaoEditora getDe() {
        return de;
    }

    public void setDe(DaoEditora de) {
        this.de = de;
    }

    public List<Editora> getEditoras() {
        preencherEditoras();
        return editoras;
    }

    public void setEditoras(List<Editora> editoras) {
        this.editoras = editoras;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    

}
