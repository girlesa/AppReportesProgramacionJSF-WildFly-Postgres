package controller;

import entities.HistoricoSumKMS;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("historicoSumKMSController")
@SessionScoped
public class HistoricoSumKMSController implements Serializable {

    @EJB
    private controller.HistoricoSumKMSFacade ejbFacade;
    private List<HistoricoSumKMS> items = null;
    private HistoricoSumKMS selected;

    public HistoricoSumKMSController() {
    }

    public HistoricoSumKMS getSelected() {
        return selected;
    }

    public void setSelected(HistoricoSumKMS selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HistoricoSumKMSFacade getFacade() {
        return ejbFacade;
    }

    public HistoricoSumKMS prepareCreate() {
        selected = new HistoricoSumKMS();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleExp").getString("HistoricoSumKMSCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleExp").getString("HistoricoSumKMSUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleExp").getString("HistoricoSumKMSDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HistoricoSumKMS> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleExp").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleExp").getString("PersistenceErrorOccured"));
            }
        }
    }

    public HistoricoSumKMS getHistoricoSumKMS(java.lang.Double id) {
        return getFacade().find(id);
    }

    public List<HistoricoSumKMS> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HistoricoSumKMS> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HistoricoSumKMS.class)
    public static class HistoricoSumKMSControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HistoricoSumKMSController controller = (HistoricoSumKMSController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "historicoSumKMSController");
            return controller.getHistoricoSumKMS(getKey(value));
        }

        java.lang.Double getKey(String value) {
            java.lang.Double key;
            key = Double.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Double value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HistoricoSumKMS) {
                HistoricoSumKMS o = (HistoricoSumKMS) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HistoricoSumKMS.class.getName()});
                return null;
            }
        }

    }

}
