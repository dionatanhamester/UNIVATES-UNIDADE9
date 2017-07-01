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
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel29))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ed_RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(Ed_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ed_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ed_UF))
                    .addComponent(Ed_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ed_CNPJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ed_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ed_Fone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ed_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(187, 187, 187))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel23))
                                    .addComponent(Ed_RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Ed_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel24))
                            .addComponent(Ed_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Ed_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(Ed_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(Ed_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_Fone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ed_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))))
                .addGap(33, 33, 33))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel25)
                .addGap(116, 116, 116))
        );

        jTabbedPane.addTab("Empresa", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
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
                    .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tab_Selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancela;
    private javax.swing.JButton BotaoConsulta;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoGrava;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JFormattedTextField Ed_Bairro;
    private javax.swing.JTextField Ed_CNPJ;
    private javax.swing.JFormattedTextField Ed_Cep;
    private javax.swing.JTextField Ed_Cidade;
    private javax.swing.JTextField Ed_Consulta;
    private javax.swing.JTextField Ed_Email;
    private javax.swing.JTextField Ed_Endereco;
    private javax.swing.JTextField Ed_Fantasia;
    private javax.swing.JFormattedTextField Ed_Fone;
    private javax.swing.JTextField Ed_RazaoSocial;
    private javax.swing.JTextField Ed_UF;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
