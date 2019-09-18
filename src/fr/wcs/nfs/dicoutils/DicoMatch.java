/**
 * 
 *
 */
package fr.wcs.nfs.dicoutils;
import java.util.regex.*;

/**
 * @author franck
 *
 */
public class DicoMatch {
	
	static Boolean match = false;
	
	public boolean wordIsPresent (String[] mots, String mot) {
		
		for (int i = 0; i < mots.length; i ++) {
			if (mots[i] == mot) {
				match = true;
				//System.out.println("Ok, le mot est dans le dico!");
				}
			
		}
		return match;
	}
	
		
		
	public static boolean startBy (String[] mots, String str) {

		
		for(int i = 0; i < mots.length; i ++) {
			
			if (mots[i].startsWith(str)) {
				match=true;
			}
			
			
		}
		return match;
	}
	
	public static boolean endBy (String[] mots, String str) {

		for(int i = 0; i < mots.length; i ++) {
			if (mots[i].endsWith(str)) {
				match=true;
			}
		}
		return match;
	}
	
	
		
		public static boolean content (String[] mots, String mot) {
			
			for(int i = 0; i < mots.length; i ++) {
				if (mots[i].contains(mot)) {
					match=true;
				}
			}
			return match;
			}
		
		
	}

	public static void main(String[] args) {
		
		String str = "ab";
		String[] mots = {
				"abaissable", 
				"abaissables", 
				"abaissai", 
				"abaissaient",
				"hébergeriez",
				"hébergerions",
				"hébergerons",
				"second",
				"seconda",
				"secondai"
				
		
		};
	
		System.out.println(content(mots, str));
	}
			
		

