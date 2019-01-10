/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.HistoricoSumKMS;
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
public class HistoricoSumKMSFacade extends AbstractFacade<HistoricoSumKMS> {

    @PersistenceContext(unitName = "ReportesProgramacion4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoSumKMSFacade() {
        super(HistoricoSumKMS.class);
    }
     public List obtenerKilometrosMes(){
        HistoricoSumKMSFacade kmsFacade;
        List<Object[]> listKms;
        
        Query q=em.createNativeQuery("SELECT \"Cuadro\", \"Linea\", \"Tipo_Evento\", kms, \"Tipologia\", \"Operador\", \"RC\", \"Fecha\", \"Tipo_dia\"\n" +
                                    "  FROM public.\"Historico_Sum_KMS\" \n" +
                                    "  WHERE \"Fecha\" between (select Max(\"Fecha\")-8 from \"Historico_Sum_KMS\" )    and  current_date ");
       listKms=q.getResultList();
        return  listKms;
    }
     
     public List<HistoricoSumKMS> consultar_Kms_Intervalo(Date date1, Date date2, String cadena1, String cadena2, String cadena3, String cadena4){
         List<HistoricoSumKMS>listKmsIntervalo;
         Query q7;
         q7=em.createNativeQuery("select * from \"Historico_Sum_KMS\" where \"Fecha\" between '"+date1+"' and '"+date2+"'and  \"Operador\" ilike '%"+cadena1+"%' and\"RC\" ilike'%"+cadena2+"%'and \"Tipologia\" ilike'%"+cadena3+"%'and \"Tipo_Evento\" ilike'%"+cadena4+"%'", HistoricoSumKMS.class);
         listKmsIntervalo=q7.getResultList();
         return listKmsIntervalo;
     
     
     }
    
}
