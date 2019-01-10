/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author girlesa.buitrago
 */
@Entity
@Table(name = "Historico_Cuenta_Buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoCuentaBuses.findAll", query = "SELECT h FROM HistoricoCuentaBuses h")
    , @NamedQuery(name = "HistoricoCuentaBuses.findById", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.id = :id")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByRc", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.rc = :rc")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByTipologia", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.tipologia = :tipologia")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByOperador", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.operador = :operador")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByZona", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.zona = :zona")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByConteoBusesTipologia", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.conteoBusesTipologia = :conteoBusesTipologia")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByLinea", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.linea = :linea")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByRutaCom", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.rutaCom = :rutaCom")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByFecha", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByTipodia", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.tipodia = :tipodia")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByMes", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.mes = :mes")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByAnio", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.anio = :anio")
    , @NamedQuery(name = "HistoricoCuentaBuses.findByCuenta", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.cuenta = :cuenta")
    , @NamedQuery(name = "HistoricoCuentaBuses.findBySuma", query = "SELECT h FROM HistoricoCuentaBuses h WHERE h.suma = :suma")})
public class HistoricoCuentaBuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RC")
    private String rc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipologia")
    private String tipologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Operador")
    private String operador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ZONA")
    private String zona;
    @Column(name = "Conteo_Buses_Tipologia")
    private BigInteger conteoBusesTipologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Linea")
    private String linea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Ruta_Com")
    private String rutaCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo_dia")
    private String tipodia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Anio")
    private String anio;
    @Column(name = "Cuenta")
    private Integer cuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Suma")
    private Double suma;

    public HistoricoCuentaBuses() {
    }

    public HistoricoCuentaBuses(Integer id) {
        this.id = id;
    }

    public HistoricoCuentaBuses(Integer id, String rc, String tipologia, String operador, String zona, String linea, String rutaCom, Date fecha, String tipodia, String mes, String anio) {
        this.id = id;
        this.rc = rc;
        this.tipologia = tipologia;
        this.operador = operador;
        this.zona = zona;
        this.linea = linea;
        this.rutaCom = rutaCom;
        this.fecha = fecha;
        this.tipodia = tipodia;
        this.mes = mes;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public BigInteger getConteoBusesTipologia() {
        return conteoBusesTipologia;
    }

    public void setConteoBusesTipologia(BigInteger conteoBusesTipologia) {
        this.conteoBusesTipologia = conteoBusesTipologia;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getRutaCom() {
        return rutaCom;
    }

    public void setRutaCom(String rutaCom) {
        this.rutaCom = rutaCom;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipodia() {
        return tipodia;
    }

    public void setTipodia(String tipodia) {
        this.tipodia = tipodia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoCuentaBuses)) {
            return false;
        }
        HistoricoCuentaBuses other = (HistoricoCuentaBuses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HistoricoCuentaBuses[ id=" + id + " ]";
    }
    
}
