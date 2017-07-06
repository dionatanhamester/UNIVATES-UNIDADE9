/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import classes.Empresa;
import classes.Usuario;
import controller.EmpresaDAO;
import java.util.List;
import util.CaixaDeDialogo;
import view.formLogin;

/**
 *
 * @author Dionatan
 */
public class Main {
    public static String vValorPesquisa = "";
    public static Empresa empresaSelecionada;
    public static Usuario usuarioAcessado;
        
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {           
        //Necessário para carregar todas as classes do BD
        CaixaDeDialogo mensagem = CaixaDeDialogo.obterInstancia();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        String sql = "FROM Empresa";
        List<Empresa> listEmpresa = empresaDAO.consultaSQL(sql); 
        
        if (listEmpresa.size() == 0){   //Verifica se existe pelo menos 1 empresa cadastrada         
            System.exit(0);
        } else {
            formLogin frmLogin = new formLogin();
            frmLogin.setVisible(true);   
        }                                         
    }    
}
