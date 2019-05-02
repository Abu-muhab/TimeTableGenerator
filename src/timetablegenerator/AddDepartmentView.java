/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.*;
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
public class AddDepartmentView extends Pane implements Initializable {

    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXButton addButton;
    @FXML
    private JFXTextField schoolField;
    @FXML
    private JFXTextField codeField;

      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public AddDepartmentView()
    {
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("AddDepartmentView.fxml"));
        fxmlloader.setController(this);
        fxmlloader.setRoot(this);
        try
        {
            fxmlloader.load();
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
        schoolField.clear();
        codeField.clear();
        nameField.requestFocus();
        new Thread(task).start();
    }

    @FXML
    private void enterButtonPressed(KeyEvent event) {
        if(event.getSource()==nameField)
        {
            if(event.getCode()==KeyCode.ENTER)
            {
                schoolField.requestFocus();
            }
        }
        else
            if(event.getSource()==schoolField)
            {
                if(event.getCode()==KeyCode.ENTER)
                {
                   codeField.requestFocus();
                }
            }
        else
            if(event.getSource()==codeField)
            {
                 if(event.getCode()==KeyCode.ENTER)
                 {
                    AddToDatabaseTask task=new AddToDatabaseTask();
                    nameField.clear();
                    schoolField.clear();
                    codeField.clear();
                    nameField.requestFocus();
                    new Thread(task).start();
                 }
            }
    }
    class AddToDatabaseTask extends Task
    {
        String name=nameField.getText();
        String school=schoolField.getText();
        String code=codeField.getText();
        @Override
        public Void call()
        {
            Connection con=TimeTableGenerator.getConnection();
            try
            {
                Statement statement=con.createStatement();
                String insert="insert into Departments (Name,School,Code)"
                        + " values"
                        + "('"+name+"',"+"'"+school+"','"+code+"');";
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
