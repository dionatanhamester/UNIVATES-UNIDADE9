/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Main;

import java.awt.Color;
import java.util.Vector;
import classes.Clientes;

import classes.Pedidos;
import classes.Produtos;
import util.CaixaDeDialogo;
import util.Uses;
import static view.formInicial.jframe_inicial;

/**
 *
 * @author Dionatan
 */
public class formVendas extends javax.swing.JInternalFrame {
    private final String _MODIFICACAO        = "modificacao";
    private final String _DEFAULT            = "default";
    private int rowItensPedidoDetalhesClick = -1;
    private Pedidos pedido = null;

    
    //private ItensPedido itensPedido = null;

    

    private Produtos produtoSelecionado = null;
    

    private Clientes cliente = null;
    
    private static CaixaDeDialogo mensagem;
    static int openFrameCount = 0;
    private String[] camposCombo = new String[1];
    private String[] ordenaCombo = new String[1];
    /**
     * Creates new form formVendas
     */
    public formVendas() {
         super("IFrame #" + (++openFrameCount),
                false, // resizable
                true, // closable
                false, // maximizable
                false);// iconifiable
        
        initComponents();
        Uses.center(this);
        carregaConfConsulta();     
        
        mensagem = CaixaDeDialogo.obterInstancia();

    }
    
    /**
     * Carreega as informações de Itens do Pedido no grid
     */
    private void carregaGridItensPedido(){
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.setSize(3);
        cabecalho.set(0, "Código");
        cabecalho.set(1, "Nome");
        cabecalho.set(2, "Preço");

        Vector<String> campos = new Vector<String>();
        campos.setSize(3);
        campos.set(0, "IP_PRODUTO");
        campos.set(1, "PR_NOME");
        campos.set(2, "IP_VALORTOTAL");
        
    }
    
    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDadosPedido() throws Exception{
                               
    }
    
    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDadosItens() throws Exception{
                                 
    }
    
    /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setDataPedidos(){          
       
    }
        /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setDataItensPedido(){     
       
    }
    /**
     * Retira todas as informações de dados que podem estar sendo apresentadas ao usuário
     */
    private void limpaTelaPedidos(){    
        Ed_Codigo.setText(""); 
        Ed_Cliente.setText(""); 
        Ed_NomCliente.setText(""); 
        Ed_Duracao.setText(""); 
        Ed_ProducaoTotal.setText(""); 
        Ed_PesoVivo.setText(""); 
        Ed_Lactantes.setText(""); 
        Ed_PreParto.setText(""); 
        Ed_Novilhas.setText(""); 
        Ed_Terneiras2.setText(""); 
        Ed_Terneiras6.setText(""); 
        Ed_FormasPgto.setText("");              
    }
    /**
     * Retira todas as informações de dados que podem estar sendo apresentadas ao usuário
     */
    private void limpaTelaItensPedido(){
        Ed_Produto.setText("");
        Ed_NomProduto.setText("");
        Ed_Quantidade.setText("");
        Ed_Tabela.setText("");
        Ed_NomFormaPgto.setText("");
        Ed_ValorUnit.setText(""); 
    }
    /**
     * Carrega o  JCombobox com as informações para pesquisa de dados
     */
     public void carregaConfConsulta()
    {
        String[] vStr = null;
        //função responsavel por carregar os campos da tela de consulta        
        camposCombo[0] = "Nome;CL_NOME";
        
        cbCampos.removeAllItems();
        for (int i = 0; i < camposCombo.length; i++)
        {
            vStr = camposCombo[i].split(";");
            cbCampos.addItem(vStr[0]);
        }

        //função responsavel por carregar os campos da tela de consulta        
        ordenaCombo[0] = "Nome;CL_NOME";

        cbOrdenacao.removeAllItems();
        for (int i = 0; i < ordenaCombo.length; i++)
        {
            vStr = ordenaCombo[i].split(";");
            cbOrdenacao.addItem(vStr[0]);
        }
    }
    
    /**
     * Verifica se os campos obrigatórios foram preenchidos
     * @return 
     */
    private boolean validarCamposTabelaPrecos(){
        boolean vReturn = true;
        
        if (Ed_Cliente.getText().toString().equals("")){
            Ed_Cliente.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Duracao.getText().toString().equals("")){
            Ed_Duracao.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_ProducaoTotal.getText().toString().equals("")){
            Ed_ProducaoTotal.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_PesoVivo.getText().toString().equals("")){
            Ed_PesoVivo.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Lactantes.getText().toString().equals("")){
            Ed_Lactantes.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_PreParto.getText().toString().equals("")){
            Ed_PreParto.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Novilhas.getText().toString().equals("")){
            Ed_Novilhas.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Terneiras2.getText().toString().equals("")){
            Ed_Terneiras2.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Terneiras6.getText().toString().equals("")){
            Ed_Terneiras6.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_FormasPgto.getText().toString().equals("")){
            Ed_FormasPgto.setBackground(Color.RED); 
            vReturn = false;
        }
        
        return vReturn;
    }
    
    
    /**
     * Ajusta a apresentação dos botoes de ação
     */
    private void arrumaBotoes(String estado)
    {
        //modificação quer dizer que a tabela vai estar em modo de edição ou inserção
        if (estado.equals(_MODIFICACAO))        {
            BotaoNovo.setEnabled(false);
            BotaoGrava.setEnabled(true);
            BotaoCancela.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoEditarDetalhes.setEnabled(false);
            BotaoEditarPedido.setEnabled(false);
            permiteEdicao(true);
        } else if (estado.equals(_DEFAULT)) {
            BotaoNovo.setEnabled(true);
            BotaoGrava.setEnabled(false);
            BotaoCancela.setEnabled(false);
            BotaoExcluir.setEnabled(true);
            BotaoEditarDetalhes.setEnabled(true);
            BotaoEditarPedido.setEnabled(false);
            permiteEdicao(false);
        }
    }
    
    /**
     * Ajusta a possibilidade de alteração das informações em determinado JTextField
     * @param vEstado 
     */
    private void permiteEdicao(boolean vEstado)
    {
        if (jTabbedPane.getSelectedIndex() == 0)/* Pedidos */{            
            Ed_Codigo.setEditable(vEstado);
            Ed_Cliente.setEditable(vEstado);
            Ed_NomCliente.setEditable(vEstado);
            Ed_Duracao.setEditable(vEstado); 
            Ed_ProducaoTotal.setEditable(vEstado); 
            Ed_PesoVivo.setEditable(vEstado);
            Ed_Lactantes.setEditable(vEstado);
            Ed_PreParto.setEditable(vEstado);
            Ed_Novilhas.setEditable(vEstado);
            Ed_Terneiras2.setEditable(vEstado);
            Ed_Terneiras6.setEditable(vEstado);
            Ed_FormasPgto.setEditable(vEstado);  
            F3_Cliente.setEnabled(vEstado);
            F3_FormaPgto.setEnabled(vEstado);
        } else if (jTabbedPane.getSelectedIndex() == 1)/*Itens do Pedido*/{                 
            Ed_Produto.setEditable(vEstado);
            Ed_NomProduto.setEditable(vEstado);
            Ed_Quantidade.setEditable(vEstado);
            Ed_Tabela.setEditable(vEstado);
            Ed_NomFormaPgto.setEditable(vEstado);
            Ed_ValorUnit.setEditable(vEstado);
            F3_Produtos.setEnabled(vEstado);
            F3_TabelaPreco.setEnabled(vEstado);
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
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        Ed_Codigo = new javax.swing.JTextField();
        Ed_Duracao = new javax.swing.JFormattedTextField();
        Ed_Lactantes = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Ed_Terneiras2 = new javax.swing.JFormattedTextField();
        BotaoEditarPedido = new javax.swing.JButton();
        Ed_Cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        F3_Cliente = new javax.swing.JButton();
        Ed_NomCliente = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Ed_ProducaoTotal = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        Ed_PesoVivo = new javax.swing.JFormattedTextField();
        jLabel37 = new javax.swing.JLabel();
        Ed_PreParto = new javax.swing.JFormattedTextField();
        jLabel38 = new javax.swing.JLabel();
        Ed_Novilhas = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        Ed_Terneiras6 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        Ed_FormasPgto = new javax.swing.JTextField();
        F3_FormaPgto = new javax.swing.JButton();
        Ed_NomFormaPgto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gridDetalhes = new javax.swing.JTable();
        Ed_Quantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Ed_Produto = new javax.swing.JTextField();
        F3_Produtos = new javax.swing.JButton();
        Ed_NomProduto = new javax.swing.JTextField();
        BotaoEditarDetalhes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Ed_ValorUnit = new javax.swing.JTextField();
        Ed_Tabela = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        F3_TabelaPreco = new javax.swing.JButton();

        setTitle("Cadastro de Vendas/Pedidos");
        setToolTipText("");

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
                .addComponent(BotaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoGrava, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(BotaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Consulta", jPanel5);

        jPanel7.setPreferredSize(new java.awt.Dimension(672, 370));

        jLabel22.setText("Código");

        Ed_Codigo.setEditable(false);

        Ed_Duracao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_DuracaoFocusLost(evt);
            }
        });

        Ed_Lactantes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_LactantesFocusLost(evt);
            }
        });

        jLabel27.setText("Duração");

        jLabel28.setText("Lactantes ( Un )");

        jLabel33.setText("Terneiras ( 2 Meses )");

        Ed_Terneiras2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_Terneiras2FocusLost(evt);
            }
        });

        BotaoEditarPedido.setText("Editar");
        BotaoEditarPedido.setFocusable(false);
        BotaoEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarPedidoActionPerformed(evt);
            }
        });

        Ed_Cliente.setEditable(false);
        Ed_Cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_ClienteFocusLost(evt);
            }
        });

        jLabel1.setText("Cliente");

        F3_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisar.png"))); // NOI18N
        F3_Cliente.setEnabled(false);
        F3_Cliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                F3_ClienteAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        F3_Cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                F3_ClienteFocusLost(evt);
            }
        });
        F3_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3_ClienteActionPerformed(evt);
            }
        });

        Ed_NomCliente.setEditable(false);
        Ed_NomCliente.setBackground(new java.awt.Color(153, 153, 153));
        Ed_NomCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel35.setText("Produção Total ( Lts )");

        Ed_ProducaoTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_ProducaoTotalFocusLost(evt);
            }
        });

        jLabel36.setText("Peso  Vivo ( Kg )");

        Ed_PesoVivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_PesoVivoFocusLost(evt);
            }
        });

        jLabel37.setText("Pré-Parto ( Un )");

        Ed_PreParto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_PrePartoFocusLost(evt);
            }
        });

        jLabel38.setText("Novilhas ( Un )");

        Ed_Novilhas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_NovilhasFocusLost(evt);
            }
        });

        jLabel34.setText("Terneiras ( 6 Meses )");

        Ed_Terneiras6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_Terneiras6FocusLost(evt);
            }
        });

        jLabel2.setText("Forma Pgto");

        Ed_FormasPgto.setEditable(false);
        Ed_FormasPgto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_FormasPgtoFocusLost(evt);
            }
        });

        F3_FormaPgto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisar.png"))); // NOI18N
        F3_FormaPgto.setEnabled(false);
        F3_FormaPgto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                F3_FormaPgtoFocusLost(evt);
            }
        });
        F3_FormaPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3_FormaPgtoActionPerformed(evt);
            }
        });

        Ed_NomFormaPgto.setEditable(false);
        Ed_NomFormaPgto.setBackground(new java.awt.Color(153, 153, 153));
        Ed_NomFormaPgto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel22))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel27)))
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ed_Duracao, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(Ed_Cliente)
                            .addComponent(Ed_Codigo)
                            .addComponent(Ed_Lactantes)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ed_FormasPgto, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(Ed_Terneiras2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Ed_PreParto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(Ed_Terneiras6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_ProducaoTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Ed_Novilhas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Ed_PesoVivo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel34)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(F3_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ed_NomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(F3_FormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ed_NomFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ed_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(Ed_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel27))
                            .addComponent(Ed_Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(Ed_Lactantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(F3_Cliente)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(Ed_NomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(Ed_ProducaoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(Ed_PesoVivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_PreParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(Ed_Novilhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ed_Terneiras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(Ed_Terneiras6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(F3_FormaPgto)
                        .addComponent(Ed_FormasPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Ed_NomFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );

        jTabbedPane.addTab("Pedido", jPanel7);

        gridDetalhes.setModel(new javax.swing.table.DefaultTableModel(
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
        gridDetalhes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridDetalhesMouseClicked(evt);
            }
        });
        gridDetalhes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gridDetalhesPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(gridDetalhes);

        Ed_Quantidade.setEditable(false);

        jLabel3.setText("Quant");

        jLabel4.setText("Produto");

        Ed_Produto.setEditable(false);
        Ed_Produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_ProdutoFocusLost(evt);
            }
        });

        F3_Produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisar.png"))); // NOI18N
        F3_Produtos.setEnabled(false);
        F3_Produtos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                F3_ProdutosFocusLost(evt);
            }
        });
        F3_Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3_ProdutosActionPerformed(evt);
            }
        });

        Ed_NomProduto.setEditable(false);
        Ed_NomProduto.setBackground(new java.awt.Color(153, 153, 153));
        Ed_NomProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        BotaoEditarDetalhes.setText("Editar");
        BotaoEditarDetalhes.setFocusable(false);
        BotaoEditarDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarDetalhesActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor");

        Ed_ValorUnit.setEditable(false);

        Ed_Tabela.setEditable(false);
        Ed_Tabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_TabelaFocusLost(evt);
            }
        });

        jLabel6.setText("Tabela");

        F3_TabelaPreco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisar.png"))); // NOI18N
        F3_TabelaPreco.setEnabled(false);
        F3_TabelaPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                F3_TabelaPrecoFocusLost(evt);
            }
        });
        F3_TabelaPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3_TabelaPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Ed_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F3_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Ed_Quantidade))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(Ed_ValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Ed_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F3_TabelaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(Ed_NomProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(BotaoEditarDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(Ed_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(F3_Produtos))
                                .addGap(3, 3, 3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Ed_NomProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(BotaoEditarDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ed_Tabela)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(F3_TabelaPreco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ed_ValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.addTab("Itens Pedido", jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Cadastro", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
                            
        if (jTabbedPane.getSelectedIndex() == 0)/*Pedidos*/{            
          pedido = new Pedidos();          
          limpaTelaPedidos();  
          Tab_Selecao.setSelectedIndex(1);
          Ed_Cliente.grabFocus();
          
        } else if (jTabbedPane.getSelectedIndex() == 1)/*Itens Pedido*/{
          //  itensPedido = new ItensPedido();
            
            
            limpaTelaItensPedido();
            Ed_Produto.grabFocus();
        }
        
        arrumaBotoes(_MODIFICACAO);
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGravaActionPerformed
       
        if (jTabbedPane.getSelectedIndex() == 0)/*Tabela de Preços*/{
            if (! validarCamposTabelaPrecos() ){
                
                mensagem.exibirMensagem(jframe_inicial,"Todos os campos obrigatórios devem ser preenchidos. Verifique!",'i');
            
            } else { //Segue com o salvar dados.
                try {               
                    salvarDadosPedido();
                
                    mensagem.exibirMensagem(jframe_inicial,"Registro gravado com sucesso",'i');
                   
                    arrumaBotoes(_DEFAULT);
                    BotaoNovo.grabFocus();
                } catch (Exception e) {

                    System.out.println(e.getMessage());

                    mensagem.exibirMensagem(jframe_inicial, "Não foi possível gravar as informações. Tente novamente mais tarde!", 'e');
                }                              
            }
        } else if (jTabbedPane.getSelectedIndex() == 1)/*Tabela de Preços - Detalhes*/{
            try {               
                    salvarDadosItens();
                
                    mensagem.exibirMensagem(jframe_inicial,"Registro gravado com sucesso",'i');
                    carregaGridItensPedido();
                    arrumaBotoes(_DEFAULT);
                    limpaTelaItensPedido();
                    BotaoNovo.grabFocus();
                } catch (Exception e) {

                    System.out.println(e.getMessage());

                    mensagem.exibirMensagem(jframe_inicial, "Não foi possível gravar as informações. Tente novamente mais tarde!", 'e');
                }  
        }  
    }//GEN-LAST:event_BotaoGravaActionPerformed

    private void BotaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelaActionPerformed
        arrumaBotoes(_DEFAULT);
        
        
        if (jTabbedPane.getSelectedIndex() == 0)/*Pedidos*/{            
            setDataPedidos();
        } else if (jTabbedPane.getSelectedIndex() == 0)/*Itens Pedido*/{                 
            
        }
    }//GEN-LAST:event_BotaoCancelaActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed

        if (mensagem.pedirConfirmacao(jframe_inicial,"Você deseja mesmo excluir o registro?") == true)
        {
            try{
                if (jTabbedPane.getSelectedIndex() == 0)/*Pedidos*/{
                                                         
                    
                    carregaGridItensPedido();
                    pedido = null;
                    
                    limpaTelaPedidos();
                    
                    arrumaBotoes(_DEFAULT);    
                } else if (jTabbedPane.getSelectedIndex() == 1)/*Itens Pedido*/{
                    
                }
           } catch (Exception erro){
                mensagem.exibirMensagem(jframe_inicial,"Erro ao excluir a filial.Verifique" + erro.getMessage(),'e');
            }
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void gridConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridConsultaMouseClicked
       
    }//GEN-LAST:event_gridConsultaMouseClicked

    /**
     * Busca todas as informações dos produtos que compoem o pedido
     */
    private void getItensPedido_Produto(){
                      
                
    }
    
    private void gridConsultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridConsultaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_gridConsultaPropertyChange

    private void BotaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultaActionPerformed

        Vector<String> cabecalho = new Vector<String>();
        cabecalho.setSize(2);
        cabecalho.set(0, "Pedido");
        cabecalho.set(1, "Cliente");

        Vector<String> campos = new Vector<String>();
        campos.setSize(2);
        campos.set(0, "PE_PEDIDO");
        campos.set(1, "CL_NOME");

    }//GEN-LAST:event_BotaoConsultaActionPerformed

    private void Ed_LactantesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_LactantesFocusLost
        Ed_Lactantes.setBackground(Color.WHITE);
    }//GEN-LAST:event_Ed_LactantesFocusLost

    private void Ed_Terneiras2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_Terneiras2FocusLost
        Ed_Terneiras2.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_Terneiras2FocusLost

    private void BotaoEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarPedidoActionPerformed
        arrumaBotoes(_MODIFICACAO);
    }//GEN-LAST:event_BotaoEditarPedidoActionPerformed

    private void Ed_ClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_ClienteFocusLost
        Ed_Cliente.setBackground(Color.WHITE);
        buscaClienteAposF3();
    }//GEN-LAST:event_Ed_ClienteFocusLost
    /*
    * Busca as informações de Cliente - Para seleção
    */
    private void buscaClienteAposF3(){
        try{            
            if (! Main.vValorPesquisa.equals("")){
                Ed_Cliente.setText(Main.vValorPesquisa);                                
                //zera a variavel;
                Main.vValorPesquisa = "";
            }
            if (!Ed_Cliente.getText().toString().trim().equals("")){
                
                
                
            } else {
                cliente = null;                        
            }                                   
        } catch (Exception e){
            mensagem.exibirMensagem(jframe_inicial,"Ocorreu um erro durante a localização do produto.Verifique!" + "\n" + e.getMessage(), 'e');            
        }
    }
    
    /**
     * usca as infromações de  Formas de Pagamento - Para Seleção
     */
    private void buscaFormaPagamentoAposF3(){

    }
    
    /**
     * Busca as informações de  produto - Para seleção
     */
    private void buscaProdutoAposF3(){
        
    }
    
    /**
     * Busca as informações para Tabela de Preços - Para Seleção
     */
    private void buscaTabelaPrecoAposF3(){
    
    }
    private void F3_ClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_ClienteFocusLost

    }//GEN-LAST:event_F3_ClienteFocusLost

    private void F3_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_ClienteActionPerformed
        String vSQL = "select * from clientes where cl_codigo is not null";        
                       
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.setSize(2);
        cabecalho.set(0, "Código");
        cabecalho.set(1, "Nome");

        Vector<String> campos = new Vector<String>();
        campos.setSize(2);
        campos.set(0, "CL_CODIGO");
        campos.set(1, "CL_NOME");

      //  Uses.ChamaTelaPesquisa(Ed_Cliente, cabecalho, campos, vSQL);              
    }//GEN-LAST:event_F3_ClienteActionPerformed

    private void Ed_PrePartoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_PrePartoFocusLost
        Ed_PreParto.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_PrePartoFocusLost

    private void Ed_NovilhasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_NovilhasFocusLost
        Ed_Novilhas.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_NovilhasFocusLost

    private void Ed_Terneiras6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_Terneiras6FocusLost
        Ed_Terneiras6.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_Terneiras6FocusLost

    private void Ed_FormasPgtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_FormasPgtoFocusLost
        Ed_FormasPgto.setBackground(Color.WHITE);        // TODO add your handling code here:
        buscaFormaPagamentoAposF3();
    }//GEN-LAST:event_Ed_FormasPgtoFocusLost

    private void F3_FormaPgtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_FormaPgtoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_F3_FormaPgtoFocusLost

    private void F3_FormaPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_FormaPgtoActionPerformed
        String vSQL = "select * from formaspgto where fp_codigo is not null";        
                       
        Vector<String> cabecalho = new Vector<String>();
        cabecalho.setSize(2);
        cabecalho.set(0, "Código");
        cabecalho.set(1, "Descrição");

        Vector<String> campos = new Vector<String>();
        campos.setSize(2);
        campos.set(0, "FP_CODIGO");
        campos.set(1, "FP_DESCRICAO");

    //    Uses.ChamaTelaPesquisa(Ed_FormasPgto,cabecalho, campos, vSQL); 
    }//GEN-LAST:event_F3_FormaPgtoActionPerformed

    private void gridDetalhesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridDetalhesMouseClicked
        rowItensPedidoDetalhesClick = gridDetalhes.getSelectedRow();
        getItensPedido_Produto();
    }//GEN-LAST:event_gridDetalhesMouseClicked

    private void gridDetalhesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridDetalhesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_gridDetalhesPropertyChange

    private void Ed_ProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_ProdutoFocusLost
        Ed_Produto.setBackground(Color.WHITE);
        buscaProdutoAposF3();
    }//GEN-LAST:event_Ed_ProdutoFocusLost

    private void F3_ProdutosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_ProdutosFocusLost

    }//GEN-LAST:event_F3_ProdutosFocusLost

    private void F3_ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_ProdutosActionPerformed
        String vSQL = "select * from produtos where pr_codigo is not null";

        Vector<String> cabecalho = new Vector<String>();
        cabecalho.setSize(2);
        cabecalho.set(0, "Código");
        cabecalho.set(1, "Nome");

        Vector<String> campos = new Vector<String>();
        campos.setSize(2);
        campos.set(0, "PR_CODIGO");
        campos.set(1, "PR_NOME");

        
    }//GEN-LAST:event_F3_ProdutosActionPerformed

    private void BotaoEditarDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarDetalhesActionPerformed
            
    }//GEN-LAST:event_BotaoEditarDetalhesActionPerformed

    private void Ed_TabelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_TabelaFocusLost
        
    }//GEN-LAST:event_Ed_TabelaFocusLost

    private void F3_TabelaPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_TabelaPrecoFocusLost

    }//GEN-LAST:event_F3_TabelaPrecoFocusLost

    private void F3_TabelaPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_TabelaPrecoActionPerformed
        
    }//GEN-LAST:event_F3_TabelaPrecoActionPerformed

    private void Ed_DuracaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_DuracaoFocusLost
        Ed_Duracao.setBackground(Color.WHITE);
    }//GEN-LAST:event_Ed_DuracaoFocusLost

    private void Ed_ProducaoTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_ProducaoTotalFocusLost
        Ed_ProducaoTotal.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_ProducaoTotalFocusLost

    private void Ed_PesoVivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_PesoVivoFocusLost
        Ed_PesoVivo.setBackground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_PesoVivoFocusLost

    private void F3_ClienteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_F3_ClienteAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_F3_ClienteAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancela;
    private javax.swing.JButton BotaoConsulta;
    private javax.swing.JButton BotaoEditarDetalhes;
    private javax.swing.JButton BotaoEditarPedido;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoGrava;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JTextField Ed_Cliente;
    private javax.swing.JTextField Ed_Codigo;
    private javax.swing.JTextField Ed_Consulta;
    private javax.swing.JFormattedTextField Ed_Duracao;
    private javax.swing.JTextField Ed_FormasPgto;
    private javax.swing.JFormattedTextField Ed_Lactantes;
    private javax.swing.JTextField Ed_NomCliente;
    private javax.swing.JTextField Ed_NomFormaPgto;
    private javax.swing.JTextField Ed_NomProduto;
    private javax.swing.JFormattedTextField Ed_Novilhas;
    private javax.swing.JFormattedTextField Ed_PesoVivo;
    private javax.swing.JFormattedTextField Ed_PreParto;
    private javax.swing.JFormattedTextField Ed_ProducaoTotal;
    private javax.swing.JTextField Ed_Produto;
    private javax.swing.JTextField Ed_Quantidade;
    private javax.swing.JTextField Ed_Tabela;
    private javax.swing.JFormattedTextField Ed_Terneiras2;
    private javax.swing.JFormattedTextField Ed_Terneiras6;
    private javax.swing.JTextField Ed_ValorUnit;
    private javax.swing.JButton F3_Cliente;
    private javax.swing.JButton F3_FormaPgto;
    private javax.swing.JButton F3_Produtos;
    private javax.swing.JButton F3_TabelaPreco;
    private javax.swing.JTabbedPane Tab_Selecao;
    private javax.swing.JComboBox cbCampos;
    private javax.swing.JComboBox cbOrdenacao;
    private javax.swing.JTable gridConsulta;
    private javax.swing.JTable gridDetalhes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
