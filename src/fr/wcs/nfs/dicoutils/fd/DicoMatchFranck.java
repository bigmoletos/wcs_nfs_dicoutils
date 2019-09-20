
package fr.wcs.nfs.dicoutils.fd;

import java.util.List;

/**
 * @author franck
 *
 */
public class DicoMatchFranck {

	static Boolean match = false;
	DicoIhm ihm;
	DicoLoader loader;
	static StringBuilder reponses = new StringBuilder();
//	DicoLoader dico = new DicoLoader();

	public void recupIhm(DicoIhm ihm, DicoLoader loader) {
		String mot = ihm.getTexte();
		int choixNumero = ihm.getChoixMenu();

//        switch (choixNumero) {
//            case 1:  wordIsPresent(null, choixNumero);
//                     break;
//                     
//            case 2:  startBy(null, choixNumero);
//                     break;
//            case 3:  endBy(null, choixNumero);
//                     break;
//            case 4: ;tableauDictionnaire(null, choixNumero);
//                     break;
//            //case 5: ;
//                     //break;	
//        }

	}

	public boolean wordIsPresent(List<String> mots, String mot) {

		for (String string : mots) {

		}
//		for (int i = 0; i < mots.size; i++) {
//			if (mots[i] == mot) {
//				match = true;
//
//			}
//		}return reponses.append(match);
		return false;

	}

	public static StringBuilder startBy(String[] mots, String mot) {

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].startsWith(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
			}
		}
		return reponses;
	}

	public static StringBuilder endBy(String[] mots, String mot) {

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].endsWith(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
			}
		}
		return reponses;
	}

	public static StringBuilder tableauDictionnaire(String[] mots, String mot) {

		for (int i = 0; i < mots.length; i++) {
			if (mots[i].contains(mot)) {
				reponses.append(mots[i]);
				reponses.append(",");
			}
		}
		return reponses;
	}

	public static void main(String[] args) {
		DicoMatchFranck match = new DicoMatchFranck();
		DicoLoader dico = new DicoLoader();

		match.wordIsPresent(dico.chargeFichier1(), "arrosoir");
	}

}
