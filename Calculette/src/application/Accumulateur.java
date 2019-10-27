package application;

public class Accumulateur implements IAccumulateur {
	
	private Pile pile;
	private String acc;
	
	// getters and setters
	public Pile getPile() {
		return pile;
	}



	public String getAcc() {
		return acc;
	}

	
	// constructeur 
	public Accumulateur(Pile p, String ac) {
		this.pile = p;
		this.acc = ac;
	}
	
	public Accumulateur() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
		if (!acc.isEmpty()) {
			Double a = Double.parseDouble(acc); //on transforme acc en double
			pile.push(a);
			acc="";
		} else {
			System.out.println("nothing to push");
		}
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		pile.removeElementAt(pile.size()-1); //on supprime le dernier élément
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		double a = pile.pop();
		double b = pile.pop();
		pile.push(b);
		pile.push(a);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		if (!pile.isEmpty()) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b+a);
		}
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		if (!pile.isEmpty()) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b-a);
		}
	}

	@Override
	public void mult() {
		// TODO Auto-generated method stub
		if (!pile.isEmpty()) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b*a);
		}
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		if (!pile.isEmpty()) {
				double a = pile.elementAt(pile.size()-1);
				if (a!=0) {
					pile.pop();
					double b = pile.pop();
					pile.push(b/a); 
				} else {
					System.out.println("Erreur, division par 0");						
			}
		}
		
	}

	@Override
	public void neg() {
		// TODO Auto-generated method stub
		String moins = "-";
		acc = moins + acc; //concat classique
		
	}

	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		acc = acc.substring(0, acc.length()-1); //on transforme acc en acc avec le dernier terme en moins
	}

	@Override
	public void accumuler(String caractere) {
		// TODO Auto-generated method stub
		acc = acc + caractere; //verifier si la concat d'un String et d'un char est possible
		
	
	}
	
	public String pileToString() {
		return pile.toString();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		acc = ""; //réinitialise seulement ce qu'on est en train de taper, pas la pile entière
	}

}