package application;


import java.util.Stack;


public class Pile extends Stack<Double> {
	
	private static final long serialVersionUID = 2869139024577659405L;
	private static int max =30;	
	private Stack<Double> pileNombre;
	
	/*
	 * display affiche l'intégralité de la pile
	 */
		
	public String displayPile() {
		return pileNombre.toString();
	}
	
	

}
