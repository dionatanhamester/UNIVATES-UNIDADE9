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
import classes.Formaspgto;
import classes.Itenspedido;
import classes.ItenspedidoId;
import java.util.List;
import classes.Pedidos;
import classes.PedidosId;
import classes.Produtos;
import classes.Tabelaprecos;
import classes.Tabelaprecosdetalhes;
import controller.FormasPgtoDAO;
import controller.ClientesDAO;
import controller.PedidosDAO;
import controller.ProdutosDAO;
import controller.ItensPedidoDAO;
import controller.TabelaPrecosDetalhesDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
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
    private PedidosDAO pedidosDAO = new PedidosDAO();
    
    private Itenspedido itensPedido       = null;
    private ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
        
    private Tabelaprecosdetalhes tabelaprecosdetalhes = null;
    private TabelaPrecosDetalhesDAO tabelaprecosdetalhesDAO = new TabelaPrecosDetalhesDAO();
    
    private Formaspgto formapgto       = null;
    private FormasPgtoDAO formapgtoDAO = new FormasPgtoDAO();
    
    private ProdutosDAO produtosDAO     = new ProdutosDAO();
    private Produtos produtoSelecionado = null;
    
    private ClientesDAO clientesDAO = new ClientesDAO();
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
        //Monta a SQL para trazer os dados                
        String vSQL = "FROM Itenspedido where ippedido = "+String.valueOf(this.pedido.getId().getPepedido())+
                      " AND ipusuario = "+ String.valueOf(Main.usuarioAcessado.getId().getUscodigo()) +
                      " AND ipempresa = "+ String.valueOf(Main.empresaSelecionada.getEmcodigo());
                
        Uses.popularTabela(gridDetalhes, vSQL, Itenspedido.class); 
    }
    
    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDadosPedido() throws Exception{        
        pedido.setPecliente(cliente.getId().getClcodigo());
        pedido.setPeduracao(Integer.valueOf(Ed_Duracao.getText().trim()));
        pedido.setPeproducaoleite(BigDecimal.valueOf(Float.valueOf(Ed_ProducaoTotal.getText().trim())));
        pedido.setPepesovivo(BigDecimal.valueOf(Float.valueOf(Ed_PesoVivo.getText().trim())));
        pedido.setPenrolactantes(Integer.valueOf(Ed_Lactantes.getText().trim()));
        pedido.setPenropreparto(Integer.valueOf(Ed_PreParto.getText().trim()));
        pedido.setPenronovilhas(Integer.valueOf(Ed_Novilhas.getText().trim()));
        pedido.setPenroterneiras2mes(Integer.valueOf(Ed_Terneiras2.getText().trim()));
        pedido.setPenroterneiras6mes(Integer.valueOf(Ed_Terneiras6.getText().trim()));    
        pedido.setPeformapgto(formapgto.getId().getFpcodigo());
        pedido.setPeobs("");
        
        pedido.setPedataatu(new Date());
        pedido.setPehoraatu(new Date());
        
        if (pedido.getId() == null){ //(int peusuario, int peempresa, int pepedido) {
            PedidosId idpedido = new PedidosId(Main.usuarioAcessado.getId().getUscodigo(),
                                               Main.empresaSelecionada.getEmcodigo(), 
                                               pedidosDAO.getAutoIncrement());
            
            pedido.setId(idpedido);
            pedidosDAO.Insert(pedido);
        } else {
            pedidosDAO.Update(pedido);
        }                                                           
    }
    
    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDadosItens() throws Exception{                
        itensPedido.setIptabelapreco(tabelaprecosdetalhes.getId().getTdtabelapreco());
        itensPedido.setIpquantidade(BigDecimal.valueOf(Double.valueOf(Ed_Quantidade.getText().trim())));
        itensPedido.setIpvalorunit(BigDecimal.valueOf(Double.valueOf(Ed_ValorUnit.getText().trim())));      
        
        BigDecimal valorTotal = BigDecimal.valueOf(Double.valueOf(Ed_ValorUnit.getText().trim()) *
                                                   Double.valueOf(Ed_Quantidade.getText().trim()));
        itensPedido.setIpvalortotal(valorTotal);
        
        itensPedido.setIpdataatu(new Date());
        itensPedido.setIphoraatu(new Date());
        
        if (itensPedido.getId() == null){      
            //int ipemresa, int ipusuario, int ippedido, int ipproduto) {
            ItenspedidoId id = new ItenspedidoId(Main.empresaSelecionada.getEmcodigo(),
                                                 Main.usuarioAcessado.getId().getUscodigo(),
                                                 pedido.getId().getPepedido(),
                                                 produtoSelecionado.getId().getPrcodigo());
            itensPedido.setId(id);
            itenspedidoDAO.Insert(itensPedido);
        } else {
            itenspedidoDAO.Update(itensPedido);
        }                                           
    }
    
    /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setDataPedidos(){          
        Ed_Codigo.setText(String.valueOf(pedido.getId().getPepedido()));
        Ed_Cliente.setText(String.valueOf(pedido.getPecliente()));
        Ed_NomCliente.setText(cliente.getClnome());
        Ed_Duracao.setText(String.valueOf(pedido.getPeduracao()));
        Ed_ProducaoTotal.setText(String.valueOf(pedido.getPeproducaoleite()));
        Ed_PesoVivo.setText(String.valueOf(pedido.getPepesovivo()));
        Ed_Lactantes.setText(String.valueOf(pedido.getPenrolactantes()));
        Ed_PreParto.setText(String.valueOf(pedido.getPenropreparto()));
        Ed_Novilhas.setText(String.valueOf(pedido.getPenronovilhas()));
        Ed_Terneiras2.setText(String.valueOf(pedido.getPenroterneiras2mes()));
        Ed_Terneiras6.setText(String.valueOf(pedido.getPenroterneiras6mes()));
        Ed_FormasPgto.setText(String.valueOf(pedido.getPeformapgto()));         
    }
        /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setDataItensPedido(){     
        Ed_Produto.setText(String.valueOf(produtoSelecionado.getId().getPrcodigo()));
        Ed_NomProduto.setText(produtoSelecionado.getPrnome());
        Ed_Quantidade.setText(String.valueOf(itensPedido.getIpquantidade()));   
        Ed_Tabela.setText(String.valueOf(itensPedido.getIptabelapreco()));        
        Ed_ValorUnit.setText(String.valueOf(itensPedido.getIpvalortotal()));        
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
        camposCombo[0] = "Pedido;PEPEDIDO";
        
        cbCampos.removeAllItems();
        for (int i = 0; i < camposCombo.length; i++)
        {
            vStr = camposCombo[i].split(";");
            cbCampos.addItem(vStr[0]);
        }

        //função responsavel por carregar os campos da tela de consulta        
        ordenaCombo[0] = "Pedido;PEPEDIDO";

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
    private boolean validarCamposPedidos(){
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
     * Verifica se os campos obrigatórios foram preenchidos
     * @return 
     */
    private boolean validarCamposItensPedido(){
        boolean vReturn = true;
        
        if (Ed_Produto.getText().toString().equals("")){
            Ed_Produto.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Quantidade.getText().toString().equals("")){
            Ed_Quantidade.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Tabela.getText().toString().equals("")){
            Ed_Tabela.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_ValorUnit.getText().toString().equals("")){
            Ed_ValorUnit.setBackground(Color.RED); 
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
        if (estado.equals(_MODIFICACAO)) {
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
            BotaoEditarPedido.setEnabled(true);
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(BotaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
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

        jLabel22.setText("Pedido");

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
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ed_Codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Duracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Lactantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Terneiras2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_FormasPgto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(F3_Cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F3_FormaPgto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Ed_NomCliente))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ed_NomFormaPgto))))
                    .addComponent(BotaoEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_ProducaoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ed_PreParto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ed_Terneiras6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel36)
                                .addGap(10, 10, 10)
                                .addComponent(Ed_PesoVivo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel38)
                                .addGap(10, 10, 10)
                                .addComponent(Ed_Novilhas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BotaoEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(Ed_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3_Cliente)
                    .addComponent(Ed_NomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(Ed_Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(Ed_ProducaoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(Ed_PesoVivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(Ed_Lactantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(Ed_PreParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(Ed_Novilhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(Ed_Terneiras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(Ed_Terneiras6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(Ed_FormasPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3_FormaPgto)
                    .addComponent(Ed_NomFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
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
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ed_Quantidade)
                    .addComponent(Ed_ValorUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(Ed_Tabela)
                    .addComponent(Ed_Produto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(F3_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3_TabelaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(Ed_NomProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(BotaoEditarDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Ed_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3_Produtos)
                    .addComponent(Ed_NomProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoEditarDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ed_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(287, 287, 287))
        );

        jTabbedPane.addTab("Itens Pedido", jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
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
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tab_Selecao))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
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
           itensPedido = new Itenspedido();
           limpaTelaItensPedido();
           Ed_Produto.grabFocus();
        }        
        arrumaBotoes(_MODIFICACAO);
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGravaActionPerformed
       
        if (jTabbedPane.getSelectedIndex() == 0)/*Pedidos*/{
            if (! validarCamposPedidos()){                
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
        } else if (jTabbedPane.getSelectedIndex() == 1)/*Pedidos - Detalhes*/{
            if (! validarCamposItensPedido()){                
                mensagem.exibirMensagem(jframe_inicial,"Todos os campos obrigatórios devem ser preenchidos. Verifique!",'i');            
            } else { //Segue com o salvar dados.
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
                    pedidosDAO.deleteAllItens(pedido);
                    pedidosDAO.Delete(pedido);                    
                    carregaGridItensPedido();
                    pedido = null;                    
                    limpaTelaPedidos();                    
                    arrumaBotoes(_DEFAULT);    
                } else if (jTabbedPane.getSelectedIndex() == 1)/*Itens Pedido*/{
                    if (itensPedido != null){
                     itenspedidoDAO.Delete(itensPedido);
                    carregaGridItensPedido();
                    itensPedido = null;                    
                    limpaTelaItensPedido();                    
                    arrumaBotoes(_DEFAULT);       
                    }                    
                }
           } catch (Exception erro){
                mensagem.exibirMensagem(jframe_inicial,"Erro ao excluir a filial.Verifique" + erro.getMessage(),'e');
            }
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void gridConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridConsultaMouseClicked
        if (evt.getClickCount() == 2){
            int row = gridConsulta.getSelectedRow();
            if (row < 0){
                return;
            } else{
                try{
                     String sql = "FROM Pedidos where peempresa = "+String.valueOf(Main.empresaSelecionada.getEmcodigo()) +
                                  " and peusuario = "+String.valueOf(Main.usuarioAcessado.getId().getUscodigo()) +
                                  " and pepedido = " + gridConsulta.getValueAt(row, 0).toString();                     
                     List<Pedidos> listPedidos = pedidosDAO.consultaSQL(sql);
                    
                     if (listPedidos.size() > 0){
                        this.pedido = listPedidos.get(0);
                        this.cliente = clientesDAO.getCliente(Main.empresaSelecionada.getEmcodigo(), pedido.getPecliente());
                        this.formapgto = formapgtoDAO.getFormaPgto(Main.empresaSelecionada.getEmcodigo(), pedido.getPeformapgto());                        
                        this.setDataPedidos();
                        this.carregaGridItensPedido();
                        Tab_Selecao.setSelectedIndex(1);
                        arrumaBotoes(_DEFAULT);
                     }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());                    
                }
            }
        }
    }//GEN-LAST:event_gridConsultaMouseClicked

    /**
     * Busca todas as informações dos produtos que compoem o pedido
     */
    private void getItensPedido_Produto(){               
        try{
            Itenspedido item = itenspedidoDAO.getItensPedido(Main.empresaSelecionada.getEmcodigo(), pedido.getId().getPepedido(), Integer.valueOf(gridDetalhes.getValueAt(rowItensPedidoDetalhesClick, 0).toString()));                    
            if (item != null){                                   
                this.itensPedido        = item;
                this.produtoSelecionado = produtosDAO.getProduto(Main.empresaSelecionada.getEmcodigo(), item.getId().getIpproduto());
                this.setDataItensPedido();
            } else {
                //como nao tem nada
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());                    
        }                      
    }
    
    private void gridConsultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridConsultaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_gridConsultaPropertyChange

    private void BotaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultaActionPerformed
        //Monta a SQL para trazer os dados
        String[] vCampo = camposCombo[cbCampos.getSelectedIndex()].split(";");
        
        String vSQL = "FROM Pedidos where peempresa = "+String.valueOf(Main.empresaSelecionada.getEmcodigo());

        String vStr = Ed_Consulta.getText().trim();
        if (Ed_Consulta.getText().length() > 0){
            vSQL = vSQL + " AND UPPER(" + vCampo[1] + ") LIKE '%" + Ed_Consulta.getText().trim().toUpperCase() + "%' ";
        }

        String[] vOrdem = ordenaCombo[cbOrdenacao.getSelectedIndex()].split(";");
        vSQL = vSQL + "ORDER BY " + vOrdem[1];
        
        Uses.popularTabela(gridConsulta, vSQL, Pedidos.class);           

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
                cliente = clientesDAO.getCliente(Main.empresaSelecionada.getEmcodigo(), Integer.valueOf(Ed_Cliente.getText().toString().trim()));    
                Ed_NomCliente.setText(cliente.getClnome());
                
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
        try{            
            if (! Main.vValorPesquisa.equals("")){
                Ed_FormasPgto.setText(Main.vValorPesquisa);                                
                //zera a variavel;
                Main.vValorPesquisa = "";
            }
            if (!Ed_FormasPgto.getText().toString().trim().equals("")){
                formapgto = formapgtoDAO.getFormaPgto(Main.empresaSelecionada.getEmcodigo(), Integer.valueOf(Ed_FormasPgto.getText().toString().trim()));    
                Ed_NomFormaPgto.setText(formapgto.getFpdescricao());                
            } else {
                formapgto = null;                        
            }                                   
        } catch (Exception e){
            mensagem.exibirMensagem(jframe_inicial,"Ocorreu um erro durante a localização do produto.Verifique!" + "\n" + e.getMessage(), 'e');            
        }
    }
    
    /**
     * Busca as informações de  produto - Para seleção
     */
    private void buscaProdutoAposF3(){
        try{            
            if (! Main.vValorPesquisa.equals("")){
                Ed_Produto.setText(Main.vValorPesquisa);                                
                //zera a variavel;
                Main.vValorPesquisa = "";
            }
            if (!Ed_Produto.getText().toString().trim().equals("")){
                produtoSelecionado = produtosDAO.getProduto(Main.empresaSelecionada.getEmcodigo(),Integer.valueOf(Ed_Produto.getText().toString().trim()));    
                Ed_NomProduto.setText(produtoSelecionado.getPrnome());
                
            } else {
                produtoSelecionado = null;                        
            }                                   
        } catch (Exception e){
            mensagem.exibirMensagem(jframe_inicial,"Ocorreu um erro durante a localização do produto.Verifique!" + "\n" + e.getMessage(), 'e');            
        }        
    }
    
    /**
     * Busca as informações para Tabela de Preços - Para Seleção
     */
    private void buscaTabelaPrecoAposF3(){
        try{            
            if (! Main.vValorPesquisa.equals("")){
                Ed_Tabela.setText(Main.vValorPesquisa);                                
                //zera a variavel;
                Main.vValorPesquisa = "";
            }
            if (!Ed_Tabela.getText().toString().trim().equals("")){
                tabelaprecosdetalhes = tabelaprecosdetalhesDAO.getTabela( Integer.valueOf(Main.empresaSelecionada.getEmcodigo()), 
                                                                          Integer.valueOf(Ed_Tabela.getText().toString().trim()),
                                                                          Integer.valueOf(Ed_Produto.getText().toString().trim())              
                                                                         );    
               
                Ed_ValorUnit.setText(String.valueOf(tabelaprecosdetalhes.getTdpreco()));
            } else {
                tabelaprecosdetalhes = null;     
                Ed_Tabela.setText("");
                Ed_ValorUnit.setText("");
            }                                   
        } catch (Exception e){
            mensagem.exibirMensagem(jframe_inicial,"Ocorreu um erro durante a localização do produto.Verifique!" + "\n" + e.getMessage(), 'e');            
            Ed_Tabela.setText("");
            Ed_ValorUnit.setText("");
        }    
    }
    private void F3_ClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_ClienteFocusLost

    }//GEN-LAST:event_F3_ClienteFocusLost

    private void F3_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_ClienteActionPerformed
        String vSQL = "FROM Clientes where clcodigo is not null ";              
        Uses.ChamaTelaPesquisa(Ed_Cliente, vSQL, Clientes.class); 
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
        String vSQL = "FROM Formaspgto where fpcodigo is not null ";              
        Uses.ChamaTelaPesquisa(Ed_FormasPgto, vSQL, Formaspgto.class); 
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
        String vSQL = "FROM Produtos where prempresa = "+String.valueOf(Main.empresaSelecionada.getEmcodigo()); 
        Uses.ChamaTelaPesquisa(Ed_Produto, vSQL, Produtos.class);         
    }//GEN-LAST:event_F3_ProdutosActionPerformed

    private void BotaoEditarDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarDetalhesActionPerformed
        if (rowItensPedidoDetalhesClick >= 0){                            
                                    
                try{
                    Itenspedido item = itenspedidoDAO.getItensPedido(pedido.getId().getPeempresa(),
                                                                     pedido.getId().getPepedido(),
                                                                     Integer.valueOf(gridDetalhes.getValueAt(rowItensPedidoDetalhesClick, 0).toString()) );
                
                    if (item != null){                            
                        this.itensPedido = item; 
                        
                        tabelaprecosdetalhes = tabelaprecosdetalhesDAO.getTabela(itensPedido.getId().getIpempresa(), 
                                                                                 itensPedido.getIptabelapreco(), 
                                                                                 itensPedido.getId().getIpproduto() );
                        
                        produtoSelecionado   = produtosDAO.getProduto(itensPedido.getId().getIpempresa(), itensPedido.getId().getIpproduto());
                        this.setDataItensPedido();
                    } else
                    {
                        //como nao tem nada
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());                    
                }
            }

        arrumaBotoes(_MODIFICACAO);            
    }//GEN-LAST:event_BotaoEditarDetalhesActionPerformed

    private void Ed_TabelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_TabelaFocusLost
        buscaTabelaPrecoAposF3();
    }//GEN-LAST:event_Ed_TabelaFocusLost

    private void F3_TabelaPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3_TabelaPrecoFocusLost

    }//GEN-LAST:event_F3_TabelaPrecoFocusLost

    private void F3_TabelaPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3_TabelaPrecoActionPerformed
        String vSQL = "FROM Tabelaprecos where tpempresa = "+String.valueOf(Main.empresaSelecionada.getEmcodigo());              
        Uses.ChamaTelaPesquisa(Ed_Tabela, vSQL, Tabelaprecos.class);         
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
