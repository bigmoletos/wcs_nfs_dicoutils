/**
 * 
 *
 */
package fr.wcs.nfs.dicoutils.fd;

import java.io.File;
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
	static String fichier = "dictionnaire.txt";
//	donne le path du projet en cours remplacer fichier par ""
	String path = new File(fichier).getAbsolutePath();

//	String fichierWithParents = "/../../../../../dictionnaire.txt";
//	String path = "/home/franck/programmation/workspaceEclipse/wcs_projetJava1_dicoutils/wcs_nfs_dicoutils/";
//	String fichierPath = path + fichier;
//	Path chemin2 = Paths.get("home", "franck", "programmation", "workspaceEclipse", "wcs_projetJava1_dicoutils",
//			"wcs_nfs_dicoutils", fichier);
//	String urlCourante = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
	List<String> tabDico;

	/**
	 * @description methode avec linkedList
	 * @return List<String>
	 *
	 * @method chargeFichier1
	 * @class DicoLoader
	 * @version 1.0
	 * @date mercredi 18 sept. 2019
	 * @see
	 *
	 **/
	public List<String> chargeFichier1() {

		try {
			Path chemin = Paths.get(path);
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

//bonus, rajoute une definition à un mot dans le fichier dictionnaire.text
	public List<String> addDefinition(int numeroLigne, String motSansDefinition, String definition) {
		// ToDo on peut aussi utiliser un set plutot que add, car permet de remplacer
		// l'element en cours
		this.tabDico.set(numeroLigne, motSansDefinition + " : " + definition);
//		this.tabDico.add(numeroLigne, motSansDefinition + " : " + definition);
		return tabDico;
//		 // création d'un listIterator sur cette liste
//		ListIterator<String> it = liste.listIterator() ;
//
//		 while(it.hasNext()) {
//		    // on ajoute un élément supplémentaire après chaque
//		    // élément de la liste
//		   String element = it.next() ;
//		   it.add(element +  " et demi") ;
//		}
//
//		 // vérification du résultat
//		 for (String s : liste) {
//		   System.out.println(s) ;
//		}
	}

	public static void main(String[] args) {

//		String urlCourante = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();

		DicoLoader loader = new DicoLoader();
		loader.chargeFichier1();

		List dictionnaire;
		dictionnaire = loader.chargeFichier1();
//		loader.addDefinition(1, "a", "le premier mot de l'alphabet");
//		public  wordIsPresent(List dico, String mot) {
//
//			for (int i = 0; i < mots.length; i++) {
//				if (mots[i] == mot) {
//					match = true;
//
//				}
//			}
//				return reponses.append(match);
//				}

//		
//		public static StringBuilder startBy(String[] mots, String mot) {
//
//			for (int i = 0; i < mots.length; i++) {
//				if (mots[i].startsWith(mot)) {
//					reponses.append(mots[i]);
//					reponses.append(",");
//				}
//			}
//			return reponses;
//		}
//
//		public static StringBuilder endBy(String[] mots, String mot) {
//
//			for (int i = 0; i < mots.length; i++) {
//				if (mots[i].endsWith(mot)) {
//					reponses.append(mots[i]);
//					reponses.append(",");
//				}
//			}
//			return reponses;
//		}
//
//		public static StringBuilder tableauDictionnaire(String[] mots, String mot) {
//
//			for (int i = 0; i < mots.length; i++) {
//				if (mots[i].contains(mot)) {
//					reponses.append(mots[i]);
//					reponses.append(",");
//				}
//			}
//			return reponses;
//		}
//
//	
//	}
	}
}
