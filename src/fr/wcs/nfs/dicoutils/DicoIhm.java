package fr.wcs.nfs.dicoutils;

import java.util.Scanner;

public class DicoIhm {

	Scanner saisieUtilisateur = new Scanner(System.in);
	
	private int choixMenu;
	private String texte;
	private String motTrouve;
	private int indiceMot;

	public int getChoixMenu() {
		return choixMenu;
	}

	public void setChoixMenu() {

		this.choixMenu = saisieUtilisateur.nextInt();
		saisieUtilisateur.nextLine();
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte() {

		this.texte = saisieUtilisateur.nextLine();
	}

	
	String menu = "(*************************************************************************)\n"
				+ "(*************************************************************************)\n"
				+ "(*     DICO UTILS : by Nina, Franck et Stéphan                           *)\n"
				+ "(*************************************************************************)\n"
				+ "(*************************************************************************)\n"
				+ "(*     1- Rechercher la présence d'un mot exacte                         *)\n"
				+ "(*     2- Rechercher tous les mots qui commencent par une valeur         *)\n"
				+ "(*     3- Rechercher tous les mots qui terminent par une valeur          *)\n"
				+ "(*     4- Rechercher tous les mots qui contiennent une valeur            *)\n"
				+ "(*     5- Rechercher des mots par une expression régulière               *)\n"
				+ "(*     0- Quitter                                                        *)\n"
				+ "(*************************************************************************)\n"
				+ "       Entrez votre choix: ";
			
		
	public void affichage(String message) {
		System.out.println(message);
	}
	public void affichage(int message) {
		System.out.println(message);
	}
	public void standBy() {
		affichage("Pressez Entrer pour recommencer");
		saisieUtilisateur.nextLine();		
		
	}

	public String getMotTrouve() {
		return motTrouve;
	}

	public void setMotTrouve(String motTrouve) {
		this.motTrouve = motTrouve;
	}

	public int getIndiceMot() {
		return indiceMot;
	}

	public void setIndiceMot(int indiceMot) {
		this.indiceMot = indiceMot;
	}
}
