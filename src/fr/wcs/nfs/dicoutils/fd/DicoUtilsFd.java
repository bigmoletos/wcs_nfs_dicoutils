package fr.wcs.nfs.dicoutils.fd;

import java.io.IOException;
import java.util.List;

public class DicoUtilsFd {

	public static void main(String[] args) throws IOException {

		boolean isRunning = true;
		DicoIhmFd ihm = new DicoIhmFd();
		DicoMatchFd match = new DicoMatchFd();
		DicoLoaderFd loader = new DicoLoaderFd();
		List<String> tabDico = loader.chargeFichier1();
		String[] tableauDictionnaire = tabDico.toArray(new String[tabDico.size()]);

		do {
			ihm.affichage(ihm.menu);
			ihm.setChoixMenu();
			ihm.getChoixMenu();

			switch (ihm.getChoixMenu()) {
			case 1:
				ihm.affichage("Entrez le mot recherché: \n");
				ihm.setTexte();
//				match.wordIsPresent(tableauDictionnaire, ihm.getTexte());
				match.findByAll(tableauDictionnaire, ihm.getTexte());
				ihm.standBy();
				break;
			case 2:
				ihm.affichage("Entrez les premières lettres du mot recherché: \n");
				ihm.setTexte();
//				ihm.affichage(match.startBy(tableauDictionnaire, ihm.getTexte()));
				ihm.affichage(match.findByAll(tableauDictionnaire, ihm.getTexte()));
				ihm.standBy();
				break;
			case 3:
				ihm.affichage("Entrez les dernières lettres du mot recherché: \n");
				ihm.setTexte();
//				ihm.affichage(match.endBy(tableauDictionnaire, ihm.getTexte()));
				ihm.affichage(match.findByAll(tableauDictionnaire, ihm.getTexte()));
				ihm.standBy();
				break;
			case 4:
				ihm.affichage("Entrez les lettres du mot recherché: \n");
				ihm.setTexte();
//				ihm.affichage(match.containsValue(tableauDictionnaire, ihm.getTexte()));
				ihm.affichage(match.findByAll(tableauDictionnaire, ihm.getTexte()));
				ihm.standBy();
				break;
			case 5:
				ihm.affichage("Entrez les lettres contenues dans le mot recherché: \n");
				ihm.setTexte();
//				ihm.affichage(match.findRegex(tableauDictionnaire, ihm.getTexte()));
				ihm.affichage(match.findByAll(tableauDictionnaire, ihm.getTexte()));
				ihm.standBy();
				break;
			case 6:
				for (String mot : tableauDictionnaire) {
					System.out.println(mot.toString());
				}
				ihm.affichage(tableauDictionnaire.length);
				ihm.standBy();
				break;
			case 0:
				ihm.affichage("Au revoir");
				isRunning = false;
				break;
			default:

			}

		} while (isRunning);

	}

}