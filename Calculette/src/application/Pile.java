package application;


import java.util.Stack;


public class Pile extends Stack<Double> {
	
	private static final long serialVersionUID = 2869139024577659405L;
	private static int max =30;	
	private Stack<Double> pileNombre;
	
//	
//	/*
//	 * drop supprime le dernier �l�ment du stack
//	 */
//	public void drop() {		
//		int index = pileNombre.size();
//		if (index > 0)
//			pileNombre.remove(index-1);
//	}
//	
//
//	/*
//	 * push ajout un nombre � la pile
//	 * @param nombre � ajouter � la pile
//	 */
//	public void push(double nombre) {
//		if (pileNombre.size() < max) {
//			pileNombre.add(nombre);
//		};	
//	}
//	
//	/*
//	 * drop d�pile le dernier �l�ment de la pile
//	 * @return le dernier nombre de la pile
//	 */  
//
//	public Double pop() {
//		int index = pileNombre.size()-1;
//		if (index >= 0) {
//			return(pileNombre.get(index));
//		}else { 
//			System.out.println("La pile est vide.");
//			return null;
//		}
//	}
	
	/*
	 * display affiche l'int�gralit� de la pile
	 */
		
	public String displayPile() {
		return pileNombre.toString();
	}
	
	

}
