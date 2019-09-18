package fr.wcs.nfs.dicoutils;

import java.io.IOException;
import java.util.Scanner;



public class DicoUtils {

	
	
	public static void main(String[] args) {
		

		DicoIhm ihm = new DicoIhm();
		DicoMatch match = new DicoMatch();
		DicoLoader loader = new DicoLoader();
		
		
		boolean isRunning=true;
		
		do 
		{
			ihm.affichageMenu();
			ihm.affichageMessage("Entrer votre choix: ");
			ihm.setChoixMenu();
			if(ihm.getChoixMenu()>0 && ihm.getChoixMenu()<6) {
				
				ihm.affichageMessage("Vous avez choisi le menu: "+ihm.getChoixMenu() + "\n");
				ihm.affichageMessage("Veuillez saisir votre recherche: ");
				ihm.setTexte();				
				ihm.affichageMessage("vous avez saisi: " + ihm.getTexte());
				
				match.recupIhm(ihm,loader);

				isRunning=false;
	
			}else if(ihm.getChoixMenu()==0) {
				
				
				isRunning=false;
				
			}
		} while(isRunning);

		

	}
	
	
}
