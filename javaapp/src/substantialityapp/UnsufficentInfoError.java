/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substantialityapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class UnsufficentInfoError extends Stage {
    
 UnsufficentInfoError()
    {
             Text error=new Text("             Error: Please Enter\n            all the required\n                 information");
            error.setFont(Font.font("Cambria", 25));
            error.setX(20);
            error.setY(75);
            Group root =new Group(error);
            this.setScene(new Scene(root, 350, 200));
            this.setTitle("ERROR");
            this.show();

        
        
    }
    
}
