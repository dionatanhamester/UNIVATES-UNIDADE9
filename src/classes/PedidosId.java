package classes;
// Generated 18/06/2017 19:11:25 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PedidosId generated by hbm2java
 */
@Embeddable
public class PedidosId  implements java.io.Serializable {


     private int peusuario;
     private int peempresa;
     private int pepedido;

    public PedidosId() {
    }

    public PedidosId(int peusuario, int peempresa, int pepedido) {
       this.peusuario = peusuario;
       this.peempresa = peempresa;
       this.pepedido = pepedido;
    }
   


    @Column(name="peusuario", nullable=false)
    public int getPeusuario() {
        return this.peusuario;
    }
    
    public void setPeusuario(int peusuario) {
        this.peusuario = peusuario;
    }


    @Column(name="peempresa", nullable=false)
    public int getPeempresa() {
        return this.peempresa;
    }
    
    public void setPeempresa(int peempresa) {
        this.peempresa = peempresa;
    }


    @Column(name="pepedido", nullable=false)
    public int getPepedido() {
        return this.pepedido;
    }
    
    public void setPepedido(int pepedido) {
        this.pepedido = pepedido;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PedidosId) ) return false;
		 PedidosId castOther = ( PedidosId ) other; 
         
		 return (this.getPeusuario()==castOther.getPeusuario())
 && (this.getPeempresa()==castOther.getPeempresa())
 && (this.getPepedido()==castOther.getPepedido());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPeusuario();
         result = 37 * result + this.getPeempresa();
         result = 37 * result + this.getPepedido();
         return result;
   }   


}


