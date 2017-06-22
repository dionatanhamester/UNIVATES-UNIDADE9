package classes;
// Generated 18/06/2017 19:11:25 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tabelaprecos generated by hbm2java
 */
@Entity
@Table(name="tabelaprecos"
    ,schema="public"
)
public class Tabelaprecos  implements java.io.Serializable {


     private TabelaprecosId id;
     private Empresa empresa;
     private String tpnome;
     private String tpobs;
     private Date tpdatatabela;
     private Date tpdataatu;
     private Date tphoraatu;
     private Set<Tabelaprecosdetalhes> tabelaprecosdetalheses = new HashSet<Tabelaprecosdetalhes>(0);

    public Tabelaprecos() {
    }

	
    public Tabelaprecos(TabelaprecosId id, Empresa empresa) {
        this.id = id;
        this.empresa = empresa;
    }
    public Tabelaprecos(TabelaprecosId id, Empresa empresa, String tpnome, String tpobs, Date tpdatatabela, Date tpdataatu, Date tphoraatu, Set<Tabelaprecosdetalhes> tabelaprecosdetalheses) {
       this.id = id;
       this.empresa = empresa;
       this.tpnome = tpnome;
       this.tpobs = tpobs;
       this.tpdatatabela = tpdatatabela;
       this.tpdataatu = tpdataatu;
       this.tphoraatu = tphoraatu;
       this.tabelaprecosdetalheses = tabelaprecosdetalheses;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="tpempresa", column=@Column(name="tpempresa", nullable=false) ), 
        @AttributeOverride(name="tpcodigo", column=@Column(name="tpcodigo", nullable=false) ) } )
    public TabelaprecosId getId() {
        return this.id;
    }
    
    public void setId(TabelaprecosId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tpempresa", nullable=false, insertable=false, updatable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    @Column(name="tpnome", length=50)
    public String getTpnome() {
        return this.tpnome;
    }
    
    public void setTpnome(String tpnome) {
        this.tpnome = tpnome;
    }

    
    @Column(name="tpobs")
    public String getTpobs() {
        return this.tpobs;
    }
    
    public void setTpobs(String tpobs) {
        this.tpobs = tpobs;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tpdatatabela", length=13)
    public Date getTpdatatabela() {
        return this.tpdatatabela;
    }
    
    public void setTpdatatabela(Date tpdatatabela) {
        this.tpdatatabela = tpdatatabela;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tpdataatu", length=13)
    public Date getTpdataatu() {
        return this.tpdataatu;
    }
    
    public void setTpdataatu(Date tpdataatu) {
        this.tpdataatu = tpdataatu;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="tphoraatu", length=15)
    public Date getTphoraatu() {
        return this.tphoraatu;
    }
    
    public void setTphoraatu(Date tphoraatu) {
        this.tphoraatu = tphoraatu;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tabelaprecos")
    public Set<Tabelaprecosdetalhes> getTabelaprecosdetalheses() {
        return this.tabelaprecosdetalheses;
    }
    
    public void setTabelaprecosdetalheses(Set<Tabelaprecosdetalhes> tabelaprecosdetalheses) {
        this.tabelaprecosdetalheses = tabelaprecosdetalheses;
    }




}


