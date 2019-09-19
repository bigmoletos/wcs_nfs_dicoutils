package fr.wcs.nfs.dicoutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DicoLoader {

	List<String> tabDico = new ArrayList<>();

	public List<String> chargeFichier1() throws IOException {

		for (String ligne : Files.readAllLines(Paths.get("dictionnaire.txt"))) {
		 for (String chaine : ligne.split("\\n"))
		 {
		 tabDico.add(chaine);
		 }
		}
		return tabDico;
	} }


