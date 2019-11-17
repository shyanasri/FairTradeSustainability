/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substantialityapp;

import static com.sun.org.apache.regexp.internal.RETest.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Window;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.Group;
import javafx.scene.text.Text; 
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Janeeta Zahid
 */
public class SubstantialityApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //m=primaryStage;
        //final Scene scene = null;
        primaryStage.setTitle("https://www.greenfoodpicker.com");//sets title 
        //main page 
        //displays bank name
        Text name= new Text("GREEN FOOD PICKER");
        
        name.setUnderline(true);
        name.setFont(Font.font("Cambria", 64));
        name.setFill(Color.GREEN);
        
        //logo 
        
        String path=System.getProperty("user.dir");
        path=path+"//tree.png";
        File file = new File(path);
        Image image1 = new Image(file.toURI().toString());
        ImageView imgView = new ImageView(image1);
        imgView.setFitHeight(250);
        imgView.setFitWidth(300);
        imgView.setX(60);
        imgView.setY(450);
        //
        //
        name.setX(100);
        name.setY(300);
        //adding tagline
        Text tag=new Text("Choose a Better Today for a Better Tomorrow");
        tag.setFont(Font.font("Cambria",FontPosture.ITALIC, 32));
        tag.setX(100);
        tag.setY(350);

        Button picturemethod=new Button("Take Picture");
        picturemethod.setLayoutX(30);
        picturemethod.setLayoutY(10);
        picturemethod.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        Button manaulmethod=new Button("Manual Submission");
        manaulmethod.setLayoutX(150);
        manaulmethod.setLayoutY(10);
        manaulmethod.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        manaulmethod.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                           new ManualSubmission();
                                                        }

                                                 });
                
        Button learnmore=new Button("Learn More");
        learnmore.setLayoutX(330);
        learnmore.setLayoutY(10);
        learnmore.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        learnmore.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                           new LearnMore();
                                                        }

                                                 });
        Button game=new Button("Play a Game!");
        game.setLayoutX(450);
        game.setLayoutY(10);
        game.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");

        Label copyrightL = new Label("\u00a9");
        copyrightL.setLayoutX(600);
        copyrightL.setLayoutY(600);
        copyrightL.setPrefWidth(900);
        copyrightL.setPrefHeight(150);
        
        Text tag1=new Text("Runtime Terror");
        tag1.setFont(Font.font("Cambria",FontPosture.ITALIC, 12));
        tag1.setX(620);
        tag1.setY(680);
        
        Button button = new Button("Tip of the Day");
        button.setTooltip(new Tooltip("Avoid Purchasing Fresh Foods Out of Season. Foods that travel \nlong distances are not typically sustainable."));
        button.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        button.setLayoutX(590);
        button.setLayoutY(10);
        
        
        Group root = new Group(picturemethod,manaulmethod,learnmore, name,imgView,tag,game,copyrightL,tag1,button);
        Scene scene = new Scene (root, 800,700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
