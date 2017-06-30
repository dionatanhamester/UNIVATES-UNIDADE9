/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Main;
import classes.Formaspgto;
import classes.FormaspgtoId;
import classes.Grupos;
import controller.FormasPgtoDAO;
import controller.GruposDAO;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import util.CaixaDeDialogo;
import util.Uses;
import static view.formInicial.jframe_inicial;

/**
 *
 * @author Dionatan
 */
public class formFormasPgto extends javax.swing.JInternalFrame {
    private final String _MODIFICACAO = "modificacao";
    private final String _DEFAULT     = "default";
    
    private FormasPgtoDAO formaspgtoDAO = new FormasPgtoDAO();    
    private Formaspgto formapgto = null;
    
    private static CaixaDeDialogo mensagem;
    static int openFrameCount = 0;
    private String[] camposCombo = new String[1];
    private String[] ordenaCombo = new String[1];
    
    /**
     * Creates new form formFormasPgto
     */
    public formFormasPgto() {
        super("IFrame #" + (++openFrameCount),
                false, // resizable
                true, // closable
                false, // maximizable
                false);// iconifiable
        
        
        initComponents();
        Uses.center(this);
        carregaConfConsulta();     
        
        mensagem = CaixaDeDialogo.obterInstancia();
                        
        //Cria um model do Spinner para limitar os valores minimo e máximo
        SpinnerModel sm = new SpinnerNumberModel(1, 1, 100, 1);
        jSpVezes.setModel(sm); 
    }

    /**
     * Carrega o  JCombobox com as informações para pesquisa de dados
     */
     public void carregaConfConsulta(){
        String[] vStr = null;
        //função responsavel por carregar os campos da tela de consulta
        camposCombo[0] = "Descrição;FPDESCRICAO";
                        
        cbCampos.removeAllItems();
        for (int i = 0; i < camposCombo.length; i++)
        {
            vStr = camposCombo[i].split(";");
            cbCampos.addItem(vStr[0]);
        }

        //função responsavel por carregar os campos da tela de consulta
        ordenaCombo[0] = "Descrição;FPDESCRICAO";
                
        cbOrdenacao.removeAllItems();
        for (int i = 0; i < ordenaCombo.length; i++)
        {
            vStr = ordenaCombo[i].split(";");
            cbOrdenacao.addItem(vStr[0]);
        }
    }    
     
      /**
     * Ajusta a apresentação dos botoes de ação
     */
     private void arrumaBotoes(String estado){
        //modificação quer dizer que a tabela vai estar em modo de edição ou inserção
        if (estado.equals(_MODIFICACAO)){ // Consiste na Inserção e Alteração dos registros
            BotaoNovo.setEnabled(false);
            BotaoGrava.setEnabled(true);
            BotaoCancela.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoEditar.setEnabled(false);
            permiteEdicao(true);
        } else if (estado.equals(_DEFAULT)) {
            BotaoNovo.setEnabled(true);
            BotaoGrava.setEnabled(false);
            BotaoCancela.setEnabled(false);
            BotaoExcluir.setEnabled(true);
            BotaoEditar.setEnabled(true);
            permiteEdicao(false);
        }
    }
     
    /**
     * Ajusta a possibilidade de alteração das informações em determinado JTextField
     * @param vEstado 
     */
     private void permiteEdicao(boolean vEstado) {
        Ed_Descricao.setEditable(vEstado);       
        jSpVezes.setEnabled(vEstado);       
    }
     
     /**
     * Retira todas as informações de dados que podem estar sendo apresentadas ao usuário
     */
    private void limpaTela(){        
        Ed_Descricao.setText("");      
        jSpVezes.setValue(1);
    }
    
    /**
     * Verifica se os campos obrigatórios foram preenchidos
     * @return 
     */
    private boolean validarCampos(){
        boolean vReturn = true;
        if (Ed_Descricao.getText().toString().equals("")){
            Ed_Descricao.setBackground(Color.RED);    
            vReturn = false;
        }                 
        
        return vReturn;
    }
    
    /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setData(){        
        Ed_Descricao.setText(formapgto.getFpdescricao());    
        jSpVezes.setValue(formapgto.getFpnrovezes());
    }
    
    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDados() throws Exception{                
        formapgto.setFpdescricao(Ed_Descricao.getText().trim());      
        formapgto.setFpnrovezes(Integer.valueOf(jSpVezes.getValue().toString()));
        formapgto.setFpdataatu(new Date());
        formapgto.setFphoraatu(new Date());        
        if (formapgto.getId() == null){
            FormaspgtoId idformas = new FormaspgtoId(Main.empresaSelecionada.getEmcodigo(), formaspgtoDAO.getAutoIncrement());
            
            formapgto.setId(idformas);                                   
            formaspgtoDAO.Insert(formapgto);
        } else {
            formaspgtoDAO.Update(formapgto);
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

        jPanel8 = new javax.swing.JPanel();
        BotaoNovo = new javax.swing.JButton();
        BotaoGrava = new javax.swing.JButton();
        BotaoCancela = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        Tab_Selecao = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridConsulta = new javax.swing.JTable();
        cbCampos = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbOrdenacao = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Ed_Consulta = new javax.swing.JTextField();
        BotaoConsulta = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Ed_Descricao = new javax.swing.JTextField();
        BotaoEditar = new javax.swing.JButton();
        jSpVezes = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();

        setTitle("Formas de Pagamento");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotaoNovo.setText("Novo");
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoGrava.setText("Gravar");
        BotaoGrava.setEnabled(false);
        BotaoGrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGravaActionPerformed(evt);
            }
        });

        BotaoCancela.setText("Cancelar");
        BotaoCancela.setEnabled(false);
        BotaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelaActionPerformed(evt);
            }
        });

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(BotaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoGrava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(206, 206, 206))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BotaoNovo)
                .addComponent(BotaoGrava, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridConsultaMouseClicked(evt);
            }
        });
        gridConsulta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gridConsultaPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(gridConsulta);

        cbCampos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel10.setText("Campo");

        cbOrdenacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel20.setText("Ordenação");

        jLabel21.setText("Consulta");

        BotaoConsulta.setText("Consultar");
        BotaoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(Ed_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(BotaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Consulta", jPanel5);

        jPanel7.setPreferredSize(new java.awt.Dimension(672, 370));

        jLabel23.setText("Descrição");

        Ed_Descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_DescricaoFocusLost(evt);
            }
        });

        BotaoEditar.setText("Editar");
        BotaoEditar.setFocusable(false);
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        jLabel24.setText("Nro Vezes");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Ed_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSpVezes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(Ed_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpVezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cadastramento", jPanel7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Cadastro", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        //Instancia o objeto grupos
        formapgto = new Formaspgto();
        arrumaBotoes(_MODIFICACAO);
        limpaTela();
        Tab_Selecao.setSelectedIndex(1);
        Ed_Descricao.grabFocus();
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGravaActionPerformed
        if (! validarCampos() ){
            mensagem.exibirMensagem(jframe_inicial,"Todos os campos obrigatórios devem ser preenchidos. Verifique!",'i');
        } else { //Segue com o salvar dados.
            try {
                salvarDados();
                mensagem.exibirMensagem(jframe_inicial,"Registro gravado com sucesso",'i');
                arrumaBotoes(_DEFAULT);
                BotaoNovo.grabFocus();
            } catch (Exception e) {

                System.out.println(e.getMessage());

                mensagem.exibirMensagem(jframe_inicial, "Não foi possível gravar as informações. Tente novamente mais tarde!", 'e');
            }

        }
    }//GEN-LAST:event_BotaoGravaActionPerformed

    private void BotaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelaActionPerformed
        arrumaBotoes(_DEFAULT);

        if (formapgto != null){
            setData();
        }
    }//GEN-LAST:event_BotaoCancelaActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        if (mensagem.pedirConfirmacao(jframe_inicial,"Você deseja mesmo excluir o registro?") == true){
            try
            {
                formaspgtoDAO.Delete(formapgto);
                formapgto = null;

                limpaTela();
                arrumaBotoes(_DEFAULT);
            } catch (Exception erro){
                mensagem.exibirMensagem(jframe_inicial,"Erro ao excluir a forma de pagamento.Verifique" + erro.getMessage(),'e');
            }
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void gridConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridConsultaMouseClicked
        if (evt.getClickCount() == 2){
            int row = gridConsulta.getSelectedRow();

            if (row < 0){
                return;
            } else{
                //Posiciona certo no registro que o usuario clicou
                try{
                    String sql = "FROM Formaspgto where fpcodigo = " + gridConsulta.getValueAt(row, 0).toString() + "";
                    List<Formaspgto> listFormasPgto = formaspgtoDAO.consultaSQL(sql);

                    if (listFormasPgto.size() > 0){
                        this.formapgto = listFormasPgto.get(0);
                        this.setData();
                        Tab_Selecao.setSelectedIndex(1);
                        arrumaBotoes(_DEFAULT);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_gridConsultaMouseClicked

    private void gridConsultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridConsultaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_gridConsultaPropertyChange

    private void BotaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultaActionPerformed
        //Monta a SQL para trazer os dados
        String[] vCampo = camposCombo[cbCampos.getSelectedIndex()].split(";");

        String vSQL = "FROM Formaspgto where fpcodigo is not null and fpempresa = " + String.valueOf(Main.empresaSelecionada.getEmcodigo());

        String vStr = Ed_Consulta.getText().trim();
        if (Ed_Consulta.getText().length() > 0){
            vSQL = vSQL + " AND UPPER(" + vCampo[1] + ") LIKE '%" + Ed_Consulta.getText().trim().toUpperCase() + "%' ";
        }

        String[] vOrdem = ordenaCombo[cbOrdenacao.getSelectedIndex()].split(";");
        vSQL = vSQL + "ORDER BY " + vOrdem[1];

        Uses.popularTabela(gridConsulta, vSQL, Formaspgto.class);

    }//GEN-LAST:event_BotaoConsultaActionPerformed

    private void Ed_DescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_DescricaoFocusLost
        if (Ed_Descricao.isEditable()){
            Ed_Descricao.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Ed_DescricaoFocusLost

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        arrumaBotoes(_MODIFICACAO);
    }//GEN-LAST:event_BotaoEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancela;
    private javax.swing.JButton BotaoConsulta;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoGrava;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JTextField Ed_Consulta;
    private javax.swing.JTextField Ed_Descricao;
    private javax.swing.JTabbedPane Tab_Selecao;
    private javax.swing.JComboBox cbCampos;
    private javax.swing.JComboBox cbOrdenacao;
    private javax.swing.JTable gridConsulta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpVezes;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
