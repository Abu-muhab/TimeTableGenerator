/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Abdulmalik Abubakar
 */
public class AssignCourseView extends Pane implements Initializable {

    @FXML
    private ChoiceBox<String> levelCombo;
    @FXML
    private VBox tableVbox;
    @FXML
    private JFXComboBox<String> departmentCombo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(int i=0;i<30;i++)
        {
            tableVbox.getChildren().add(new TableRow());
        }
        levelCombo.getItems().addAll("100","200","300","400","500");
        levelCombo.setValue("100");
         Connection con=TimeTableGenerator.getConnection();
         try
         {
            Statement s=con.createStatement();
            String select="select * from Departments;";
            ResultSet rows=s.executeQuery(select);
            boolean firstLoopFlag=false;
            while(rows.next())
            {
                departmentCombo.getItems().add(rows.getString("Name").toUpperCase());
                if(firstLoopFlag==false)
                {
                    departmentCombo.setValue(rows.getString("Name").toUpperCase());
                    firstLoopFlag=true;
                }
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
    }    
    
    public AssignCourseView()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AssignCourseView.fxml"));
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
    
}
