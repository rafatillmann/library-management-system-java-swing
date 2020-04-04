package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Editora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ModelEditora extends AbstractTableModel{

    private List<Editora> editoras = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return editoras.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editora e = editoras.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return e.getId();
            }
            case 1:{
                return e.getNome();
            }        
            default: {
               return e.getCidade();
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
            default: {
               return "Cidade";
            }
        }
    }
    
    public void adicionarEditora(Editora e){
        editoras.add(e);
        fireTableRowsInserted(editoras.size() - 1, editoras.size() - 1);
    }
    
    public void removerEditora(int i){
        editoras.remove(i);
        fireTableRowsDeleted(i, i);    
    }
    
    public void atualizar(int i){
        fireTableRowsUpdated(i, i);
    }
    
    public Editora getEditora(int i){
        return editoras.get(i);
    }
    
}
