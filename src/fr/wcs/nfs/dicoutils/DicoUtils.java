package fr.wcs.nfs.dicoutils;

import java.util.Scanner;

public class DicoUtils {

	public static void main(String[] args) {
		
		boolean isRunning=true;
		Scanner saisieUtlisateur = new Scanner(System.in);	
		DicoIhm dico = new DicoIhm();
		int choixMenu;
		//Dicoloader fichier= new Dicoloader();
	
		while (isRunning) 
		{
			
			dico.affichageMenu();
			
			
			System.out.print("Entrer votre choix: ");  
	          choixMenu = saisieUtlisateur.nextInt(); 
	          
			if (choixMenu<0 || choixMenu>6) {
				isRunning=true;
				System.out.println("Votre choix doit etre entre 0 et 5 ");
			}else {
				
				choixUtilisateur(choixMenu);
				isRunning=false;
			}
			
			
		}
		
	}
	
		
		
	
	

	private static void choixUtilisateur(int choix) {
		
		System.out.println("Vous avez choix l'option"+ choix);
		
	}

}

