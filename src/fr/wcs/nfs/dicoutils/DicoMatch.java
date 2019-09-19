
package fr.wcs.nfs.dicoutils;

//import java.util.regex.*;

public class DicoMatch {

	static Boolean match = false;
	DicoIhm ihm = new DicoIhm();
	DicoLoader loader = new DicoLoader();
	
	static StringBuilder reponses = new StringBuilder();

	
	public void wordIsPresent(String[] mots, String mot) {
		//remis a zero du StringBuilder
		reponses.setLength(0);
		int indiceMot=0;
		
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].equals(mot)) {
				match = true;
				indiceMot = i;
				System.out.println(indiceMot);
				saisirDefinition(indiceMot,mots);
			}
		} 
	}

	public String startBy(String[] mots, String mot) {
		reponses.setLength(0);
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].startsWith(mot)) {

				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + reponses.length() + " occurences.");
		return reponses.toString();
	}

	public String endBy(String[] mots, String mot) {
		reponses.setLength(0);
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].endsWith(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + reponses.length() + " occurences.");
		return reponses.toString();
	}

	public String tableauDictionnaire(String[] mots, String mot) {
		reponses.setLength(0);
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].contains(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + reponses.length() + " occurences.");
		return reponses.toString();
	}
	
	
	public void saisirDefinition(int indiceMot,String[] mots)  {
		
		
		ihm.affichage("Voulez vous donner définition [o/n]");
		ihm.setTexte();
		switch (ihm.getTexte().toUpperCase()) {
		case "O":
			ihm.affichage("Entrez votre définition");
			ihm.setTexte();
			//ihm.affichage(ihm.getTexte());
			
			reponses.append(mots[indiceMot]);
			reponses.append(" : ");
			reponses.append(ihm.getTexte());
			ihm.affichage(reponses.toString());
			mots[indiceMot]=reponses.toString();
//			for (String mot : mots) {
//				System.out.println(mot.toString());
//				
//			}
			loader.saveFichier(mots);
			ihm.standBy();
			
			break;
		case "N":ihm.affichage("vous avez dit non");

			break;
		default:
			break;
		}
		
	}

}
