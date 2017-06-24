package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Itenspedido generated by hbm2java
 */
@Entity
@Table(name="itenspedido"
    ,schema="public"
)
public class Itenspedido  implements java.io.Serializable {


     private ItenspedidoId id;
     private Pedidos pedidos;
     private Tabelaprecosdetalhes tabelaprecosdetalhes;
     private BigDecimal ipquantidade;
     private BigDecimal ipvalorunit;
     private BigDecimal ipvalortotal;
     private BigDecimal ippercdesconto;
     private Date ipdataatu;
     private Date iphoraatu;
     private String ipobs;

    public Itenspedido() {
    }

	
    public Itenspedido(ItenspedidoId id, Pedidos pedidos, Tabelaprecosdetalhes tabelaprecosdetalhes, BigDecimal ipquantidade, BigDecimal ipvalorunit, BigDecimal ipvalortotal, Date ipdataatu, Date iphoraatu) {
        this.id = id;
        this.pedidos = pedidos;
        this.tabelaprecosdetalhes = tabelaprecosdetalhes;
        this.ipquantidade = ipquantidade;
        this.ipvalorunit = ipvalorunit;
        this.ipvalortotal = ipvalortotal;
        this.ipdataatu = ipdataatu;
        this.iphoraatu = iphoraatu;
    }
    public Itenspedido(ItenspedidoId id, Pedidos pedidos, Tabelaprecosdetalhes tabelaprecosdetalhes, BigDecimal ipquantidade, BigDecimal ipvalorunit, BigDecimal ipvalortotal, BigDecimal ippercdesconto, Date ipdataatu, Date iphoraatu, String ipobs) {
       this.id = id;
       this.pedidos = pedidos;
       this.tabelaprecosdetalhes = tabelaprecosdetalhes;
       this.ipquantidade = ipquantidade;
       this.ipvalorunit = ipvalorunit;
       this.ipvalortotal = ipvalortotal;
       this.ippercdesconto = ippercdesconto;
       this.ipdataatu = ipdataatu;
       this.iphoraatu = iphoraatu;
       this.ipobs = ipobs;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="ipemresa", column=@Column(name="ipemresa", nullable=false) ), 
        @AttributeOverride(name="ipusuario", column=@Column(name="ipusuario", nullable=false) ), 
        @AttributeOverride(name="ippedido", column=@Column(name="ippedido", nullable=false) ), 
        @AttributeOverride(name="ipproduto", column=@Column(name="ipproduto", nullable=false) ) } )
    public ItenspedidoId getId() {
        return this.id;
    }
    
    public void setId(ItenspedidoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ipusuario", referencedColumnName="peusuario", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ippedido", referencedColumnName="peempresa", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ipemresa", referencedColumnName="pepedido", nullable=false, insertable=false, updatable=false) } )
    public Pedidos getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="iptabelapreco", referencedColumnName="tdempresa", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ipproduto", referencedColumnName="tdtabelapreco", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ipemresa", referencedColumnName="tdproduto", nullable=false, insertable=false, updatable=false) } )
    public Tabelaprecosdetalhes getTabelaprecosdetalhes() {
        return this.tabelaprecosdetalhes;
    }
    
    public void setTabelaprecosdetalhes(Tabelaprecosdetalhes tabelaprecosdetalhes) {
        this.tabelaprecosdetalhes = tabelaprecosdetalhes;
    }

    
    @Column(name="ipquantidade", nullable=false, precision=15)
    public BigDecimal getIpquantidade() {
        return this.ipquantidade;
    }
    
    public void setIpquantidade(BigDecimal ipquantidade) {
        this.ipquantidade = ipquantidade;
    }

    
    @Column(name="ipvalorunit", nullable=false, precision=15)
    public BigDecimal getIpvalorunit() {
        return this.ipvalorunit;
    }
    
    public void setIpvalorunit(BigDecimal ipvalorunit) {
        this.ipvalorunit = ipvalorunit;
    }

    
    @Column(name="ipvalortotal", nullable=false, precision=15)
    public BigDecimal getIpvalortotal() {
        return this.ipvalortotal;
    }
    
    public void setIpvalortotal(BigDecimal ipvalortotal) {
        this.ipvalortotal = ipvalortotal;
    }

    
    @Column(name="ippercdesconto", precision=15)
    public BigDecimal getIppercdesconto() {
        return this.ippercdesconto;
    }
    
    public void setIppercdesconto(BigDecimal ippercdesconto) {
        this.ippercdesconto = ippercdesconto;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ipdataatu", nullable=false, length=13)
    public Date getIpdataatu() {
        return this.ipdataatu;
    }
    
    public void setIpdataatu(Date ipdataatu) {
        this.ipdataatu = ipdataatu;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="iphoraatu", nullable=false, length=15)
    public Date getIphoraatu() {
        return this.iphoraatu;
    }
    
    public void setIphoraatu(Date iphoraatu) {
        this.iphoraatu = iphoraatu;
    }

    
    @Column(name="ipobs")
    public String getIpobs() {
        return this.ipobs;
    }
    
    public void setIpobs(String ipobs) {
        this.ipobs = ipobs;
    }




}

