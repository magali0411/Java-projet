package application;


public interface IAccumulateur {
	
	/**
	 * getpile retourne la pile de l'accumulateur
	 * @return pile
	 */
	public Pile getPile();
	/**
	 * getacc retourn l'entrée clavier actuelle
	 * @return chiffre 
	 */
	public String getAcc();
	
	/**
	 * push ajout un élément à la pile
	 */
	public void push();
	/**
	 * drop supprime le dernier élément
	 */
	public void drop();
	/**
	 * swap échange les deux derniers chiffres de la pile
	 */
	public void swap();
	/**
	 * add additionne les deux derniers chiffres de la pile
	 */
	public void add();
	/**
	 * sub soustrait les deux derniers chiffres de la pile
	 */
	public void sub();
	/**
	 * mult multiplie les deux derniers chiffres de la pile
	 */
	public void mult();
	/**
	 * div divise les deux derniers chiffres de la pile
	 */
	public void div();
	/**
	 * neg ajoute une chiffre négatif à la pile
	 */
	public void neg();
	/**
	 * backspace permet la correction d'une entrée utilisateur 
	 */
	public void backspace();
	/**
	 * accumuler entre un caractère utilisateur
	 * @param caractere
	 */
	public void accumuler(String caractere);
	/**
	 * resetAcc efface la dernière entrée de l'utilisateur 
	 */
	public void resetAcc();
	
	/**
	 * reset toute la calculatrice
	 */
	public void reset();
	
	
	
	public String pileToString();

}