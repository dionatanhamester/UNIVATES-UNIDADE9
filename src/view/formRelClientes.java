/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Main;
import classes.Clientes;
import controller.ClientesDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import reportclasses.RelClientes;
import util.CaixaDeDialogo;
import util.Uses;
import static view.formInicial.jDesktopPane1;



/**
 *
 * @author Dionatan
 */
public class formRelClientes extends javax.swing.JInternalFrame {
    private static CaixaDeDialogo mensagem;
    static int openFrameCount = 0;  
    /**
     * Creates new form formRelClientes
     */
    public formRelClientes() {
        super("IFrame #" + (++openFrameCount),
                false, // resizable
                true, // closable
                false, // maximizable
                false);// iconifiable
        
        initComponents();
        Uses.center(this);
        
        mensagem = CaixaDeDialogo.obterInstancia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGeraRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtFiltroNome = new javax.swing.JTextField();

        setTitle("Relatório de Clientes");

        btnGeraRelatorio.setText("Gerar Relatório");
        btnGeraRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeraRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Filtros de Clientes");

        jLabel2.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGeraRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(edtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeraRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeraRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeraRelatorioActionPerformed
                                
        String vSQL = "FROM Clientes where clcodigo is not null ";                
        if (edtFiltroNome.getText().length() > 0){
            vSQL = vSQL + " AND UPPER(CLNOME) LIKE '%" + edtFiltroNome.getText().trim().toUpperCase() + "%' ";
        }        
        vSQL = vSQL + " ORDER BY CLNOME";
        
        ClientesDAO clientesDAO     = new ClientesDAO();
        List<Clientes> listClientes = clientesDAO.consultaSQL(vSQL);
        List<RelClientes> listRel   = new ArrayList<RelClientes>();
        
        for (int i = 0; i < listClientes.size() ; i++){                    
            RelClientes rel = new RelClientes();
            rel.setEmrazaosocial(Main.empresaSelecionada.getEmrazaosocial());
            rel.setEmfantasia(Main.empresaSelecionada.getEmfantasia());
            rel.setEmcidade(Main.empresaSelecionada.getEmcidade());
            rel.setEmcnpj(Main.empresaSelecionada.getEmcnpj());
            rel.setEmuf(Main.empresaSelecionada.getEmuf());
            rel.setClmatricula(listClientes.get(i).getClmatricula());
            rel.setClnome(listClientes.get(i).getClnome());
            rel.setClcidade(listClientes.get(i).getClcidade());
            rel.setCluf(listClientes.get(i).getCluf());
            rel.setClfone(listClientes.get(i).getClfone());
            rel.setClemail(listClientes.get(i).getClemail());
        
            listRel.add(rel);
        }                        
        JasperPrint jpPrint = null;
        try {
            jpPrint = JasperFillManager.fillReport("iReport/RelatorioClientes.jasper", new HashMap(), new JRBeanCollectionDataSource(listRel));
            JasperViewer jpViewer = new JasperViewer(jpPrint , false); //false - não encerra a aplicação ao fechar a janela                       
            jpViewer.setVisible(true);
            jpViewer.toFront(); //apresenta o relatório acima das outras janelas            
            jpViewer.setAlwaysOnTop(true);            
        } catch (JRException ex) {
            Logger.getLogger(formRelClientes.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnGeraRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeraRelatorio;
    private javax.swing.JTextField edtFiltroNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
