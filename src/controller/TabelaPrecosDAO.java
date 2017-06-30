/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import classes.Tabelaprecos;
import util.Convert;

/**
 *
 * @author Dionatan
 */
public class TabelaPrecosDAO extends CustomDAO<Tabelaprecos>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Tabelaprecos.class);
    }
          
    
}