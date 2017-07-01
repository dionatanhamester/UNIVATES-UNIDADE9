/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Clientes;
import java.util.List;

/**
 *
 * @author Dionatan
 */
public class ClientesDAO extends CustomDAO<Clientes>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();        
        return sequences.getID(Clientes.class);
    }
        
    public Clientes getCliente(Integer empresa, Integer clie){
        String vSQL = "FROM Clientes where clempresa = "+String.valueOf(empresa) + " and clcodigo = "+String.valueOf(clie);
        ClientesDAO clienteDAO = new ClientesDAO();                
        List<Clientes> listData = clienteDAO.consultaSQL(vSQL);
        
        if (listData.size() > 0){
            return listData.get(0);
        } else {
            return null;
        }
    }    
}