/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Formaspgto;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class FormasPgtoDAO extends CustomDAO<Formaspgto>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Formaspgto.class);
    }
    
    
    public Formaspgto getFormaPgto(Integer empresa, Integer formapgto){
        String vSQL = "FROM Formaspgto where fpempresa = "+String.valueOf(empresa) + " and fpcodigo = "+String.valueOf(formapgto);
        FormasPgtoDAO formaspgtoDAO = new FormasPgtoDAO();                
        List<Formaspgto> listData = formaspgtoDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    } 
    
}