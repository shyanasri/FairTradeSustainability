/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substantialityapp;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class FeaturedCompaines extends Stage {
    
    FeaturedCompaines()
        {

                String path=System.getProperty("user.dir");
                 path=path+"//tree.png";
                 File file = new File(path);
                 Image image1 = new Image(file.toURI().toString());
                 ImageView imgView = new ImageView(image1);
                 imgView.setFitHeight(200);
                 imgView.setFitWidth(300);
                 imgView.setX(60);
                 imgView.setY(500);




                 Text s = new Text("Here is a list of Companies which provide\n sustainably sourced products:\n\n");
                 Text list=new Text("President's Choice Organic\n\n"
                         + "One Coffe\n\n"
                         + "Everyday Gourmet Coffee Roasters\n\n"
                         + "ME to WE\n\n"
                         + "Nature Zen" );      
                 
                list.setX(150);
                list.setY(200); 
                list.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));

                 
                 

                 s.setFill(Color.DARKBLUE); 
                 s.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));

                 //unfort
                 s.setX(150);
                 s.setY(100);
                 //back button 
                 final Button back=new Button("Back");
                 back.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                 back.setOnAction(new EventHandler<ActionEvent>()
                    {
                             @Override
                             public void handle(ActionEvent e) 
                                {
                                    Stage stage = (Stage) back.getScene().getWindow();
                                    stage.close();
                                }

                    });
                  back.setLayoutX(10);
                  back.setLayoutY(10);

                Group root1= new Group(s,imgView,list);
                this.setScene(new Scene(root1, 800, 700));
                this.setTitle("https://greenfoodpicker/featuredcompaines");
                this.show();
                
            
        }

    
}
