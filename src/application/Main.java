/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import classes.Clientes;
import classes.Empresa;
import classes.Grupos;
import classes.Produtos;
import classes.ProdutosId;
import controller.ClientesDAO;
import controller.CustomDAO;
import controller.EmpresaDAO;
import controller.GruposDAO;
import controller.ProdutosDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import view.formInicial;

/**
 *
 * @author Dionatan
 */
public class Main {
    public static String vValorPesquisa = "";
    public static Empresa empresaSelecionada;
        
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {           
        EmpresaDAO empresaDAO = new EmpresaDAO();
                     
        try {            
           String sql = "FROM Empresa";           
           List<Empresa> listEmpresa = empresaDAO.consultaSQL(sql);           
                      
           if (listEmpresa.size() == 0){
               
               Empresa empresa = new Empresa();
               empresa.setEmcodigo(empresaDAO.getAutoIncrement());
               empresa.setEmrazaosocial("Razão Social da Emprsa");
               empresa.setEmfantasia("Fantasia da Empresa");
               empresa.setEmuf("RS");                              
               empresa.setEmcep("95890000");
               empresa.setEmcnpj("9999999999999");
               empresa.setEmbairro("Bairro");
               empresa.setEmcidade("Cidade");
               empresa.setEmendereco("Endereço");
               empresa.setEmemail("Email@email.com.br");
    
               empresaDAO.Insert(empresa);
               
               empresaSelecionada = empresa;
            } else {    
               empresaSelecionada = listEmpresa.get(0);                        
            }
            formInicial frmInicial = new formInicial();
            frmInicial.setVisible(true);                    
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    
}
