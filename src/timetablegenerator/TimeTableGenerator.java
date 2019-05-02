/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Abdulmalik Abubakar
 */
public class TimeTableGenerator extends Application {
    public static boolean LOGGED_IN;
    public static Stage stage;
    public static Parent root1,root2;
    
    @Override
    public void start(Stage stage) throws Exception {
        root1 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root1);
        
        this.stage=stage;
        stage.setResizable(false);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Connection getConnection()
    {
       Connection con=null;
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/TimetableGeneratorDb?serverTimezone=UTC";
            String user="root";
            String password="111Abdulmalik111";
            con=DriverManager.getConnection(url,user,password);
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return con;
    }
    
}
