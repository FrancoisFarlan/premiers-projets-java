package controller;

import java.util.Scanner;

public class ListeInvites {

	public static final int NB_INVITES_MAX = 6; 
	public static Scanner sc;
	public static String[] liste = new String[NB_INVITES_MAX];
	
	public static void main(String[] args) {
		sc = new Scanner(System.in); 
		int choix;
		String nomInvite;
		String prenom;
		String nom;
		
		
		//affiche menu une 1�re fois
		afficherMenu();
		
		choix = scannerInt();
		sc.nextLine();
		
		while(choix != 0) {
			//saisie du choix
			
			switch(choix) {
				case 1 : 
					prenom = scannerTexte("Veuillez saisir le prenom de l'invite");
					nom = scannerTexte("Veuillez saisir le nom de l'invite").toUpperCase();
					nomInvite = prenom + " " + nom; 
					ajouterPersonne(nomInvite, liste); break;
				case 2 : 
					nomInvite = scannerTexte("Veuillez saisir le nom de l'invite");
					enleverPersonne(nomInvite, liste); break;
				case 3 : 
					afficherListe(liste); break;
				default : 
					System.out.println("Veuillez taper un chiffre entre 0 et 3");
			
			}
			
			afficherMenu();
			choix = scannerInt();
			sc.nextLine();
		} 
		
		sc.close();
		
	}

	public static int scannerInt() {
		return sc.nextInt(); 
	}
	
	public static String scannerTexte(String message) {
		System.out.println(message);
		return sc.nextLine(); 
	}
	
	
	public static void afficherMenu() {
		System.out.println("------------------------------------------");
		System.out.println("----------- Saisir votre choix -----------");
		System.out.println("-- 0 - Quitter ---------------------------");
		System.out.println("-- 1 - Ajouter une personne --------------");
		System.out.println("-- 2 - Enlever une personne --------------");
		System.out.println("-- 3 - Afficher la liste -----------------");
		System.out.println("------------------------------------------");
		System.out.println("                                          ");
	}
	
	public static void ajouterPersonne(String personne, String[] tab) {
		for(int i = 0; i < NB_INVITES_MAX ; i++) {
			if(tab[i] == null) {
				tab[i] = personne;
				break;
			}
			
			if(i == 5 && tab[i] != null) {
				System.out.println("Il n'y a plus de place sur la liste d'invites");
			}
		}
	}
	
	public static void enleverPersonne(String personne, String[] tab) {
		for(int i = 0; i < NB_INVITES_MAX ; i++) {
			if(tab[i].equals(personne)) {
				tab[i] = null;
				break;
			}
			
			if(i == 5 && tab[i] != null) {
				System.out.println("Cet invite ne figure pas sur la liste");
			}
			
		}
		
	}
	
	public static void afficherListe(String[] liste) {
		for(String invite : liste) {
			if(invite != null) {
			System.out.println(invite);
			}
		}
	}
}
