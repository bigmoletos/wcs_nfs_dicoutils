
package fr.wcs.nfs.dicoutils;

//import java.util.regex.*;

public class DicoMatch {

	static Boolean match = false;
	DicoIhm ihm = new DicoIhm();
	DicoLoader loader = new DicoLoader();
	int compteurOccurences;

	static StringBuilder reponses = new StringBuilder();

	public void wordIsPresent(String[] mots, String mot) {
		// remis a zero du StringBuilder
		reponses.setLength(0);
		int indiceMot = 0;

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].equals(mot)) {
				match = true;
				indiceMot = i;
				System.out.println(indiceMot);
				saisirDefinition(indiceMot, mots);
			}
		}
	}

	public String startBy(String[] mots, String mot) {
		reponses.setLength(0);
		compteurOccurences = 0;
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].startsWith(mot)) {
				compteurOccurences += 1;
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + compteurOccurences + " occurences.");
		return reponses.toString();
	}

	public String endBy(String[] mots, String mot) {
		reponses.setLength(0);
		compteurOccurences = 0;
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].endsWith(mot)) {
				compteurOccurences += 1;
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + compteurOccurences + " occurences.");
		return reponses.toString();
	}

	public String tableauDictionnaire(String[] mots, String mot) {
		reponses.setLength(0);
		compteurOccurences = 0;
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].contains(mot)) {
				compteurOccurences += 1;
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + compteurOccurences + " occurences.");
		return reponses.toString();
	}

	public String findRegex(String[] mots, String mot) {
		reponses.setLength(0);
		compteurOccurences = 0;
		for (int i = 0; i < mots.length; i++) {
			if (mots[i].matches(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
				reponses.append("\n");
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + compteurOccurences + " occurences.");
		return reponses.toString();
	}

	public void saisirDefinition(int indiceMot, String[] mots) {
		reponses.setLength(0);
		compteurOccurences = 0;

		ihm.affichage("Voulez vous donner définition [o/n]");
		ihm.setTexte();
		switch (ihm.getTexte().toUpperCase()) {
		case "O":
			ihm.affichage("Entrez votre définition");
			ihm.setTexte();
			reponses.append(mots[indiceMot]);
			reponses.append(" : ");
			reponses.append(ihm.getTexte());
			ihm.affichage(reponses.toString());
			mots[indiceMot] = reponses.toString();
			loader.saveFichier(mots);
			ihm.standBy();

			break;
		case "N":
			ihm.affichage("vous avez dit non");

			break;
		default:
			break;
		}

	}

}
