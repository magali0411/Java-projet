package Interface;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.tools.javac.util.Position;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI implements IView {

	private Clavier clv;// vue clavier  
	private Titre tr; //titre
	private Group root; // groupe
	private Scene scene; //scene
	private Stage primaryStage;

	
	public Scene createScene() {
		
		tr = new Titre();
		clv = new Clavier();
		
		//new Affichage();
				
		// création des noeuds 
		Label lbl = tr.createLabel();
		GridPane grille = clv.createGrid();
		VBox box = clv.createbox();
		VBox vb = clv.createAffichage();

		root = new Group();
		
		scene = new Scene(root, 500, 600, Color.MINTCREAM);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
        // Placement dans la fenêtre parent  
        root.getChildren().add(vb);
        root.getChildren().add(grille);
        //root.getChildren().add(box);
        
       return scene;
	
	}

	public Stage createPrimaryScene() {
		
		 //definir la scene principale
		Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("Images/calculette.jpg"));
        primaryStage.setTitle("Calculatrice");
        primaryStage.setOpacity(0.9);
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        
        Alert a = new Alert(AlertType.NONE); 

    	primaryStage.setOnCloseRequest(event ->
        {
        	a.setAlertType(AlertType.WARNING); 
        	a.setContentText("Vous quittez la calculatrice.");
            a.show(); 
            System.out.println("Application stopped.");
            
        });
    	
    	return primaryStage;	
		
	}

}
