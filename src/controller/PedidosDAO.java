/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import classes.Itenspedido;
import classes.Pedidos;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class PedidosDAO  extends CustomDAO<Pedidos>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();        
        return sequences.getID(Pedidos.class);
    }
    
    public boolean deleteAllItens(Pedidos pedido){
        boolean vReturn = true;
        try{
            String vSQL = "FROM Itenspedido where ippedido = "+String.valueOf(pedido.getId().getPepedido())+
                      " AND ipusuario = "+ String.valueOf(Main.usuarioAcessado.getId().getUscodigo()) +
                      " AND ipempresa = "+ String.valueOf(Main.empresaSelecionada.getEmcodigo());
            
            ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
            List<Itenspedido> list = itensPedidoDAO.consultaSQL(vSQL);
            
            for (int i = 0; i < list.size(); i++){
                itensPedidoDAO.Delete(list.get(i));
            }            
        } catch (Exception ex){
            vReturn = false;
            
        }                           
        
        return vReturn;
    }
}
