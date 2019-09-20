
package fr.wcs.nfs.dicoutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.regex.*;

public class DicoMatch {

	static Boolean match = false;
	DicoIhm ihm;
	DicoLoader loader;
	static StringBuilder reponses = new StringBuilder();

	public String wordIsPresent(String[] mots, String mot) {
		// remis a zero du StringBuilder
		reponses.setLength(0);

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].equals(mot)) {
				match = true;
			}
		}
		if (match) {
			return reponses.append("Il y une occurrence du mot recherché.\n").toString();
		} else {
			return reponses.append("Il n'y a aucun mot correspondant.\n").toString();
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
			}
		}
		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + reponses.length() + " occurences.");
		return reponses.toString();
	}

	public String findRegex(String[] mots, String regex) {
		reponses.setLength(0);

//		« (to)+ » =mot contenant to
//		« a+ »    =mot commencant par plusieurs a

//		compilation du regex en objet java
		Pattern pattern = Pattern.compile(regex);
//		instanciation pour application à une chaine de caractéres
		Matcher matcher = null;
//		pattern.matcher(mots);
		int res = 0;
		System.out.println("regex " + regex);

		for (String string : mots) {
			matcher = pattern.matcher(string);
			if (matcher.find()) {
				// get the MatchResult Object
//				MatchResult resultMatch = matcher.toMatchResult();

				// Prints the offset after the last character of the subsequence captured by the
				// given group during this match.
//				System.out.println("Second Capturing Group - Match String - end(1): " + resultMatch.end(1));
				res++;
//				System.out.println("nb occurences " + res);
				reponses.append(string);
				reponses.append(",");
				reponses.append("\n");
			}
//			if (pattern.matcher(string) != null) {
//				while (matcher.find()) {
//					String texte = matcher.group();
//					int debut = matcher.start();
//					int fin = matcher.end();
//					System.out.println("Trouvé " + texte + " à la position " + debut);
//					res++;
//					System.out.println("nb occurences " + res);
//					reponses.append(string);
//
//				}

//				System.out.println("match mot" + matcher.find());
//				System.out.println("mot: " + string);
		}

		reponses.deleteCharAt(reponses.length() - 2);
		reponses.append("Il y a " + reponses.length() + " occurences.");
		return reponses.toString();
//		String regex = "@#\\?"; //echappement du ?
//		String NewsousChaine = sousChaine.replaceAll(regex, " ");
	}

}