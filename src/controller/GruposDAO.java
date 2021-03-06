/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Grupos;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class GruposDAO extends CustomDAO<Grupos>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Grupos.class);
    }
    
    
    public Grupos getGrupo(Integer empresa, Integer grupo){
        String vSQL = "FROM Grupos where grempresa = "+String.valueOf(empresa) + " and grcodigo = "+String.valueOf(grupo);
        GruposDAO gruposDAO = new GruposDAO();                
        List<Grupos> listData = gruposDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    } 
    
}