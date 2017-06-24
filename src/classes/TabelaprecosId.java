package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TabelaprecosId generated by hbm2java
 */
@Embeddable
public class TabelaprecosId  implements java.io.Serializable {


     private int tpempresa;
     private int tpcodigo;

    public TabelaprecosId() {
    }

    public TabelaprecosId(int tpempresa, int tpcodigo) {
       this.tpempresa = tpempresa;
       this.tpcodigo = tpcodigo;
    }
   


    @Column(name="tpempresa", nullable=false)
    public int getTpempresa() {
        return this.tpempresa;
    }
    
    public void setTpempresa(int tpempresa) {
        this.tpempresa = tpempresa;
    }


    @Column(name="tpcodigo", nullable=false)
    public int getTpcodigo() {
        return this.tpcodigo;
    }
    
    public void setTpcodigo(int tpcodigo) {
        this.tpcodigo = tpcodigo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TabelaprecosId) ) return false;
		 TabelaprecosId castOther = ( TabelaprecosId ) other; 
         
		 return (this.getTpempresa()==castOther.getTpempresa())
 && (this.getTpcodigo()==castOther.getTpcodigo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTpempresa();
         result = 37 * result + this.getTpcodigo();
         return result;
   }   


}


