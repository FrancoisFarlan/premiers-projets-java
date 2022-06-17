package controller;

import java.util.Arrays;
import java.util.Scanner;

public class MelangeurMots {
	
	//d�claration du scanner
	public static Scanner sc;
	
	public static void main(String[] args) {
		//------------------------------------------------------------
		//FONCTIONS A CREER
		//------------------------------------------------------------
		
		//Initialisation du scanner
		sc = new Scanner(System.in);
		
		//appel fonction scanner texte
		String phrase = scannerTexte("Veuillez saisir la phrase qui doit �tre melang�e");
		
		//phrase = phrase.trim().replace(' ', '/');
		
		//cr�� un tableau de mots
		String[] mots = phrase.split(" ");
		String phraseMelangee = ""; 	
		
		//boucle sur chaque mot dans mots
		for(int i = 0; i < mots.length ; i++) {
			//cr�e nouveau mot 
			String motMelange =""; 
			
			//cr�e un tab de char � partir du mot
			char[] tabChar = mots[i].toCharArray();
			
			//cr�e une copie vide du tableau de char
			char[] tabChar2 = new char[tabChar.length];
			
			//assigne la 1�re lettre
			tabChar2[0] = tabChar[0];
			
			if (tabChar2.length > 1) { //assigne la derni�re lettre
				tabChar2[tabChar.length-1] = tabChar[tabChar.length-1];
				
				int indice;
				
				//assigne les autres lettres al�atoirement
				for(int j = 1; j < tabChar2.length -1 ; j++) {
					
					//g�n�re un nb al�atoire entre 1 et tabChar.length-1
					do {
						indice = (int)(Math.random()*(tabChar.length-2)+1);
					} while(tabChar2[indice] != '\u0000'); 
					
					//ins�re dans tabChar2[j] le char de tabChar � l'indice indice
					tabChar2[indice] = tabChar[j];
				}
				
			}
			motMelange = String.valueOf(tabChar2);
			
			//modifie la valeur du mot
			mots[i] = motMelange; 
			
		}
		
		//ajoute les mots m�lang�s � la phrase m�lang�e
		for(String mot : mots) {
			phraseMelangee += " " + mot; 
		}
		
		System.out.println(phraseMelangee.trim());
		
		//cl�ture du scanner
		sc.close(); 

	}
	
	public static String scannerTexte(String message) {
		System.out.println(message);
		return sc.nextLine(); 
		
	}

}
