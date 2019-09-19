
package fr.wcs.nfs.dicoutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DicoLoader {

	List<String> tabDico = new ArrayList<>();

	public List<String> chargeFichier1() throws IOException {

		for (String ligne : Files.readAllLines(Paths.get("dictionnaireTest.txt"))) {
		 for (String chaine : ligne.split("\\n"))
		 {
		 tabDico.add(chaine);
		 }
		}
		return tabDico;
	} 
	public void saveFichier(String[]tableau) {
		
		try {

			   File file = new File("dictionnaireTest.txt");

			   // créer le fichier s'il n'existe pas
			   if (!file.exists()) {
			    file.createNewFile();
			   }

			   FileWriter fw = new FileWriter(file.getAbsoluteFile());
			   BufferedWriter bw = new BufferedWriter(fw);
			   for (String mot : tableau) {
				   bw.write(mot+"\n");
				  
			}
			   //bw.write(tableau);
			   bw.close();

			   System.out.println("Modification terminée!");

			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 }
	}
	

