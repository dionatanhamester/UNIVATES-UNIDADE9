package classes;
// Generated 06/07/2017 22:21:10 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Grupos generated by hbm2java
 */
public class Grupos  implements java.io.Serializable {


     private GruposId id;
     private Empresa empresa;
     private String grnome;
     private Date grdataatu;
     private Date grhoraatu;

    public Grupos() {
    }

	
    public Grupos(GruposId id, Empresa empresa, Date grdataatu, Date grhoraatu) {
        this.id = id;
        this.empresa = empresa;
        this.grdataatu = grdataatu;
        this.grhoraatu = grhoraatu;
    }
    public Grupos(GruposId id, Empresa empresa, String grnome, Date grdataatu, Date grhoraatu) {
       this.id = id;
       this.empresa = empresa;
       this.grnome = grnome;
       this.grdataatu = grdataatu;
       this.grhoraatu = grhoraatu;
    }
   
    public GruposId getId() {
        return this.id;
    }
    
    public void setId(GruposId id) {
        this.id = id;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getGrnome() {
        return this.grnome;
    }
    
    public void setGrnome(String grnome) {
        this.grnome = grnome;
    }
    public Date getGrdataatu() {
        return this.grdataatu;
    }
    
    public void setGrdataatu(Date grdataatu) {
        this.grdataatu = grdataatu;
    }
    public Date getGrhoraatu() {
        return this.grhoraatu;
    }
    
    public void setGrhoraatu(Date grhoraatu) {
        this.grhoraatu = grhoraatu;
    }




}


