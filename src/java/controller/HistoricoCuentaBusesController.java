package controller;

import entities.HistoricoCuentaBuses;
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

@Named("historicoCuentaBusesController")
@SessionScoped
public class HistoricoCuentaBusesController implements Serializable {

    @EJB
    private controller.HistoricoCuentaBusesFacade ejbFacade;
    private List<HistoricoCuentaBuses> items = null;
    private HistoricoCuentaBuses selected;

    public HistoricoCuentaBusesController() {
    }

    public HistoricoCuentaBuses getSelected() {
        return selected;
    }

    public void setSelected(HistoricoCuentaBuses selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HistoricoCuentaBusesFacade getFacade() {
        return ejbFacade;
    }

    public HistoricoCuentaBuses prepareCreate() {
        selected = new HistoricoCuentaBuses();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HistoricoCuentaBusesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HistoricoCuentaBusesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HistoricoCuentaBusesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HistoricoCuentaBuses> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public HistoricoCuentaBuses getHistoricoCuentaBuses(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<HistoricoCuentaBuses> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HistoricoCuentaBuses> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HistoricoCuentaBuses.class)
    public static class HistoricoCuentaBusesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HistoricoCuentaBusesController controller = (HistoricoCuentaBusesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "historicoCuentaBusesController");
            return controller.getHistoricoCuentaBuses(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HistoricoCuentaBuses) {
                HistoricoCuentaBuses o = (HistoricoCuentaBuses) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HistoricoCuentaBuses.class.getName()});
                return null;
            }
        }

    }

}
