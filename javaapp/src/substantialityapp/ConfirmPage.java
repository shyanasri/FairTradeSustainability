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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.html.CSS;

/**
 *
 * @author Janeeta Zahid
 */
public class ConfirmPage extends Stage {
    
   ConfirmPage()
   {
       GridPane root = new GridPane();

        String path=System.getProperty("user.dir");
        path=path+"//tree.png";
        File file = new File(path);
        Image image1 = new Image(file.toURI().toString());
        ImageView imgView = new ImageView(image1);
        imgView.setFitHeight(200);
        imgView.setFitWidth(300);
        imgView.setX(60);
        imgView.setY(500);
        
        


        Text s = new Text("                                    Congratulations,                    " + "\n" ); 

        Text t = new Text("you have successfully chosen a sustainably sourced \n                             product!!");

        t.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));
        s.setFill(Color.GREEN); 

        s.setFont(Font.font("Calibri", FontWeight.NORMAL, 28));
        t.setFill(Color.GREEN); 
        s.setX(100);
        s.setY(250);
        t.setX(180);
        t.setY(280);

    

        Button btns2 = new Button("LEARN MORE");
        btns2.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        btns2.setLayoutX(650);
        btns2.setLayoutY(650);

        Group root1=new Group(btns2,s,t,imgView);

        this.setScene(new Scene(root1, 800, 700));
        this.setTitle("https://greenfoodpicker/CONGRATS");
        this.show();
       
   }
    
}
