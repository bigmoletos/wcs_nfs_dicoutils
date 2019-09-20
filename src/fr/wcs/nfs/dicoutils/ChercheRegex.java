/**
 * 
 *
 */
package fr.wcs.nfs.dicoutils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author franck
 *
 */
public class ChercheRegex {

	/**
	 * @description
	 *
	 * @return void
	 *
	 * @method main
	 * @class ChercheRegex
	 * @version 1.0
	 * @date jeudi 19 sept. 2019
	 * @see
	 *
	 **/
	Charset charset = Charset.forName("UTF-8");
	static String fichier = "dictionnaire.txt";
//		donne le path du projet en cours remplacer fichier par ""
	static String path = new File(fichier).getAbsolutePath();
	static List<String> tabDico;
	static StringBuilder reponses = new StringBuilder();
	static String prevert = "Une pierre\n" + "deux maisons\n" + "trois ruines\n" + "quatre fossoyeurs\n" + "un jardin\n"
			+ "des fleurs\n" + "\n" + "un raton laveur\n" + "\n" + "une douzaine d'huîtres un citron un pain\n"
			+ "un rayon de soleil\n" + "une lame de fond\n" + "six musiciens\n" + "une porte avec son paillasson\n"
			+ "un monsieur décoré de la légion d'honneur\n" + "\n" + "un autre raton laveur";

	public List<String> chargeFichier1() {

		try {
			Path chemin = Paths.get(path);
//			this.tabDico = new LinkedList<>();
			this.tabDico = Files.readAllLines(chemin);
//		cast de List <String> en tableau de String[]
//			String[] tableauDictionnaire = tabDico.toArray(new String[tabDico.size()]);
//			return tableauDictionnaire;
			return this.tabDico;

		} catch (Exception e) {
			System.out.println("oups une erreur! " + e.getMessage());
		}
		return null;
	}

	public String findRegex(List<String> tableau, String mot) {

//			« (to)+ » =mot contenant to
//			« a+ »    =mot commencant par plusieurs a

		reponses.setLength(0);
		System.out.println("regex " + mot);

		for (String string : chargeFichier1()) {
			if (Pattern.matches(mot, string)) {
				System.out.println("mot: " + string);
				reponses.append(string);
			}
		}
		return reponses.toString();
	}

//	public static void main(String[] args) {

	public static void main(String[] args) {
		ChercheRegex reg = new ChercheRegex();
		reg.findRegex(reg.chargeFichier1(), "+h");
	}
}
