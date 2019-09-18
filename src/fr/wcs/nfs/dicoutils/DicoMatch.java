
package fr.wcs.nfs.dicoutils;

//import java.util.regex.*;

public class DicoMatch {

	static Boolean match = false;
	DicoIhm ihm;
	DicoLoader loader;
	static StringBuilder reponses = new StringBuilder();

	public String wordIsPresent(String[] mots, String mot) {
		//remis a zero du StringBuilder
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
		return reponses.deleteCharAt(reponses.length() - 2).toString();
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
		return reponses.toString();
	}

}
