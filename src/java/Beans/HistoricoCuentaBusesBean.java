/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import controller.HistoricoCuentaBusesFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "historicoCuentaBusesBean")
@RequestScoped
public class HistoricoCuentaBusesBean {

    @EJB
    private HistoricoCuentaBusesFacade busesFacade;
    private List<Object[]> listadoCuentaBuses;

    public List<Object[]> getListadoCuentaBuses() {
        return listadoCuentaBuses;
    }

    public void setListadoCuentaBuses(List<Object[]> listadoCuentaBuses) {
        this.listadoCuentaBuses = listadoCuentaBuses;
    }
    @PostConstruct
    public void llenarTabla(){
    listadoCuentaBuses=busesFacade.getBusesListado();
    }
    public HistoricoCuentaBusesBean() {
    }
    
}
