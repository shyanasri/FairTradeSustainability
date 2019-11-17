/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substantialityapp;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Scanner;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Janeeta Zahid
 */
public class ManualSubmission extends Stage {
    
  ManualSubmission()
        {
            creatFile(); //creates file with name of all comapaines
            String path=System.getProperty("user.dir");
            path=path+"//tree.png";
            File file = new File(path);
            Image image1 = new Image(file.toURI().toString());
            ImageView imgView = new ImageView(image1);
            imgView.setFitHeight(200);
            imgView.setFitWidth(300);
            imgView.setX(60);
            imgView.setY(500);
        
            GridPane gridpane =new GridPane();
            gridpane.setAlignment(Pos.CENTER);
            gridpane.setPadding(new Insets(40, 40, 40, 40)); 
            Label label2=new Label("\tManual Submission");
             label2.setAlignment(Pos.TOP_CENTER);
             label2.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 25));
             label2.setTextFill(Color.GREEN);
             gridpane.add(label2,0,0,2,1);
             GridPane.setMargin(label2, new Insets(200, 100,20,300));
            //Label for entering name of product 
            Label name= new Label("Name of Product: ");
            GridPane.setMargin(name,new Insets(10,10,10,150));
            gridpane.add(name,0,1);
            //textbox for name of product
            final TextField nameField= new TextField();
            gridpane.add(nameField,1,1);
            GridPane.setMargin(nameField,new Insets(10,10,10,20));
            //Label for company name
            Label comapny= new Label("Company:  ");
            gridpane.add(comapny,0,4);
            GridPane.setMargin(comapny,new Insets(10,10,10,150));
            //textbox for company name
            final TextField companyField= new TextField();
            gridpane.add(companyField,1,4);
            GridPane.setMargin(companyField,new Insets(10,10,10,20));
            //Feild for adding the date of production
            //a button to go back if the user clicked the wrong login
            final Button back=new Button("Back");
            back.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
            final Button submit=new Button("Submit");
            submit.setStyle("-fx-border-color:#10c23f;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
            submit.setOnAction(new EventHandler<ActionEvent>()
            {
                     @Override
                     public void handle(ActionEvent e) 
                        {
                            boolean confirmed=false; //a varible which sees if the comapny is within the data set 
                            if(companyField.getText().isEmpty() || nameField.getText().isEmpty() )
                                                             {
                                                                new UnsufficentInfoError();
                                                             }
                         
                         else 
                         {
                         try {  
                             String companyname;
                             companyname= companyField.getText(); //stores the name of the comapny the user inputed inot a varaible 
                             File f1=new File("Companies.txt"); //file with customers
                             String s;
                             FileReader fr = new FileReader(f1); //Creation of File reader object
                             BufferedReader br = new BufferedReader(fr);
                             while((s=br.readLine())!=null) 
                                {  
                                   if((s.equals(companyname))) 
                                   {
                                       confirmed=true;
                                   }
                                   else 
                                   {
                                       continue;
                                   }
                                }
                             fr.close();
                             
                         } catch (FileNotFoundException ex) {
                             Logger.getLogger(ManualSubmission.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (IOException ex) {
                             Logger.getLogger(ManualSubmission.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         if (confirmed==true)
                         {
                             new ConfirmPage();
                         }
                         if(confirmed==false)
                         {
                             new NotPage();
                         }
                         
                        }
                        }
            
            });
               
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
            GridPane.setMargin(back,new Insets(10,10,10,150));
            gridpane.add(back,1,5,2,5);
            gridpane.add(submit,1,9,2,5);
            Group root1= new Group(gridpane,imgView);
            this.setScene(new Scene(root1, 800, 700));
            this.setTitle("https://greenfoodpicker/manualsubmission");
            this.show();

            
            
        }
  void creatFile() 
    {
        File f1=new File("Companies.txt"); //open file with the custimer info 
        FileWriter fw; 
      try {
          fw = new FileWriter(f1,true); //Creation of File writer object
          BufferedWriter br = new BufferedWriter(fw); 
          fw.append("Brand\n" +
                    "President's Choice Organic\n" +
                    "Earth's Choice\n" +
                    "Good Earth Coffee House\n" +
                    "Gourmet Coffee - Winnipeg's Finest\n" +
                    "One Coffee\n" +
                    "Spirit Bear Coffee\n" +
                    "Whistler Chocolate\n" +
                    "Ara Azzurro\n" +
                    "\n" +
                    "Beachcomber Coffee\n" +
                    "23 Degrees Roastery\n" +
                    "\n" +
                    "Bercy Foods\n" +
                    "Aliments Tristan\n" +
                    "Alpha Wolf\n" +
                    "Alter Eco\n" +
                    "Alternative Grounds\n" +
                    "Aroma Specialty Coffee\n" +
                    "\n" +
                    "Baden Coffee Company\n" +
                    "Balzac's Coffee\n" +
                    "Barry Callebaut\n" +
                    "Bean Fair\n" +
                    "Belvas\n" +
                    "Ben & Jerry's\n" +
                    "Brûlerie Café Aladdin Coffee Roastery\n" +
                    "Brûlerie Des Cantons\n" +
                    "Brûlerie Rousseau\n" +
                    "Brazcanco Inc.\n" +
                    "Bridgehead\n" +
                    "Café Brossard\n" +
                    "Brulerie St-Denis\n" +
                    "Totem Roasters\n" +
                    "\n" +
                    "Café Agga\n" +
                    "Café Bar L'Abstracto\n" +
                    "Café Barista Inc\n" +
                    "Café Cambio\n" +
                    "Café La Brûlerie\n" +
                    "Café Mystique\n" +
                    "Café Napoléon Inc.\n" +
                    "Café Plantation\n" +
                    "Café Rico\n" +
                    "Café Union Coffee\n" +
                    "Café Vittoria Inc.\n" +
                    "\n" +
                    "Brûleries FARO Roasting Houses\n" +
                    "Café Hubert Saint-Jean\n" +
                    "Cafe-Vrac.com\n" +
                    "\n" +
                    "\n" +
                    "Camellia Sinensis\n" +
                    "ReSIProcate\n" +
                    "\n" +
                    "Cavalier\n" +
                    "Chicken Creek Coffee Company\n" +
                    "Chocomotive\n" +
                    "Clementine Café-Deli\n" +
                    "Club Coffee LP\n" +
                    "Coffee Tree Roastery\n" +
                    "Coffeecology Inc.\n" +
                    "Coffeemark Coffee & Tea Services Limited\n" +
                    "Colonial Coffee\n" +
                    "Mountain View Estates Coffee\n" +
                    "Concept chocolat\n" +
                    "Concept Eco Plein Air Le Baluchon Inc.\n" +
                    "Cordoba Coffee\n" +
                    "County Roasters Inc\n" +
                    "Coutts & Company Coffeehouse\n" +
                    "Creemore Coffee Company\n" +
                    "Handmade Organic Delight\n" +
                    "DeLuca Specialty Foods\n" +
                    "\n" +
                    "Diesel House Coffee Roasters\n" +
                    "Discovery Organics\n" +
                    "Divine\n" +
                    "\n" +
                    "Doi Chaang\n" +
                    "Douceur de Géraldine\n" +
                    "Earth's General Store\n" +
                    "En'tyce\n" +
                    "Endangered Species\n" +
                    "Equator Coffee Roasters Inc.\n" +
                    "Équifruit\n" +
                    "Espanola Coffee Roasters\n" +
                    "New World, Everland\n" +
                    "Everyday Gourmet Coffee Roasters\n" +
                    "Ziggy's\n" +
                    "Fair Trade Jewellery Co.\n" +
                    "Fernwood Coffee Co.\n" +
                    "Florists Supply\n" +
                    "Forbidden Flavours Roastery\n" +
                    "Full Steam Coffee Company\n" +
                    "Fyffes\n" +
                    "Galerie au Chocolat, Jelina Chocolatier\n" +
                    "Garden To Cup Organics\n" +
                    "Grauman Packaging\n" +
                    "Barkleys\n" +
                    "Nuterra Granola\n" +
                    "hatch\n" +
                    "Hell's Half Acre Coffee\n" +
                    "Heritage Coffee\n" +
                    "Highland Farms Inc\n" +
                    "House of Mandela\n" +
                    "\n" +
                    "Ironwood Coffee\n" +
                    "Mountain Gems\n" +
                    "JJ Bean Coffee Roasters\n" +
                    "Jumping Bean Coffee\n" +
                    "Just Us!\n" +
                    "Clipper\n" +
                    "Karité Delapointe\n" +
                    "\n" +
                    "\n" +
                    "Keurig Canada\n" +
                    "Kicking Horse Coffee\n" +
                    "\n" +
                    "Kitimai\n" +
                    "Kooshoo\n" +
                    "Ethical Bean\n" +
                    "L'Armorique Inc\n" +
                    "La Brulerie de l'Atlantique\n" +
                    "La Choppe à Café\n" +
                    "La Compagnie des Mers du Sud Inc.\n" +
                    "La Riojana\n" +
                    "Camino\n" +
                    "La Societe de Torréfaction de Café\n" +
                    "Laughing Whale Coffee Roasters\n" +
                    "Le Caféier - Boustifo\n" +
                    "Le Cafétier Plus Inc.\n" +
                    "Les Aliments Merci\n" +
                    "\n" +
                    "Longo Brother Fruit Market Inc.\n" +
                    "Luisella\n" +
                    "M68 Mercantile Inc. DBA Caffe Umbria Canada\n" +
                    "Malleable Jewellers\n" +
                    "Tribal Java\n" +
                    "Mayan Coffee\n" +
                    "ME to WE\n" +
                    "Melitta World Harvest\n" +
                    "Mercedes Beans & Model Teas\n" +
                    "\n" +
                    "Midnight Sun Coffee Roasters\n" +
                    "Milano Coffee Ltd\n" +
                    "Mochaberry Coffee & Company Ltd\n" +
                    "Moja Coffee\n" +
                    "Green & Black's\n" +
                    "Mongozo\n" +
                    "Montana Coffee & Tea Services\n" +
                    "Moonbean Coffee Company\n" +
                    "Brown Gold\n" +
                    "\n" +
                    "Muldoons' Own Authentic Coffee\n" +
                    "\n" +
                    "Nador Inc.\n" +
                    "\n" +
                    "\n" +
                    "Nature Zen\n" +
                    "Nature's Path\n" +
                    "Northland Floral\n" +
                    "Tega\n" +
                    "Numi\n" +
                    "Pizzelle Cookies\n" +
                    "Oasis Bags\n" +
                    "Old Rock Roasting Company\n" +
                    "Olivia\n" +
                    "OMG's Candy\n" +
                    "One Tree Coffee\n" +
                    "Organic Meadow\n" +
                    "\n" +
                    "Origin 1668\n" +
                    "Oughtred Coffee & Tea\n" +
                    "Patera\n" +
                    "Petite Brulerie de Trois-Rivieres\n" +
                    "Planet Bean\n" +
                    "Pluck\n" +
                    "Prana\n" +
                    "Tate & Lyle\n" +
                    "Remarkable Bean\n" +
                    "Reunion Coffee Roasters\n" +
                    "Ross Chocolates\n" +
                    "Rumble\n" +
                    "Salt Spring Coffee Co.\n" +
                    "School House Roasting\n" +
                    "Settlement Co.\n" +
                    "Shuswap Coffee Company ltd\n" +
                    "Sissiboo Coffee Roaster\n" +
                    "VOLO Athletics\n" +
                    "Sodexo Canada\n" +
                    "Source My Garment\n" +
                    "\n" +
                    "St. Joseph Island Coffee\n" +
                    "Station Cold Brew\n" +
                    "Steam Punk'd\n" +
                    "Stone Temple Coffees\n" +
                    "Strait Coffee Ltd.\n" +
                    "Sudcafé\n" +
                    "\n" +
                    "Takasa\n" +
                    "Take a Break Coffee\n" +
                    "teaBOT\n" +
                    "\n" +
                    "Ten Tree\n" +
                    "The Green Campus Co-op\n" +
                    "Time Out Products\n" +
                    "\n" +
                    "Traditional Medicinals\n" +
                    "Four O'Clock\n" +
                    "Trybec\n" +
                    "Twisted Goat Coffee Roasters\n" +
                    "Umano\n" +
                    "Frisky Zebras\n" +
                    "Valrhona\n" +
                    "Van Houtte\n" +
                    "\n" +
                    "Theobroma\n" +
                    "Vince's Market\n" +
                    "Vittoria Coffee\n" +
                    "\n" +
                    "William Spartivento\n" +"23 Degrees Roastery\n" +
                    "A. Holliday &amp; Company Inc.\n" +
                    "Aliments Bercy\n" +
                    "Aliments Tristan\n" +
                    "Alpha Wolf Coffee\n" +
                    "Alter Eco America&#8217;s (Canada)\n" +
                    "Alternative Grounds\n" +
                    "Aroma Specialty Coffee Roasters\n" +
                    "Associated Brands LP\n" +
                    "Baden Coffee Company Inc.\n" +
                    "Balzac&#8217;s Coffee Ltd.\n" +
                    "Barry Callebaut Canada\n" +
                    "Bean Fair\n" +
                    "Belvas Belgian Chocolate\n" +
                    "Ben &amp; Jerry&#8217;s\n" +
                    "Br&ucirc;lerie Caf&eacute; Aladdin Coffee Roastery\n" +
                    "Br&ucirc;lerie Des Cantons\n" +
                    "Br&ucirc;lerie Rousseau\n" +
                    "Brazcanco Inc.\n" +
                    "Bridgehead (2000) Inc.\n" +
                    "Brossard Fr&egrave;res Inc\n" +
                    "Brulerie St-Denis\n" +
                    "Brûlerie Totem Roasters Inc.\n" +
                    "Burnbrae Farms\n" +
                    "Caf&eacute; Agga V.I.P. Inc.\n" +
                    "Caf&eacute; Bar L&#8217;Abstracto\n" +
                    "Caf&eacute; Barista Inc\n" +
                    "Caf&eacute; Cambio Coop&eacute;rative de travail\n" +
                    "Caf&eacute; La Br&ucirc;lerie\n" +
                    "Caf&eacute; Mystique Coffee Inc\n" +
                    "Caf&eacute; Napol&eacute;on Inc.\n" +
                    "Caf&eacute; Plantation\n" +
                    "Caf&eacute; Rico\n" +
                    "Caf&eacute; Union Coffee\n" +
                    "Caf&eacute; Vittoria Inc.\n" +
                    "Caf&eacute;s RGC Coffee Inc.\n" +
                    "Café Faro Inc.\n" +
                    "Café Hubert Saint-Jean\n" +
                    "Cafe-Vrac.com\n" +
                    "Caffe Umbria\n" +
                    "Cambrian Solutions\n" +
                    "Camellia Sinensis\n" +
                    "Canterbury Coffee Corporation\n" +
                    "Cascade Coffee Inc\n" +
                    "Cavalier Belgian Chocolatier\n" +
                    "Chicken Creek Coffee Company\n" +
                    "Chocomotive\n" +
                    "Clementine Caf&eacute;-Deli\n" +
                    "Club Coffee LP\n" +
                    "Coffee Tree Roastery\n" +
                    "Coffeecology Inc.\n" +
                    "Coffeemark Coffee &amp; Tea Services Limited\n" +
                    "Colonial Coffee\n" +
                    "Columbia Coffee &#038; Tea \\ Mountain View Estates Coffee Co\n" +
                    "Concept Chocolat\n" +
                    "Concept Eco Plein Air Le Baluchon Inc.\n" +
                    "Cordoba Coffee Ltd\n" +
                    "County Roasters Inc\n" +
                    "Coutts &amp; Company Coffeehouse Emporium\n" +
                    "Creemore Coffee Company\n" +
                    "Delight\n" +
                    "DeLuca Specialty Foods Cooking School and Restaurant Ltd.\n" +
                    "Detour Coffee Roasters\n" +
                    "Diesel House Coffee Roasters\n" +
                    "Discovery Organics Ltd\n" +
                    "Divine Chocolate Limited\n" +
                    "Divine Specialty Teas Company Ltd\n" +
                    "Doi Chaang Coffee Company Inc.\n" +
                    "Douceur de G&eacute;raldine\n" +
                    "Earth&#8217;s General Store\n" +
                    "En&#8217;tyce\n" +
                    "Endangered Species Chocolate, LLC.\n" +
                    "Equator Coffee Roasters Inc.\n" +
                    "Equifruit\n" +
                    "Espanola Coffee Roasters\n" +
                    "Everland Natural Foods Inc.\n" +
                    "Everyday Gourmet Coffee Roasters\n" +
                    "Factors Group of Nutritional Companies Inc\n" +
                    "Fair Trade Jewellery Company Ltd.\n" +
                    "Fernwood Coffee Co.\n" +
                    "Florists Supply Ltd\n" +
                    "Forbidden Flavours Roastery\n" +
                    "Full Steam Coffee Company\n" +
                    "Fyffes North America Inc.(Canada)\n" +
                    "Galerie Au Chocolat / Jelina Chocolatier\n" +
                    "Garden To Cup Organics\n" +
                    "Grauman Packaging\n" +
                    "Green Chocolate Works Ltd\n" +
                    "H. &#038; J. BRÜGGEN KG\n" +
                    "Hatch Beverage Company\n" +
                    "Hell&#8217;s Half Acre Coffee\n" +
                    "Heritage Coffee\n" +
                    "Highland Farms Inc\n" +
                    "House of Mandela\n" +
                    "International Sugars Inc.\n" +
                    "Ironwood Coffee Company\n" +
                    "Java Works Coffee Inc\n" +
                    "JJ Bean Inc\n" +
                    "Jumping Bean Coffee\n" +
                    "Just Us! Coffee Roasters Co-op\n" +
                    "Kallo Foods Ltd\n" +
                    "Karit&eacute; Delapointe\n" +
                    "Ken Gabbay Coffee LTD.\n" +
                    "Kencaf Importing &amp; Distributing Inc.\n" +
                    "Keurig Canada (formerly GMCR Canada Holdings Inc)\n" +
                    "Kicking Horse Coffee\n" +
                    "Kingsmill Foods\n" +
                    "Kitimai Tea &amp; Coffee\n" +
                    "Kooshoo Lifestyle Inc.\n" +
                    "Kraft Heinz (Canada)\n" +
                    "L&#8217;Armorique Inc\n" +
                    "La Brulerie de l&#8217;Atlantique\n" +
                    "La Choppe &agrave; Caf&eacute;\n" +
                    "La Compagnie des Mers du Sud Inc.\n" +
                    "La Riojana Coop\n" +
                    "La Siembra Co-operative\n" +
                    "La Societe de Torr&eacute;faction de Caf&eacute;\n" +
                    "Laughing Whale Coffee Roasters\n" +
                    "Le Caf&eacute;ier &#8211; Boustifo\n" +
                    "Le Caf&eacute;tier Plus Inc.\n" +
                    "Les Aliments Merci\n" +
                    "Les Services Adaptes Transit\n" +
                    "Longo Brother Fruit Market Inc.\n" +
                    "Luisella Foods Inc\n" +
                    "M68 Mercantile Inc. DBA Caffe Umbria Canada\n" +
                    "Malleable Jewellers Corporation\n" +
                    "Max Voets Coffee Roasting Ltd\n" +
                    "Mayan Green Coffee Imports\n" +
                    "ME to WE Shop Inc\n" +
                    "Melitta Canada Inc.\n" +
                    "Mercedes Beans &amp; Model Teas\n" +
                    "Mexican Arabica Bean Company\n" +
                    "Midnight Sun Coffee Roasters\n" +
                    "Milano Coffee Ltd\n" +
                    "Mochaberry Coffee &amp; Company Ltd\n" +
                    "Moja Coffee\n" +
                    "Mondelez Canada Inc.\n" +
                    "Mongozo\n" +
                    "Montana Coffee &amp; Tea Services\n" +
                    "Moonbean Coffee Company\n" +
                    "Mother Parker&#8217;s Tea &amp; Coffee Inc.\n" +
                    "Mountain Coffee Ltd\n" +
                    "Muldoons&#8217; Own Authentic Coffee\n" +
                    "N.J. DOUEK / UNIGLOBE COFFEE\n" +
                    "Nador Inc.\n" +
                    "NATRA Chocolate America\n" +
                    "Nature Bio Foods\n" +
                    "Nature Zen\n" +
                    "Nature&#8217;s Path Foods Inc.\n" +
                    "Northland Floral\n" +
                    "Nu-Tea Company Ltd.\n" +
                    "Numi Inc. (Canada)\n" +
                    "NuStef Baking Limited\n" +
                    "Oasis Bags\n" +
                    "Old Rock Roasting Company\n" +
                    "Olivia Chocolatiers\n" +
                    "OMG&#8217;s Candy\n" +
                    "One Tree Coffee\n" +
                    "Organic Meadow Inc.\n" +
                    "Organic Products Trading Company (Canada)\n" +
                    "Origin 1668 Coffee\n" +
                    "Oughtred Coffee &amp; Tea\n" +
                    "Patera Group Inc\n" +
                    "Petite Brulerie de Trois-Rivieres\n" +
                    "Planet Bean\n" +
                    "Pluck Tea Inc.\n" +
                    "Prana Biovegan Inc.\n" +
                    "Redpath Sugars Ltd.\n" +
                    "Remarkable Bean\n" +
                    "Reunion Coffee Roasters\n" +
                    "Ross Chocolates\n" +
                    "Rumble Nutrition Ltd\n" +
                    "Salt Spring Coffee Co.\n" +
                    "School House Roasting Collaborative Inc\n" +
                    "Settlement Co.\n" +
                    "Shuswap Coffee Company ltd\n" +
                    "Sissiboo Coffee Roaster\n" +
                    "Social Conscience Company\n" +
                    "Sodexo Canada (Brock University)\n" +
                    "Source My Garment\n" +
                    "Spire Tea Inc.\n" +
                    "St. Joseph Island Coffee Roasters\n" +
                    "Station Cold Brew\n" +
                    "Steam Punk&#8217;d Roasters Ltd\n" +
                    "Stone Temple Coffees\n" +
                    "Strait Coffee Ltd.\n" +
                    "Sudcaf&eacute;\n" +
                    "Swiss Water Decaffeinated Coffee Co. Inc.\n" +
                    "Takasa Lifestyle Company Inc.\n" +
                    "Take a Break Coffee Services\n" +
                    "TBOT Inc\n" +
                    "Tea Affair\n" +
                    "Ten Tree International Inc.\n" +
                    "The Green Campus Co-op\n" +
                    "Time Out Products Inc\n" +
                    "Tradin Organics USA Inc. (Canada)\n" +
                    "Traditional Medicinals (Canada)\n" +
                    "Trans-Herbe Inc\n" +
                    "Trybec Beverages Inc\n" +
                    "Twisted Goat Coffee Roasters\n" +
                    "Umano\n" +
                    "United Nations of Wine\n" +
                    "Valrhona Inc.\n" +
                    "Van Houtte Coffee Services / Services de café Van Houtte\n" +
                    "Van Rees (North America) Inc.\n" +
                    "Vigneault Chocolatier Lt&eacute;e\n" +
                    "Vince&#8217;s Market\n" +
                    "Vittoria Coffee\n" +
                    "Westcoast Coffee Trader\n" +
                    "William Spartivento\n" +
                    ""
                    );
          fw.close();
      } catch (IOException ex) {
          Logger.getLogger(ManualSubmission.class.getName()).log(Level.SEVERE, null, ex);
      }
           //Creation of File Reader object
        //String s;
        

   
        
        
    }
  
    
}
