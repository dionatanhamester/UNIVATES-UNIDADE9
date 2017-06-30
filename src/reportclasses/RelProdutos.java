/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportclasses;

/**
 *
 * @author Dionatan
 */
public class RelProdutos {
    private int emcodigo;
    private String emrazaosocial;
    private String emfantasia;
    private String emcidade;
    private String embairro;
    private String emcnpj;
    private String emuf;
    private String emcep;    
    private String prnome;
    private String prunidade;
    private String grnome;   
    private int prcodigo;
    
    public int getEmcodigo(){
        return this.emcodigo;
    }
    
    public void setEmcodigo(int emcodigo){
        this.emcodigo = emcodigo;
    }   
    
    public String getEmrazaosocial (){
        return emrazaosocial;
    }
    
    public void setEmrazaosocial (String emrazaosocial){
        this.emrazaosocial   = emrazaosocial;
    }
    
    public String getEmfantasia (){
        return emfantasia; 
    }
    
    public void setEmfantasia (String emfantasia){
        this.emfantasia   = emfantasia;
    }
    
    public String getEmcidade (){
        return emcidade;
    }
    
    public void setEmcidade (String emcidade){
        this.emcidade   = emcidade;
    }
    
    public String getEmbairro(){
        return embairro;
    }
    
    public void setEmbairro(String embairro){
        this.embairro = embairro;
    }
    
    public String getEmcnpj (){
        return emcnpj;
    }
    
    public void setEmcnpj (String emcnpj){
        this.emcnpj   = emcnpj;
    }
    
    public String getEmuf (){
        return emuf;
    }
    
    public void setEmuf (String emuf){
        this.emuf   = emuf;
    }
    
    public String getEmcep(){
        return emcep;        
    }
    
    public void setEmcep(String emcep){
        this.emcep = emcep;
    }       
    
    public void setPrnome ( String prnome){
        this.prnome  = prnome;
    }
    
    public String getPrnome (){
        return this.prnome;
    }
    
    
    public void setPrunidade ( String prunidade){
        this.prunidade = prunidade;
    }
    
    public String getPrunidade(){
        return this.prunidade  ;
    }
    
    public void setGrnome ( String grnome){
        this.grnome  = grnome;
    }
    
    public String getGrnome(){
        return this.grnome  ;
    }                              
    
    public void setPrcodigo(int codigo){
        this.prcodigo = codigo;
    }
    
    public int getPrcodigo(){
        return this.prcodigo;
    }
}
