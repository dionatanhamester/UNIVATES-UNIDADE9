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
import classes.Tabelaprecosdetalhes;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class TabelaPrecosDetalhesDAO extends CustomDAO<Tabelaprecosdetalhes>{
    
    public Integer getAutoIncrement() {
        return -1;
    }
    

    public Tabelaprecosdetalhes getTabela(Integer empresa, Integer tabelapreco, Integer produto){
        String vSQL = "FROM Tabelaprecosdetalhes where tdempresa = "+String.valueOf(empresa) + " and tdtabelapreco = "+String.valueOf(tabelapreco)+" and tdproduto = "+String.valueOf(produto);                
        TabelaPrecosDetalhesDAO tabelaprecosdetalhesDAO = new TabelaPrecosDetalhesDAO();                
        List<Tabelaprecosdetalhes> listData = tabelaprecosdetalhesDAO.consultaSQL(vSQL);        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    }      
    
    public boolean jaExiste(Integer empresa, Integer tabelapreco, Integer produto){
        String vSQL = "FROM Tabelaprecosdetalhes where tdempresa = "+String.valueOf(empresa) + " and tdtabelapreco = "+String.valueOf(tabelapreco)+" and tdproduto = "+String.valueOf(produto);                
        TabelaPrecosDetalhesDAO tabelaprecosdetalhesDAO = new TabelaPrecosDetalhesDAO();                
        List<Tabelaprecosdetalhes> listData = tabelaprecosdetalhesDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return true;
        } else {
            return false;
        }
    }
    
}