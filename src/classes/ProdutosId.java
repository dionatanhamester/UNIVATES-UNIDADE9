package classes;
// Generated 06/07/2017 22:21:10 by Hibernate Tools 4.3.1



/**
 * ProdutosId generated by hbm2java
 */
public class ProdutosId  implements java.io.Serializable {


     private int prempresa;
     private int prcodigo;

    public ProdutosId() {
    }

    public ProdutosId(int prempresa, int prcodigo) {
       this.prempresa = prempresa;
       this.prcodigo = prcodigo;
    }
   
    public int getPrempresa() {
        return this.prempresa;
    }
    
    public void setPrempresa(int prempresa) {
        this.prempresa = prempresa;
    }
    public int getPrcodigo() {
        return this.prcodigo;
    }
    
    public void setPrcodigo(int prcodigo) {
        this.prcodigo = prcodigo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProdutosId) ) return false;
		 ProdutosId castOther = ( ProdutosId ) other; 
         
		 return (this.getPrempresa()==castOther.getPrempresa())
 && (this.getPrcodigo()==castOther.getPrcodigo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPrempresa();
         result = 37 * result + this.getPrcodigo();
         return result;
   }   


}


