//Importation des class
package fr.wcs.nfs.dicoutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DicoMatch {

	//initialisation des variables dont on a besoin pour le programme
	static Boolean match = false;
	DicoIhm ihm = new DicoIhm();
	DicoLoader loader = new DicoLoader();
	int compteurOccurences;

	//Besoin d'unconstructeur du tableau car en cas d'une très grande liste de réponses, lzs concaténations prendraient trop de ressources.
	static StringBuilder reponses = new StringBuilder();

	//Méthode pour chercher dans le dico un mot
	public void wordIsPresent(String[] mots, String mot) {
		// remise a zero du StringBuilder
		reponses.setLength(0);
		int indiceMot = 0;

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].equals(mot)) {
				match = true;
				indiceMot = i;
				saisirDefinition(indiceMot, mots);
			}
		}
	}

	//Méthode pour saisir une définition, elle est appelée dans la méthode wordIsPresent lorsque l'utilisateur choisit d'ajouter une définition
	public void saisirDefinition(int indiceMot, String[] mots) {
		reponses.setLength(0);
		//Un compteur d'occurences est initialisé pour éviter que le StringBuilder compte pour un mot les : et ,
		compteurOccurences = 0;

		ihm.affichage("Voulez vous saisir une définition? [O/n]");
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

	// Methode pour une recherche de mots qui commencent par
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
		// DeleteCharAt est une méthode de StringBuilder pour enlever la virgule à la
		// fin du dernier mot del a liste de réponses
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + compteurOccurences + " occurences.");
		return reponses.toString();
	}

	// Methode pour une recherche de mots qui finissent par
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

	// Méthode pour rechercher tous les mots qui contiennent une valeur
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

	// Méthode pour rechercher des expressions régulières. C'est une chaîne de
	// caractères, qui décrit, selon une syntaxe précise, un ensemble de chaînes de
	// caractères possibles. Les expressions régulières sont également appelées
	// regex (de l'anglais regular expression).
	//	« (to)+ » =mot contenant to
	//	« a+ »    =mot commencant par plusieurs a
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
}