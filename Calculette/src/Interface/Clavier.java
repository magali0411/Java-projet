package Interface;


import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import com.sun.accessibility.internal.resources.accessibility;
import com.sun.tools.javac.code.TypeTag.NumericClasses;

import application.Accumulateur;
import application.IAccumulateur;
import application.Pile;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import sun.font.CreatedFontTracker;

public class Clavier extends Affichage{
	
	// Définition des styles des boutons
    String styles =
        "-fx-background-radius: 1em; " +
  		"-fx-font-weight: bold;" +
  		"-fx-font-size: 2.5em;"+
  		"-fx-font-family: sans-serif;" ;  
    
    String roundStyle = 
    		        "-fx-background-radius: 10em; " +
    		        "-fx-min-width: 80px; " +
    		        "-fx-min-height: 80px; " +
    		        "-fx-max-width: 80px; " +
    		        "-fx-max-height: 80px; " ;
    		        //"-fx-background-color: transparent;" 
    		        
    
	// Définition du style des boites de dialogue
	private String dialStyle = "-fx-font-family: Arial;" +
		    "-fx-font-size: 14;" ;
    
	/**
	 * Gridpane génère la grille représentant le clavier de la calculatricce
	 * @return gridPane
	 */
    
	public GridPane createGrid() {
		
		//grille = new GridPane();
	
        // Le corps de la calculatrice
	    grille.setPadding(new Insets(175, 10, 10, 10)); 
        grille.setHgap(5);
        grille.setVgap(5);
        grille.setAlignment(Pos.CENTER); 
        
   
    	String numeros[][] = {
	    		
    			{ "7" , "8", "9", "%" , " " },
    			{ "4" , "5", "6", "X", "logo1" },
    			{ "1" , "2", "3", "-", "logo2" },
    			{ "0" , ",", "(-)", "+", "logo3" }
    	};
	    
	    for(int i = 0; i < 4; i++){
	       for(int j = 0; j < 5; j++){
	    	   clavier[i][j] = createButton(numeros[i][j]); 
	    	   grille.add(clavier[i][j] ,j, i);
	       	}
	    }
	    
	    return grille;
	    
	}
	
	
	
	/**
	 * createButton génère les boutons de l"interface uns à uns 
	 * @return Button
	 */	
	private Button createButton(String num){
		
		// Images spécifiques 
		Image imageReverse = new Image("Images/reverse.png");
		Image imageBack = new Image("Images/back.png");
		Image imagePush = new Image("Images/entrer.png");
		
		// Déclaration du bouton
		Button button = new Button();
		button.setPrefSize(85, 85);
		
		if (num == "logo1") {
	        button.setGraphic(new ImageView(imageReverse));
			button.setStyle(roundStyle);
			button.setTooltip(new Tooltip("Remise à 0 de la calculatrice"));
		} else if (num == "logo2") {
	        button.setGraphic(new ImageView(imageBack));
			button.setStyle(roundStyle);
			button.setTooltip(new Tooltip("Supprimer la dernier valeur"));
			
		} else if (num == "logo3"){			
			button.setGraphic(new ImageView(imagePush));
			button.setStyle(roundStyle);
			button.setTooltip(new Tooltip("Valider"));		
		} else if (num ==" ") {
			button.setStyle("-fx-background-color: transparent;");
			button.setText("");
			
		} else {
			button.setStyle(styles);
			button.setText(num);
		}
		
		button.setId(num); // id pour identifier les bouttons 
		
		
		// Ecouteur sur les click souris
		button.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
		    public void handle(MouseEvent me){
		    	
		        switch(button.getId()){
		        	case "+" : accumulateur.add();refresh(); break;
		        	case "-": accumulateur.sub();refresh(); break;
		        	case "%" : accumulateur.div();refresh(); break;
		        	case "X" : accumulateur.mult();refresh();break;
		        	case "0" : accumulateur.accumuler("0");refresh();break;
		        	case "1" : accumulateur.accumuler("1") ;refresh(); break;
		        	case "2" : accumulateur.accumuler("2") ;refresh(); break;
		        	case "3" : accumulateur.accumuler("3") ;refresh(); break;
		        	case "4" : accumulateur.accumuler("4") ;refresh(); break;
		        	case "5" : accumulateur.accumuler("5") ;refresh(); break;
		        	case "6" : accumulateur.accumuler("6") ;refresh(); break;
		        	case "7" : accumulateur.accumuler("7") ;refresh(); break;
		        	case "8" : accumulateur.accumuler("8") ;refresh(); break;
		        	case "9" : accumulateur.accumuler("9"); refresh();break;
		        	case "," : accumulateur.accumuler(".");refresh(); break;
		        	case "(-)" : accumulateur.neg(); refresh();break ;
		        	case "logo2" : accumulateur.drop();refresh(); break;
		        	case "logo1" : accumulateur.reset();refresh(); break;
		        	case "logo3" : accumulateur.push();refresh(); break;
		        	default :refresh(); break;
		        }
		    }
		});
		
		return button;
	}

	
	/**
	 * createAffichage génère l'affichage pour l'utilisateur de la calculatrice
	 * @return la box d'affichage
	 */
	
	public VBox createAffichage() {
				
		// Conteneur des dialogues
		textBox.setPrefSize(475, 100);
		textBox.setPadding(new Insets(20,10,10,10));
		textBox.setSpacing(10);
		textBox.setAlignment(Pos.CENTER);
		
		
		// Création des fenêtres de dialogue
		taDial.setEditable(false);
		taDial.setStyle(dialStyle);
		taDial.setText("Bienvenue sur la calculatrice - Entrez vos opérations ");
		
		//taHisto1.setEditable(false);
		taHisto1.setStyle(dialStyle);	
		
		//taHisto2.setEditable(false);
		taHisto2.setStyle(dialStyle);
		
		textBox.getChildren().add(taDial);
		textBox.getChildren().add(taHisto1);
		textBox.getChildren().add(taHisto2);
		
		return textBox;
	
	}

	
	/**
	 * createBox crée la dernière ligne du clavier comportant des fonctionnalités supplémentaires
	 * 
	 * @return box contenant les logos
	 */
	
	public VBox createbox() {
		
		Image imageReverse = new Image("Images/reverse.png");
		Image imageBack = new Image("Images/back.png");
		
        // Ligne supplémentaire
	    box.setPadding(new Insets(20, 300, 350, 380)); 
        box.setAlignment(Pos.TOP_LEFT); 
        box.setSpacing(10);
        
        // bouton remise à 0
        Button buttonRev = new Button();
        buttonRev.setGraphic(new ImageView(imageReverse));
		buttonRev.setPrefSize(85, 85);
		buttonRev.setStyle(roundStyle);
		
        // Bouton retour arrière
        Button buttonB = new Button();
        buttonB.setGraphic(new ImageView(imageBack));
		buttonB.setPrefSize(85, 85);
		buttonB.setStyle(roundStyle);

		// Ajout des boutons au conteneur box
		box.getChildren().addAll(buttonRev, buttonB);
		
		return box;
		
	}
	

}
