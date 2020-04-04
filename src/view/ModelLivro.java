package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Livro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ModelLivro extends AbstractTableModel{

    private List<Livro> livros = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro l = livros.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return l.getId();
            }
            case 1:{
                return l.getNumeroPag();
            }     
            case 2:{
                return l.getTitulo();
            }
            case 3:{
                return l.getAutores();
            }
            default: {
               return l.getEditora().getNome();
            }
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:{
                return "Id";
            }
            case 1:{
                return "Numero de Páginas";
            } 
            case 2:{
                return "Titulo";
            }
            case 3:{
                return "Autores";
            }
            default: {
               return "Editora";
            }
        }
    }
    
    public void adicionarLivro(Livro l){
        livros.add(l);
        fireTableRowsInserted(livros.size() - 1, livros.size() - 1);
    }
    
    public void removerLivro(int i){
        livros.remove(i);
        fireTableRowsDeleted(i, i);    
    }
    
    public void atualizar(int i){
        fireTableRowsUpdated(i, i);
    }
    
    public Livro getLivro(int i){
        return livros.get(i);
    }
    
}
