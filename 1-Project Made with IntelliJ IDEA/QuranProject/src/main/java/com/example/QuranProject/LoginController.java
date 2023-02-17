package com.example.QuranProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;


public class LoginController {

    public static Integer id;

    @FXML
    private Hyperlink forget;

    @FXML
    private Button login;

    @FXML
    private Hyperlink signup;

    @FXML
    private TextField textFeildID;

    @FXML
    private PasswordField textFeildPassword;

    @FXML
    private Label passwordNotCorrect;

    @FXML
    private Label idNotCorrect;


    @FXML
    public void LogIn(ActionEvent event) {


        idNotCorrect.setText("");
        passwordNotCorrect.setText("");

        try {
            id = Integer.parseInt(textFeildID.getText());
        } catch (Exception e) {
            idNotCorrect.setText("رقم المستخدم غير صحيح");
        }


        try {

            String password = textFeildPassword.getText();
            Connection con = Main.createConnection();

            String query1 = "select id,password from supervisor";
            String query2 = "select id,password from student";
            ResultSet res1 = con.createStatement().executeQuery(query1); // for supervisor
            ResultSet res2 = con.createStatement().executeQuery(query2); // for student


            // check admin
            if (id == 1234 && password.equals(new String("admin"))) {
                // show admin screen
//                Stage stag = new Stage();
//                Main.showStage(stag, "home.fxml");

                Stage stage = new Stage();
                stage.setTitle("Home");

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                ((Node) (event.getSource())).getScene().getWindow().hide();

                stage.setScene(scene);
                stage.show();


            }
            // check supervisor
            else if (id >= 2000 && id <= 3000) {
                boolean flag = false;
                while (res1.next()) {
                    if (id == res1.getInt(1)) {
                        if (password.equals(res1.getString(2))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;

                        }
                    } else {
                        flag = false;
                    }
                }

                if (flag) {
//                    Stage stag = new Stage();
//                    Main.showStage(stag, "supervisor.fxml");

                    Stage stage = new Stage();
                    stage.setTitle("Login");

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("supervisor.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    ((Node) (event.getSource())).getScene().getWindow().hide();

                    stage.setScene(scene);
                    stage.show();


                } else {
                    passwordNotCorrect.setText("رقم المستخدم او كلمة المرور غير صحيحة");
                }
            }
            // check student
            else if (id >= 1000 && id <= 1999) {
                boolean flag = false;
                while (res2.next()) {
                    if (id == res2.getInt(1)) {
                        if (password.equals(res2.getString(2))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }
                if (flag) {
//                    Stage stag = new Stage();
//                    Main.showStage(stag, "student.fxml");


                    Stage stage = new Stage();
                    stage.setTitle("Login");

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("student.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    ((Node) (event.getSource())).getScene().getWindow().hide();

                    stage.setScene(scene);
                    stage.show();


                } else {
                    passwordNotCorrect.setText("رقم المستخدم او كلمة المرور غير صحيحة");
                }

            } else {
                idNotCorrect.setText("رقم المستخدم غير صحيح");
            }

            res1.close();
            res2.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }


}
