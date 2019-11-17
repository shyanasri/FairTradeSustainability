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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class LearnMore extends Stage {
    
    LearnMore()
        {
                Text name= new Text("GREEN FOOD PICKER");
                name.setFont(Font.font("Cambria", 64));
                name.setFill(Color.GREEN);
                name.setX(100);
                name.setY(50);
                Text tag=new Text("Choose a Better Today for a Better Tomorrow");
                tag.setFont(Font.font("Cambria",FontPosture.ITALIC, 32));
                tag.setX(100);
                tag.setY(80);
                Text info=new Text("Fairtrade Canada is a non-profit organization \n\nthat works towards making trade of "
                        + "goods \n\nfairer for farmers and other workers by directly working with\n\n businesses and consumers. "
                        + "The Fairtrade certification\n\n promotes more ethical and environmentally-friendly\n\n standards for goods producers. "
                        + "By meeting these standards,\n\n consumers can be confident in a product’s sustainability in all \n\naspects.");
                info.setX(80);
                info.setY(180);
                info.setFont(Font.font("Cambria", 26));
                final Button back=new Button("Back");
                back.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                back.setLayoutX(5);
                back.setLayoutY(650);
                back.setOnAction(new EventHandler<ActionEvent>()
            {
                     @Override
                     public void handle(ActionEvent e) 
                        {
                            Stage stage = (Stage) back.getScene().getWindow();
                            stage.close();
                        }
            
            });
                Group root1= new Group(tag,name,info,back);
                this.setScene(new Scene(root1, 800, 700));
                this.setTitle("https://greenfoodpicker/learnmore");
                this.show();
                
            
        }
  
}
