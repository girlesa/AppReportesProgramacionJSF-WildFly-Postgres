/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoCuentaExpediciones;
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
public class HistoricoCuentaExpedicionesFacade extends AbstractFacade<HistoricoCuentaExpediciones> {

    @PersistenceContext(unitName = "ReportesProgramacion4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoCuentaExpedicionesFacade() {
        super(HistoricoCuentaExpediciones.class);
    }
    
    public List ObtenerExpedicionesMes(){
        
            Query q =em.createNativeQuery("SELECT \"Linea\", \"Tipo_Evento\", \"Cuenta_expediciones\", \"Tipologia\", \"Operador\", \"RC\", \"Fecha\", \"Mes\", \"Tipo_dia\", \"Dia_Cal\"\n" +
        "  FROM public.\"Historico_Cuenta_Expediciones\"\n" +
        "   WHERE  \"Fecha\" between (select max(\"Fecha\")-30 from \"Historico_Cuenta_Expediciones\" ) and (select max(\"Fecha\") from \"Historico_Cuenta_Expediciones\")--- (max(\"Fecha\")-1 and ('2018-10-31'))\n" +
        "");


            List<Object[]> listExp=q.getResultList();
            return listExp;
    
    }
    
    public List<HistoricoCuentaExpediciones> consultarExpedicionesAll(Date date1,Date date2,String cadena1,String cadena2,String cadena4){
        
         List<HistoricoCuentaExpediciones> listExpedicionesAll;
         Query q7;
         //q7=em.createNativeQuery("select * from \"Historico_Cuenta_Expediciones\" where \"Fecha\" between '"+date1+"' and '"+date2+"'and  \"Operador\" ilike '%"+cadena1+"%' and \"RC\" ilike'%"+cadena2+"%' and \"Linea\" ilike'%"+cadena3+"%'and \"Tipo_Evento\" ilike'%"+cadena4+"%'",HistoricoCuentaExpediciones.class);
         q7=em.createNativeQuery(" select * from  \"Historico_Cuenta_Expediciones\" where \"Fecha\" between '"+date1+"' and '"+date2+"' and  \"Operador\" ilike '%"+cadena1+"%' and\"RC\" ilike'%"+cadena2+"%'and \"Tipo_Evento\" ilike'%"+cadena4+"%'", HistoricoCuentaExpediciones.class);
         
         listExpedicionesAll=q7.getResultList();
         return listExpedicionesAll;
        
    }
}
