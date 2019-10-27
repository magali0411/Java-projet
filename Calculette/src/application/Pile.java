package application;


import java.util.Stack;


public class Pile extends Stack<Double> {
	
	private static final long serialVersionUID = 2869139024577659405L;
	private static int max =30;	
	private Stack<Double> pileNombre;
	
//	
//	/*
//	 * drop supprime le dernier élément du stack
//	 */
//	public void drop() {		
//		int index = pileNombre.size();
//		if (index > 0)
//			pileNombre.remove(index-1);
//	}
//	
//
//	/*
//	 * push ajout un nombre à la pile
//	 * @param nombre à ajouter à la pile
//	 */
//	public void push(double nombre) {
//		if (pileNombre.size() < max) {
//			pileNombre.add(nombre);
//		};	
//	}
//	
//	/*
//	 * drop dépile le dernier élément de la pile
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
	 * display affiche l'intégralité de la pile
	 */
		
	public String displayPile() {
		return pileNombre.toString();
	}
	
	

}
