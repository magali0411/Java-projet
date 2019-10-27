package Interface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import com.sun.accessibility.internal.resources.accessibility;

import Controleur.ActionControleur;
import application.Accumulateur;
import application.IAccumulateur;
import application.Pile;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

public class Clavier extends Affichage implements ActionListener{
	

	
    String styles =
//          "-fx-background-color: #0000ff;" +
//          "-fx-border-color: #ff0000;" +
        "-fx-background-radius: 1em; " +
  		"-fx-font-weight: bold;" +
  		"-fx-font-size: 2.5em;"+
  		"-fx-font-family: sans-serif;" ;  
    
    String roundStyle = 
    		        "-fx-background-radius: 10em; " +
    		        "-fx-min-width: 80px; " +
    		        "-fx-min-height: 80px; " +
    		        "-fx-max-width: 80px; " +
    		        "-fx-max-height: 80px; " +
    		        "-fx-background-color: transparent;" ;
    

	/**
	 * Gridpane génère la grille représentant le clavier de la calculatricce
	 * @return gridPane
	 */
    
	
	public GridPane createGrid() {
		
		this.AffichageText = new Texts(accumulateur);
		
		
		//grille = new GridPane();
	
        // Le corps de la calculatrice
	    grille.setPadding(new Insets(175, 10, 10, 10)); 
        grille.setHgap(5);
        grille.setVgap(5);
        grille.setAlignment(Pos.CENTER); 
        
   
    	String numeros[][] = {
	    		
    			{ "7" , "8", "9", "%" , "PUSH" },
    			{ "4" , "5", "6", "X", " r " },
    			{ "1" , "2", "3", "-", " " },
    			{ "0" , ",", "(-)", "+", " " }
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

		// Déclaration du bouton
		Button button = new Button();
		button.setText(num);
		button.setStyle(styles);
		button.setPrefSize(85, 85);
		
		// Listener click souris
		button.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
		    public void handle(MouseEvent me){
		    	
		    	// On afficha la pile à chaque fois qu'un bouton est cliqué 
		    	if (!accumulateur.getPile().isEmpty()) {
		    		AffichageText.taHisto1.setText(accumulateur.pileToString());
		    		System.out.println("Pile :" + accumulateur.pileToString());
		    	}
		    	
		    	// l'entrée clavier aussi
		    	if (accumulateur.getAcc() != "") {
		    		AffichageText.taHisto2.setText(accumulateur.getAcc());
		    		System.out.println("Accumulateur : " + accumulateur.getAcc());
		    	}
		    			    	
		        switch(button.getText()){
		        	case "+" : accumulateur.add(); break;
		        	case "-": accumulateur.sub(); break;
		        	case "%" : accumulateur.div(); break;
		        	case "X" : accumulateur.mult();break;
		        	case "0" : accumulateur.accumuler("0");break;
		        	case "1" : accumulateur.accumuler("1") ; break;
		        	case "2" : accumulateur.accumuler("2") ; break;
		        	case "3" : accumulateur.accumuler("3") ; break;
		        	case "4" : accumulateur.accumuler("4") ; break;
		        	case "5" : accumulateur.accumuler("5") ; break;
		        	case "6" : accumulateur.accumuler("6") ; break;
		        	case "7" : accumulateur.accumuler("7") ; break;
		        	case "8" : accumulateur.accumuler("8") ; break;
		        	case "9" : accumulateur.accumuler("9"); break;
		        	case "PUSH" : accumulateur.push(); break;
		        	case "," : accumulateur.accumuler(","); break;
		        	case "(-)" : accumulateur.neg(); break ;
		        	default : break;
		        }
		    }
		});
		
		return button;
	}
	/**
	 * createBox crée la dernière ligne du clavier comportant des fonctionnalités supplémentaires
	 * 
	 * @return box contenant les logos
	 */
	
	public VBox createbox() {
		
		Image imageReverse = new Image("Images/reverse.png");
		Image imageBack = new Image("Images/back.png");
		
		box = new VBox();
		
        // Ligne supplémentaire
	    box.setPadding(new Insets(20, 300, 350, 380)); 
        box.setAlignment(Pos.TOP_LEFT); 
        box.setSpacing(10);
        box.setMouseTransparent(true);
        
        // bouton remise à 0
        Button buttonRev = new Button();
        buttonRev.setGraphic(new ImageView(imageReverse));
		buttonRev.setPrefSize(85, 85);
		buttonRev.setStyle(roundStyle);
		buttonRev.setTooltip(new Tooltip("Tooltip for Button"));
		
        // Bouton retour arrière
        Button buttonB = new Button();
        buttonB.setGraphic(new ImageView(imageBack));
		buttonB.setPrefSize(85, 85);
		buttonB.setStyle(roundStyle);
		
		
		// Ajout des tooltips
		Tooltip tpReset = new Tooltip("Remise à 0 de la calculatrice");
		
		Tooltip tpBack = new Tooltip("Supprimer la dernière valeur");
		buttonB.setTooltip(tpBack);
		
		// Mouse listener
		
	     DropShadow shadow = new DropShadow(); // ombre 
	     
        // Ajout d'une ombre lorsque la souris passe sur le bouton
		buttonB.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	buttonB.setEffect(shadow);
            	System.out.println("hhh");
            }
        });
 
        // Suppression de l'ombre
		buttonB.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	buttonB.setEffect(null);
            }
        });
		
		box.getChildren().addAll(buttonRev, buttonB);
		
		return box;
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
