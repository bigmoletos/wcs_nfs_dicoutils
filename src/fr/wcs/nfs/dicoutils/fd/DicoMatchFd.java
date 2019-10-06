
package fr.wcs.nfs.dicoutils.fd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.regex.*;

public class DicoMatchFd {

	static Boolean match = false;
	static DicoIhmFd ihm = new DicoIhmFd();
//	static String choix = ihm.getTexte();
	static int choix = ihm.getChoixMenu();
	DicoLoaderFd loader = new DicoLoaderFd();
	int compteurOccurences;

	Scanner inputKeyBoard = new Scanner(System.in);
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
//		String saisieString = inputKeyBoard.nextLine();

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

	public String findByAll(String[] mots, String regex) {
		System.out.println("saisir choix");
		int choix = inputKeyBoard.nextInt();
		inputKeyBoard.nextLine();
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
//		a{3}	correspond exactement à aaa
//		a{2,}	correspond à un minimum de deux a consécutifs
//		soit aa, aaa, aaaaa....
//		a{2,4}	correspond uniquement à aa, aaa, aaaa
//		br[iu]n	ce qui signifie, trouver br suivi de i ou de u 
//		suivi de n comme brun ou brin
//		p(ai|i)n	la barre verticale détermine une alternative
//		ce qui signifie tout ce qui s'écrit pain ou pin
//		^(De|Sujet|Date):@  reconnaît tout ce qui commence par De:@ ou Sujet:@ ou Date:@
//		[^0-9]  reconnaît tout ce qui n'est pas des chiffres
//		[^1-6]  reconnaît tout sauf les chiffres de 1 à 6
//		Rappel : l'accent circonflexe est un métacaratère à l'intérieur de la classe. 
//		A l'extérieur, c'est une ancre qui signifie le début de...
//		System.out.println("choix: " + ihm.getChoixMenu());
		System.out.println("choix: " + choix);
		if (choix == 1) {
//			contient seulement le mot
			regex = "^" + regex + "$";
			System.out.println("regex: " + regex);
//			return regex;
		} else if (choix == 2) {
			// commence par
			regex = "^" + regex;
			System.out.println("regex: " + regex);
//			return regex;
		} else if (choix == 3) {
			// termine par
			regex = regex + "$";
			System.out.println("regex: " + regex);
//			return regex;
		} else if (choix == 4) {
			// contient les valeurs
			regex = (regex) + "+";
			System.out.println("regex: " + regex);
//			return regex;
		} else if (choix == 5) {
			// contient les valeurs
//			return regex;
		}
		System.out.println("regex: " + regex);
//		compilation du regex en objet java
		Pattern pattern = Pattern.compile(regex);
//		static boolean matches(String regex, CharSequence entree)	;
//		Compile l'expression régulière et analyse la séquence de caractères entree.
//		Equivalent à 
//		Pattern.compile(expreg).matcher(entree).matches()
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
//			loader.saveFichier1(mots);
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