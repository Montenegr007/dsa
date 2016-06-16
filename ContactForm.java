package ContactGUI;

import AlertsGUI.Alerts;
import AlertsGUI.Exit;
import CompanyGUI.CompanyTable;
import DBConnection.JDBCclass;
import DealGUI.DealForm;
import Interface.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;

import java.sql.*;

public class ContactForm extends BaseController {


    @FXML
    private Label ContactId;

    @FXML
    private TextField LastName, FirstName, SecName, Agent, Email, Tel, Messenger, Web;

    @FXML
    private TextArea Comment;

    @FXML
    private DatePicker DatePicker1;

    @FXML
    private ChoiceBox TypeCB, SourceCB, EmailCB, TelCB, MessengerCB, ManagerCB;

    @FXML
    private MenuItem NewContact, OpenContact, SaveContact, DeleteContact, ExitContact, CreateDeal, SendSuggestion,
            SendInvoice, SendSuperSuggestion;

    @FXML
    private Button ClearButton;


    private CompanyTable companyTable;

    private int id;

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    @Override
    public void PreShowing(){
        super.PreShowing();
        openContact();
    }

    public void newContact(){
        Main.getNavigation().load("/ContactGUI/ContactForm.fxml").Show();
    }

    public void openContact(){
        String url = "jdbc:postgresql://localhost:5432/dsadb";
        String username = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM dsa_contacts WHERE id=?");
                stmt.setInt(1, getId());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    ContactId.setText(Integer.toString(rs.getInt("id")));
                    LastName.setText(rs.getString("lastname"));
                    FirstName.setText(rs.getString("firstname"));
                    SecName.setText(rs.getString("secname"));
                    TypeCB.setValue(rs.getString("type"));
                    SourceCB.setValue(rs.getString("source"));
                    Agent.setText(rs.getString("agent"));
                    DatePicker1.setValue(rs.getDate("dateofbirth").toLocalDate());
                    Email.setText(rs.getString("email"));
                    EmailCB.setValue(rs.getString("email_type"));
                    Tel.setText(rs.getString("tel"));
                    TelCB.setValue(rs.getString("tel_type"));
                    Messenger.setText(rs.getString("messenger"));
                    MessengerCB.setValue(rs.getString("messenger_type"));
                    Web.setText(rs.getString("web"));
                    ManagerCB.setValue(rs.getString("manager"));
                    Comment.setText(rs.getString("comment"));
                }
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveContact()throws SQLException {

        if(ContactId.getText().equals("")) {

                    String sqlRequest = "INSERT INTO dsa_contacts " +
                            "(lastname, firstname, secname, type, source, agent, dateofbirth, email, email_type, tel, tel_type, messenger, messenger_type, web, manager, comment) " +
                            " VALUES (" + "'" + LastName.getText() + "', " + "'" + FirstName.getText() + "', " + "'" + SecName.getText() + "', " +
                            "'" + TypeCB.getValue() + "', " + "'" + SourceCB.getValue() + "', " + "'" + Agent.getText() + "', " + "'" + java.sql.Date.valueOf(DatePicker1.getValue()) + "', " +
                            "'" + Email.getText() + "', " + "'" + EmailCB.getValue() + "', " + "'" + Tel.getText() + "', " + "'" + TelCB.getValue() + "', " +
                            "'" + Messenger.getText() + "', " + "'" + MessengerCB.getValue() + "', " + "'" + Web.getText() + "', " + "'" + ManagerCB.getValue() + "', " +
                            "'" + Comment.getText() + "');";

                    JDBCclass insert = new JDBCclass();
                    insert.insertIntoDB(sqlRequest);

        } else {
                   String sqlRequest = "UPDATE dsa_contacts SET (lastname, firstname, secname, type, source, agent, dateofbirth, email, email_type, tel, tel_type, messenger, messenger_type, web, manager, comment)=" +
                            "(" + "'" + LastName.getText() + "', " + "'" + FirstName.getText() + "', " + "'" + SecName.getText() + "', " +
                            "'" + TypeCB.getValue() + "', " + "'" + SourceCB.getValue() + "', " + "'" + Agent.getText() + "', " + "'" + java.sql.Date.valueOf(DatePicker1.getValue()) + "', " +
                            "'" + Email.getText() + "', " + "'" + EmailCB.getValue() + "', " + "'" + Tel.getText() + "', " + "'" + TelCB.getValue() + "', " +
                            "'" + Messenger.getText() + "', " + "'" + MessengerCB.getValue() + "', " + "'" + Web.getText() + "', " + "'" + ManagerCB.getValue() + "', " +
                            "'" + Comment.getText() + "') WHERE id=" + ContactId.getText();

                     JDBCclass update = new JDBCclass();
                     update.insertIntoDB(sqlRequest);
        }
    }

    public void exitContact(){
        Exit exit = new Exit();
        exit.exitToTable("/ContactGUI/ContactTable.fxml");

    }

    public void createDeal(){
             DealForm dealForm = (DealForm) Main.getNavigation().load("/DealGUI/DealForm.fxml");
             dealForm.setContactId(Integer.toString(id));
             dealForm.setContactLastname(LastName.getText());
             dealForm.setContactFirstname(FirstName.getText());
             dealForm.Show();
    }

    public void sendSuggestion(){

    }

    public void sendInvoice(){

    }

    public void sendSuperSuggestion() {

    }

    public void clearContact(){ LastName.clear(); FirstName.clear(); SecName.clear(); TypeCB.setValue(null);
        SourceCB.setValue(null); Agent.clear(); DatePicker1.getEditor().clear(); Email.clear(); EmailCB.setValue(null);
        TelCB.setValue(null); Tel.clear(); MessengerCB.setValue(null); Messenger.clear(); Web.clear(); ManagerCB.setValue(null);
        Comment.clear();
    }


}
