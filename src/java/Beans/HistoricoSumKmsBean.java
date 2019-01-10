/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import controller.HistoricoSumKMSFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author girlesa.buitrago
 */
@Named(value = "historicoSumKmsBean")
@RequestScoped
public class HistoricoSumKmsBean {

    /**
     * Creates a new instance of HistoricoSumKmsBean
     */
    public HistoricoSumKmsBean() {
    }
     @EJB
    private HistoricoSumKMSFacade kmsFacade;
    private List<Object[]> listadoKms;
            
       public List<Object[]> getListadoKms() {
        return listadoKms;
    }

    public void setListadoKms(List<Object[]> listadoKms) {
        this.listadoKms = listadoKms;
    }
    @PostConstruct
     public void llenarArregloKms(){
         listadoKms=kmsFacade.obtenerKilometrosMes();
        
        
    
    }
    
}
