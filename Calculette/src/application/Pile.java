package application;


import java.util.Stack;


public class Pile extends Stack<Double> {
	
	private static final long serialVersionUID = 2869139024577659405L;
	private Stack<Double> pileNombre;
	
/**
 * displayPile affiche le contenu de la pile
 * @return Texte string
 */
		
	public String displayPile() {
		return pileNombre.toString();
	}
	
	
	
	

}
