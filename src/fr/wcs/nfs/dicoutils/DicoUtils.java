package fr.wcs.nfs.dicoutils;

import java.io.IOException;
import java.util.List;

public class DicoUtils {

	public static void main(String[] args) throws IOException {
		
		boolean isRunning=true;
		DicoIhm ihm = new DicoIhm();
		DicoMatch match = new DicoMatch();
		DicoLoader loader = new DicoLoader();
		List<String> tabDico=loader.chargeFichier1();
		String[] tableauDictionnaire = tabDico.toArray(new String[tabDico.size()]);
		
//		String[] tableauDictionnaire= {"abaissa\n" , 
//				"abaissable\n" , 
//				"abaissables\n" , 
//				"abaissai\n" , 
//				"abaissaient\n" , 
//				"abaissais\n" , 
//				"abaissait\n" , 
//				"abaissâmes\n" , 
//				"abaissant\n" , 
//				"abaissante\n" , 
//				"abaissantes\n" , 
//				"abaissants\n" , 
//				"abaissas\n" , 
//				"abaissasse\n" , 
//				"abaissassent"};
//		

		do 
		{
			ihm.affichage(ihm.menu);
			ihm.setChoixMenu();
			
			switch ( ihm.getChoixMenu() ) {
            case 1:
            	ihm.affichage("Entrez le mot recherché: \n" );
                ihm.setTexte();
                ihm.affichage(match.wordIsPresent(tableauDictionnaire, ihm.getTexte()));
                ihm.standBy();
                break;
            case 2:
            	ihm.affichage( "Entrez les premières lettres du mot recherché: \n" );
            	ihm.setTexte();
            	ihm.affichage(match.startBy(tableauDictionnaire, ihm.getTexte()));
            	ihm.standBy();
                break;
            case 3:
            	ihm.affichage("Entrez les dernières lettres du mot recherché: \n" );
                ihm.setTexte();
                ihm.affichage(match.endBy(tableauDictionnaire, ihm.getTexte()));
                ihm.standBy();
                break;
            case 4:
            	ihm.affichage("Entrez les lettres du mot recherché: \n" );
                ihm.setTexte();
                match.tableauDictionnaire(tableauDictionnaire, ihm.getTexte());
                ihm.standBy();
                break;
            case 5:
            	ihm.affichage("Entrez les lettres contenues dans le mot recherché: \n" );
                ihm.setTexte();
                match.wordIsPresent(tableauDictionnaire, ihm.getTexte());
                ihm.standBy();
                break;
            case 0:
            	ihm.affichage("Au revoir");  
                isRunning = false;
                break;
            default:

            }

        } while ( isRunning );

	}

}
