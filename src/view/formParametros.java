/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Empresa;
import controller.EmpresaDAO;
import java.awt.Color;
import java.util.Date;
import util.CaixaDeDialogo;
import util.JTextFieldLimit;
import util.Uses;
import java.util.List;
import static view.formInicial.jframe_inicial;

/**
 *
 * @author Dionatan
 */
public class formParametros extends javax.swing.JInternalFrame {
    private final String _MODIFICACAO = "modificacao";
    private final String _DEFAULT     = "default";
    
    private Empresa empresa = null;
    private EmpresaDAO empresaDAO = new EmpresaDAO();
    private static CaixaDeDialogo mensagem;
    static int openFrameCount = 0;
    private String[] camposCombo = new String[2];
    private String[] ordenaCombo = new String[2];
    /**
     * Creates new form formParametros
     */
    public formParametros() {
        super("IFrame #" + (++openFrameCount),
                false, // resizable
                true, // closable
                false, // maximizable
                false);// iconifiable
        
        initComponents();
        Uses.center(this);
        carregaConfConsulta();     
        
        mensagem = CaixaDeDialogo.obterInstancia();
        
        Ed_RazaoSocial.setDocument(new JTextFieldLimit(100));
        Ed_Fantasia.setDocument(new JTextFieldLimit(100));
        Ed_Bairro.setDocument(new JTextFieldLimit(30));
        Ed_Cidade.setDocument(new JTextFieldLimit(50));
        Ed_Endereco.setDocument(new JTextFieldLimit(100));
        Ed_Email.setDocument(new JTextFieldLimit(50));
        Ed_Fone.setDocument(new JTextFieldLimit(20));                                    
    }
    
    /**
     * Carrega o  JCombobox com as informações para pesquisa de dados
     */
    public void carregaConfConsulta()
    {
        String[] vStr = null;
        //função responsavel por carregar os campos da tela de consulta
        camposCombo[0] = "Razão Social;EMRAZAOSOCIAL";
        camposCombo[1] = "CNPJ;EMCNPJ";
        
        cbCampos.removeAllItems();
        for (int i = 0; i < camposCombo.length; i++)
        {
            vStr = camposCombo[i].split(";");
            cbCampos.addItem(vStr[0]);
        }

        //função responsavel por carregar os campos da tela de consulta
        ordenaCombo[0] = "Razão Social;EMRAZAOSOCIAL";
        ordenaCombo[1] = "CNPJ;EMCNPJ";

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
    private void arrumaBotoes(String estado)
    {
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
        if (jTabbedPane.getSelectedIndex() == 0)/*Empresa*/{                    
            Ed_CNPJ.setEditable(vEstado);
            Ed_RazaoSocial.setEditable(vEstado);
            Ed_Fantasia.setEditable(vEstado);
            Ed_Endereco.setEditable(vEstado);
            Ed_Bairro.setEditable(vEstado);
            Ed_Cidade.setEditable(vEstado);
            Ed_UF.setEditable(vEstado);
            Ed_Cep.setEditable(vEstado);
            Ed_Fone.setEditable(vEstado);
            Ed_Email.setEditable(vEstado);            
        } else { /*Usuario*/
            
        }
        
    }
    
    
    /*
    Responsável por apresentar os dados na tela do usuário
    */
    private void setDataEmpresa(){
       Ed_CNPJ.setText(empresa.getEmcnpj());
       Ed_RazaoSocial.setText(empresa.getEmrazaosocial());
       Ed_Fantasia.setText(empresa.getEmfantasia());       
       Ed_Endereco.setText(empresa.getEmendereco());
       Ed_Bairro.setText(empresa.getEmbairro());
       Ed_Cidade.setText(empresa.getEmcidade());       
       Ed_UF.setText(empresa.getEmuf());
       Ed_Cep.setText(empresa.getEmcep());
       Ed_Fone.setText(empresa.getEmtelefone());
       Ed_Email.setText(empresa.getEmemail());            
       
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel23 = new javax.swing.JLabel();
        Ed_RazaoSocial = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        Ed_Endereco = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Ed_CNPJ = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        Ed_Cidade = new javax.swing.JTextField();
        Ed_Cep = new javax.swing.JFormattedTextField();
        Ed_Fone = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Ed_Email = new javax.swing.JTextField();
        Ed_Bairro = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        BotaoEditar = new javax.swing.JButton();
        Ed_UF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Ed_Fantasia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        Ed_CNPJ1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Ed_RazaoSocial1 = new javax.swing.JTextField();
        BotaoEditar1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        Ed_CNPJ2 = new javax.swing.JTextField();
        Ed_Endereco1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Ed_Bairro1 = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        Ed_Cidade1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        Ed_UF1 = new javax.swing.JTextField();
        Ed_Cep1 = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Ed_Fone1 = new javax.swing.JFormattedTextField();
        Ed_Email1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        Ed_Email2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        BotaoNovo = new javax.swing.JButton();
        BotaoGrava = new javax.swing.JButton();
        BotaoCancela = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();

        setTitle("Parâmetros do Sistema");

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
                    .addComponent(cbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Consulta", jPanel5);

        jPanel7.setPreferredSize(new java.awt.Dimension(672, 370));

        jLabel23.setText("Razão Social");

        Ed_RazaoSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_RazaoSocialFocusLost(evt);
            }
        });

        jLabel24.setText("Endereço");

        jLabel25.setText("Bairro");

        jLabel26.setText("Cidade*");

        Ed_Cidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_CidadeFocusLost(evt);
            }
        });

        Ed_Fone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_FoneFocusLost(evt);
            }
        });

        jLabel27.setText("CEP");

        jLabel28.setText("Fone");

        jLabel30.setText("Email");

        Ed_Bairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_BairroFocusLost(evt);
            }
        });

        jLabel31.setText("CNPJ");

        BotaoEditar.setText("Editar");
        BotaoEditar.setFocusable(false);
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        Ed_UF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_UFFocusLost(evt);
            }
        });

        jLabel32.setText("UF*");

        Ed_Fantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_FantasiaFocusLost(evt);
            }
        });

        jLabel29.setText("Fantasia");

        jLabel33.setText("UF*");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ed_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Ed_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addGap(4, 4, 4)
                        .addComponent(Ed_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ed_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Ed_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Fone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(Ed_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(161, 161, 161)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Ed_RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(160, 160, 160)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(Ed_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel23)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel29))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(Ed_RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Ed_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel24))
                            .addComponent(Ed_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Ed_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33)
                                .addComponent(Ed_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26))))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel27)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel28))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(Ed_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Ed_Fone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel30))
                            .addComponent(Ed_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Empresa", jPanel7);

        jLabel34.setText("CNPJ");

        jLabel35.setText("Usuário/Nome");

        Ed_RazaoSocial1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_RazaoSocial1FocusLost(evt);
            }
        });

        BotaoEditar1.setText("Editar");
        BotaoEditar1.setFocusable(false);
        BotaoEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditar1ActionPerformed(evt);
            }
        });

        jLabel36.setText("CPF");

        jLabel37.setText("Endereço");

        jLabel38.setText("Bairro");

        Ed_Bairro1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_Bairro1FocusLost(evt);
            }
        });

        jLabel39.setText("Cidade*");

        Ed_Cidade1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_Cidade1FocusLost(evt);
            }
        });

        jLabel40.setText("UF*");

        Ed_UF1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_UF1FocusLost(evt);
            }
        });

        jLabel41.setText("CEP");

        jLabel42.setText("Fone");

        Ed_Fone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Ed_Fone1FocusLost(evt);
            }
        });

        jLabel43.setText("Email");

        jLabel44.setText("Senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(3, 3, 3)
                                .addComponent(Ed_Email2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ed_Fone1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ed_Email1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ed_Endereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Ed_Bairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39)
                                        .addGap(4, 4, 4)
                                        .addComponent(Ed_Cidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Ed_UF1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Ed_Cep1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(3, 3, 3)
                                .addComponent(Ed_RazaoSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(3, 3, 3)
                                .addComponent(Ed_CNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(3, 3, 3)
                                .addComponent(Ed_CNPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(BotaoEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotaoEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel35))
                            .addComponent(Ed_RazaoSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_CNPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel34)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ed_CNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel36)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel37))
                    .addComponent(Ed_Endereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ed_Bairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ed_Cidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(Ed_UF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel41))
                    .addComponent(Ed_Cep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel42))
                    .addComponent(Ed_Fone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel43))
                    .addComponent(Ed_Email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel44))
                    .addComponent(Ed_Email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane.addTab("Usuários", jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 556, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Tab_Selecao.addTab("Cadastro", jPanel6);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gridConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridConsultaMouseClicked
        if (evt.getClickCount() == 2){
            int row = gridConsulta.getSelectedRow();
            if (row < 0){
                return;
            } else{
                try{
                    String sql = "FROM Empresa where emcodigo = " + gridConsulta.getValueAt(row, 0).toString();
                    List<Empresa> listEmpresa = empresaDAO.consultaSQL(sql);

                    if (listEmpresa.size() > 0){
                        this.empresa = listEmpresa.get(0);
                        this.setDataEmpresa();
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
        
        String vSQL = "FROM Empresa where emcodigo is not null ";

        String vStr = Ed_Consulta.getText().trim();
        if (Ed_Consulta.getText().length() > 0){
            vSQL = vSQL + " AND UPPER(" + vCampo[1] + ") LIKE '%" + Ed_Consulta.getText().trim().toUpperCase() + "%' ";
        }

        String[] vOrdem = ordenaCombo[cbOrdenacao.getSelectedIndex()].split(";");
        vSQL = vSQL + "ORDER BY " + vOrdem[1];
        
        Uses.popularTabela(gridConsulta, vSQL, Empresa.class);     
    }//GEN-LAST:event_BotaoConsultaActionPerformed

    private void Ed_RazaoSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_RazaoSocialFocusLost
        if (Ed_RazaoSocial.isEditable()){
            Ed_RazaoSocial.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Ed_RazaoSocialFocusLost

    private void Ed_CidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_CidadeFocusLost
        if (Ed_Cidade.isEditable()){
            Ed_Cidade.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Ed_CidadeFocusLost

    private void Ed_FoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_FoneFocusLost

    }//GEN-LAST:event_Ed_FoneFocusLost

    private void Ed_BairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_BairroFocusLost

    }//GEN-LAST:event_Ed_BairroFocusLost

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        arrumaBotoes(_MODIFICACAO);
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void Ed_UFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_UFFocusLost
        if (Ed_UF.isEditable()){
            Ed_UF.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Ed_UFFocusLost

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
                           
        if (jTabbedPane.getSelectedIndex() == 0)/*Empresa*/{            
          empresa = new Empresa();
          limpaTelaEmpresa();  
          Tab_Selecao.setSelectedIndex(1);
          Ed_CNPJ.grabFocus();          
        } else if (jTabbedPane.getSelectedIndex() == 1)/*Usuários*/{
            //tabelaprecosdetalhes = new Tabelaprecosdetalhes();                        
            //limpaTelaTabelaPrecosDetalhes();
            //Ed_Produto.grabFocus();            
        }        
        arrumaBotoes(_MODIFICACAO);          
    }//GEN-LAST:event_BotaoNovoActionPerformed

    /**
     * Retira todas as informações de dados que podem estar sendo apresentadas ao usuário
     */
    private void limpaTelaEmpresa(){
        Ed_CNPJ.setText("");
        Ed_RazaoSocial.setText("");
        Ed_Fantasia.setText("");       
        Ed_Endereco.setText("");
        Ed_Bairro.setText("");
        Ed_Cidade.setText("");       
        Ed_UF.setText("");
        Ed_Cep.setText("");
        Ed_Fone.setText("");
        Ed_Email.setText("");              
    }
    /**
     * Retira todas as informações de dados que podem estar sendo apresentadas ao usuário
     */
    private void limpaTelaUsuarios(){
        //Ed_Produto.setText("");        
       // Ed_Preco.setText("");                
       // Ed_NomProduto.setText("");
    }
    
    private boolean validarCamposEmpresa(){
        boolean vReturn = true;
        
        if (Ed_RazaoSocial.getText().toString().equals("")){
            Ed_RazaoSocial.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_CNPJ.getText().toString().equals("")){
            Ed_CNPJ.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Cidade.getText().toString().equals("")){
            Ed_Cidade.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_UF.getText().toString().equals("")){
            Ed_UF.setBackground(Color.RED); 
            vReturn = false;
        }
        
        if (Ed_Email.getText().toString().equals("")){
            Ed_Email.setBackground(Color.RED); 
            vReturn = false;
        }                 
        
        return vReturn;
    }
    
    private void BotaoGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGravaActionPerformed
        if (jTabbedPane.getSelectedIndex() == 0)/*Empresa*/{
         if (! validarCamposEmpresa()){
            mensagem.exibirMensagem(jframe_inicial,"Todos os campos obrigatórios devem ser preenchidos. Verifique!",'i');
        } else { //Segue com o salvar dados.
            try {
                salvarDadosEmpresa();

                mensagem.exibirMensagem(jframe_inicial,"Registro gravado com sucesso",'i');

                arrumaBotoes(_DEFAULT);
                BotaoNovo.grabFocus();
            } catch (Exception e) {

                System.out.println(e.getMessage());

                mensagem.exibirMensagem(jframe_inicial, "Não foi possível gravar as informações. Tente novamente mais tarde!", 'e');
            }

        }           
        } else {
            
        }        
    }//GEN-LAST:event_BotaoGravaActionPerformed

    /*
    Responsável por Salvar dos dados inseridos ou alterados pelo Usuário
    */
    private void salvarDadosEmpresa() throws Exception{        
        empresa.setEmrazaosocial(Ed_RazaoSocial.getText().trim());
        empresa.setEmfantasia(Ed_Fantasia.getText().trim());
        empresa.setEmcnpj(Ed_CNPJ.getText().trim());
        empresa.setEmcep(Ed_Cep.getText().trim());
        empresa.setEmuf(Ed_UF.getText().trim());
        empresa.setEmbairro(Ed_Bairro.getText().trim());
        empresa.setEmcidade(Ed_Cidade.getText().trim());
        empresa.setEmendereco(Ed_Endereco.getText().trim());
        empresa.setEmemail(Ed_Email.getText().trim());
        empresa.setEmtelefone(Ed_Fone.getText().trim());
        
        empresa.setEmdataatu(new Date());
        empresa.setEmhoraatu(new Date());
                                                                     
        if (empresa.getEmcodigo() == 0){                                    
            empresa.setEmcodigo(empresaDAO.getAutoIncrement());
            empresaDAO.Insert(empresa);
        } else {
            empresaDAO.Update(empresa);
        }                              
    }
    
    private void BotaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelaActionPerformed
        arrumaBotoes(_DEFAULT);
        if (jTabbedPane.getSelectedIndex() == 0)/*Empresa*/{     
           if (empresa != null){
              setDataEmpresa();
           }  
        } else {
            
        }                    
    }//GEN-LAST:event_BotaoCancelaActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        if (mensagem.pedirConfirmacao(jframe_inicial,"Você deseja mesmo excluir o registro?") == true){
            try{
                if (jTabbedPane.getSelectedIndex() == 0)/*Empresa*/{
                    empresaDAO.Delete(empresa);
                    empresa = null;
                    
                    limpaTelaEmpresa();
                    arrumaBotoes(_DEFAULT);    
                } else if (jTabbedPane.getSelectedIndex() == 1)/*Usuários*/{
                   //tabelaprecosdetalhesDAO.Delete(tabelaprecosdetalhes);
                   //tabelaprecosdetalhes = null;
                   
                   //limpaTelaTabelaPrecosDetalhes();
                   //arrumaBotoes(_DEFAULT);
                   //carregaGridTabelaPrecosDetalhes();
                }
           } catch (Exception erro){
                mensagem.exibirMensagem(jframe_inicial,"Erro ao excluir a filial.Verifique" + erro.getMessage(),'e');
            }
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void Ed_FantasiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_FantasiaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_FantasiaFocusLost

    private void Ed_RazaoSocial1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_RazaoSocial1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_RazaoSocial1FocusLost

    private void BotaoEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoEditar1ActionPerformed

    private void Ed_Bairro1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_Bairro1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_Bairro1FocusLost

    private void Ed_Cidade1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_Cidade1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_Cidade1FocusLost

    private void Ed_UF1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_UF1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_UF1FocusLost

    private void Ed_Fone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ed_Fone1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_Ed_Fone1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancela;
    private javax.swing.JButton BotaoConsulta;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoEditar1;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoGrava;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JFormattedTextField Ed_Bairro;
    private javax.swing.JFormattedTextField Ed_Bairro1;
    private javax.swing.JTextField Ed_CNPJ;
    private javax.swing.JTextField Ed_CNPJ1;
    private javax.swing.JTextField Ed_CNPJ2;
    private javax.swing.JFormattedTextField Ed_Cep;
    private javax.swing.JFormattedTextField Ed_Cep1;
    private javax.swing.JTextField Ed_Cidade;
    private javax.swing.JTextField Ed_Cidade1;
    private javax.swing.JTextField Ed_Consulta;
    private javax.swing.JTextField Ed_Email;
    private javax.swing.JTextField Ed_Email1;
    private javax.swing.JTextField Ed_Email2;
    private javax.swing.JTextField Ed_Endereco;
    private javax.swing.JTextField Ed_Endereco1;
    private javax.swing.JTextField Ed_Fantasia;
    private javax.swing.JFormattedTextField Ed_Fone;
    private javax.swing.JFormattedTextField Ed_Fone1;
    private javax.swing.JTextField Ed_RazaoSocial;
    private javax.swing.JTextField Ed_RazaoSocial1;
    private javax.swing.JTextField Ed_UF;
    private javax.swing.JTextField Ed_UF1;
    private javax.swing.JTabbedPane Tab_Selecao;
    private javax.swing.JComboBox cbCampos;
    private javax.swing.JComboBox cbOrdenacao;
    private javax.swing.JTable gridConsulta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
