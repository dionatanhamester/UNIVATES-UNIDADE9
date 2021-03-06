/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import application.Main;
import controller.ClientesDAO;
import classes.Clientes;
import classes.Empresa;
import classes.Formaspgto;
import classes.Grupos;
import classes.Itenspedido;
import classes.Pedidos;
import classes.Produtos;
import classes.Tabelaprecos;
import classes.Tabelaprecosdetalhes;
import classes.Usuario;
import controller.EmpresaDAO;
import controller.FormasPgtoDAO;
import controller.GruposDAO;
import controller.ItensPedidoDAO;
import controller.PedidosDAO;
import controller.ProdutosDAO;
import controller.TabelaPrecosDAO;
import controller.TabelaPrecosDetalhesDAO;
import controller.UsuarioDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import org.hibernate.Query;
import view.formInicial;
import view.formPesquisa;

/**
 *
 * @author Dionatan
 */
public class Uses {
    
    /**
     * Posiciona  o JInternalFrame ao Centro da tela
     * @param componente JInternalFrame a ser posicionado
     */
    public static void center(Component componente)
    {
        // Centraliza a janela de abertura no centro do desktop.
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle r = componente.getBounds();
        // Dimensões da janela
        int widthSplash = r.width;
        int heightSplash = r.height;

        // calculo para encontrar as cooredenadas X e Y para a centralização da janela.
        int posX = (screen.width / 2) - (widthSplash / 2);
        int posY = (screen.height / 2) - (heightSplash / 2);

        componente.setBounds(posX, posY, widthSplash, heightSplash);
    }
  
    /**
     * Verifica se determinado JInternalFrame já está aberto
     * @param jDesktopPane JDesktopPane
     * @param frame JInternalFrame a ser verificado
     * @return Boolean
     */
    public static Boolean verificaForm(JDesktopPane jDesktopPane,JInternalFrame frame) {
        Boolean valor = false;       
        JInternalFrame[] results;
        results = jDesktopPane.getAllFrames();
        for (int i = 0 ; i < results.length ; i++){
            
           if( results[i].getName().equals(frame.getName()) ){
              valor = true;
              break;
           }
        }
        return valor; 
    }      
    
    /**
     * Apresenta as de informações de pesquisa
     * @param edt JTextField da Pesquisa
     * @param SQL SQL do BD
     * @param classe Classe que está sendo Pesquisadaa
     */
    public static void ChamaTelaPesquisa(JTextField edt, String SQL, Class classe)    {
        formPesquisa pesq = new formPesquisa(edt, SQL, classe);
        formInicial.jDesktopPane1.add(pesq);
        Uses.center(pesq);
        pesq.setVisible(true);
    }        
        
    /**
     * Insere as informações de um Vector + SQL dentro das linhas do JTable
     * @param grid Grid de Apresentação
     * @param vSQL SQL do BD
     * @param tabela  Classe a ser apresentada
     */
    public static void popularTabela(JTable grid, String vSQL, Class tabela){
        
        Vector<String> cabecalho = new Vector<String>();
        Vector<String> campos    = new Vector<String>();
        Vector dadosTabela       = new Vector();

        try{
            if (tabela.equals(Clientes.class)){
                 cabecalho.setSize(3);
                 cabecalho.set(0, "Código");
                 cabecalho.set(1, "Matrícula");
                 cabecalho.set(2, "Nome");
                 
                 campos.setSize(3);
                 campos.set(0, "clcodigo");
                 campos.set(1, "clmatricula");
                 campos.set(2, "clnome");  
                                          
                ClientesDAO clientesDAO = new ClientesDAO();                
                List<Clientes> listData = clientesDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){
                    
                    Vector<Object> linha = new Vector<Object>();
                     linha.add(String.valueOf(listData.get(i).getId().getClcodigo()));
                     linha.add(listData.get(i).getClmatricula());
                     linha.add(listData.get(i).getClnome());
                     
                     dadosTabela.add(linha);
                }
            } else if (tabela.equals(Produtos.class)){                        
                cabecalho.setSize(2);
                cabecalho.set(0, "Código");        
                cabecalho.set(1, "Nome");        
                campos.setSize(2);
                campos.set(0, "PRCODIGO");        
                campos.set(1, "PRNOME");  
                
                ProdutosDAO produtosDAO = new ProdutosDAO();                
                List<Produtos> listData = produtosDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();
                     linha.add(String.valueOf(listData.get(i).getId().getPrcodigo()));
                     linha.add(listData.get(i).getPrnome());                     
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Grupos.class)){                        
                cabecalho.setSize(2);
                cabecalho.set(0, "Código");                
                cabecalho.set(1, "Nome");        
                campos.setSize(2);
                campos.set(0, "GRCODIGO");           
                campos.set(1, "GRNOME"); 
                
                GruposDAO gruposDAO = new GruposDAO();                
                List<Grupos> listData = gruposDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();
                     linha.add(String.valueOf(listData.get(i).getId().getGrcodigo()));
                     linha.add(listData.get(i).getGrnome());                     
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Tabelaprecos.class)){                        
                cabecalho.setSize(2);
                cabecalho.set(0, "Código");
                cabecalho.set(1, "Nome");        
                campos.setSize(2);
                campos.set(0, "TPCODIGO");
                campos.set(1, "TPNOME");
                
                TabelaPrecosDAO tabelaDAO = new TabelaPrecosDAO();                
                List<Tabelaprecos> listData = tabelaDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();
                     linha.add(String.valueOf(listData.get(i).getId().getTpcodigo()));
                     linha.add(listData.get(i).getTpnome());                     
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Tabelaprecosdetalhes.class)){                        
                cabecalho.setSize(2);
                cabecalho.setSize(3);
                cabecalho.set(0, "Código");
                cabecalho.set(1, "Nome");
                cabecalho.set(2, "Preço");       
                campos.setSize(3);
                campos.set(0, "TDPRODUTO");
                campos.set(1, "PRNOME");
                campos.set(2, "TDPRECO");
                
                TabelaPrecosDetalhesDAO tabeladetalhesDAO = new TabelaPrecosDetalhesDAO();                
                List<Tabelaprecosdetalhes> listData = tabeladetalhesDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();
                    ProdutosDAO produtosDAO = new ProdutosDAO();
                    
                    Produtos prod = produtosDAO.getProduto(listData.get(i).getId().getTdempresa(), listData.get(i).getId().getTdproduto());
                     linha.add(String.valueOf(prod.getId().getPrcodigo()));
                     linha.add(prod.getPrnome());             
                     linha.add(String.valueOf(listData.get(i).getTdpreco()));               
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Formaspgto.class)){                        
                cabecalho.setSize(2);
                cabecalho.setSize(2);
                cabecalho.set(0, "Código");
                cabecalho.set(1, "Descrição");                      
                campos.setSize(2);
                campos.set(0, "FPCODIGO");
                campos.set(1, "FPDESCRICAO");                
                
                FormasPgtoDAO formaspgtoDAO = new FormasPgtoDAO();                
                List<Formaspgto> listData = formaspgtoDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();                                                            
                     linha.add(String.valueOf(listData.get(i).getId().getFpcodigo()));
                     linha.add(listData.get(i).getFpdescricao());                                  
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Pedidos.class)){                        
                cabecalho.setSize(2);
                cabecalho.setSize(2);
                cabecalho.set(0, "Pedido");
                cabecalho.set(1, "Cliente");
                campos.setSize(2);
                campos.set(0, "PEPEDIDO");
                campos.set(1, "CLNOME");            
                
                PedidosDAO pedidosDAO = new PedidosDAO();                
                List<Pedidos> listData = pedidosDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();                                                            
                    
                    ClientesDAO clientesDAO = new ClientesDAO();                    
                    Clientes clie = clientesDAO.getCliente(listData.get(i).getId().getPeempresa(), listData.get(i).getPecliente());
                    
                     linha.add(String.valueOf(listData.get(i).getId().getPepedido()));
                     linha.add(clie.getClnome());                                  
                     
                     dadosTabela.add(linha);
                }                
            }else if (tabela.equals(Itenspedido.class)){                                                
                    cabecalho.setSize(3);
                    cabecalho.set(0, "Código");
                    cabecalho.set(1, "Nome");
                    cabecalho.set(2, "Valor Total");                    
                    campos.setSize(3);
                    campos.set(0, "IPPRODUTO");
                    campos.set(1, "PRNOME");
                    campos.set(2, "IPVALORTOTAL");   
                
                ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();                
                List<Itenspedido> listData = itensPedidoDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();                                                            
                    
                    ProdutosDAO produtosDAO = new ProdutosDAO();                    
                    Produtos prod = produtosDAO.getProduto(Main.empresaSelecionada.getEmcodigo(), listData.get(i).getId().getIpproduto());
                    
                     linha.add(String.valueOf(listData.get(i).getId().getIpproduto()));
                     linha.add(prod.getPrnome());
                     linha.add(String.valueOf(listData.get(i).getIpvalortotal()));                                  
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Empresa.class)){                        
                cabecalho.setSize(3);
                cabecalho.setSize(3);
                cabecalho.set(0, "Código");
                cabecalho.set(1, "Razão Social");
                cabecalho.set(2, "CNPJ");
                campos.setSize(3);
                campos.set(0, "EMCODIGO");
                campos.set(1, "EMRAZAOSOCIAL");            
                campos.set(2, "EMCNPJ");            
                
                EmpresaDAO empresaDAO = new EmpresaDAO();                
                List<Empresa> listData = empresaDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();                                                            
                                        
                     linha.add(String.valueOf(listData.get(i).getEmcodigo()));
                     linha.add(listData.get(i).getEmrazaosocial());                                  
                     linha.add(listData.get(i).getEmcnpj());                                  
                     
                     dadosTabela.add(linha);
                }                
            } else if (tabela.equals(Usuario.class)){                        
                cabecalho.setSize(2);
                cabecalho.setSize(2);
                cabecalho.set(0, "Código");
                cabecalho.set(1, "Nome");
                campos.setSize(2);
                campos.set(0, "USCODIGO");
                campos.set(1, "USNOME");                        
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();                
                List<Usuario> listData = usuarioDAO.consultaSQL(vSQL);
                
                for (int i = 0; i < listData.size(); i++){                    
                    Vector<Object> linha = new Vector<Object>();                                                            
                                        
                     linha.add(String.valueOf(listData.get(i).getId().getUscodigo()));
                     linha.add(listData.get(i).getUsnome());                                                                    
                     
                     dadosTabela.add(linha);
                }                
            }                  
        } catch (Exception e)
        {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }
        grid.setModel(new DefaultTableModel(dadosTabela, cabecalho)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;                
            }
        });

        // permite seleção de apenas uma linha da tabela
        grid.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < campos.size(); i++)
        {
            column = grid.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
        grid.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column)
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0)
                {
                    setBackground(Color.CYAN);
                } else
                {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
    }
}
