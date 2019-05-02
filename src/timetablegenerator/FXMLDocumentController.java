/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdulmalik Abubakar
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane viewBufferPane;
    @FXML
    private ImageView exitButton;
    @FXML
    private ImageView minimizeButton;
    static double xOffset;
    static double yOffset;

    public void initialize(URL url, ResourceBundle rb) {
        viewBufferPane.getChildren().add(new AddCourseView());
        
    }    

    @FXML
    private void exitButtonClicked(MouseEvent event) {
        TimeTableGenerator.stage.close();
        System.exit(0);
    }

    @FXML
    private void minimizeButtonClicked(MouseEvent event) {
        TimeTableGenerator.stage.setIconified(true);
    }

    @FXML
    private void departmentButtonClicked(MouseEvent event) {
        viewBufferPane.getChildren().clear();
        viewBufferPane.getChildren().add(new AddDepartmentView());
    }

    @FXML
    private void venueButtonClicked(MouseEvent event) {
        viewBufferPane.getChildren().clear();
        viewBufferPane.getChildren().add(new AddVenueView());
    }

    @FXML
    private void courseButtonClicked(MouseEvent event) {
        viewBufferPane.getChildren().clear();
        viewBufferPane.getChildren().add(new AddCourseView());
    }

    @FXML
    private void assgnCourseButtonClicked(MouseEvent event) {
        viewBufferPane.getChildren().clear();
        viewBufferPane.getChildren().add(new AssignCourseView());
    }

    @FXML
    private void assgnVenueButtonClicked(MouseEvent event) {
    }
    
    @FXML
    private void paneDragged(MouseEvent event) {
        TimeTableGenerator.stage.setX(event.getScreenX()+xOffset);
        TimeTableGenerator.stage.setY(event.getScreenY()+yOffset);
        
    }

    @FXML
    private void panePressed(MouseEvent event) {
        xOffset=TimeTableGenerator.stage.getX()-event.getScreenX();
        yOffset=TimeTableGenerator.stage.getY()-event.getScreenY();
    }


   
}
