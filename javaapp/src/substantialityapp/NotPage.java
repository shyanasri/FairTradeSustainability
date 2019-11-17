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
public class NotPage extends Stage {
    
  NotPage()
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
        
        


        Text s = new Text("Unfortunately the Product you Entered is" ); 

        Text t = new Text("NOT");
        
        Text u= new Text("Sustainably Sourced");

        t.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
        s.setFill(Color.GREEN); 
        s.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));
        u.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));
        t.setFill(Color.DARKBLUE);
        u.setFill(Color.GREEN);
        //unfort
        s.setX(100);
        s.setY(200);
        //not
        t.setX(580);
        t.setY(200);
        //sus
        u.setX(200);
        u.setY(250);

    

        Button btns2 = new Button("LEARN MORE");
        btns2.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        btns2.setLayoutX(100);
        btns2.setLayoutY(10);
        btns2.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                           new LearnMore();
                                                        }

                                                 });
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
        final Button comapines=new Button("Featured Compaines");
        comapines.setMinWidth(100);
        comapines.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        comapines.setOnAction(new EventHandler<ActionEvent>()
            {
                     @Override
                     public void handle(ActionEvent e) 
                        {
                            new FeaturedCompaines();
                        }
            
            });
        comapines.setLayoutX(250);
        comapines.setLayoutY(10);
        Group root1=new Group(btns2,s,t,imgView,u,back,comapines);

        this.setScene(new Scene(root1, 800, 700));
        this.setTitle("https://greenfoodpicker/Sorry...");
        this.show();
          }
    
}
