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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.*;


public class SupervisorController implements Initializable {


    @FXML
    private Label userId;

    @FXML
    private Label userName;

    @FXML
    private TextField ID_info;

    @FXML
    private Button INFO_USER;

    @FXML
    private AnchorPane Insert_grad_pan;

    @FXML
    private TextField Phone_info;

    @FXML
    private TextField center_info;

    @FXML
    private TextField memorizeMarkTextField;

    @FXML
    private AnchorPane REP_pane;

    @FXML
    private GridPane REPort;

    @FXML
    private TextField ReviewMark;

    @FXML
    private TextField searchTextField;

    @FXML
    private AnchorPane SER_PAN;

    @FXML
    private TextField address_info;

    @FXML
    private TextField ayat_p;

    @FXML
    private TextField ayat_rev;

    @FXML
    private TextField bd_info;

    @FXML
    private Button but_Delete;

    @FXML
    private Button but_UPdate;

    @FXML
    private Button but_Up_inf;

    @FXML
    private Button but_Up_pass;

    @FXML
    private Button but_instert;

    @FXML
    private Button but_logout;

    @FXML
    private Button buta;

    @FXML
    private Button butc;

    @FXML
    private Button butc1;

    @FXML
    private Button generateReport;

    @FXML
    private TextField grade_p;

    @FXML
    private TextField grade_rev;

    @FXML
    private Hyperlink hk_change_pass;

    @FXML
    private TextField id_repo;

    @FXML
    private TextField indix_rep;

    @FXML
    private AnchorPane info_pan;

    @FXML
    private Label lab_NewPass;

    @FXML
    private Label lab_oldPass;

    @FXML
    private TextField name_info;

    @FXML
    private ComboBox<String> name_insert;

    ObservableList<String> studentsNamesObservableList = FXCollections.observableArrayList();


    @FXML
    private ComboBox<String> name_sora_p;

    @FXML
    private ComboBox<String> name_sora_rev;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private TextField new_pass;

    @FXML
    private TextField old_pass;

    @FXML
    private VBox vboxx;

    @FXML
    private TextField reportSearchTextField;

    // students table
    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> studentId;

    @FXML
    private TableColumn<Student, String> studentName;

    @FXML
    private TableColumn<Student, Date> studentBd;

    @FXML
    private TableColumn<Student, String> studentAddress;

    @FXML
    private TableColumn<Student, Integer> studentPhoneNumber;

    // list for all students
    ObservableList<Student> studentsObservableList = FXCollections.observableArrayList();
    FilteredList<Student> filteredList = new FilteredList<>(studentsObservableList, b -> true);

    // Reports table
    @FXML
    TableView<Report> reportTable;
    @FXML
    private TableColumn<Report, Integer> reportStudentid;
    @FXML
    private TableColumn<Report, String> reprotStudentName;
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
    @FXML
    private TableColumn<Report, Integer> reportIndex;
    // list for all students
    ObservableList<Report> reportsObservableList = FXCollections.observableArrayList();
    FilteredList<Report> reportsfilteredList = new FilteredList<>(reportsObservableList, b -> true);


    Integer supervisorId = LoginController.id;
    String supervisorName;
    Date supervisorBd;
    String supervisorAddress;
    Integer supervisorPhoneNumber;
    String supervisorCenterName;
    String supervisorPassword;


    @FXML
    void bag2(ActionEvent event) throws IOException {


        if (event.getSource() == buta) {
            Insert_grad_pan.setVisible(false);

            SER_PAN.setVisible(true);
            studentsTable.setVisible(true);
            reportTable.setVisible(false);
            REP_pane.setVisible(false);
            info_pan.setVisible(false);


            refresh();
        }


        if (event.getSource() == butc) {

            SER_PAN.setVisible(false);
            studentsTable.setVisible(false);
            Insert_grad_pan.setVisible(false);
            reportTable.setVisible(true);
            REP_pane.setVisible(true);
            info_pan.setVisible(false);

            id_repo.setText("");
            indix_rep.setText("");
            ReviewMark.setText("");
            memorizeMarkTextField.setText("");

            refresh();
        }


        if (event.getSource() == butc1) {

            SER_PAN.setVisible(false);
            studentsTable.setVisible(false);
            reportTable.setVisible(false);
            REP_pane.setVisible(false);
            info_pan.setVisible(false);
            Insert_grad_pan.setVisible(true);

            ayat_p.setText("");
            ayat_rev.setText("");
            grade_p.setText("");
            grade_rev.setText("");


            refresh();
        }

        if (event.getSource() == but_logout) {

            Stage stage = new Stage();
            stage.setTitle("Hello!");

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((Node) (event.getSource())).getScene().getWindow().hide();


            stage.setScene(scene);
            stage.show();


        }

        if (event.getSource() == INFO_USER) {
            SER_PAN.setVisible(false);
            studentsTable.setVisible(false);
            reportTable.setVisible(false);
            REP_pane.setVisible(false);

            Insert_grad_pan.setVisible(false);


            info_pan.setVisible(true);

            old_pass.setVisible(false);
            new_pass.setVisible(false);
            lab_NewPass.setVisible(false);
            lab_oldPass.setVisible(false);
            but_Up_pass.setVisible(false);

            // user info interface
            ID_info.setText(supervisorId.toString());
            name_info.setText(supervisorName);
            bd_info.setText(supervisorBd.toString());
            address_info.setText(supervisorAddress);
            Phone_info.setText(supervisorPhoneNumber.toString());
            center_info.setText(supervisorCenterName);


        }


        if (hk_change_pass == event.getSource()) {

            old_pass.setVisible(true);
            new_pass.setVisible(true);
            lab_NewPass.setVisible(true);
            lab_oldPass.setVisible(true);
            but_Up_pass.setVisible(true);

            old_pass.setText("");
            new_pass.setText("");

            refresh();
        }

        if (but_Up_pass == event.getSource()) {

            if (old_pass.getText().equals(supervisorPassword)) {
                try {
                    Connection con = Main.createConnection();
                    String stm = "update supervisor set password='" + new_pass.getText() + "' where id=" + supervisorId;

                    con.createStatement().executeUpdate(stm);
                    con.commit();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Password changed successfully");
                    alert.show();

                    new_pass.setText("");
                    old_pass.setText("");

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.toString());
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The old password is not correct");
                alert.show();
            }

            refresh();
        }

//        if (Clear_stud == event.getSource()) {
//
//            Serch_addres.setText("");
//            Serch_BD.setText("");
//            Serch_Center.setText("");
//            Serch_ID.setText("");
//            Serch_name.setText("");
//
//
//        }

        if (but_Delete == event.getSource()) {

            Report report = reportTable.getSelectionModel().getSelectedItem();
            try {
                if (report != null) {
                    Connection con = Main.createConnection();

                    String stm = "delete from report where (st_id=" + report.getSt_id() + " and i=" + report.getIndex() + ")";

                    con.createStatement().executeUpdate(stm);
                    con.commit();
                    con.close();

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please Select a row to delete");
                    alert.show();
                }


            } catch (Exception e) {

            }
            report = null;
            refresh();
        }

        if (but_UPdate == event.getSource()) {
            Float memorzieMark;
            Float reviewMark;
            Integer id;
            Integer index;

            try {
                Connection con = Main.createConnection();
                if (!(id_repo.getText().isEmpty() && indix_rep.getText().isEmpty())) {
                    id = Integer.parseInt(id_repo.getText());
                    index = Integer.parseInt(indix_rep.getText());

                    if (!(memorizeMarkTextField.getText().isEmpty())) {
                        memorzieMark = Float.parseFloat(memorizeMarkTextField.getText());
                        String qurey = "update report set memorize_mark=" + memorzieMark + " where (st_id=" + id + " and i=" + index + ") ";
                        con.createStatement().executeUpdate(qurey);

                    }
                    if (!(ReviewMark.getText().isEmpty())) {
                        reviewMark = Float.parseFloat(ReviewMark.getText());
                        String qurey = "update report set REVIWE_MARK=" + reviewMark + " where (st_id=" + id + " and i=" + index + ") ";
                        con.createStatement().executeUpdate(qurey);
                    }


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter both , ID and index");
                    alert.show();
                }
                memorizeMarkTextField.setText("");
                ReviewMark.setText("");
                id_repo.setText("");
                indix_rep.setText("");
                con.commit();
                con.close();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter correct ID and index");
                alert.show();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
                alert.show();
            }


            refresh();
        }
        if (but_instert == event.getSource()) {

            int flag = 0;
            Alert alert = new Alert(Alert.AlertType.ERROR);


            if (ayat_p.getText().equals("")) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }

            if (grade_p.getText().equals("")) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }

            if (ayat_rev.getText().equals("")) {
                alert.setContentText("Error for match");
                alert.show();
                flag = 1;
            }
            if (grade_rev.getText().equals("")) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }
            if (name_sora_p.getValue() == null) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }
            if (name_sora_rev.getValue() == null) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }
            if (name_insert.getValue() == null) {
                alert.setContentText("Please provide student");
                alert.show();
                flag = 1;
            }
            if (reportDatePicker.getValue() == null) {
                alert.setContentText("Error");
                alert.show();
                flag = 1;
            }
            try {
                if (Float.parseFloat(grade_p.getText()) > 10 && Float.parseFloat(grade_rev.getText()) > 10) {
                    alert.setContentText("Please enter a mark from 10 ");
                    alert.show();
                    flag = 1;
                }
            } catch (Exception e) {
                alert.setContentText("Please enter correct mark ");
                alert.show();
                flag = 1;
            }

            if (flag == 0) {
                String studentName = name_insert.getValue();
                String reportdate = reportDatePicker.getValue().toString();
                String suraP = name_sora_p.getValue();
                String suraRev = name_sora_rev.getValue();
                String ayatP = ayat_p.getText();
                String ayatRev = ayat_rev.getText();
                Float gradeP = Float.parseFloat(grade_p.getText());
                Float gradeRev = Float.parseFloat(grade_rev.getText());
                Integer studentID = 0;

                // to find the id of the student with name = studentName variable
                for (Student student : studentsObservableList) {
                    if (studentName.equals(student.getName())) {
                        studentID = student.getId();
                    }
                }

                try {
                    Connection con = Main.createConnection();

                    String stm = "insert into report VALUES(" + studentID + ",report_inc.nextval,'" + suraP + "','" + ayatP + "'," + gradeP + ",'" + ayatRev + "','" + suraRev + "'," + gradeRev + ",TO_DATE('" + reportdate + "','YYYY-MM-DD')," + supervisorId + ")";
                    con.createStatement().executeUpdate(stm);
                    con.commit();
                    con.close();
                } catch (Exception e) {
                    alert.setContentText(e.toString());
                    System.out.println(e.toString());
                    alert.show();
                }


//                name_insert.setValue(null);
                reportDatePicker.setValue(null);
                name_sora_p.setValue(null);
                name_sora_rev.setValue(null);
                ayat_rev.setText(null);
                ayat_p.setText(null);
                grade_p.setText(null);
                grade_rev.setText(null);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Added Successfully");
                alert.show();
            }
            refresh();
        }

        if (generateReport == event.getSource()) {

            Student student = studentsTable.getSelectionModel().getSelectedItem();
            if (student != null) {
                try {

                    Float memorzieAvg = Float.valueOf(0);
                    Float reviewAvg = Float.valueOf(0);


                    // lists to contain all report for student who's id = student.getId()
                    List<Report> reports = new ArrayList<Report>();

                    for (Report report : reportsObservableList) {

                        if (Objects.equals(report.getSt_id(), student.getId())) {
                            reports.add(report);
                            memorzieAvg += report.getMemorizeMark();
                            reviewAvg += report.getReviewMark();
                        }
                    }
                    memorzieAvg = (memorzieAvg / reports.size()) * 10;
                    reviewAvg = (reviewAvg / reports.size()) * 10;

                    /* Convert List to JRBeanCollectionDataSource */
                    JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(reports);

                    Map<String, Object> parameters = new HashMap<String, Object>();
                    parameters.put("Reports", itemsJRBean);
                    parameters.put("studentId", student.getId());
                    parameters.put("studentName", student.getName());
                    parameters.put("studentSupervisor", supervisorName);
                    parameters.put("studentCenter", supervisorCenterName);
                    parameters.put("studentAddress", student.getAddress());
                    parameters.put("studentBD", student.getBd().toString());
                    parameters.put("studentPhoneNumber", student.getPhone_number());
                    parameters.put("memorzieAvg", memorzieAvg);
                    parameters.put("reviewAvg", reviewAvg);


                    InputStream input = new FileInputStream(new File("studentReport.jrxml"));
                    JasperDesign jd = JRXmlLoader.load(input);
                    JasperReport jr = JasperCompileManager.compileReport(jd); // now the file with .jasper extinction
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());

                    /* outputStream to create PDF */
                    OutputStream outputStream = new FileOutputStream(new File("report`" + student.getId() + ".pdf"));
                    /* Write content to PDF file */
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Generated successfully");
                    alert.show();


                } catch (Exception e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText(e.toString());
                    alert.show();

                }

                student = null;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please select a student to generate the report ");
                alert.show();
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //------------ get all data for the user ( which is the supervisor ) ---------------------- //

        try {
            Connection con = Main.createConnection();
            String qurey = "select name,bd,address,phone_number,center_id,password from supervisor where id=" + supervisorId;
            ResultSet res = con.createStatement().executeQuery(qurey);
            res.next();
            supervisorName = res.getString(1);
            supervisorBd = res.getDate(2);
            supervisorAddress = res.getString(3);
            supervisorPhoneNumber = res.getInt(4);
            supervisorPassword = res.getString(6);

            // res.getInt(5) rep center id
            String qurey2 = "select address from center where id=" + res.getInt(5);
            res = con.createStatement().executeQuery(qurey2);
            res.next();
            supervisorCenterName = res.getString(1);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }

        userId.setText(supervisorId.toString());
        userName.setText(supervisorName);


        // -----------------------------Students interface---------------------------------- //

        // initialize students table
        studentsTable.setEditable(true);
        studentId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        studentBd.setCellValueFactory(new PropertyValueFactory<Student, Date>("bd"));
        studentAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        studentPhoneNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("phone_number"));

        // to make the search in studentsObservableList

        try {
            searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                filteredList.setPredicate(student -> {

                    // if no search value the display all records
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    if (student.getId().toString().indexOf(newValue) > -1) {
                        System.out.println("in  student search");
                        return true; // means we found a match in id
                    } else if (student.getName().indexOf(newValue) > -1) {
                        return true;
                    } else if (student.getAddress().indexOf(newValue) > -1) {
                        return true;
                    } else if (student.getPhone_number().toString().indexOf(newValue) > -1) {
                        return true;
                    } else if (student.getBd().toString().indexOf(newValue) > -1) {
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

        // -----------------------------reports interface---------------------------------- //

        // initialize reports table
        reportTable.setEditable(true);
        reportStudentid.setCellValueFactory(new PropertyValueFactory<Report, Integer>("st_id"));
        reprotStudentName.setCellValueFactory(new PropertyValueFactory<Report, String>("st_name"));
        memorizeSurah.setCellValueFactory(new PropertyValueFactory<Report, String>("memorizeSurah"));
        memorizeRange.setCellValueFactory(new PropertyValueFactory<Report, String>("memorizeRange"));
        memorizeMark.setCellValueFactory(new PropertyValueFactory<Report, Integer>("memorizeMark"));
        reviewSurah.setCellValueFactory(new PropertyValueFactory<Report, String>("reviewSurah"));
        reviewRange.setCellValueFactory(new PropertyValueFactory<Report, String>("reviewRange"));
        reviewMark.setCellValueFactory(new PropertyValueFactory<Report, Integer>("reviewMark"));
        reportDate.setCellValueFactory(new PropertyValueFactory<Report, Date>("reportDate"));
        reportIndex.setCellValueFactory(new PropertyValueFactory<Report, Integer>("index"));

        // to make the search in reportsObservableList
        try {
            reportSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

                reportsfilteredList.setPredicate(report -> {

                    // if no search value the display all records
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    if (report.getSt_id() != null && report.getSt_id().toString().indexOf(newValue) > -1) {
                        return true; // means we found a match in id
                    } else if (report.getSt_name() != null && report.getSt_name().indexOf(newValue) > -1) {
                        return true;
                    } else if (report.getMemorizeSurah() != null && report.getMemorizeSurah().indexOf(newValue) > -1) {
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }


        // -----------------------------add reports interface---------------------------------- //

        String pas[] = {
                "سورة البقرة", "سورة آل عمران", "سورة النساء", "سورة المائدة", "سورة الأنعام", "سورة الأعراف", " سورة الأنفال", "سورة التوبة",

                "سورة يونس", "سورة هود", "سورة يوسف", "سورة الرعد", " سورة إبراهيم", "سورة الحجر", "سورة النحل", " سورة الإسراء",
                "سورة الكهف", " سورة مريم", " سورة طه", "سورة الأنبياء", "سورة الحج", "سورة المؤمنون", "سورة النور", "سورة الفرقان", " سورة الشعراء",
                "سورة النمل", "سورة القصص", "سورة العنكبوت", "سورة الروم", "سورة لقمان", "سورة السجدة", "سورة الأحزاب", "سورة سبأ",
                "سورة فاطر", "سورة يس", "سورة الصافات", "سورة ص", "سورة الزمر", "سورة غافر", "سورة فصلت", "سورة الشورى", "سورة الزخرف",
                "سورة الدخان", "سورة الجاثية", "سورة الأحقاف", "سورة محمد", "سورة الفتح", "سورة الحجرات", "سورة ق", "سورة الذاريات", "سورة الطور", "سورة النجم",
                "سورة القمر", "سورة الرحمن", "سورة الواقعة", "سورة الحديد", "سورة المجادلة", " سورة الحشر", "سورة الممتحنة", " سورة الصف", "سورة الجمعة", "سورة المنافقون",
                "سورة التغابن", "سورة الطلاق", " سورة التحريم", "سورة الملك", "سورة القلم", "سورة الحاقة", "سورة المعارج", "سورة نوح", "سورة الجن", "سورة المزمل", "سورة المدثر",
                "سورة القيامة", "سورة الإنسان", "سورة المرسلات", "سورة النبأ", "سورة النازعات", "سورة عبس", "سورة التكوير", "سورة الانفطار", "سورة المطففين", "سورة الانشقاق", "سورة البروج",
                "سورة الطارق", "سورة الأعلى", "سورة الغاشية", "سورة الفجر", "سورة البلد", "سورة الشمس", "سورة الليل", "سورة الضحى", "سورة الشرح", "سورة التين", "سورة العلق", "سورة القدر", "سورة البينة",
                "سورة الزلزلة", "سورة العاديات", "سورة القارعة", " سورة التكاثر", "سورة العصر", "سورة الهمزة", "سورة الفيل", "سورة قريش", "سورة الماعون", "سورة الكوثر", "سورة الكافرون", "سورة النصر", "سورة المسد", "سورة الإخلاص", "سورة الفلق", "سورة الناس"


        };


        // // initialize name_insertComboBox
        name_insert.setItems(studentsNamesObservableList);


        name_sora_p.setTooltip(new Tooltip());
        name_sora_p.getItems().addAll(pas);

        name_sora_rev.setTooltip(new Tooltip());
        name_sora_rev.getItems().addAll(pas);

//        new ComboBoxAutoComplete<String>(name_sora_p);
//        new ComboBoxAutoComplete<String>(name_sora_rev);


        refresh();
    }

    private void refresh() {

        try {
            Connection con = Main.createConnection();

            // add all students to students table view && add students names to studentsNames
            studentsObservableList.clear();
            studentsNamesObservableList.clear();
            String query = "select id,name,BD,address,phone_number from STUDENT where (su_id=" + supervisorId + ") order by id";
            ResultSet res = con.createStatement().executeQuery(query);
            while (res.next()) {
                Student stu = new Student(res.getInt(1), res.getString(2), res.getDate(3), res.getString(4), res.getInt(5));
                studentsObservableList.add(stu);
                studentsNamesObservableList.add(stu.getName());
            }
            studentsTable.setItems(filteredList);


            // add all reports to report table view
            reportsObservableList.clear();
            String query1 = "select DISTINCT report.st_id,student.name,report.memorize_surah,report.memorize_range,report.memorize_mark,report.review_surah,report.review_range,report.reviwe_mark,report.report_date,report.I from report,student where (report.su_id=" + supervisorId + " and report.st_id=student.id) order by report.i";
            ResultSet res1 = con.createStatement().executeQuery(query1);
            while (res1.next()) {
                Report report1 = new Report(res1.getInt(1), res1.getString(2), res1.getString(3), res1.getString(4), res1.getFloat(5), res1.getString(6), res1.getString(7), res1.getFloat(8), res1.getDate(9), res1.getInt(10));
                reportsObservableList.add(report1);
            }
            reportTable.setItems(reportsfilteredList);


            con.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }

    }

}
