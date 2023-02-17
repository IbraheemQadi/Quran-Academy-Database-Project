package com.example.QuranProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class StudentController implements Initializable {

    @FXML
    private TextField ID_info;

    @FXML
    private Button INFO_USER;

    @FXML
    private TextField Phone_info;

    @FXML
    private AnchorPane REP_pane;

    @FXML
    private GridPane REPort;

    @FXML
    private TextField address_info;

    @FXML
    private TextField bd_info;

    @FXML
    private Button but_Up_inf;

    @FXML
    private Button but_Up_pass;

    @FXML
    private Button but_logout;

    @FXML
    private Button butc;

    @FXML
    private Hyperlink hk_change_pass;

    @FXML
    private AnchorPane info_pan;

    @FXML
    private Label lab_NewPass;

    @FXML
    private Label userId;

    @FXML
    private Label userName;

    @FXML
    private Label lab_oldPass;

    @FXML
    private TextField name_info;

    @FXML
    private TextField new_pass;

    @FXML
    private TextField old_pass;

    @FXML
    private TextField center_info;

    @FXML
    private TextField supervisor_info;

    @FXML
    private TextField reportSearchTextField;

    @FXML
    private VBox vboxx;
    @FXML
    TableView<Report> reportTable;

    @FXML
    private TableColumn<Report, String> memorizeSurah;
    @FXML
    private TableColumn<Report, String> memorizeRange;
    @FXML
    private TableColumn<Report, Integer> memorizeMark;
    @FXML
    private TableColumn<Report, String> reviewSurah;
    @FXML
    private TableColumn<Report, String> reviewRange;
    @FXML
    private TableColumn<Report, Date> reportDate;
    @FXML
    private TableColumn<Report, Integer> reviewMark;

    // list for all students
    ObservableList<Report> reportsObservableList = FXCollections.observableArrayList();
    FilteredList<Report> reportsfilteredList = new FilteredList<>(reportsObservableList, b -> true);


    Integer studentId = LoginController.id;
    String studentName;
    Date studentBd;
    String studentAddress;
    Integer studentPhoneNumber;
    String studentCenterName;
    String studentPassword;
    String studentSupervisor;

    @FXML
    void bag2(ActionEvent event) throws IOException {


        if (event.getSource() == butc) {

            REPort.setVisible(true);
            REP_pane.setVisible(true);
            info_pan.setVisible(false);

            refresh();
        }


        if (event.getSource() == but_logout) {

            Stage stage = new Stage();
            stage.setTitle("Login");

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((Node) (event.getSource())).getScene().getWindow().hide();

            stage.setScene(scene);
            stage.show();

        }

        if (event.getSource() == INFO_USER) {

            REPort.setVisible(false);
            REP_pane.setVisible(false);


            info_pan.setVisible(true);

            old_pass.setVisible(false);
            new_pass.setVisible(false);
            lab_NewPass.setVisible(false);
            lab_oldPass.setVisible(false);
            but_Up_pass.setVisible(false);

            // user info interface
            ID_info.setText(studentId.toString());
            name_info.setText(studentName);
            bd_info.setText(studentBd.toString());
            address_info.setText(studentAddress);
            Phone_info.setText(studentPhoneNumber.toString());
            center_info.setText(studentCenterName);
            supervisor_info.setText(studentSupervisor);

        }

        if (hk_change_pass == event.getSource()) {

            old_pass.setVisible(true);
            new_pass.setVisible(true);
            lab_NewPass.setVisible(true);
            lab_oldPass.setVisible(true);
            but_Up_pass.setVisible(true);

            old_pass.setText("");
            new_pass.setText("");


        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //------------ get all data for the user ( which is the student ) ---------------------- //

        try {
            Connection con = Main.createConnection();
            String qurey = "select name,bd,address,phone_number,center_id,password,su_id from student where id=" + studentId;
            ResultSet res = con.createStatement().executeQuery(qurey);
            res.next();
            studentName = res.getString(1);
            studentBd = res.getDate(2);
            studentAddress = res.getString(3);
            studentPhoneNumber = res.getInt(4);
            studentPassword = res.getString(6);

            // res.getInt(5) rep center id
            String qurey2 = "select address from center where id=" + res.getInt(5);
            ResultSet res2 = con.createStatement().executeQuery(qurey2);
            res2.next();
            studentCenterName = res2.getString(1);

            //res,getIng(7) rep supervisor id
            res.getInt(7);
            String qurey3 = "select name from supervisor where id=" + res.getInt(7);
            res = con.createStatement().executeQuery(qurey3);
            res.next();
            studentSupervisor = res.getString(1);


        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }

        userId.setText(Integer.toString(studentId));
        userName.setText(studentName);


        // -----------------------------reports interface---------------------------------- //

        // initialize reports table
        reportTable.setEditable(true);
        memorizeSurah.setCellValueFactory(new PropertyValueFactory<Report, String>("memorizeSurah"));
        memorizeRange.setCellValueFactory(new PropertyValueFactory<Report, String>("memorizeRange"));
        memorizeMark.setCellValueFactory(new PropertyValueFactory<Report, Integer>("memorizeMark"));
        reviewSurah.setCellValueFactory(new PropertyValueFactory<Report, String>("reviewSurah"));
        reviewRange.setCellValueFactory(new PropertyValueFactory<Report, String>("reviewRange"));
        reviewMark.setCellValueFactory(new PropertyValueFactory<Report, Integer>("reviewMark"));
        reportDate.setCellValueFactory(new PropertyValueFactory<Report, Date>("reportDate"));


        // to make the search in reportsObservableList
        try {
            reportSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                reportsfilteredList.setPredicate(report -> {

                    // if no search value the display all records
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }


                    if (report.getMemorizeSurah() != null && report.getMemorizeSurah().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getMemorizeRange() != null && report.getMemorizeRange().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getMemorizeMark() != null && report.getMemorizeMark().toString().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getReviewSurah() != null && report.getReviewSurah().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getReviewRange() != null && report.getReviewRange().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getReviewMark() != null && report.getReviewMark().toString().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getReportDate() != null && report.getReportDate().toString().indexOf(newValue) > -1) {
                        return true;
                    } else {
                        return false;
                    }

                });
            });

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }
        refresh();
    }

    public void refresh() {


        try {
            Connection con = Main.createConnection();

            // add all reports to report table view
            reportsObservableList.clear();
            String query1 = "select memorize_surah,memorize_range,memorize_mark,review_surah,review_range,reviwe_mark,report_date from report where (st_id=" + studentId + ") order by report.i";
            ResultSet res1 = con.createStatement().executeQuery(query1);
            while (res1.next()) {
                Report report1 = new Report(res1.getString(1), res1.getString(2), res1.getFloat(3), res1.getString(4), res1.getString(5), res1.getFloat(6), res1.getDate(7));
                reportsObservableList.add(report1);
            }
            reportTable.setItems(reportsfilteredList);


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }


    }

}


