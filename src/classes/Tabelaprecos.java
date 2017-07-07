package classes;
// Generated 06/07/2017 22:21:10 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tabelaprecos generated by hbm2java
 */
public class Tabelaprecos  implements java.io.Serializable {


     private TabelaprecosId id;
     private Empresa empresa;
     private String tpnome;
     private String tpobs;
     private Date tpdatatabela;
     private Date tpdataatu;
     private Date tphoraatu;

    public Tabelaprecos() {
    }

	
    public Tabelaprecos(TabelaprecosId id, Empresa empresa) {
        this.id = id;
        this.empresa = empresa;
    }
    public Tabelaprecos(TabelaprecosId id, Empresa empresa, String tpnome, String tpobs, Date tpdatatabela, Date tpdataatu, Date tphoraatu) {
       this.id = id;
       this.empresa = empresa;
       this.tpnome = tpnome;
       this.tpobs = tpobs;
       this.tpdatatabela = tpdatatabela;
       this.tpdataatu = tpdataatu;
       this.tphoraatu = tphoraatu;
    }
   
    public TabelaprecosId getId() {
        return this.id;
    }
    
    public void setId(TabelaprecosId id) {
        this.id = id;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getTpnome() {
        return this.tpnome;
    }
    
    public void setTpnome(String tpnome) {
        this.tpnome = tpnome;
    }
    public String getTpobs() {
        return this.tpobs;
    }
    
    public void setTpobs(String tpobs) {
        this.tpobs = tpobs;
    }
    public Date getTpdatatabela() {
        return this.tpdatatabela;
    }
    
    public void setTpdatatabela(Date tpdatatabela) {
        this.tpdatatabela = tpdatatabela;
    }
    public Date getTpdataatu() {
        return this.tpdataatu;
    }
    
    public void setTpdataatu(Date tpdataatu) {
        this.tpdataatu = tpdataatu;
    }
    public Date getTphoraatu() {
        return this.tphoraatu;
    }
    
    public void setTphoraatu(Date tphoraatu) {
        this.tphoraatu = tphoraatu;
    }




}


