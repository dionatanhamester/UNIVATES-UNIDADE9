package classes;
// Generated 24/06/2017 11:39:22 by Hibernate Tools 4.3.1


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
 * Clientes generated by hbm2java
 */
@Entity
@Table(name="clientes"
    ,schema="public"
)
public class Clientes  implements java.io.Serializable {


     private ClientesId id;
     private Empresa empresa;
     private String clmatricula;
     private String clnome;
     private String clendereco;
     private String clcidade;
     private String clbairro;
     private String cluf;
     private String clcep;
     private String clfone;
     private String clemail;
     private String clcpf;
     private String clcnpj;
     private String clinativo;
     private Date cldataatu;
     private Date clhoraatu;
     private Set pedidoses = new HashSet(0);

    public Clientes() {
    }

	
    public Clientes(ClientesId id, Empresa empresa, Date cldataatu, Date clhoraatu) {
        this.id = id;
        this.empresa = empresa;
        this.cldataatu = cldataatu;
        this.clhoraatu = clhoraatu;
    }
    public Clientes(ClientesId id, Empresa empresa, String clmatricula, String clnome, String clendereco, String clcidade, String clbairro, String cluf, String clcep, String clfone, String clemail, String clcpf, String clcnpj, String clinativo, Date cldataatu, Date clhoraatu, Set pedidoses) {
       this.id = id;
       this.empresa = empresa;
       this.clmatricula = clmatricula;
       this.clnome = clnome;
       this.clendereco = clendereco;
       this.clcidade = clcidade;
       this.clbairro = clbairro;
       this.cluf = cluf;
       this.clcep = clcep;
       this.clfone = clfone;
       this.clemail = clemail;
       this.clcpf = clcpf;
       this.clcnpj = clcnpj;
       this.clinativo = clinativo;
       this.cldataatu = cldataatu;
       this.clhoraatu = clhoraatu;
       this.pedidoses = pedidoses;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="clempresa", column=@Column(name="clempresa", nullable=false) ), 
        @AttributeOverride(name="clcodigo", column=@Column(name="clcodigo", nullable=false) ) } )
    public ClientesId getId() {
        return this.id;
    }
    
    public void setId(ClientesId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clempresa", nullable=false, insertable=false, updatable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    @Column(name="clmatricula", length=20)
    public String getClmatricula() {
        return this.clmatricula;
    }
    
    public void setClmatricula(String clmatricula) {
        this.clmatricula = clmatricula;
    }

    
    @Column(name="clnome", length=80)
    public String getClnome() {
        return this.clnome;
    }
    
    public void setClnome(String clnome) {
        this.clnome = clnome;
    }

    
    @Column(name="clendereco", length=100)
    public String getClendereco() {
        return this.clendereco;
    }
    
    public void setClendereco(String clendereco) {
        this.clendereco = clendereco;
    }

    
    @Column(name="clcidade", length=50)
    public String getClcidade() {
        return this.clcidade;
    }
    
    public void setClcidade(String clcidade) {
        this.clcidade = clcidade;
    }

    
    @Column(name="clbairro", length=30)
    public String getClbairro() {
        return this.clbairro;
    }
    
    public void setClbairro(String clbairro) {
        this.clbairro = clbairro;
    }

    
    @Column(name="cluf", length=2)
    public String getCluf() {
        return this.cluf;
    }
    
    public void setCluf(String cluf) {
        this.cluf = cluf;
    }

    
    @Column(name="clcep", length=9)
    public String getClcep() {
        return this.clcep;
    }
    
    public void setClcep(String clcep) {
        this.clcep = clcep;
    }

    
    @Column(name="clfone", length=30)
    public String getClfone() {
        return this.clfone;
    }
    
    public void setClfone(String clfone) {
        this.clfone = clfone;
    }

    
    @Column(name="clemail", length=100)
    public String getClemail() {
        return this.clemail;
    }
    
    public void setClemail(String clemail) {
        this.clemail = clemail;
    }

    
    @Column(name="clcpf", length=11)
    public String getClcpf() {
        return this.clcpf;
    }
    
    public void setClcpf(String clcpf) {
        this.clcpf = clcpf;
    }

    
    @Column(name="clcnpj", length=14)
    public String getClcnpj() {
        return this.clcnpj;
    }
    
    public void setClcnpj(String clcnpj) {
        this.clcnpj = clcnpj;
    }

    
    @Column(name="clinativo", length=1)
    public String getClinativo() {
        return this.clinativo;
    }
    
    public void setClinativo(String clinativo) {
        this.clinativo = clinativo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="cldataatu", nullable=false, length=13)
    public Date getCldataatu() {
        return this.cldataatu;
    }
    
    public void setCldataatu(Date cldataatu) {
        this.cldataatu = cldataatu;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="clhoraatu", nullable=false, length=15)
    public Date getClhoraatu() {
        return this.clhoraatu;
    }
    
    public void setClhoraatu(Date clhoraatu) {
        this.clhoraatu = clhoraatu;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
    public Set getPedidoses() {
        return this.pedidoses;
    }
    
    public void setPedidoses(Set pedidoses) {
        this.pedidoses = pedidoses;
    }




}

