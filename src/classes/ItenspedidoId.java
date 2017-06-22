package classes;
// Generated 18/06/2017 19:11:25 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ItenspedidoId generated by hbm2java
 */
@Embeddable
public class ItenspedidoId  implements java.io.Serializable {


     private int ipemresa;
     private int ipusuario;
     private int ippedido;
     private int ipproduto;

    public ItenspedidoId() {
    }

    public ItenspedidoId(int ipemresa, int ipusuario, int ippedido, int ipproduto) {
       this.ipemresa = ipemresa;
       this.ipusuario = ipusuario;
       this.ippedido = ippedido;
       this.ipproduto = ipproduto;
    }
   


    @Column(name="ipemresa", nullable=false)
    public int getIpemresa() {
        return this.ipemresa;
    }
    
    public void setIpemresa(int ipemresa) {
        this.ipemresa = ipemresa;
    }


    @Column(name="ipusuario", nullable=false)
    public int getIpusuario() {
        return this.ipusuario;
    }
    
    public void setIpusuario(int ipusuario) {
        this.ipusuario = ipusuario;
    }


    @Column(name="ippedido", nullable=false)
    public int getIppedido() {
        return this.ippedido;
    }
    
    public void setIppedido(int ippedido) {
        this.ippedido = ippedido;
    }


    @Column(name="ipproduto", nullable=false)
    public int getIpproduto() {
        return this.ipproduto;
    }
    
    public void setIpproduto(int ipproduto) {
        this.ipproduto = ipproduto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItenspedidoId) ) return false;
		 ItenspedidoId castOther = ( ItenspedidoId ) other; 
         
		 return (this.getIpemresa()==castOther.getIpemresa())
 && (this.getIpusuario()==castOther.getIpusuario())
 && (this.getIppedido()==castOther.getIppedido())
 && (this.getIpproduto()==castOther.getIpproduto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIpemresa();
         result = 37 * result + this.getIpusuario();
         result = 37 * result + this.getIppedido();
         result = 37 * result + this.getIpproduto();
         return result;
   }   


}


