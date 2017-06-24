package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tabelaprecosdetalhes generated by hbm2java
 */
@Entity
@Table(name="tabelaprecosdetalhes"
    ,schema="public"
)
public class Tabelaprecosdetalhes  implements java.io.Serializable {


     private TabelaprecosdetalhesId id;
     private BigDecimal tdpreco;
     private Set itenspedidos = new HashSet(0);

    public Tabelaprecosdetalhes() {
    }

	
    public Tabelaprecosdetalhes(TabelaprecosdetalhesId id, BigDecimal tdpreco) {
        this.id = id;
        this.tdpreco = tdpreco;
    }
    public Tabelaprecosdetalhes(TabelaprecosdetalhesId id, BigDecimal tdpreco, Set itenspedidos) {
       this.id = id;
       this.tdpreco = tdpreco;
       this.itenspedidos = itenspedidos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="tdempresa", column=@Column(name="tdempresa", nullable=false) ), 
        @AttributeOverride(name="tdtabelapreco", column=@Column(name="tdtabelapreco", nullable=false) ), 
        @AttributeOverride(name="tdproduto", column=@Column(name="tdproduto", nullable=false) ) } )
    public TabelaprecosdetalhesId getId() {
        return this.id;
    }
    
    public void setId(TabelaprecosdetalhesId id) {
        this.id = id;
    }

    
    @Column(name="tdpreco", nullable=false, precision=15)
    public BigDecimal getTdpreco() {
        return this.tdpreco;
    }
    
    public void setTdpreco(BigDecimal tdpreco) {
        this.tdpreco = tdpreco;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tabelaprecosdetalhes")
    public Set getItenspedidos() {
        return this.itenspedidos;
    }
    
    public void setItenspedidos(Set itenspedidos) {
        this.itenspedidos = itenspedidos;
    }




}

