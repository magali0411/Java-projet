package application;
import java.util.logging.Logger;

import javafx.scene.control.Alert;


import javafx.scene.control.Alert.AlertType;

public class Accumulateur implements IAccumulateur {
	
	private static final Logger LOGGER = Logger.getLogger(Accumulateur.class.getName());
	
	private Pile pile;
	private String acc;
	
	// getters and setters
	public Pile getPile() {
		return pile;
	}



	public String getAcc() {
		if (!acc.isEmpty())
			return acc;
		else 
			return "";
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
			LOGGER.info("nothing to push");
		}
		
	}

	@Override
	public void drop() {
		if (!acc.isEmpty()) {
			String str = acc;
			acc = str.substring(0, str.length() - 1); // on supprime le dernier élément de l'accumulateur
		} else if (!pile.isEmpty()) {			
			pile.remove(pile.size()-1); //on supprime le dernier élément de la pile				
		} else {
			LOGGER.info("Nothing to drop");
		}
			
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
		
		if (pile.size() > 1) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b+a);
		} else {
			warn("Veuillez entrer au moins 2 nombres avant d'effectuer une opération");
		}
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		if (pile.size() > 1) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b-a);
		} else {
			warn("Veuillez entrer au moins 2 nombres avant d'effectuer une opération");
		}
	}

	@Override
	public void mult() {
		// TODO Auto-generated method stub
		if (pile.size() > 1) {
			double a = pile.pop();
			double b = pile.pop();
			pile.push(b*a);
		} else {
			warn("Veuillez entrer au moins 2 nombres avant d'effectuer une opération");
		}
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		if (pile.size() > 1) {
				double a = pile.elementAt(pile.size()-1);
				if (a!=0) {
					pile.pop();
					double b = pile.pop();
					pile.push(b/a); 
				} else {
					warn("Division par 0 impossible");
					LOGGER.info("Erreur, division par 0");						
			}
		} else {
			warn("Veuillez entrer au moins 2 nombres avant d'effectuer une opération");
		}
		
	}

	@Override
	public void neg() {
		if(acc.charAt(0) != '-') {
			String moins = "-";
			acc = moins + acc; //concat classique
		}else {
			acc = acc.substring(1); // possibilité de supprimer la negation
		}
		
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
	public void resetAcc() {
		// TODO Auto-generated method stub
		acc = ""; //réinitialise seulement ce qu'on est en train de taper, pas la pile entière
	}
	
	public void reset() {
		pile.clear();
		acc = "";
	}
	
	public void warn(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.show();
	}

}