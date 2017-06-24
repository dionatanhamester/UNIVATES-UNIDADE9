/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Clientes;
import classes.Empresa;
import classes.Grupos;
import classes.Produtos;
import classes.Sequences;
import classes.Tabelaprecos;
import java.util.List;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Dionatan
 */
public class SequencesDAO extends CustomDAO<Sequences>{        
     /*
     * Gera o ID da tabela solicitada
     * @return ID disponível na tabela
     */
    public Integer getID(Class table){
        Integer vID = -1;
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
           String sql = "FROM Sequences";
           List<Sequences> resultado = this.consultaSQL(sql);
           Sequences seq = (Sequences) resultado.get(0);
           
           if ( table.equals(Empresa.class)){
               vID = seq.getGenempresa();
               seq.setGenempresa(vID+1);
           } else if ( table.equals(Clientes.class)){
               vID = seq.getGenclientes();
               seq.setGenclientes(vID+1);
           } else if ( table.equals(Produtos.class)){
               vID = seq.getGenprodutos();
               seq.setGenprodutos(vID+1);
           } else if ( table.equals(Grupos.class)){
               vID = seq.getGengrupos();
               seq.setGengrupos(vID+1);
           } else if ( table.equals(Tabelaprecos.class)){
               vID = seq.getGentabelaprecos();
               seq.setGentabelaprecos(vID+1);
           } 
           
           
           
           SequencesDAO sequencesDAO = new SequencesDAO();
           sequencesDAO.Update(seq);
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vID = -1;
        }   
        
        return vID;
    };    
}
