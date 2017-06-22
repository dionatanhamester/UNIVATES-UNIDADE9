/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Empresa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import util.HibernateUtil;

/**
 *
 * @author Dionatan
 */
public class EmpresaDAO extends CustomDAO<Empresa>{
    
    public Integer getAutoIncrement() {
        SequencesDAO sequences = new SequencesDAO();
        
        return sequences.getID(Empresa.class);
    }
    
}
