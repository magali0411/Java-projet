package application;


public interface IAccumulateur {
	
	/**
	 * getpile retourne la pile de l'accumulateur
	 * @return pile
	 */
	public Pile getPile();
	/**
	 * getacc retourn l'entr�e clavier actuelle
	 * @return chiffre 
	 */
	public String getAcc();
	
	/**
	 * push ajout un �l�ment � la pile
	 */
	public void push();
	/**
	 * drop supprime le dernier �l�ment
	 */
	public void drop();
	/**
	 * swap �change les deux derniers chiffres de la pile
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
	 * neg ajoute un chiffre n�gatif � la pile
	 */
	public void neg();
	/**
	 * backspace permet la correction d'une entr�e utilisateur 
	 */
	public void backspace();
	/**
	 * accumuler entre un caract�re utilisateur
	 * @param caractere
	 */
	public void accumuler(String caractere);
	/**
	 * resetAcc efface la derni�re entr�e de l'utilisateur 
	 */
	public void resetAcc();
	
	/**
	 * reset toute la calculatrice
	 */
	public void reset();
	
	/**
	 * Warn informe l'utilisateur
	 * @param message � afficher 
	 */
	public void warn(String str);
	
	
	/**
	 * pileToString affiche le contenu de la pile
	 * @return cha�ne de caract�res 
	 */
	public String pileToString();

}