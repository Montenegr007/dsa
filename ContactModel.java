package ContactGUI;

import javafx.scene.control.Button;

/**
 * Created by Anton on 07.04.2016.
 */
public class ContactModel {

    private Button menuButton;
    private int contactId;
    private String contactLastName;
    private String contactFirstName;
    private String contactType;
    private String contactTel;
    private String contactEmail;
    private String contactManager;

    public ContactModel(Button menuButton, int contactId, String contactLastName, String contactFirstName, String contactType, String contactTel, String contactEmail, String contactManager){
        this.menuButton = menuButton;
        this.contactId = contactId;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.contactType = contactType;
        this.contactTel = contactTel;
        this.contactEmail = contactEmail;
        this.contactManager = contactManager;
    }

    public ContactModel(){ }

    public Button getMenuButton() {return menuButton;}
    public void setMenuButton(Button menuButton) {this.menuButton = menuButton;}
    public int getContactId() {return contactId;}
    public void setContactId(int contactId) {this.contactId = contactId;}
    public String getContactLastName() {
        return contactLastName;
    }
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }
    public String getContactFirstName() {
        return contactFirstName;
    }
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }
    public String getContactType() {
        return contactType;
    }
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    public String getContactTel() {
        return contactTel;
    }
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getContactManager() {
        return contactManager;
    }
    public void setContactManager(String contactManager) {
        this.contactManager = contactManager;
    }

}


