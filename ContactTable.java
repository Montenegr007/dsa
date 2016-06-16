package ContactGUI;

import AlertsGUI.Alerts;
import AlertsGUI.Exit;
import DBConnection.JDBCclass;
import DealGUI.DealForm;
import Interface.BaseController;
import Mail.MozStarter;
import PDFMaker.InvoiceMaker;
import SearchGUI.*;
import com.itextpdf.text.DocumentException;
import com.sun.javafx.scene.control.skin.ContextMenuContent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

/**
 * Created by Anton on 07.04.2016.
 */
public class ContactTable extends BaseController {

    ObservableList<ContactModel> data = FXCollections.observableArrayList(); // Список для хранения строк таблицы

    @FXML
    private TableColumn<ContactModel, String> LastnameColumn, FirstnameColumn, TypeColumn, TelColumn, EmailColumn, ManagerColumn;

    @FXML
    private TableColumn<ContactModel, Integer> IdColumn;

    @FXML
    private TableColumn<ContactModel, Button> MenuColumn;

    @FXML
    private MenuItem AddContact, FindContact;

    @FXML
    TableView<ContactModel> ContactTable;

    @FXML
    private TextField SearchField;


    private int selectedId;
    private String selectedLastname;
    private String selectedFirstname;

    public int getSelectedId() {
        return selectedId;
    }
    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }
    public String getSelectedLastname() {
        return selectedLastname;
    }
    public void setSelectedLastname(String selectedLastname) {
        this.selectedLastname = selectedLastname;
    }
    public String getSelectedFirstname() {
        return selectedFirstname;
    }
    public void setSelectedFirstname(String selectedFirstname) {
        this.selectedFirstname = selectedFirstname;
    }


    @Override
    public void PreShowing() {

        String url = "jdbc:postgresql://localhost:5432/dsadb";
        String username = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                String sqlRequest = "SELECT id, lastname, firstname, type, tel, email, manager FROM dsa_contacts";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlRequest);
                while (rs.next()) {
                    ContactModel contactModel = new ContactModel();
                    Button menuButton = new Button("", new ImageView(new Image("/Images/menu.png")));
                    menuButton.setPrefWidth(20);
                    menuButton.setPrefHeight(15);
                    menuButton.setOnAction(new EventHandler<ActionEvent>() {
                                               @Override
                                               public void handle(ActionEvent event) {

                                                   ContextMenu contextMenu = new javafx.scene.control.ContextMenu();
                                                   MenuItem menuItem1 = new MenuItem("Просмотреть/Редактировать");
                                                   menuItem1.setId("1");
                                                   MenuItem menuItem2 = new MenuItem("Добавить сделку");
                                                   menuItem2.setId("2");
                                                   MenuItem menuItem3 = new MenuItem("Создать счет");
                                                   menuItem3.setId("3");
                                                   MenuItem menuItem4 = new MenuItem("Написать письмо");
                                                   menuItem4.setId("4");
                                                   MenuItem menuItem5 = new MenuItem("Удалить контакт");
                                                   menuItem5.setId("5");
                                                   contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5);
                                                   menuButton.setContextMenu(contextMenu);
                                                   contextMenu.show(menuButton, Side.TOP, 0, 0);
                                                   contextMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                                                       @Override
                                                       public void handle(MouseEvent event) {
                                                           String itemId = ((ContextMenuContent.MenuItemContainer) event.getTarget()).getId();
                                                           if (itemId.equals(menuItem1.getId())) {
                                                               contactSelect();
                                                               contextMenu.hide();
                                                               ContactForm contactForm = (ContactForm) Main.getNavigation().load("/ContactGUI/ContactForm.fxml");
                                                               contactForm.setId(getSelectedId());
                                                               contactForm.Show();
                                                           }
                                                           if (itemId.equals(menuItem2.getId())) {
                                                               contactSelect();
                                                               contextMenu.hide();
                                                               DealForm dealForm = (DealForm) Main.getNavigation().load("/DealGUI/DealForm.fxml");
                                                               dealForm.setContactId(Integer.toString(getSelectedId()));
                                                               dealForm.setContactLastname(getSelectedLastname());
                                                               dealForm.setContactFirstname(getSelectedFirstname());
                                                               dealForm.newDeal();
                                                               dealForm.Show();
                                                           }
                                                           if (itemId.equals(menuItem3.getId())) {
                                                               InvoiceMaker im = new InvoiceMaker();
                                                               try {
                                                                   contactSelect();
                                                                   contextMenu.hide();
                                                                   String clientName = selectedLastname + " " + selectedFirstname;
                                                                   LocalDate ld = LocalDate.now();
                                                                   String issueDate = ld.toString();
                                                                   im.createPDF(clientName, issueDate);
                                                               }catch (DocumentException e){
                                                                   e.printStackTrace();
                                                               }catch (IOException e){
                                                                   e.printStackTrace();
                                                               }
                                                           }
                                                           if (itemId.equals(menuItem4.getId())) {
                                                               MozStarter ms = new MozStarter();
                                                               ms.mozStart();
                                                           }
                                                           if (itemId.equals(menuItem5.getId())) {
                                                               contactSelect();
                                                               contextMenu.hide();
                                                               Alerts deleteAlert = new Alerts();
                                                               deleteAlert.setSelectedId(selectedId);
                                                               deleteAlert.deletingConfirmation();                                                           }
                                                       }

                                                   });
                                               }
                                           });


                    contactModel.setMenuButton(menuButton);
                    contactModel.setContactId(rs.getInt("id"));
                    contactModel.setContactLastName(rs.getString("lastname"));
                    contactModel.setContactFirstName(rs.getString("firstname"));
                    contactModel.setContactType(rs.getString("type"));
                    contactModel.setContactTel(rs.getString("tel"));
                    contactModel.setContactEmail(rs.getString("email"));
                    contactModel.setContactManager(rs.getString("manager"));

                    data.add(contactModel);
                }
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        buildTable();

        for (int i = 0; i < data.size(); i++) {
            int j = ContactTable.getItems().get(i).getContactId();
            if (j == selectedId) {
                ContactTable.getSelectionModel().select(i);
            }
        }

    }

    public void buildTable() {

        MenuColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, Button>("menuButton"));
        IdColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, Integer>("contactId"));
        IdColumn.setSortType(TableColumn.SortType.ASCENDING);
        LastnameColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactLastName"));
        FirstnameColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactFirstName"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactType"));
        TelColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactTel"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactEmail"));
        ManagerColumn.setCellValueFactory(new PropertyValueFactory<ContactModel, String>("contactManager"));

        ContactTable.setItems(data);

    }

    public void contactSelect() {

        selectedId = ContactTable.getSelectionModel().getSelectedItem().getContactId();
        System.out.println(selectedId);
        selectedLastname = ContactTable.getSelectionModel().getSelectedItem().getContactLastName();
        selectedFirstname = ContactTable.getSelectionModel().getSelectedItem().getContactFirstName();
        //PopupMenu popupMenu = new PopupMenu();
        //popupMenu.setSelectedId(selectedId);
        //popupMenu.setSelectedLastname(selectedLastname);
        //popupMenu.setSelectedFirstname(selectedFirstname);
        //popupMenu.popupMenu1();

    }

    public void addContact() {

        Main.getNavigation().load("/ContactGUI/ContactForm.fxml").Show();
    }

    public void exitContact() {
        Exit exit = new Exit();
        exit.exitToMainPage();
    }

    public void deleteContact() throws SQLException {
        //Alerts deleteAlert = new Alerts();
        //deleteAlert.setSelectedId(selectedId);
        //deleteAlert.deletingConfirmation();
        String sqlRequest = "DELETE FROM dsa_contacts WHERE id=" + getSelectedId();
        String viewPath = "/ContactGUI/ContactTable.fxml";
        JDBCclass delete = new JDBCclass();
        delete.deleteFromDB(sqlRequest, viewPath);
    }

    public void openContact() {
        SearchForOpen searchForOpen = new SearchForOpen();
        searchForOpen.searchForOpenCompany();
    }

    public void searchContact() {

        ObservableList<String> lastnamelist = FXCollections.observableArrayList();
        ObservableList<String> firstnamelist = FXCollections.observableArrayList();
        ObservableList<Integer> idlist = FXCollections.observableArrayList();
        ObservableList<MenuItem> menulist = FXCollections.observableArrayList();
        MenuItem menuItem;

        String url = "jdbc:postgresql://localhost:5432/dsadb";
        String username = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {

                String sqlRequest = "SELECT id, lastname, firstname FROM dsa_contacts WHERE lastname LIKE " + "'%" + SearchField.getText() + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlRequest);
                while (rs.next()){
                    lastnamelist.add(rs.getString("lastname"));
                    firstnamelist.add(rs.getString("lastname"));
                    idlist.add(rs.getInt("id"));
                    menuItem = new MenuItem("№" + rs.getInt("id") + "    " + rs.getString("lastname") + " " + rs.getString("firstname"));
                    menuItem.setId(Integer.toString(rs.getInt("id")));
                    menulist.add(menuItem);
                }

                con.close();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String itemId = ((ContextMenuContent.MenuItemContainer) event.getTarget()).getId();
                ContactForm contactForm = (ContactForm) Main.getNavigation().load("/ContactGUI/ContactForm.fxml");
                contactForm.setId(Integer.parseInt(itemId));
                contactForm.Show();
            }
        });
        contextMenu.getItems().addAll(menulist);
        SearchField.setContextMenu(contextMenu);
        contextMenu.show(SearchField, Side.BOTTOM, 0, 0);


        }



    }









