package classes;
// Generated 06/07/2017 22:21:10 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private int emcodigo;
     private String emrazaosocial;
     private String emfantasia;
     private String emcnpj;
     private String emcep;
     private String emuf;
     private String embairro;
     private String emcidade;
     private String emendereco;
     private String ememail;
     private String emtelefone;
     private Date emdataatu;
     private Date emhoraatu;
     private Set produtoses = new HashSet(0);
     private Set gruposes = new HashSet(0);
     private Set formaspgtos = new HashSet(0);
     private Set tabelaprecoses = new HashSet(0);
     private Set clienteses = new HashSet(0);
     private Set pedidoses = new HashSet(0);
     private Set usuarios = new HashSet(0);

    public Empresa() {
    }

	
    public Empresa(int emcodigo, String emcnpj, String emcep) {
        this.emcodigo = emcodigo;
        this.emcnpj = emcnpj;
        this.emcep = emcep;
    }
    public Empresa(int emcodigo, String emrazaosocial, String emfantasia, String emcnpj, String emcep, String emuf, String embairro, String emcidade, String emendereco, String ememail, String emtelefone, Date emdataatu, Date emhoraatu, Set produtoses, Set gruposes, Set formaspgtos, Set tabelaprecoses, Set clienteses, Set pedidoses, Set usuarios) {
       this.emcodigo = emcodigo;
       this.emrazaosocial = emrazaosocial;
       this.emfantasia = emfantasia;
       this.emcnpj = emcnpj;
       this.emcep = emcep;
       this.emuf = emuf;
       this.embairro = embairro;
       this.emcidade = emcidade;
       this.emendereco = emendereco;
       this.ememail = ememail;
       this.emtelefone = emtelefone;
       this.emdataatu = emdataatu;
       this.emhoraatu = emhoraatu;
       this.produtoses = produtoses;
       this.gruposes = gruposes;
       this.formaspgtos = formaspgtos;
       this.tabelaprecoses = tabelaprecoses;
       this.clienteses = clienteses;
       this.pedidoses = pedidoses;
       this.usuarios = usuarios;
    }
   
    public int getEmcodigo() {
        return this.emcodigo;
    }
    
    public void setEmcodigo(int emcodigo) {
        this.emcodigo = emcodigo;
    }
    public String getEmrazaosocial() {
        return this.emrazaosocial;
    }
    
    public void setEmrazaosocial(String emrazaosocial) {
        this.emrazaosocial = emrazaosocial;
    }
    public String getEmfantasia() {
        return this.emfantasia;
    }
    
    public void setEmfantasia(String emfantasia) {
        this.emfantasia = emfantasia;
    }
    public String getEmcnpj() {
        return this.emcnpj;
    }
    
    public void setEmcnpj(String emcnpj) {
        this.emcnpj = emcnpj;
    }
    public String getEmcep() {
        return this.emcep;
    }
    
    public void setEmcep(String emcep) {
        this.emcep = emcep;
    }
    public String getEmuf() {
        return this.emuf;
    }
    
    public void setEmuf(String emuf) {
        this.emuf = emuf;
    }
    public String getEmbairro() {
        return this.embairro;
    }
    
    public void setEmbairro(String embairro) {
        this.embairro = embairro;
    }
    public String getEmcidade() {
        return this.emcidade;
    }
    
    public void setEmcidade(String emcidade) {
        this.emcidade = emcidade;
    }
    public String getEmendereco() {
        return this.emendereco;
    }
    
    public void setEmendereco(String emendereco) {
        this.emendereco = emendereco;
    }
    public String getEmemail() {
        return this.ememail;
    }
    
    public void setEmemail(String ememail) {
        this.ememail = ememail;
    }
    public String getEmtelefone() {
        return this.emtelefone;
    }
    
    public void setEmtelefone(String emtelefone) {
        this.emtelefone = emtelefone;
    }
    public Date getEmdataatu() {
        return this.emdataatu;
    }
    
    public void setEmdataatu(Date emdataatu) {
        this.emdataatu = emdataatu;
    }
    public Date getEmhoraatu() {
        return this.emhoraatu;
    }
    
    public void setEmhoraatu(Date emhoraatu) {
        this.emhoraatu = emhoraatu;
    }
    public Set getProdutoses() {
        return this.produtoses;
    }
    
    public void setProdutoses(Set produtoses) {
        this.produtoses = produtoses;
    }
    public Set getGruposes() {
        return this.gruposes;
    }
    
    public void setGruposes(Set gruposes) {
        this.gruposes = gruposes;
    }
    public Set getFormaspgtos() {
        return this.formaspgtos;
    }
    
    public void setFormaspgtos(Set formaspgtos) {
        this.formaspgtos = formaspgtos;
    }
    public Set getTabelaprecoses() {
        return this.tabelaprecoses;
    }
    
    public void setTabelaprecoses(Set tabelaprecoses) {
        this.tabelaprecoses = tabelaprecoses;
    }
    public Set getClienteses() {
        return this.clienteses;
    }
    
    public void setClienteses(Set clienteses) {
        this.clienteses = clienteses;
    }
    public Set getPedidoses() {
        return this.pedidoses;
    }
    
    public void setPedidoses(Set pedidoses) {
        this.pedidoses = pedidoses;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


