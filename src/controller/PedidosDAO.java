/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Pedidos;

/**
 *
 * @author Dionatan
 */
public class PedidosDAO  extends CustomDAO<Pedidos>{
    
        public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();        
        return sequences.getID(Pedidos.class);
    }
}
