package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsuarioId generated by hbm2java
 */
@Embeddable
public class UsuarioId  implements java.io.Serializable {


     private int uscodigo;
     private int usempresa;

    public UsuarioId() {
    }

    public UsuarioId(int uscodigo, int usempresa) {
       this.uscodigo = uscodigo;
       this.usempresa = usempresa;
    }
   


    @Column(name="uscodigo", nullable=false)
    public int getUscodigo() {
        return this.uscodigo;
    }
    
    public void setUscodigo(int uscodigo) {
        this.uscodigo = uscodigo;
    }


    @Column(name="usempresa", nullable=false)
    public int getUsempresa() {
        return this.usempresa;
    }
    
    public void setUsempresa(int usempresa) {
        this.usempresa = usempresa;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuarioId) ) return false;
		 UsuarioId castOther = ( UsuarioId ) other; 
         
		 return (this.getUscodigo()==castOther.getUscodigo())
 && (this.getUsempresa()==castOther.getUsempresa());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUscodigo();
         result = 37 * result + this.getUsempresa();
         return result;
   }   


}


