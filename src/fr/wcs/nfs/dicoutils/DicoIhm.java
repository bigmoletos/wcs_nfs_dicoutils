package fr.wcs.nfs.dicoutils;

import java.util.Scanner;

public class DicoIhm {
	
	private String messageEnvoye="";
	Scanner saisieUtilisateur = new Scanner(System.in);
	private String choixMenu;
	private String texte;
	private boolean isRunning;
	
		
	public String getChoixMenu() {
		return choixMenu;
	}

	public void setChoixMenu(String choixMenu) {
		this.choixMenu = choixMenu;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public void setMessageEnvoye(String messageEnvoye) {
		this.messageEnvoye = messageEnvoye;
	}

	public DicoIhm() {
		
	};
	
	public void affichageMenu() {
		String menu;
		menu =  "************************\n"+
				"************************\n"+
				"*     DICO UTILS       *\n"+
				"************************\n"+
				"************************\n"+
				"*     1- CHOIX         *\n"+
				"*     2- CHOIX         *\n"+
				"*     3- CHOIX         *\n"+
				"*     4- CHOIX         *\n"+
				"*     5- CHOIX         *\n"+
				"*     0- Quitter       *\n"+
				"************************";
		System.out.println(menu);	
	}
	
	public void affichageMessage(String message) {
		messageEnvoye="";
		messageEnvoye += message;
		System.out.println(messageEnvoye);
	}
	public String choixUtilisateur() {
		
		choixMenu = saisieUtilisateur.nextLine();
		
		return choixMenu;
	}
	
	public void start() {
		isRunning = true;
		
		do 
		{
			affichageMenu();
			affichageMessage("Entrer votre choix: ");
			setChoixMenu(choixUtilisateur());
			
			//Faire un switch case
			
			
//	        if(this.getChoixMenu()!="0" || this.getChoixMenu()!="1" ||
//					this.getChoixMenu()!="2" ||this.getChoixMenu()!="3" ||this.getChoixMenu()!="4" || this.getChoixMenu()!="5") {
//	        	
//	        	affichageMessage("Nombre compris entre 0 et 5");
//	        }else {
//	        	
//	        	affichageMessage("Vous avez choisi le menu: "+getChoixMenu() + "\n");
//	        	affichageMessage("Veuillez saisir votre recherche: ");
//	        	setTexte(choixUtilisateur());
//	        	affichageMessage("vous avez saisi: " + getTexte());
//	        	isRunning=false;
//	        }
	
		} while(isRunning);
		
	}



}
