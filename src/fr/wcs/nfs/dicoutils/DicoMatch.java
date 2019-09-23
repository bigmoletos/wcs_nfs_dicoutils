package fr.wcs.nfs.dicoutils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
				ihm.affichage("Il y a une occurence.");
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

	public String containsValue(String[] mots, String mot) {
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
	
	
	public String findRegex(String[] mots, String regex) {
		reponses.setLength(0);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		int res = 0;
		System.out.println("regex " + regex);

		for (String string : mots) {
			matcher = pattern.matcher(string);
			if (matcher.find()) {
				res++;
				reponses.append(string);
				reponses.append(",");
				reponses.append("\n");
			}
		}

		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + res + " occurences.");
		return reponses.toString();
	}
	

	public void saisirDefinition(int indiceMot, String[] mots) {
		reponses.setLength(0);
		compteurOccurences = 0;

		ihm.affichage("Voulez vous donner définition [o/n]");
		ihm.setTexte();
		String charSaisie = ihm.getTexte();
		if (charSaisie.equals("\\n")) {
			charSaisie="O";
		}
		switch (charSaisie.toUpperCase()) {
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
