/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdulmalik Abubakar
 */
public class LoginPage {

    @FXML
    private Pane loginPane;
    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private JFXButton loginButton;
    @FXML
    private Label loginErrorText;

    @FXML
    private void user_password_valueEntered(KeyEvent event) {
        if(loginErrorText.isVisible())
        {
            loginErrorText.setVisible(false);
        }
    }

    @FXML
    private void loginButtonClicked(MouseEvent event) {
         //this method gets the login credentials entered by the user
        //and compares it to the stored login credentials.
        String username=usernameField.getText();
        String password=passwordField.getText();
        if(username.equals("abumuhab")&&password.equals("111Abdulmalik111"))
        {
            TimeTableGenerator.LOGGED_IN=true;
            Scene scene=new Scene(TimeTableGenerator.root2);
            TimeTableGenerator.stage.setScene(scene);
        }
        else
        {
            loginErrorText.setVisible(true);
        }
    }
    
}
