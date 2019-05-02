/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablegenerator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Abdulmalik Abubakar
 */
public class TableRow extends Pane  implements Initializable {

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public TableRow()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("TableRow.fxml"));
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
