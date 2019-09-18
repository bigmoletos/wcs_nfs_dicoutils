package fr.wcs.nfs.dicoutils;

import java.util.Scanner;

public class DicoIhm {

	Scanner saisieUtilisateur = new Scanner(System.in);
	private int choixMenu;
	private String texte;
	private boolean isRunning;
	private DicoMatch token;

	public DicoIhm() {

	};

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

	public void affichageMenu() {
		String menu;
		menu = "(*************************************************************************)\n"
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
				+ "(*************************************************************************)\n";
		System.out.println(menu);
	}

	public void affichageMessage(String message) {
		System.out.println(message);
	}

	public void start() {
		isRunning = true;

		do {
			affichageMenu();
			affichageMessage("Entrer votre choix: ");
			setChoixMenu();
<<<<<<< HEAD
			if (getChoixMenu() > 0 && getChoixMenu() < 6) {

				affichageMessage("Vous avez choisi le menu: " + getChoixMenu() + "\n");
=======
			if(getChoixMenu()>0 && getChoixMenu()<6) {

				affichageMessage("Vous avez choisi le menu: "+getChoixMenu() + "\n");
>>>>>>> 4cec07e9457c9adce638e73970e297670da9c92e
				affichageMessage("Veuillez saisir votre recherche: ");
				setTexte();
				affichageMessage("vous avez saisi: " + getTexte());

<<<<<<< HEAD
				token = new DicoMatch(getTexte(), getChoixMenu());
				token.methode();

				isRunning = false;

			} else if (getChoixMenu() == 0) {

				isRunning = false;
=======
				token = new DicoMatch(getTexte(),getChoixMenu());
				token.methode();

				isRunning=false;

			}else if(getChoixMenu()==0) {


				isRunning=false;
>>>>>>> 4cec07e9457c9adce638e73970e297670da9c92e

			}
		} while (isRunning);

	}

}
