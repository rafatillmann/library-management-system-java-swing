package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ModelAluno extends AbstractTableModel{

    private List<Aluno> alunos = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno a = alunos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return a.getId();
            }
            case 1:{
                return a.getNome();
            }     
            case 2:{
                return a.getMatricula();
            }
            default: {
               return a.getTurma();
            }
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:{
                return "Id";
            }
            case 1:{
                return "Nome";
            } 
            case 2:{
                return "Matricula";
            }
            default: {
               return "Turma";
            }
        }
    }
    
    public void adicionarAluno(Aluno a){
        alunos.add(a);
        fireTableRowsInserted(alunos.size() - 1, alunos.size() - 1);
    }
    
    public void removerAluno(int i){
        alunos.remove(i);
        fireTableRowsDeleted(i, i);    
    }
    
    public void atualizar(int i){
        fireTableRowsUpdated(i, i);
    }
    
    public Aluno getAluno(int i){
        return alunos.get(i);
    }
    
}
