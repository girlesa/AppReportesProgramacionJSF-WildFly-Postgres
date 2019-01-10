/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoCuentaBuses;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author girlesa.buitrago
 */
@Stateless
public class HistoricoCuentaBusesFacade extends AbstractFacade<HistoricoCuentaBuses> {

    @PersistenceContext(unitName = "ReportesProgramacion4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoCuentaBusesFacade() {
        super(HistoricoCuentaBuses.class);
    }
    public List getBusesListado(){
        Query q;
        q=em.createNativeQuery("SELECT \"ID\", \"RC\", \"Tipologia\", \"Operador\", \"ZONA\", \"Conteo_Buses_Tipologia\", \n" +
    "       \"Linea\", \"Ruta_Com\", \"Fecha\", \"Tipo_dia\", \"Mes\", \"Anio\", \"Cuenta\", \n" +
    "       \"Suma\"\n" +
    "  FROM public.\"Historico_Cuenta_Buses\" WHERE  \"Fecha\" between (select max(\"Fecha\")-30 from \"Historico_Cuenta_Buses\" ) and (select max(\"Fecha\") from \"Historico_Cuenta_Buses\")");
       List<Object[]> listado=q.getResultList();
       return listado;
    
    }
    public List<HistoricoCuentaBuses> consultarBusesAll(Date date1,Date date2,String cadena1,String cadena2,String cadena3){
        
         List<HistoricoCuentaBuses> listBusesAll;
         Query q6;
         q6=em.createNativeQuery("select * from \"Historico_Cuenta_Buses\" where \"Fecha\" between '"+date1+"' and '"+date2+"'and  \"Operador\" ilike '%"+cadena1+"%' and \"Ruta_Com\" ilike'%"+cadena2+"%' and \"Linea\" ilike'%"+cadena3+"%'",HistoricoCuentaBuses.class);
         listBusesAll=q6.getResultList();
         return listBusesAll;
        
    }
    
}
