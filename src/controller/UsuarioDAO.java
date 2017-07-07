/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Usuario;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class UsuarioDAO extends CustomDAO<Usuario>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();        
        return sequences.getID(Usuario.class);
    }
        
    public Usuario validaLogin(String usuario, String senha){
        String vSQL = "FROM Usuario where upper(ususuario) = '"+usuario + "' and upper(ussenha) = '"+senha+"'";
        UsuarioDAO usuarioDAO = new UsuarioDAO();                
        List<Usuario> listData = usuarioDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    }
}
