package fr.wcs.nfs.dicoutils;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @author franck
 *
 */

public class DicoLoader {

	/**
	 * @description
	 *
	 * @return void
	 *
	 * @method chargeFichier
	 * @class DicoLoader
	 * @version 1.0
	 * @date mardi 17 sept. 2019
	 * @see
	 *
	 **/

//	gestion du path
	Charset charset = Charset.forName("UTF-8");
	String fichierWithParents = "/../../../../../dictionnaire.txt";
	String fichier = "dictionnaire.txt";
	String path = "/home/franck/programmation/workspaceEclipse/wcs_projetJava1_dicoutils/wcs_nfs_dicoutils/";
	String fichierPath = path + fichier;
//	Path chemin2 = Paths.get("home", "franck", "programmation", "workspaceEclipse", "wcs_projetJava1_dicoutils",
//			"wcs_nfs_dicoutils", fichier);

//		methode avec linkedList
	List<String> tabDico;

	public List<String> chargeFichier1() {

		try {
			Path chemin = Paths.get(fichierPath);
			this.tabDico = new LinkedList<>();
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
}