/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Abdulmalik Abubakar
 */
public class AddVenueView extends Pane implements Initializable {

    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXButton addButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public AddVenueView()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AddVenueView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void addButtonClicked(MouseEvent event) {
        AddToDatabaseTask task=new AddToDatabaseTask();
        nameField.clear();
        new Thread(task).start();
    }

    @FXML
    private void enterButtonPressed(KeyEvent event) {
        if(event.getSource()==nameField)
        {
            if(event.getCode()==KeyCode.ENTER)
            {
                AddToDatabaseTask task=new AddToDatabaseTask();
                nameField.clear();
                new Thread(task).start();
            }
        }
    }
    
    
    class AddToDatabaseTask extends Task
    {
        String name=nameField.getText();
        Connection con=TimeTableGenerator.getConnection();
        public Void call()
        {
            try
            {
                Statement statement=con.createStatement();
                String insert="insert into Venues (Name)"
                        + " values "
                        + "('"+name+"');";
                statement.executeUpdate(insert);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}
