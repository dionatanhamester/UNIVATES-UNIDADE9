/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Itenspedido;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class ItensPedidoDAO extends CustomDAO<Itenspedido>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Itenspedido.class);
    }
    
    public Itenspedido getItensPedido(Integer empresa, Integer pedido, Integer produto){
        String vSQL = "FROM Itenspedido where ipempresa = "+String.valueOf(empresa) + " and ippedido = "+String.valueOf(pedido) + " and ipproduto = "+String.valueOf(produto);
                        
        ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();                
        List<Itenspedido> listData = itenspedidoDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    }
    
}
