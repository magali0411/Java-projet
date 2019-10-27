package Interface;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Titre {
	
	
    // label
	private Label label;
	

	/**
	 * createLabel créé le tritre de la calculatrice
	 * @return label
	 */
	public Label createLabel() {
		
		label = new Label("BEST CALCULETTE");
	    label.setFont(new Font("Arial", 38));
	    label.setTextFill(Color.web("#0076a3"));
	    label.setTextAlignment(TextAlignment.JUSTIFY);
	    label.setWrapText(true);
	    label.setLayoutX(110);
	    label.setLayoutY(0);
	     
	     //ombre sur le texte
	     DropShadow dropShadow = new DropShadow();
	     dropShadow.setRadius(5.0);
	     dropShadow.setOffsetX(3.0);
	     dropShadow.setOffsetY(3.0);
	     dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
	        
	     label.setEffect(dropShadow);
	  
	      
	     //Effet sur le titre
	     TranslateTransition tt = new TranslateTransition(Duration.millis(3000), label);
	     tt.setFromX(0);
	     //coordonnée relative
	     tt.setToX(-label.getLayoutX()+label.getLayoutX()/10);
	     tt.setCycleCount(1);
	     tt.play();

	     setLabel(label);
	     
	     return label;
	     
	}
	
	/**
	 * setLabel associe un label à l'attribut de la classe
	 * @param label
	 */
	
	public void setLabel(Label lbl) {
		this.label = lbl;
	}

	/**
	 * getLabel retourne le label de la classe
	 * @return label
	 */
	public Label getLabel() {
		return this.label;
	}

}
