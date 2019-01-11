/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import controller.HistoricoSumKMSFacade;
import entities.HistoricoSumKMS;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "busquedaHistoricoSumKmsBean")
@SessionScoped
public class BusquedaHistoricoSumKmsBean implements Serializable {

    private String txt_operador_a_buscar="";
    private String txt_ruta_a_buscar="";
    private String txt_tipologia_a_buscar="";
    private String txt_tipo_evento_a_buscar="";
    private Date date1;
    private  Date date2;
    private List<HistoricoSumKMS> listKmsIntervalo= new ArrayList<>();
    @EJB
    private HistoricoSumKMSFacade connSumKmsFacade;

    public String getTxt_operador_a_buscar() {
        return txt_operador_a_buscar;
    }

    public void setTxt_operador_a_buscar(String txt_operador_a_buscar) {
        this.txt_operador_a_buscar = txt_operador_a_buscar;
    }

    public String getTxt_ruta_a_buscar() {
        return txt_ruta_a_buscar;
    }

    public void setTxt_ruta_a_buscar(String txt_ruta_a_buscar) {
        this.txt_ruta_a_buscar = txt_ruta_a_buscar;
    }

    public String getTxt_tipologia_a_buscar() {
        return txt_tipologia_a_buscar;
    }

    public void setTxt_tipologia_a_buscar(String txt_tipologia_a_buscar) {
        this.txt_tipologia_a_buscar = txt_tipologia_a_buscar;
    }

    public String getTxt_tipo_evento_a_buscar() {
        return txt_tipo_evento_a_buscar;
    }

    public void setTxt_tipo_evento_a_buscar(String txt_tipo_evento_a_buscar) {
        this.txt_tipo_evento_a_buscar = txt_tipo_evento_a_buscar;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public List<HistoricoSumKMS> getListKmsIntervalo() {
        return listKmsIntervalo;
    }

    public void setListKmsIntervalo(List<HistoricoSumKMS> listKmsIntervalo) {
        this.listKmsIntervalo = listKmsIntervalo;
    }
    
    
    public BusquedaHistoricoSumKmsBean() {
    }
    public void llenarTablaKms(){
    listKmsIntervalo=connSumKmsFacade.consultar_Kms_Intervalo(date1, date2, txt_operador_a_buscar, txt_ruta_a_buscar,  txt_tipo_evento_a_buscar, txt_tipologia_a_buscar);
    }
    
}
