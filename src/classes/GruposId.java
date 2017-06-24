package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GruposId generated by hbm2java
 */
@Embeddable
public class GruposId  implements java.io.Serializable {


     private int grempresa;
     private int grcodigo;

    public GruposId() {
    }

    public GruposId(int grempresa, int grcodigo) {
       this.grempresa = grempresa;
       this.grcodigo = grcodigo;
    }
   


    @Column(name="grempresa", nullable=false)
    public int getGrempresa() {
        return this.grempresa;
    }
    
    public void setGrempresa(int grempresa) {
        this.grempresa = grempresa;
    }


    @Column(name="grcodigo", nullable=false)
    public int getGrcodigo() {
        return this.grcodigo;
    }
    
    public void setGrcodigo(int grcodigo) {
        this.grcodigo = grcodigo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GruposId) ) return false;
		 GruposId castOther = ( GruposId ) other; 
         
		 return (this.getGrempresa()==castOther.getGrempresa())
 && (this.getGrcodigo()==castOther.getGrcodigo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getGrempresa();
         result = 37 * result + this.getGrcodigo();
         return result;
   }   


}

