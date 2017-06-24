/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Produtos;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class ProdutosDAO extends CustomDAO<Produtos>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Produtos.class);
    }
    
    public Produtos getProduto(Integer empresa, Integer produto){
        String vSQL = "FROM Produtos where prempresa = "+String.valueOf(empresa) + " and prcodigo = "+String.valueOf(produto);
        ProdutosDAO produtosDAO = new ProdutosDAO();                
        List<Produtos> listData = produtosDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    }    
}