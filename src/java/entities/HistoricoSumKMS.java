/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author girlesa.buitrago
 */
@Entity
@Table(name = "Historico_Sum_KMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoSumKMS.findAll", query = "SELECT h FROM HistoricoSumKMS h")
    , @NamedQuery(name = "HistoricoSumKMS.findById", query = "SELECT h FROM HistoricoSumKMS h WHERE h.id = :id")
    , @NamedQuery(name = "HistoricoSumKMS.findByCuadro", query = "SELECT h FROM HistoricoSumKMS h WHERE h.cuadro = :cuadro")
    , @NamedQuery(name = "HistoricoSumKMS.findByLinea", query = "SELECT h FROM HistoricoSumKMS h WHERE h.linea = :linea")
    , @NamedQuery(name = "HistoricoSumKMS.findByTipoEvento", query = "SELECT h FROM HistoricoSumKMS h WHERE h.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "HistoricoSumKMS.findByKms", query = "SELECT h FROM HistoricoSumKMS h WHERE h.kms = :kms")
    , @NamedQuery(name = "HistoricoSumKMS.findByTipologia", query = "SELECT h FROM HistoricoSumKMS h WHERE h.tipologia = :tipologia")
    , @NamedQuery(name = "HistoricoSumKMS.findByOperador", query = "SELECT h FROM HistoricoSumKMS h WHERE h.operador = :operador")
    , @NamedQuery(name = "HistoricoSumKMS.findByRc", query = "SELECT h FROM HistoricoSumKMS h WHERE h.rc = :rc")
    , @NamedQuery(name = "HistoricoSumKMS.findByFecha", query = "SELECT h FROM HistoricoSumKMS h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistoricoSumKMS.findByTipodia", query = "SELECT h FROM HistoricoSumKMS h WHERE h.tipodia = :tipodia")})
public class HistoricoSumKMS implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Double id;
    @Size(max = 10)
    @Column(name = "Cuadro")
    private String cuadro;
    @Column(name = "Linea")
    private Double linea;
    @Size(max = 10)
    @Column(name = "Tipo_Evento")
    private String tipoEvento;
    @Column(name = "kms")
    private Double kms;
    @Size(max = 255)
    @Column(name = "Tipologia")
    private String tipologia;
    @Size(max = 255)
    @Column(name = "Operador")
    private String operador;
    @Size(max = 255)
    @Column(name = "RC")
    private String rc;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "Tipo_dia")
    private String tipodia;

    public HistoricoSumKMS() {
    }

    public HistoricoSumKMS(Double id) {
        this.id = id;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getCuadro() {
        return cuadro;
    }

    public void setCuadro(String cuadro) {
        this.cuadro = cuadro;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Double getKms() {
        return kms;
    }

    public void setKms(Double kms) {
        this.kms = kms;
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

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoSumKMS)) {
            return false;
        }
        HistoricoSumKMS other = (HistoricoSumKMS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HistoricoSumKMS[ id=" + id + " ]";
    }
    
}
