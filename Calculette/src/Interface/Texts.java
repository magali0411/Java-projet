package Interface;



import java.text.NumberFormat.Style;

import com.sun.accessibility.internal.resources.accessibility;

import application.Accumulateur;
import application.IAccumulateur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class Texts extends Affichage{
	
	private String dialStyle = "-fx-font-family: Arial;" +
		    "-fx-font-size: 14;" ;
	
	/**
	 * Constructeurs
	 */
	
	public Texts(VBox b,TextArea ta, TextArea t1, TextArea t2, 
			IAccumulateur ac) {
		this.textBox = b;
		this.taHisto1 = t1;
		this.taHisto2 = t2;
		this.taDial = ta;
		this.accumulateur = ac;
		
	}
	
	
	public Texts(IAccumulateur ac) {
//		this.textBox = new VBox();
//		this.taHisto1 = new TextArea();
//		this.taHisto2 = new TextArea();
//		this.taDial = new TextArea();
		this.accumulateur = ac;
		
	}
	
	public Texts() {
//		this.textBox = new VBox();
//		this.taHisto1 = new TextArea();
//		this.taHisto2 = new TextArea();
//		this.taDial = new TextArea();
//		this.accumulateur = new Accumulateur();
		
	}

	
	/**
	 * createAffichage génère l'affichage pour l'utilisateur de la calculatrice
	 * @return la box d'affichage
	 */
	
	public VBox createAffichage() {
		
				
		//VBox textBox = new VBox();
		textBox.setPrefSize(375, 100);
		textBox.setPadding(new Insets(20,10,10,10));
		textBox.setSpacing(10);
		textBox.setAlignment(Pos.CENTER);
        //box.setStyle("-fx-border-color: grey;");
		
		// Textes de dialogue
		taDial.setEditable(false);
		taDial.setStyle(dialStyle);
		taDial.setText("Bienvenue sur la calculatrice - Entrez vos opérations ");
		
		taHisto1.setEditable(false);
		taHisto1.setStyle(dialStyle);
		
		taHisto2.setEditable(false);
		taHisto2.setStyle(dialStyle);
		
		textBox.getChildren().add(taDial);
		textBox.getChildren().add(taHisto1);
		textBox.getChildren().add(taHisto2);

		
		return box;
	
	}
	

}
