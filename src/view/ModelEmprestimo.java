package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Emprestimo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emprestimo
 */
public class ModelEmprestimo extends AbstractTableModel{

    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return emprestimos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo e = emprestimos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return e.getId();
            }
            case 1:{
                return e.getLivro().getTitulo();
            }     
            case 2:{
                return e.getAluno().getNome();
            }
            case 3:{
                return e.isDevolvido();
            }
            case 4:{
                return e.getData();
            }
            default: {
               return e.getDataDevolucao();
            }
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:{
                return "Id";
            }
            case 1:{
                return "Livro";
            } 
            case 2:{
                return "Aluno";
            }
            case 3:{
                return "Devolvido";
            }
            case 4:{
                return "Data";
            }
            default: {
               return "Data Devolução";
            }
        }
    }
    
    public void adicionarEmprestimo(Emprestimo e){
        emprestimos.add(e);
        fireTableRowsInserted(emprestimos.size() - 1, emprestimos.size() - 1);
    }
   
    public void removerEmprestimo(int i){
        emprestimos.remove(i);
        fireTableRowsDeleted(i, i);    
    }
    
    public void atualizarEmprestimo(int i){
        emprestimos.get(i).setDevolvido(true);
        fireTableRowsUpdated(i, i);
    }
    
    public void atualizar(int i){
        fireTableRowsUpdated(i, i);
    }
    
    public Emprestimo getEmprestimo(int i){
        return emprestimos.get(i);
    }
    
}

