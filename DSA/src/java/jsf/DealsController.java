package jsf;

import entities.Deals;
import entities.Hotels;
import entities.Yachts;
import java.io.IOException;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.DealsFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import session.HotelsFacade;
import session.YachtsFacade;

@Named("dealsController")
@ApplicationScoped
public class DealsController implements Serializable {

    @EJB
    private session.DealsFacade ejbFacade;
    
    @EJB
    private session.HotelsFacade hotelsFacade;
    
    @EJB
    private session.YachtsFacade yachtsFacade;
    
    private List<Deals> items = null;
    private Deals selected;
    
    
    private List<Hotels> hotels;
    private List<Yachts> yachts;
    private Map<String, Map<String,String>> mapOfServices = new HashMap<String,Map<String,String>>();
    private Map<String,String> hotelsName = new HashMap<String, String>();
    private Map<String,String> listOfRooms = new HashMap<String, String>();
    private Map<String,String> listOfYachts = new HashMap<String,String>();
    
    
     
       
    public DealsController() {
    }

    public Map<String, String> getHotelsName() {
        return hotelsName;
    }

    public Map<String, String> getListOfRooms() {
        return listOfRooms;
    }

    public Map<String, String> getListOfYachts() {
        return listOfYachts;
    }

    public Map<String, Map<String, String>> getMapOfServices() {
        return mapOfServices;
    }
    
    
    public YachtsFacade getYachtsFacade() {
        return yachtsFacade;
    }
    
    public HotelsFacade getHotelsFacade() {
        return hotelsFacade;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public List<Yachts> getYachts() {
        return yachts;
    }
    
    
    
    

    
        
    
    
    public Deals getSelected() {
        return selected;
    }

    public void setSelected(Deals selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DealsFacade getFacade() {
        return ejbFacade;
    }

    public Deals prepareCreate() {
        
        //Создание выпадающего списка для отелей из БД отелей
       // hotels = hotelsFacade.findAll();
      //  for (int i = 0; i < hotels.size(); i++) {
      //      hotelsName.put(hotels.get(i).getHotelName(), hotels.get(i).getHotelName());
      //  }
        
         
     
        
        selected = new Deals();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources1").getString("DealsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources1").getString("DealsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources1").getString("DealsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Deals> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources1").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources1").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Deals getDeals(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Deals> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Deals> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Deals.class)
    public static class DealsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DealsController controller = (DealsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dealsController");
            return controller.getDeals(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Deals) {
                Deals o = (Deals) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Deals.class.getName()});
                return null;
            }
        }

    }
    
    //Метод выбора списка услуг (номеров в отелях, моделей машин, моделей яхт) в зависимости от типа услуги
    public void listOfServicesCreation(){
        
        
        if (selected.getMainServiceType() != null && !selected.getMainServiceType().equals("")) {
            if (selected.getMainServiceType().equals("Отель")) {
                Map<String, String> map = new HashMap<String, String>();
                hotels = hotelsFacade.findAll();
                for (int i = 0; i < hotels.size(); i++) {
                    map.put(hotels.get(i).getHotelName(), hotels.get(i).getHotelName());
                }

                hotelsName = map;

            }else if(selected.getMainServiceType().equals("Яхта")){
                Map<String, String> map = new HashMap<String, String>();
                yachts = yachtsFacade.findAll();
                for (int i = 0; i < yachts.size(); i++) {
                    map.put(yachts.get(i).getModel(), yachts.get(i).getModel());
                }

                hotelsName = map;
                
            }
            
        }
        
    }




    //Метод формирования списка номеров в конкретном отеле
    public void listOfRoomsCreation() {

        listOfRooms.clear(); // Чистим коллекцию номеров

        if (selected.getServiceName() != null && !selected.getServiceName().equals("")) {
            for (Hotels hot : hotels) {
                if (hot.getHotelName().equals(selected.getServiceName())) {

                    String key = "http://dsa-travel.com/accommodation/" + hot.getId() + "/";
                    System.out.println(key);

                    Document doc = null;
                    try {
                        doc = Jsoup.connect(key).get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Elements r = null;
                    if (doc != null) {
                        r = doc.select("div.room_line > a");

                    }
                    for (int i = 0; i < r.size(); i++) {

                        String n = r.get(i).toString().substring(14, 21).replace("\"", "").replace(" ", "");
                        System.out.println(n);
                        String p = r.get(i).toString().substring(64).replace("</a>", "").replace(">", "").replace("\"", "");
                        System.out.println(p);

                        listOfRooms.put(p, p);
                    }

                }
            }
        }
            
       
        
       


        
    } 

}
