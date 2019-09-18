/**
 * 
 *
 */
package fr.wcs.nfs.dicoutils;

/**
 * @author franck
 *
 */
public class DicoMatch {

	private String texte;
	private int choixMenu;
	static boolean match= false;
	static DicoIhm ihm = new DicoIhm();
	
	
	
	public DicoMatch(String texte,int choixMenu) {
		
		this.texte = texte;
		this.choixMenu = choixMenu;
		
	}
	
	public void methode() {
		
		switch (this.choixMenu) {
		case 1:  ihm.affichageMessage("Ce message vient de DicoMatch " +this.texte);
							
			
			break;

		default:
			break;
		}
		
	}
	

}
