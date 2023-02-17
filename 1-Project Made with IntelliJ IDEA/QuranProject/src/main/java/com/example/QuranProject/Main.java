package com.example.QuranProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.sql.Connection;


import javax.swing.*;


public class Main extends Application {
    public static Stage stage1;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            stage1 = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Hello!");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void showStage(Stage stage, String fxml) throws Exception {
//        stage1.close();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setResizable(false);
//        stage.setTitle("Home");
//        stage.setScene(scene);
//        stage.show();
//
//    }

    // method to make connection with database
    public static Connection createConnection() {
        Connection con = null;
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("ibraheemqadi");
            ods.setPassword("123456");
            con = ods.getConnection();
            con.setAutoCommit(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            launch();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            e.printStackTrace();
        }
    }
}