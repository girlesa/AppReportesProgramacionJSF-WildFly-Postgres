/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import controller.HistoricoCuentaBusesFacade;
import entities.HistoricoCuentaBuses;
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
@Named(value = "busquedaHistoricoBusesBean")
@SessionScoped
public class BusquedaHistoricoBusesBean implements Serializable {

    private Date date1;
  private Date date2;
  private String txt_Operador_a_buscar="";
  private String txt_Ruta_a_Buscar="";
  private String txt__Linea_a_Buscar="";
  
  private List<HistoricoCuentaBuses> listFilterBuses=new ArrayList<>();
 
 @EJB
 private HistoricoCuentaBusesFacade connBusesFacadeAll;

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

    public String getTxt_Operador_a_buscar() {
        return txt_Operador_a_buscar;
    }

    public void setTxt_Operador_a_buscar(String txt_Operador_a_buscar) {
        this.txt_Operador_a_buscar = txt_Operador_a_buscar;
    }

    public String getTxt_Ruta_a_Buscar() {
        return txt_Ruta_a_Buscar;
    }

    public void setTxt_Ruta_a_Buscar(String txt_Ruta_a_Buscar) {
        this.txt_Ruta_a_Buscar = txt_Ruta_a_Buscar;
    }

    public String getTxt__Linea_a_Buscar() {
        return txt__Linea_a_Buscar;
    }

    public void setTxt__Linea_a_Buscar(String txt__Linea_a_Buscar) {
        this.txt__Linea_a_Buscar = txt__Linea_a_Buscar;
    }

    public List<HistoricoCuentaBuses> getListFilterBuses() {
        return listFilterBuses;
    }

    public void setListFilterBuses(List<HistoricoCuentaBuses> listFilterBuses) {
        this.listFilterBuses = listFilterBuses;
    }
  
  
 
    
    public  void llenarListaFilterBuses(){
        listFilterBuses=connBusesFacadeAll.consultarBusesAll(date1, date2, txt_Operador_a_buscar,  txt_Ruta_a_Buscar,txt__Linea_a_Buscar);
                
    }
    
    public BusquedaHistoricoBusesBean() {
    }
    
}
