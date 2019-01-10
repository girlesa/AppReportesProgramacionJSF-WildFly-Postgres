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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author girlesa.buitrago
 */
@Entity
@Table(name = "Historico_Cuenta_Expediciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoCuentaExpediciones.findAll", query = "SELECT h FROM HistoricoCuentaExpediciones h")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findById", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.id = :id")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByCuadro", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.cuadro = :cuadro")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByLinea", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.linea = :linea")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByTipoEvento", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByCuentaexpediciones", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.cuentaexpediciones = :cuentaexpediciones")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByTipologia", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.tipologia = :tipologia")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByOperador", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.operador = :operador")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByRc", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.rc = :rc")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByFecha", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByMes", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.mes = :mes")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByTipodia", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.tipodia = :tipodia")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findByDiaCal", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.diaCal = :diaCal")
    , @NamedQuery(name = "HistoricoCuentaExpediciones.findBySumar", query = "SELECT h FROM HistoricoCuentaExpediciones h WHERE h.sumar = :sumar")})
public class HistoricoCuentaExpediciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Cuadro")
    private String cuadro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Linea")
    private int linea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo_Evento")
    private String tipoEvento;
    @Column(name = "Cuenta_expediciones")
    private Integer cuentaexpediciones;
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
    @Column(name = "RC")
    private String rc;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo_dia")
    private String tipodia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Dia_Cal")
    private String diaCal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Sumar")
    private Double sumar;

    public HistoricoCuentaExpediciones() {
    }

    public HistoricoCuentaExpediciones(Integer id) {
        this.id = id;
    }

    public HistoricoCuentaExpediciones(Integer id, String cuadro, int linea, String tipoEvento, String tipologia, String operador, String rc, String mes, String tipodia, String diaCal) {
        this.id = id;
        this.cuadro = cuadro;
        this.linea = linea;
        this.tipoEvento = tipoEvento;
        this.tipologia = tipologia;
        this.operador = operador;
        this.rc = rc;
        this.mes = mes;
        this.tipodia = tipodia;
        this.diaCal = diaCal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuadro() {
        return cuadro;
    }

    public void setCuadro(String cuadro) {
        this.cuadro = cuadro;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getCuentaexpediciones() {
        return cuentaexpediciones;
    }

    public void setCuentaexpediciones(Integer cuentaexpediciones) {
        this.cuentaexpediciones = cuentaexpediciones;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTipodia() {
        return tipodia;
    }

    public void setTipodia(String tipodia) {
        this.tipodia = tipodia;
    }

    public String getDiaCal() {
        return diaCal;
    }

    public void setDiaCal(String diaCal) {
        this.diaCal = diaCal;
    }

    public Double getSumar() {
        return sumar;
    }

    public void setSumar(Double sumar) {
        this.sumar = sumar;
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
        if (!(object instanceof HistoricoCuentaExpediciones)) {
            return false;
        }
        HistoricoCuentaExpediciones other = (HistoricoCuentaExpediciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HistoricoCuentaExpediciones[ id=" + id + " ]";
    }
    
}
