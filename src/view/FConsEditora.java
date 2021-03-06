package view;

import control.ControlEditora;
import javax.swing.JOptionPane;
import model.Editora;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tillm
 */
public class FConsEditora extends javax.swing.JDialog {

    /**
     * Creates new form FConsEditora
     */
    public FConsEditora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarEditoras();
    }
    
    public void carregarEditoras(){
        for(Editora e: controlEditora.getEditoras()){
            modelEditora.adicionarEditora(e);
        }
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEditoras = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbEditoras.setModel(modelEditora);
        jScrollPane1.setViewportView(tbEditoras);

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linha = tbEditoras.getSelectedRow();
        if(linha >=0){
            if(controlEditora.excluir(modelEditora.getEditora(linha))){
                modelEditora.removerEditora(linha);
                JOptionPane.showMessageDialog(this, "Excluido com sucesso");
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao excluir");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um registro");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linha = tbEditoras.getSelectedRow();
        if(linha >=0){
            Editora e = modelEditora.getEditora(linha);
            controlEditora.setEditora(e);
            FCadCadastro telaEditora = new FCadCadastro(null, true);
            telaEditora.carregarCampos(e);
            telaEditora.setVisible(true);
            modelEditora.atualizar(linha);
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um registro");
        }
    }//GEN-LAST:event_btEditarActionPerformed

       
    
    /**
     * @param args the command line arguments
     */
    
    private ModelEditora modelEditora = new ModelEditora();
    private ControlEditora controlEditora = ControlEditora.getInstancia();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEditoras;
    // End of variables declaration//GEN-END:variables
}
