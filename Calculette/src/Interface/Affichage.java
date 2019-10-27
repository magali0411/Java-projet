package Interface;

import application.Accumulateur;
import application.IAccumulateur;
import application.Pile;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Affichage {
	
	protected IAccumulateur accumulateur;
	
	// composants clavier
	protected Button[][] clavier = new Button[4][5];	
	protected Texts AffichageText;
	  
	protected GridPane grille;
	protected VBox box;
	
	// composants texts
	protected VBox textBox;
	protected TextArea taDial;
	protected TextArea taHisto1;
	protected TextArea taHisto2;
	
	public Affichage() {
		Pile p = new Pile();
		String ac = "";
		accumulateur = new Accumulateur(p, ac);
		
		grille = new GridPane();
		box = new VBox();
		textBox = new VBox();
		taDial = new TextArea();
		taHisto1 = new TextArea();
		taHisto2 = new TextArea();
		
	}
}