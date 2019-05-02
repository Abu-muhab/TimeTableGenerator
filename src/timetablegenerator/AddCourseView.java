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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * FXML Controller class
 *
 * @author Abdulmalik Abubakar
 */
public class AddCourseView extends Pane implements Initializable {

    @FXML
    private ChoiceBox<String> semesterCombo;
    @FXML
    private ChoiceBox<String> levelCombo;
    @FXML
    private JFXTextField courseCodeField;
    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXButton addButton;
    @FXML
    private JFXTextField unitField;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        semesterCombo.getItems().addAll("First Semester".toUpperCase(),"Second Semester".toUpperCase());
        semesterCombo.setValue("First Semester".toUpperCase());
        levelCombo.getItems().addAll("100","200","300","400","500");
        levelCombo.setValue("100");
    }    
    
    public AddCourseView()
    {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("AddCourseView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try
        {
            fxmlLoader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void addButtonClicked(MouseEvent event) {
        AddToDatabaseTask task=new AddToDatabaseTask();
        courseCodeField.clear();
        nameField.clear();
        unitField.clear();
        courseCodeField.requestFocus();
        new Thread(task).start();
    }

    @FXML
    private void enterButtonPressed(KeyEvent event)
    {
        if(event.getSource()==courseCodeField)
        {
            if(event.getCode()==KeyCode.ENTER)
            {
                nameField.requestFocus();
            }
        }
        else
            if(event.getSource()==nameField)
            {
                if(event.getCode()==KeyCode.ENTER)
                {
                    unitField.requestFocus();
                }
            }
            else 
                if(event.getSource()==unitField)
                {
                   if(event.getCode()==KeyCode.ENTER)
                   {
                        AddToDatabaseTask task=new AddToDatabaseTask();
                        courseCodeField.clear();
                        nameField.clear();
                        unitField.clear();
                        courseCodeField.requestFocus();
                        new Thread(task).start();
                   }
                }
    }
    class AddToDatabaseTask extends Task
    {
        
        String courseCode=courseCodeField.getText();
        String name=nameField.getText();
        String semester=semesterCombo.getValue();
        int _semester=0;
        @Override
        public Void call()
        {
            if(semester.equalsIgnoreCase("First Semester"))
            {
                _semester=1;
            }
            else
            {
                _semester=2;
            }
            
            int level=Integer.parseInt(levelCombo.getValue());
            int units=Integer.parseInt(unitField.getText());
            Connection con=TimeTableGenerator.getConnection();
            try
            {
                Statement statement=con.createStatement();
                String insert__="insert into courses (CourseCode,Name,Semester,"
                        + "Level,Units) "
                        + "values "
                        + "('"+courseCode+"','"+name+"',"+_semester+","
                        +level+","+units+");";
                statement.executeUpdate(insert__);  
                
                
                
//                statement=con.createStatement();
//                String select="select * from departmets;";
//                ResultSet rows=statement.executeQuery(select);
//                while(rows.next())
//                {
//                    if((courseCode.toLowerCase()).contains(rows.getString("Code"
//                            + "").toLowerCase()))
//                    {
//                        String department=rows.getString("Code")+""+level;
//                        //the next line is for debugging process, delete later
//                        System.out.print(department);
//                        statement=con.createStatement();
//                        String create="create table "+department+
//                                " ( course varchar(45) not null );";
//                        statement.executeUpdate(create);
//                        String insert_="insert into "+department+" (course) values"
//                                + " ('"+courseCode+"');";
//                        statement.executeUpdate(insert_);
//                    }
//                }
            }
            catch(Exception e)
            {
                
                System.out.println("error");
                e.printStackTrace();
            
            }
            return null; 
        }
    }
}
