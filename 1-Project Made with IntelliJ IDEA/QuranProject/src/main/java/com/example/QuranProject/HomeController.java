package com.example.QuranProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FormatStringConverter;
import javafx.util.converter.IntegerStringConverter;
//import org.controlsfx.control.textfield.TextFields;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class HomeController implements Initializable {


    @FXML
    private AnchorPane RegAnch;

    @FXML
    private AnchorPane SER_PAN;

    @FXML
    private Button Sign_UP;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField centerAddressTextField;

    @FXML
    private TextField address;

    @FXML
    private DatePicker birthdate;

    @FXML
    private TextField addressTextField;


    @FXML
    private ComboBox<String> any;

    @FXML
    private ComboBox<String> anyNumber;


    @FXML
    private ComboBox<String> anyNumber1;


    @FXML
    private Button but_Delete;

    @FXML
    private Button createCenter;

    @FXML
    private Button but_UPdate;

    @FXML
    private Button updateCenterButton;

    @FXML
    private Button but_logout;

    @FXML
    private Button buta;

    @FXML
    private Button butb;

    @FXML
    private Button butc;

    @FXML
    private Button butd;

    @FXML
    private Button printReport;

    @FXML
    private TextField centerWorkingDaysTextField;


    @FXML
    private VBox g3_v;

    @FXML
    private TextField centerID;

    @FXML
    private Label lab2;

    @FXML
    private Label centerNumberLabel;

    @FXML
    private TextField name;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phone;

    @FXML
    private Label stdsu;

    @FXML
    private Label interfaceLabel;

    @FXML
    private VBox vboxx;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField centerSearchTextField;

    @FXML
    private DatePicker birthdateDatePicker;
    // centers comboBox with it's ObservableList
    @FXML
    private ComboBox centerComboBox;
    ObservableList<String> centerComboBoxList = FXCollections.observableArrayList();

    // supervisor comboBox with it's ObservableList
    @FXML
    private ComboBox supervisorsComboBox;

    ObservableList<String> supervisorsComboBoxList = FXCollections.observableArrayList();


    //    table view for student

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> phone_numberColumn;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, Date> bdColumn;

    @FXML
    private TableColumn<Student, String> addressCoulumn;

    @FXML
    private TableColumn<Student, String> supervisorColumn;

    @FXML
    private TableColumn<Student, String> centerColumn;

    // list for all students
    ObservableList<Student> studentsObservableList = FXCollections.observableArrayList();
    FilteredList<Student> filteredList = new FilteredList<>(studentsObservableList, b -> true);

    //    table view for supervisor
    @FXML
    private TableView<Supervisor> supervisorsTable;

    @FXML
    private TableColumn<Supervisor, String> supervisorName;

    @FXML
    private TableColumn<Supervisor, Integer> supervisorPhoneNumber;

    @FXML
    private TableColumn<Supervisor, Integer> supervisorId;

    @FXML
    private TableColumn<Supervisor, Date> supervisorBD;

    @FXML
    private TableColumn<Supervisor, String> supervisorAddress;

    @FXML
    private TableColumn<Supervisor, String> supervisorCenter;

    // list for all supervisors
    ObservableList<Supervisor> supervisorsObservableList = FXCollections.observableArrayList();

    FilteredList<Supervisor> supervisorsfilteredList = new FilteredList<>(supervisorsObservableList, b -> true);

    // table view for centers
    @FXML
    private TableView<Center> centersTable;
    @FXML
    private TableColumn<Center, Integer> centerId;
    @FXML
    private TableColumn<Center, String> centerAddress;
    @FXML
    private TableColumn<Center, String> centerWorkingDays;

    // list for all centers
    ObservableList<Center> centersObservableList = FXCollections.observableArrayList();

    FilteredList<Center> centersfilteredList = new FilteredList<>(centersObservableList, b -> true);

    int interfaceNumber;


    @FXML
    void bag2(ActionEvent event) throws IOException {

        if (event.getSource() == but_logout) {

            Stage stage = new Stage();
            stage.setTitle("Login!");

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } else if (event.getSource() == buta) {

            studentsTable.toFront();
            studentsTable.setVisible(true);
            supervisorsTable.setVisible(false);
            centersTable.setVisible(false);
            g3_v.setVisible(false);
            RegAnch.setVisible(false);

            SER_PAN.setVisible(true);
            supervisorsComboBox.setVisible(true);
            lab2.setVisible(true);
            searchTextField.setText("");
            centerComboBox.setVisible(true);
            centerNumberLabel.setVisible(true);
            but_Delete.setVisible(true);

            idTextField.setText("");
            addressTextField.setText("");
            nameTextField.setText("");

            interfaceNumber = 0;
            interfaceLabel.setTranslateX(0);
            interfaceLabel.setText("الطلاب");


            // do a refresh
            refresh();


        } else if (event.getSource() == butb) {

            studentsTable.setVisible(false);
            centersTable.setVisible(false);
            supervisorsTable.setVisible(true);
            supervisorsTable.toFront();
            g3_v.setVisible(false);
            RegAnch.setVisible(false);
            SER_PAN.setVisible(true);

            lab2.setVisible(false);
            supervisorsComboBox.setVisible(false);
            searchTextField.setText("");
            centerComboBox.setVisible(false);
            centerNumberLabel.setVisible(false);
            but_Delete.setVisible(false);

            idTextField.setText("");
            addressTextField.setText("");
            nameTextField.setText("");

            interfaceNumber = 1;
            interfaceLabel.setTranslateX(0);
            interfaceLabel.setText("المشرفين");
            // do a refresh
            refresh();

        } else if (event.getSource() == butc) {
            studentsTable.setVisible(false);
            supervisorsTable.setVisible(false);
            centersTable.setVisible(true);

            g3_v.setVisible(true);
            SER_PAN.setVisible(false);
            RegAnch.setVisible(false);

            centerID.setText("");
            centerWorkingDaysTextField.setText("");
            centerAddressTextField.setText("");
            centerSearchTextField.setText("");


            interfaceNumber = 2;
            interfaceLabel.setTranslateX(0);
            interfaceLabel.setText("المراكز");
            // do a refresh
            refresh();

        } else if (butd == event.getSource()) {

            studentsTable.setVisible(false);
            supervisorsTable.setVisible(false);
            centersTable.setVisible(false);

            g3_v.setVisible(false);

            RegAnch.setVisible(true);
            SER_PAN.setVisible(false);


            this.name.setText("");
            this.address.setText("");
            this.phone.setText("");



            interfaceNumber = 3;
            interfaceLabel.setTranslateX(-70);
            interfaceLabel.setText("اضافة مستخدم");

            //
            refresh();

        }

        if (Sign_UP == event.getSource()) {

            // to indicate that all inputs are entered
            int flag = 0;
            Alert alert = new Alert(Alert.AlertType.ERROR);

            if (name.getText().equals("")) {
                alert.setContentText("Error for name");
                alert.show();
                flag = 1;
            }

            if (address.getText().equals("")) {
                alert.setContentText("Error for address ");
                alert.show();
                flag = 1;
            }

            if (phone.getText().equals("")) {
                alert.setContentText("Please enter correct phone number");
                alert.show();
                flag = 1;
            }
            if (birthdate.getValue() == null) {
                alert.setContentText("Error for birthdate");
                alert.show();
                flag = 1;
            }
            // check center comboBox
            if (anyNumber.getValue() == null) {
                alert.setContentText("Error for center");
                alert.show();
                flag = 1;
            }
            // check supervisor
            if (anyNumber1.getValue() == null && any.getValue() == "طالب") {
                alert.setContentText("Please Provide a supervisor");
                alert.show();
                flag = 1;
            }
            try {
                if (Integer.parseInt(phone.getText()) > 599999999) {
                    alert.setContentText("Please enter correct phone number ");
                    alert.show();
                    flag = 1;
                }
            } catch (Exception e) {
                alert.setContentText("Please enter correct phone number ");
                alert.show();
                flag = 1;
            }


            if (flag == 0) {

                String name1 = name.getText();
                String bd = birthdate.getValue().toString();
                String address1 = address.getText();
                String center = anyNumber.getValue();
                int phone_number = Integer.parseInt(phone.getText());
                String supervisor;


                // check supervisor
                if (anyNumber1.getValue() == null) {
                    supervisor = null;
                } else {
                    supervisor = anyNumber1.getValue();
                }

                // add the student or supervisor to DB
                try {
                    Connection con = Main.createConnection();


                    String query = "select id from center where address=" + "'" + center + "'";
                    ResultSet res = con.createStatement().executeQuery(query);
                    res.next(); // now, res points to center id


                    String query1;
                    ResultSet res1 = null;
                    if (supervisor != null) {
                        query1 = "select id from supervisor where name=" + "'" + supervisor + "'";
                        res1 = con.createStatement().executeQuery(query1);
                        res1.next(); // now res1 points in supervisor id

                    }


                    if (any.getValue().equals("طالب")) {

                        // check if student has a supervisor
                        if (supervisor != null) {
                            String stm1 = "INSERT into student VALUES(student_inc.nextval,'" + name1 + "',TO_DATE('" + bd + "','YYYY-MM-DD'),'" + address1 + "'," + phone_number + ",student_inc.nextval," + res1.getString(1) + "," + res.getString(1) + ")";
                            con.createStatement().executeUpdate(stm1);
                        }
//                        else {
//                            // if student does not have supervisor
//                            String stm1 = "INSERT into student VALUES(student_inc.nextval,'" + name1 + "',TO_DATE('" + bd + "','YYYY-MM-DD'),'" + address1 + "'," + phone_number + ",student_inc.nextval, null," + res.getString(1) + ")";
//                            con.createStatement().executeUpdate(stm1);
//                        }

                    } else {
                        String stm2 = "INSERT into supervisor VALUES(supervisor_inc.nextval,'" + name1 + "',TO_DATE('" + bd + "','YYYY-MM-DD'),'" + address1 + "'," + phone_number + ",supervisor_inc.nextval," + res.getString(1) + ")";
                        con.createStatement().executeUpdate(stm2);
                    }

                    con.commit();
                    con.close();
                } catch (Exception e) {
                    alert.setContentText(e.toString());
                    alert.show();
                }


                this.name.setText("");
                this.address.setText("");
                this.phone.setText("");
                anyNumber.setValue(null);
                anyNumber1.setValue(null);
                birthdate.setValue(null);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Added Successfully");
                alert.show();
            }

            refresh();
        }

        if (any == event.getSource()) {

            if (any.getValue().equals("طالب")) {

                anyNumber1.setVisible(true);
                stdsu.setVisible(true);

            } else {

                anyNumber1.setVisible(false);
                stdsu.setVisible(false);

            }

        }


        // to make supervisorsComboBox values suitable with centerComboBox selected value
        if (centerComboBox == event.getSource()) {
            String center;

            if (centerComboBox.getSelectionModel().getSelectedItem() != null) {
                center = centerComboBox.getSelectionModel().getSelectedItem().toString();
                try {
                    Connection con = Main.createConnection();
                    supervisorsComboBoxList.clear();
                    String query = "select SUPERVISOR.name from SUPERVISOR,CENTER where (SUPERVISOR.CENTER_ID=CENTER.id and CENTER.ADDRESS='" + center + "') order by SUPERVISOR.id";
                    ResultSet res = con.createStatement().executeQuery(query);
                    while (res.next()) {
                        supervisorsComboBoxList.add(res.getString(1));
                    }
                    supervisorsComboBox.setDisable(false);


                    con.close();
                } catch (Exception e) {
                    // alert
                }

            }
        }
        // to make anyNumberComboBox values suitable with anyNumber1ComboBox selected value
        if (anyNumber == event.getSource()) {
            String center;

            if (anyNumber.getSelectionModel().getSelectedItem() != null) {
                center = anyNumber.getSelectionModel().getSelectedItem().toString();
                try {
                    Connection con = Main.createConnection();
                    supervisorsComboBoxList.clear();
                    String query = "select SUPERVISOR.name from SUPERVISOR,CENTER where (SUPERVISOR.CENTER_ID=CENTER.id and CENTER.ADDRESS='" + center + "') order by SUPERVISOR.id";
                    ResultSet res = con.createStatement().executeQuery(query);
                    while (res.next()) {
                        supervisorsComboBoxList.add(res.getString(1));
                    }
                    anyNumber1.setDisable(false);

                    con.close();
                } catch (Exception e) {
                    // alert
                }

            }
        }

//        // to make centerComboBox value suitable with supervisorsComboBox selected value
//        if (supervisorsComboBox == event.getSource()) {
//            String supervisor;
//            if (supervisorsComboBox.getSelectionModel().getSelectedItem() != null) {
//                supervisor = supervisorsComboBox.getSelectionModel().getSelectedItem().toString();
//                try {
//                    Connection con = Main.createConnection();
//                    centerComboBoxList.clear();
//                    String query = "select center.address from center,supervisor WHERE (center.id=supervisor.center_id and supervisor.name='" + supervisor + "')";
//                    ResultSet res = con.createStatement().executeQuery(query);
//                    while (res.next()) {
////                        centerComboBoxList.add(res.getString(1));
//                        centerComboBox.setValue(res.getString(1));
//                    }
//
//                    con.close();
//                } catch (Exception e) {
//                    //alert
//                }
//            }
//        }

        // to refresh tables


        if (but_Delete == event.getSource()) {


            if (interfaceNumber == 0) {
                //database for student
                try {
                    // get the selected row
                    Student student = studentsTable.getSelectionModel().getSelectedItem();
                    if (student != null) {
                        // update the row in DateBase
                        Connection con = Main.createConnection();
//                        String stm = "update student set su_id=null , center_id=null where id=" + student.getId();
                        String stm = "delete from student where id=" + student.getId();
                        con.createStatement().executeUpdate(stm);
                        con.commit();
                        con.close();
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setContentText("Deleted succsuflly");
//                        alert.show();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Please Select a row to delete");
                        alert.show();
                    }

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.toString());
                    alert.show();
                }


            } else {

                //database for superviso


            }

            refresh();
        }
        if (but_UPdate == event.getSource()) {

            //database
            int id;
            String name = nameTextField.getText();
            String bd;
            String address = addressTextField.getText();


            // here we are in students interface
            if (interfaceNumber == 0 || interfaceNumber == 1) {
                //database for student
                if (!idTextField.getText().isEmpty()) {
                    try {
                        Connection con = Main.createConnection();


                        id = Integer.parseInt(idTextField.getText());
                        if (!nameTextField.getText().isEmpty()) {
                            String stm = "";
                            if (interfaceNumber == 0) {
                                stm = "update student set name='" + name + "' where id=" + id;
                            } else {
                                stm = "update supervisor set name='" + name + "' where id=" + id;
                            }
                            con.createStatement().executeUpdate(stm);
                        }
                        if (birthdateDatePicker.getValue() != null) {
                            String stm = "";
                            bd = birthdateDatePicker.getValue().toString();
                            if (interfaceNumber == 0) {
                                stm = "UPDATE student set bd=TO_DATE('" + bd + "','YYYY-MM-DD') where id=" + id;
                            } else {
                                stm = "UPDATE supervisor set bd=TO_DATE('" + bd + "','YYYY-MM-DD') where id=" + id;
                            }
                            con.createStatement().executeUpdate(stm);
                        }
                        if (!addressTextField.getText().isEmpty()) {
                            String stm = "";
                            if (interfaceNumber == 0) {
                                stm = "update student set address='" + address + "' where id=" + id;
                            } else {
                                stm = "update supervisor set address='" + address + "' where id=" + id;
                            }
                            con.createStatement().executeUpdate(stm);
                        }
                        if (centerComboBox.getSelectionModel().getSelectedItem() != null) {
                            String stm = "";
                            String center = centerComboBox.getSelectionModel().getSelectedItem().toString();

                            String query = "select id from center where address=" + "'" + center + "'";
                            ResultSet res = con.createStatement().executeQuery(query);
                            res.next(); // now, res points to center id


                            stm = "update student set center_id=" + res.getInt(1) + "where id=" + id;


                            // check if the supervisorComboBox is not empty
                            if (supervisorsComboBox.getSelectionModel().getSelectedItem() != null && interfaceNumber == 0) {

                                con.createStatement().executeUpdate(stm);

                                String supervisor = supervisorsComboBox.getSelectionModel().getSelectedItem().toString();

                                String query1 = "select id from supervisor where name=" + "'" + supervisor + "'";
                                ResultSet res1 = con.createStatement().executeQuery(query1);
                                res1.next(); // now res points in supervisor id

                                String stm1 = "update student set su_id=" + res1.getInt(1) + "where id=" + id;
                                con.createStatement().executeUpdate(stm1);
                            } else if (interfaceNumber == 1) {
                                stm = "update supervisor set center_id=" + res.getInt(1) + "where id=" + id;
                                con.createStatement().executeUpdate(stm);

                            } else {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setContentText("Please Provide supervisor");
                                alert.show();
                            }

                        }


                        // clear text fields and other input components
                        idTextField.setText("");
                        addressTextField.setText("");
                        nameTextField.setText("");
                        birthdateDatePicker.setValue(null);
                        centerComboBox.getItems().clear();
                        supervisorsComboBox.getItems().clear();


                        con.commit();
                        con.close();
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Please Provide correct id");
                        alert.show();
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.toString());
                        alert.show();
                    }


                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please Provide correct id");
                    alert.show();
                }


            } else if (interfaceNumber == 1) {

                //database for supervisor


            }
            refresh();
        }


//        if (printReport == event.getSource()) {
//
//            try {
//
////                /* User home directory location */
////                String userHomeDirectory = System.getProperty("user.home");
////                /* Output file location */
////                String outputFile = userHomeDirectory + File.separatorChar + "JasperTableExample.pdf";
//
//                List<Student> students = new ArrayList<Student>();
//
//                Student s1 = new Student("ibraheem", "annu");
//                Student s2 = new Student("jafar", "annu");
//                Student s3 = new Student("ahmad", "annu");
//
//                students.add(s1);
//                students.add(s2);
//                students.add(s3);
//
//
//
//                /* Convert List to JRBeanCollectionDataSource */
//                JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(students);
//
//                /* Map to hold Jasper report Parameters */
//                Map<String, Object> parameters = new HashMap<String, Object>();
//                parameters.put("ItemDataSource", itemsJRBean);
//                parameters.put("studentId", 15);
//
//                /* Using compiled version(.jasper) of Jasper report to generate PDF */
//                InputStream input = new FileInputStream(new File("C:\\Users\\hp\\JaspersoftWorkspace\\test\\Blank_A4.jrxml"));
//                JasperDesign jd = JRXmlLoader.load(input);
//                JasperReport jr = JasperCompileManager.compileReport(jd); // now the file with .jasper extinction
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
//
//                /* outputStream to create PDF */
//                OutputStream outputStream = new FileOutputStream(new File("JasperTableExample2.pdf"));
//                /* Write content to PDF file */
//                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//
//                JOptionPane.showMessageDialog(null, "generated succfully");
//
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.toString());
//            }
//
//
//        }
        if (createCenter == event.getSource()) {
            String address;
            String workingDays;
            if (centerAddressTextField.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please Provide center address");
                alert.show();
            } else if (centerWorkingDaysTextField.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please Provide center working days");
                alert.show();
            } else {
                address = centerAddressTextField.getText();
                workingDays = centerWorkingDaysTextField.getText();
                try {
                    Connection con = Main.createConnection();
                    String query = "insert into center VALUES(center_inc.nextval,'" + address + "','" + workingDays + "')";
                    con.createStatement().executeUpdate(query);


                    con.commit();
                    con.close();
                    refresh();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Created successful");
                    alert.show();
                    centerAddressTextField.setText("");
                    centerWorkingDays.setText("");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText(e.toString());
                    alert.show();
                }

            }
            refresh();
        }
        if (updateCenterButton == event.getSource()) {
            try {
                String address;
                String workingDays;
                Integer id;

                if (!centerID.getText().isEmpty()) {

                    Connection con = Main.createConnection();
                    id = Integer.parseInt(centerID.getText());

                    if (!(centerAddressTextField.getText().isEmpty())) {
                        address = centerAddressTextField.getText();
                        String query = "update center set address='" + address + "' where id=" + id;
                        con.createStatement().executeUpdate(query);

                    }
                    if (!(centerWorkingDaysTextField.getText().isEmpty())) {
                        workingDays = centerWorkingDaysTextField.getText();
                        String query = "update center set working_days='" + workingDays + "' where id=" + id;
                        con.createStatement().executeUpdate(query);
                    }

                    con.commit();
                    con.close();
                    refresh();
                    centerAddressTextField.setText("");
                    centerWorkingDays.setText("");
                    centerID.setText("");
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please Provide center ID number");
                    alert.show();
                }


            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please Provide correct ID number");
                alert.show();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(e.toString());
                alert.show();
            }
            refresh();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        interfaceNumber = 0;
        refresh();

        // -----------------------------Students interface---------------------------------- //

        // initialize students table
        studentsTable.setEditable(true);
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        bdColumn.setCellValueFactory(new PropertyValueFactory<Student, Date>("bd"));
        addressCoulumn.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        phone_numberColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("phone_number"));
        supervisorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("supervisor"));
        centerColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("center"));

        // to make the search in studentsObservableList
        if (interfaceNumber == 0) {
            try {
                searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                    filteredList.setPredicate(student -> {

                        // if no search value the display all records
                        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                            return true;
                        }

                        if (student.getId() != null && student.getId().toString().indexOf(newValue) > -1) {
                            return true; // means we found a match in id
                        } else if (student.getName() != null && student.getName().indexOf(newValue) > -1) {
                            return true;
                        } else if (student.getAddress() != null && student.getAddress().indexOf(newValue) > -1) {
                            return true;
                        } else if (student.getPhone_number() != null && student.getPhone_number().toString().indexOf(newValue) > -1) {
                            return true;
                        } else if (student.getSupervisor() != null && student.getSupervisor().indexOf(newValue) > -1) {
                            return true;
                        } else if (student.getCenter() != null && student.getCenter().indexOf(newValue) > -1) {
                            return true;
                        } else if (student.getBd() != null && student.getBd().toString().indexOf(newValue) > -1) {
                            return true;
                        } else {
                            return false;
                        }

                    });
                });

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
                alert.show();
            }
        }
//        // add all students to students table view
//        try {
//            Connection con = Main.createConnection();
//            studentsObservableList.clear();
//            String query = "select STUDENT.id,STUDENT.name,STUDENT.BD,STUDENT.address,STUDENT.phone_number,SUPERVISOR.name,CENTER.address from STUDENT,SUPERVISOR,CENTER where (STUDENT.su_id=SUPERVISOR.id and STUDENT.CENTER_ID=CENTER.id) order by student.id";
//            ResultSet res = con.createStatement().executeQuery(query);
//            while (res.next()) {
//                Student stu = new Student(res.getInt(1), res.getString(2), res.getDate(3), res.getString(4), res.getInt(5), res.getString(6), res.getString(7));
//                studentsObservableList.add(stu);
//            }
//            studentsTable.setItems(filteredList);
//            con.close();
//        } catch (Exception e) {
//
//        }
//

//        // add all centers to centerComboBox
//        try {
//            Connection con = Main.createConnection();
//            centerComboBoxList.clear();
//            String query1 = "select address from center order by id";
//            ResultSet res1 = con.createStatement().executeQuery(query1);
//            while (res1.next()) {
//                centerComboBoxList.add(res1.getString(1));
//            }
//            con.close();
//        } catch (Exception e) {
//
//        }

        // initialize centerComboBox
        centerComboBox.setItems(centerComboBoxList);

        // initialize supervisorComboBox
        supervisorsComboBox.setItems(supervisorsComboBoxList);
        supervisorsComboBox.setDisable(true);

        // -----------------------------Supervisor interface--------------------------------------------------- //

        // initialize Supervisor table
        supervisorsTable.setEditable(true);
        supervisorId.setCellValueFactory(new PropertyValueFactory<Supervisor, Integer>("id"));
        supervisorName.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("name"));
        supervisorBD.setCellValueFactory(new PropertyValueFactory<Supervisor, Date>("bd"));
        supervisorAddress.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("address"));
        supervisorPhoneNumber.setCellValueFactory(new PropertyValueFactory<Supervisor, Integer>("phone_number"));
        supervisorCenter.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("center"));

        // to make the search in SupervisorObservableList
        try {

            searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                supervisorsfilteredList.setPredicate(supervisor -> {
                    // if no search value the display all records
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    if (supervisor.getId() != null && supervisor.getId().toString().indexOf(newValue) > -1) {
                        return true; // means we found a match in id
                    } else if (supervisor.getName() != null && supervisor.getName().indexOf(newValue) > -1) {
                        return true;
                    } else if (supervisor.getAddress() != null && supervisor.getAddress().indexOf(newValue) > -1) {
                        return true;
                    } else if (supervisor.getPhone_number() != null && supervisor.getPhone_number().toString().indexOf(newValue) > -1) {
                        return true;
                    } else if (supervisor.getCenter() != null && supervisor.getCenter().indexOf(newValue) > -1) {
                        return true;
                    } else if (supervisor.getBd() != null && supervisor.getBd().toString().indexOf(newValue) > -1) {
                        return true;
                    } else {
                        return false;
                    }

                });
            });

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }

        // -----------------------------Add centers interface------------------------------------------------ //
        // initialize centers table
        centersTable.setEditable(true);
        centerId.setCellValueFactory(new PropertyValueFactory<Center, Integer>("id"));
        centerAddress.setCellValueFactory(new PropertyValueFactory<Center, String>("address"));
        centerWorkingDays.setCellValueFactory(new PropertyValueFactory<Center, String>("working_days"));


        // to make the search in centersObservableList
        try {

            centerSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                centersfilteredList.setPredicate(center -> {
                    // if no search value the display all records
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    if (center.getId() != null && center.getId().toString().indexOf(newValue) > -1) {
                        return true; // means we found a match in id
                    } else if (center.getAddress() != null && center.getAddress().indexOf(newValue) > -1) {
                        return true;
                    } else if (center.getWorking_days() != null && center.getWorking_days().toString().indexOf(newValue) > -1) {
                        return true;
                    } else {
                        return false;
                    }

                });
            });

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }


        // -----------------------------Add students and Supervisors interface----------------------------- //

        // initialize anyNumber comboBox
        anyNumber.setItems(centerComboBoxList);
        anyNumber1.setItems(supervisorsComboBoxList);
        anyNumber1.setDisable(true);


        any.getItems().addAll(
                "مشرف", "طالب"
        );

        any.setValue("طالب");

        any.setCellFactory(
                new Callback<ListView<String>, ListCell<String>>() {
                    @Override
                    public ListCell<String> call(ListView<String> param) {
                        final ListCell<String> cell = new ListCell<String>() {
                            {
                                super.setPrefWidth(100);
                            }

                            @Override
                            public void updateItem(String item,
                                                   boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    setText(item);
                                    if (item.contains("طالب")) {
                                        setTextFill(Color.BLUE);
                                    } else if (item.contains("مشرف")) {
                                        setTextFill(Color.BLUE);
                                    }

                                } else {
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                });
        // to refresh all tables and comboBoxes
        refresh();

    }

    private void refresh() {
        if (interfaceNumber == 0) {

            try {
                Connection con = Main.createConnection();
                // add all students to students table view
                studentsObservableList.clear();
                String query = "select STUDENT.id,STUDENT.name,STUDENT.BD,STUDENT.address,STUDENT.phone_number,SUPERVISOR.name,CENTER.address from STUDENT,SUPERVISOR,CENTER where (STUDENT.su_id=SUPERVISOR.id and STUDENT.CENTER_ID=CENTER.id) order by student.id";
                ResultSet res = con.createStatement().executeQuery(query);
                while (res.next()) {
                    Student stu = new Student(res.getInt(1), res.getString(2), res.getDate(3), res.getString(4), res.getInt(5), res.getString(6), res.getString(7));
                    studentsObservableList.add(stu);
                }
                studentsTable.setItems(filteredList);

                // add all centers to centerComboBox
                centerComboBoxList.clear();
                String query1 = "select address from center order by id";
                ResultSet res1 = con.createStatement().executeQuery(query1);
                while (res1.next()) {
                    centerComboBoxList.add(res1.getString(1));
                }

                // add all supervisors to supervisorsComboBox
                supervisorsComboBoxList.clear();
                supervisorsComboBox.setDisable(true);
                String query2 = "select name from supervisor order by id";
                ResultSet res2 = con.createStatement().executeQuery(query2);
                while (res2.next()) {
                    supervisorsComboBoxList.add(res2.getString(1));
                }

                con.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
                alert.show();
            }

        } else if (interfaceNumber == 1) {
            // add all supervisors to supervisors table

            try {
                Connection con = Main.createConnection();

                supervisorsObservableList.clear();
                String query = "select SUPERVISOR.id,SUPERVISOR.name,SUPERVISOR.BD,SUPERVISOR.address,SUPERVISOR.phone_number,CENTER.address from SUPERVISOR,CENTER where (SUPERVISOR.CENTER_ID=CENTER.id) order by SUPERVISOR.id";
                ResultSet res = con.createStatement().executeQuery(query);
                while (res.next()) {
                    Supervisor sup = new Supervisor(res.getInt(1), res.getString(2), res.getDate(3), res.getString(4), res.getInt(5), res.getString(6));
                    supervisorsObservableList.add(sup);
                }
                supervisorsTable.setItems(supervisorsfilteredList);


                con.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
                alert.show();
            }


        } else if (interfaceNumber == 2) {
            // add all centers to center table

            try {
                Connection con = Main.createConnection();

                centersObservableList.clear();
                String query = "select id,address,working_days from CENTER order by id";
                ResultSet res = con.createStatement().executeQuery(query);
                while (res.next()) {
                    Center sup = new Center(res.getInt(1), res.getString(2), res.getString(3));
                    centersObservableList.add(sup);
                }
                centersTable.setItems(centersfilteredList);


                con.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
                alert.show();
            }


        }
    }

}

