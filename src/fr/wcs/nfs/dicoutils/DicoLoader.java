/**
 * 
 *
 */
package fr.wcs.nfs.dicoutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	Path cheminVersLeFichier = Paths.get(fichierWithParents);
	Path cheminVersLeFichier2 = Paths.get(fichier);

	Path chemin2 = Paths.get("home", "franck", "programmation", "workspaceEclipse", "wcs_projetJava1_dicoutils",
			"wcs_nfs_dicoutils", fichier);
	Path chemin = Paths.get(fichierPath);

	public void chargeFichier() throws IOException {
		System.out.println("chemin 1: " + chemin.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println("path du fichier2: " + cheminVersLeFichier);
		System.out.println("path du fichier3: " + cheminVersLeFichier2);

		File file = new File(fichierPath);
		System.out.println("path du fichier 4:" + file.getAbsolutePath());
		try {
//			String path = "/programmation/workspaceEclipse/wcs_projetJava1_dicoutils/wcs_nfs_dicoutils/src/fr/wcs/nfs/dicoutils/dictionnaire.txt";
			InputStream flux = new FileInputStream(fichierPath);
//			System.out.println("lecture fichier" + path);

			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne = buff.readLine()) != null) {

//			methode tableau
//				String[] tabFichier = new String[336532];
//
//			}

				buff.close();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void chargeFichier1() throws IOException {

		int nbreLignes = 0;
		Path chemin = Paths.get(fichierPath);
		List<String> lignes = Files.readAllLines(chemin);
		for (String mot : lignes) {
			nbreLignes++;
			System.out.println("nbreLignes:" + nbreLignes);
//			System.out.println("lignes." + lignes);
		}
//		methode avec linkedList
		List<String> collection = new LinkedList<>();
//		lecture avec un foreach
		for (String element : collection) {
			nbreLignes++;
			System.out.println("nbreLignes:" + nbreLignes);
//			System.out.println("elements:" + element);
		}
//		String[] temp;
//		while ((ligne = buff.readLine()) != null) {
//			System.out.println(ligne);
//			temp = ligne.split(" ");
//			collection.addAll(collection);
//			for (int i = 0; i < temp.length; i++) {
//				nbreLignes++;
//				System.out.println("nbreLignes:" + nbreLignes);
////				System.out.println("mot " + temp[i]);
//			}
	}

//methode avexc le scanner
	public void chargeFichier3() throws FileNotFoundException {
		String tableau[][] = null, ligne; // CREATION DU TABLEAU A 2 DIMENSIONS

		int i = 0;

		FileReader fichier = new FileReader(fichierPath); // OUVERTURE DU FICHIER
		Scanner sc = new Scanner(fichier);

		while (sc.hasNextLine()) {
			ligne = sc.nextLine();
			tableau[0] = ligne.split("\n");// ENREGISTRER LES DONNES DANS LE TABLEAU A 2 DIMENSIONS
			i++;
		}
	}

//methode java8 avec un collector
	public void chargeFichier2() throws IOException {
		List<String> dictionnaire = Files.lines(Paths.get(path)).collect(Collectors.toList());
//		System.out.println("mot:" + dictionnaire);
		for (String string : dictionnaire) {

			// System.out.println("mot: " + list[200]);
//			System.out.println("mot: " + list);
			System.out.println("mot: " + string);
		}
	}

//methode avec File
	public void chargeFichier4() throws FileNotFoundException {

		File file = new File(fichierPath);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : " + fis.available());
			System.out.println("getChannel " + fis.getChannel());
			System.out.println("toString " + fis.toString());
			System.out.println("getFD " + fis.getFD());
			System.out.println("readAllBytes " + fis.readAllBytes());
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
//				System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		DicoLoader loadFichier = new DicoLoader();
//		loadFichier.chargeFichier();
		loadFichier.chargeFichier1();
//		loadFichier.chargeFichier2();
//		loadFichier.chargeFichier3();
//		loadFichier.chargeFichier4();
	}
}
