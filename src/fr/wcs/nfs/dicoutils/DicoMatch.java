
package fr.wcs.nfs.dicoutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.wcs.nfs.dicoutils.fd.DicoIhmFd;

//import java.util.regex.*;

public class DicoMatch {

	static Boolean match = false;
	DicoIhmFd ihm = new DicoIhmFd();
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

	/**
	 * @description methode permettant de faire les 5 choix en partant de la version
	 *              regex et en modifiant ce dernier en fonction du choix
	 *              utilisateur. Cela permet de n'utiliser qu'une seule methode au
	 *              lieu de 5
	 * @return String
	 *
	 * @method findByAll
	 * @class DicoMatch
	 * @version 1.0
	 * @date vendredi 20 sept. 2019
	 * @see
	 *
	 **/
	public String findByAll(String[] mots, String regex) {
		reponses.setLength(0);
//		^chat$  reconnaît chat seul
//		^$  reconnaît chaîne vide
//		^  début de chaîne
//		$  fin de chaîne
//		« (to)+ » =mot contenant to
//		« a+ »    =mot commencant par plusieurs a
//		 "@#\\?"; //echappement du ?
//		[a-z]  reconnaît les lettres de a à z
//		[Yy]ves  un mot avec ou sans majuscule
//		<h[1-6]>  une balise de titre par exemple
//		L[y|i]s  reconnaît Lys ou Lis
//		^(De|Sujet|Date):@  reconnaît tout ce qui commence par De:@ ou Sujet:@ ou Date:@
//		[^0-9]  reconnaît tout ce qui n'est pas des chiffres
//		[^1-6]  reconnaît tout sauf les chiffres de 1 à 6
//		Rappel : l'accent circonflexe est un métacaratère à l'intérieur de la classe. 
//		A l'extérieur, c'est une ancre qui signifie le début de...
		if (ihm.getChoixMenu() == 1) {
//			contient seulement le mot
			regex = "^" + regex + "$";
			return regex;
		} else if (ihm.getChoixMenu() == 2) {
			// commence par
			regex = "^" + regex;
			return regex;
		} else if (ihm.getChoixMenu() == 3) {
			// termine par
			regex = regex + "$";
			return regex;
		} else if (ihm.getChoixMenu() == 4) {
			// contient les valeurs
			regex = (regex) + "+";
			return regex;
		} else if (ihm.getChoixMenu() == 5) {
			// contient les valeurs
			return regex;
		}
		System.out.println("regex: " + regex);
//		compilation du regex en objet java
		Pattern pattern = Pattern.compile(regex);
//		instanciation pour application à une chaine de caractéres
		Matcher matcher = null;
		int res = 0;

		for (String string : mots) {
			matcher = pattern.matcher(string);
			if (matcher.find()) {
				res++;
//				System.out.println("nb occurences " + res);
				reponses.append(string);
				reponses.append(",");
				reponses.append("\n");
			}
		}

//		reponses.deleteCharAt(reponses.length() - 2);
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

	/**
	 * @description
	 *
	 * @return String
	 *
	 * @method containsValue
	 * @class DicoMatch
	 * @version 1.0
	 * @date dimanche 29 sept. 2019
	 * @see
	 *
	 **/
	public String containsValue(String[] tableauDictionnaire, String texte) {
		// TODO Auto-generated method stub
		return null;
	}

}